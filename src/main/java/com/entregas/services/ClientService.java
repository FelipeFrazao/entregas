package com.entregas.services;

import com.entregas.entity.Client;
import com.entregas.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class ClientService extends DefaultService {


    public ClientService() {}
    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        super();
        this.repository = clientRepository;
        this.clientRepository = clientRepository;
    }

    public Client findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public boolean save(Object object, String service) {
        try {
            Client client = (Client) object;
            return super.save(client, service);
        } catch (Exception ex) {
            log.info("[CLIENTSERVICE][SAVECLIENT] ERROR {} ON SAVE CLIENT ", ex.getMessage());
            return false;
        }
    }
}
