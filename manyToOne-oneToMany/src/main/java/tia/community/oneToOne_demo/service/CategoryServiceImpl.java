package tia.community.oneToOne_demo.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tia.community.oneToOne_demo.dao.CategoryDao;
import tia.community.oneToOne_demo.entity.Category;
import tia.community.oneToOne_demo.entity.Produit;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryDao categoryDao;

    @Transactional
    @Override
    public void returnProduitsByCategory() {
        Category category = categoryDao.findByName("Electronic");
        List<Produit> produits = category.getProduits();

        System.out.println(category.getName());
        produits.forEach(produit -> {
            System.out.println("---------------------------");
            System.out.println(produit.getName());
            System.out.println(produit.getPrice());
            System.out.println(produit.getImageUrl());
            System.out.println(produit.getCategory().getName());
        });
    }
}