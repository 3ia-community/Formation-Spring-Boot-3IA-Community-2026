package tia.community.oneToOne_demo.service;

import jakarta.transaction.Transactional;

/**
 * @author Ezzaim Mohammed
 */

public interface CategoryService {
    @Transactional
    void returnProduitsByCategory();
}

