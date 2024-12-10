package com.twinleaves.assignment.service.impl;

import com.twinleaves.assignment.dto.request.BatchRequestDTO;
import com.twinleaves.assignment.entities.Batch;
import com.twinleaves.assignment.entities.Product;
import com.twinleaves.assignment.repository.BatchRepository;
import com.twinleaves.assignment.repository.ProductRepository;
import com.twinleaves.assignment.service.BatchService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

	private final BatchRepository batchRepo;
	private final ProductRepository productRepo;

	@Override
	public List<Batch> getBatchesWithPositiveQuantity() {
		return batchRepo.findByAvailableQuantityGreaterThan(0);
	}

	@Override
	public List<Batch> getLatestBatchesWithNegativeOrZeroQuantity() {
		return batchRepo.findByAvailableQuantityLessThanEqualOrderByInwardedOnDesc(0);
	}

	@Override
	public Batch saveBatchOrder(BatchRequestDTO batchRequest) {
		Product product = productRepo.findByProductName(batchRequest.getProductName())
	            .orElseThrow(() -> new RuntimeException("Product not found"));
		Batch batchOrder = Batch.builder().mrp(batchRequest.getMrp()).sp(batchRequest.getSp())
				.availableQuantity(batchRequest.getAvailableQuantity()).product(product)
				.purchasePrice(batchRequest.getPurchasePrice())
				.inwardedOn(batchRequest.getInwardedOn().atStartOfDay(ZoneOffset.UTC)).build();
		return batchRepo.save(batchOrder);
	}
}
