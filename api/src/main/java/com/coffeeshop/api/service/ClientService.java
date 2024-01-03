package com.coffeeshop.api.service;

import com.coffeeshop.api.model.ClientEntity;
import com.coffeeshop.api.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientEntity register(String name, String password) throws Exception {
        var client = clientRepository.getClientByName(name);
        if (client != null) throw new Exception("User already exists");
        return clientRepository.addClient(name, password);
    }

    public ClientEntity login(String name, String password) throws Exception {
        var client = clientRepository.checkPassword(name, password);
        if (client == null) throw new Exception("Invalid password");
        return client;
    }

    public Long getBonusPoints(Long clientId) throws Exception {
        var bonusPoints = clientRepository.getBonusPoints(clientId);
        if (bonusPoints == null) throw new Exception("User doesnt exists");
        return bonusPoints;
    }

    public void spendPoints(Long clientId, Long amount) {
        clientRepository.spendBonusPoints(Math.toIntExact(clientId), Math.toIntExact(amount));
    }

    public void saveFavouriteCoffee(Long clientId, Long beansId, Long milkId, Long syrupId, Long sizeId) {
        clientRepository.saveFavouriteCoffee(Math.toIntExact(clientId), Math.toIntExact(beansId), Math.toIntExact(milkId), Math.toIntExact(syrupId), Math.toIntExact(sizeId));
    }

}
