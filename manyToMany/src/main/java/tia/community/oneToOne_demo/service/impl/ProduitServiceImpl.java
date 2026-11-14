package tia.community.oneToOne_demo.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tia.community.oneToOne_demo.dao.ClientDao;
import tia.community.oneToOne_demo.dao.ProduitDao;
import tia.community.oneToOne_demo.entity.Client;
import tia.community.oneToOne_demo.entity.Produit;
import tia.community.oneToOne_demo.service.facade.ProduitService;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private final ProduitDao produitDao;
    private final ClientDao clientDao;

    @Transactional
    @Override
    public void returnerClientsAcheteProduct(String name) {
        Produit currentProduct = produitDao.findByName(name);
        List<Client> clients = currentProduct.getClients();
        System.out.println("Les Clients Acheter cette Produit");
        clients.forEach(client -> {
            System.out.println(client.getUsername());
            System.out.println(client.getLastname());
            System.out.println(client.getEmail());
            System.out.println("-------------------------------");
        });
    }

    @Transactional
    @Override
    public void buyAProduct(String email, String id) {
        Client client = clientDao.findByEmail(email);
        Produit produit = produitDao.findById(id).orElseThrow();

        List<Produit> produits = client.getProduits();
        produits.add(produit);

        client.setProduits(produits);

        clientDao.save(client);
    }
}