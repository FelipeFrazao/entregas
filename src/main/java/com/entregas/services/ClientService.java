package com.entregas.services;

import com.entregas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientService extends DefaultService {

    private ClientRepository clientRepository;

    public ClientService() {}

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }
}
