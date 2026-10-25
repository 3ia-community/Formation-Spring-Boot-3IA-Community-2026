package tia.community.oneToOne_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tia.community.oneToOne_demo.entity.Client;
import tia.community.oneToOne_demo.entity.Produit;

public interface ProduitDao extends JpaRepository<Produit, String> {
}
