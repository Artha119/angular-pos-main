package com.artha.angular_pos_backend.repository;

import com.artha.angular_pos_backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item,String> {
@Query(value = "SELECT * FROM item WHERE order_id=?1",nativeQuery = true)
    Optional<Item> findByOrderId(String OrderId);

}
