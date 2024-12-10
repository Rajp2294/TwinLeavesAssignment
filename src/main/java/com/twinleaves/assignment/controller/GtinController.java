package com.twinleaves.assignment.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twinleaves.assignment.controller.common.BaseController;
import com.twinleaves.assignment.dto.request.GtinRequestDTO;
import com.twinleaves.assignment.dto.response.SuccessResponse;
import com.twinleaves.assignment.service.GtinService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GtinController extends BaseController<Object>{

    private final GtinService gtinService;

    @GetMapping("/gtins")
    public ResponseEntity<SuccessResponse<Object>> getGtinsByGtin(@RequestParam String gtin) {
        return success(gtinService.getGtinsByGtin(gtin), "OK", HttpStatus.OK);
    }

    @GetMapping("/gtins/product")
    public ResponseEntity<SuccessResponse<Object>> getGtinsByProductId(@RequestParam int productId) {
        return success(gtinService.getGtinsByProductId(productId), "OK", HttpStatus.OK);
    }
    
    @PostMapping("/gtins/add")
    public ResponseEntity<SuccessResponse<Object>> createGtin(@Valid @RequestBody GtinRequestDTO gtin) {
        return success(gtinService.saveGtin(gtin), "OK", HttpStatus.OK);
    }
    
    @GetMapping("/gtins/positive")
    public ResponseEntity<SuccessResponse<Object>> getGtinsWithPositiveBatch() {
        return success(gtinService.getGtinsWithPositiveBatchQuantity(), "OK", HttpStatus.OK);
    }
    
    @GetMapping("/gtins/negative-latest")
    public ResponseEntity<SuccessResponse<Object>> getGtinsNegativeLatest() {
        return success(gtinService.getGtinsWithLatestNegativeOrZeroBatchQuantity(), "OK", HttpStatus.OK);
    }
}
