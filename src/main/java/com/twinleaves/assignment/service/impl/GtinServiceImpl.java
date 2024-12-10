package com.twinleaves.assignment.service.impl;

import com.twinleaves.assignment.dto.request.GtinRequestDTO;
import com.twinleaves.assignment.entities.Gtin;
import com.twinleaves.assignment.entities.Product;
import com.twinleaves.assignment.repository.GtinRepository;
import com.twinleaves.assignment.repository.ProductRepository;
import com.twinleaves.assignment.service.GtinService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GtinServiceImpl implements GtinService {

	private final GtinRepository gtinRepo;

	private final ProductRepository productRepo;

	@Override
	public List<Gtin> getGtinsByGtin(String gtin) {
		return gtinRepo.findByGtin(gtin);
	}

	@Override
	public List<Gtin> getGtinsByProductId(int productId) {
		return gtinRepo.findByProduct_ProductId(productId);
	}

	@Override
	public Gtin saveGtin(GtinRequestDTO gtinRequest) {
		Product product = productRepo.findByProductName(gtinRequest.getProductName())
				.orElseThrow(() -> new RuntimeException("Product with the product name not found"));
		Gtin gtinRecord = Gtin.builder().gtin(gtinRequest.getGtin()).product(product).build();
		return gtinRepo.save(gtinRecord);
	}

	@Override
	public List<Gtin> getGtinsWithPositiveBatchQuantity() {
		return gtinRepo.findGtinsWithPositiveBatchQuantity();
	}

	@Override
	public List<Gtin> getGtinsWithLatestNegativeOrZeroBatchQuantity() {
		return gtinRepo.findGtinsWithLatestNegativeOrZeroBatchQuantity();
	}
}
