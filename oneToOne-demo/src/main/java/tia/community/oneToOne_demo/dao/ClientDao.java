package tia.community.oneToOne_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tia.community.oneToOne_demo.entity.Client;

public interface ClientDao extends JpaRepository<Client, String> {
}
