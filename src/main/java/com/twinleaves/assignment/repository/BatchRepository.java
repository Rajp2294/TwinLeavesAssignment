package com.twinleaves.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.twinleaves.assignment.entities.Batch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
    List<Batch> findByAvailableQuantityGreaterThan(int quantity);

    List<Batch> findByAvailableQuantityLessThanEqualOrderByInwardedOnDesc(int quantity);
}
