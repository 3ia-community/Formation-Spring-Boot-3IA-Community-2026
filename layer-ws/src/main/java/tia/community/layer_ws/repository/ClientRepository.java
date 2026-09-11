package tia.community.layer_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tia.community.layer_ws.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByRef(String ref);
    List<Client> findByVille(String ville);
    List<Client> findByActif(boolean actif);
}
