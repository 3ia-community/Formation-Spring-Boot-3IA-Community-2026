package tia.community.oneToOne_demo.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tia.community.oneToOne_demo.dao.ClientDao;
import tia.community.oneToOne_demo.entity.Client;
import tia.community.oneToOne_demo.entity.Produit;
import tia.community.oneToOne_demo.service.facade.ClientService;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;

    @Transactional
    @Override
    public void returnerProductsAcheteByClient(String email) {
        Client client = clientDao.findByEmail(email);

        List<Produit> produitsBuyByClient = client.getProduits();
        System.out.println("Products Buy By Current Client");
        for (Produit produit: produitsBuyByClient) {
            System.out.println(produit.getName());
            System.out.println(produit.getPrice());
            System.out.println(produit.getImageUrl());
            System.out.println("--------------------------------------------");
        }
    }
}