package com.twinleaves.assignment.service;

import com.twinleaves.assignment.dto.request.BatchRequestDTO;
import com.twinleaves.assignment.entities.Batch;

import java.util.List;

public interface BatchService {
    public List<Batch> getBatchesWithPositiveQuantity();

    public List<Batch> getLatestBatchesWithNegativeOrZeroQuantity();
    
    public Batch saveBatchOrder(BatchRequestDTO batchRequest);
}
