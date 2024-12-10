package com.twinleaves.assignment.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twinleaves.assignment.controller.common.BaseController;
import com.twinleaves.assignment.dto.request.BatchRequestDTO;
import com.twinleaves.assignment.dto.response.SuccessResponse;
import com.twinleaves.assignment.service.BatchService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BatchController extends BaseController<Object>{

    private final BatchService batchService;

    @GetMapping("/batches/positive")
    public ResponseEntity<SuccessResponse<Object>> getBatchesWithPositiveQuantity() {
        return success(batchService.getBatchesWithPositiveQuantity(),"OK", HttpStatus.OK);
    }

    @GetMapping("/batches/negative-latest")
    public ResponseEntity<SuccessResponse<Object>> getLatestBatchesWithNegativeOrZeroQuantity() {
        return success(batchService.getLatestBatchesWithNegativeOrZeroQuantity(), "OK", HttpStatus.OK);
    }
    
    @PostMapping("/batches")
    public ResponseEntity<SuccessResponse<Object>> createBatch(@Valid @RequestBody BatchRequestDTO batch) {
        return success(batchService.saveBatchOrder(batch), "OK", HttpStatus.OK);
    }
}
