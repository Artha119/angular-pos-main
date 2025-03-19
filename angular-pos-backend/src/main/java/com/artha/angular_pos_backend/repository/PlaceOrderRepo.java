package com.artha.angular_pos_backend.repository;

import com.artha.angular_pos_backend.entity.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceOrderRepo extends JpaRepository<PlaceOrder,String> {

    @Query("SELECT r FROM place_order r WHERE FUNCTION('YEAR', r.date) = :year")
    List<PlaceOrder> findByYear(int year);
}
