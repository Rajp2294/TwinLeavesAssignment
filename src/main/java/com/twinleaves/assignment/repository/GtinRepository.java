package com.twinleaves.assignment.repository;

import com.twinleaves.assignment.entities.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GtinRepository extends JpaRepository<Gtin, Integer> {
    List<Gtin> findByGtin(String gtin);

    List<Gtin> findByProduct_ProductId(int productId);
    
    @Query("SELECT g FROM Gtin g JOIN g.product p JOIN Batch b ON b.product = p WHERE b.availableQuantity > 0")
    List<Gtin> findGtinsWithPositiveBatchQuantity();
    
    @Query("SELECT g FROM Gtin g JOIN g.product p JOIN Batch b ON b.product = p " +
            "WHERE b.availableQuantity <= 0 AND b.inwardedOn = " +
            "(SELECT MAX(b2.inwardedOn) FROM Batch b2 WHERE b2.product = p AND b2.availableQuantity <= 0)")
     List<Gtin> findGtinsWithLatestNegativeOrZeroBatchQuantity();
}
