package tia.community.oneToOne_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tia.community.oneToOne_demo.entity.Category;
import tia.community.oneToOne_demo.entity.Produit;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
