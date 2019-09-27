package com.entregas.services;

import com.entregas.entity.Delivery;
import com.entregas.repository.DeliveryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class DeliveryService extends DefaultService {

    public DeliveryService() {}

    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        repository = deliveryRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getDeliveriesByClient(Long clientId) {

        List<Delivery> deliveryList = new ArrayList();
        deliveryRepository.findAllByclient_id(clientId).forEach(deliveryList::add);
        return deliveryList;
    }


    @Override
    public boolean save(Object object, String service) {
        try {
            Delivery delivery = (Delivery) object;
            return super.save(delivery, service);
        } catch (Exception ex) {
            log.info("[CLIENTSERVICE][SAVECLIENT] ERROR {} ON SAVE CLIENT ", ex.getMessage());
            return false;
        }
    }

}
