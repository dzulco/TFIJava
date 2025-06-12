package com.techlab.service;

import com.techlab.model.Client;

public class ClientService {

    public Client generateClient(String name, String email) {
        Client client = new Client(name,email);
        return client;
    }
}
