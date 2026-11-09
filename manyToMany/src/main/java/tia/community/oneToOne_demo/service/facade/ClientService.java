package tia.community.oneToOne_demo.service.facade;

import jakarta.transaction.Transactional;

public interface ClientService {
    @Transactional
    void returnerProductsAcheteByClient(String email);
}
