package com.twinleaves.assignment.service;

import com.twinleaves.assignment.dto.request.GtinRequestDTO;
import com.twinleaves.assignment.entities.Gtin;

import java.util.List;

public interface GtinService {

    public List<Gtin> getGtinsByGtin(String gtin);

    public List<Gtin> getGtinsByProductId(int productId);
    
    public Gtin saveGtin(GtinRequestDTO gtinRequest);
    
    public List<Gtin> getGtinsWithPositiveBatchQuantity();
    public List<Gtin> getGtinsWithLatestNegativeOrZeroBatchQuantity();
}
