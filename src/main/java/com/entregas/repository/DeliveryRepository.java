package com.entregas.repository;

import com.entregas.entity.Client;
import com.entregas.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findAllByclient_id(Long clientId);
}
