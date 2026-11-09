package tia.community.oneToOne_demo.service.facade;

import jakarta.transaction.Transactional;

public interface ProduitService {
    @Transactional
    void returnerClientsAcheteProduct(String name);
}
