package tia.community.oneToOne_demo.service.facade;

import jakarta.transaction.Transactional;

public interface ProduitService {
    @Transactional
    void returnerClientsAcheteProduct(String name);

    @Transactional
    void buyAProduct(String email, String id);
}
