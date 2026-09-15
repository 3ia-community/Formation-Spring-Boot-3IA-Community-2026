package tia.community.layer_ws.service.facade;

import tia.community.layer_ws.entity.Client;

import java.util.List;
import java.util.Map;

public interface ClientService {
    List<Client> findAll();
    Client findByRef(String ref);
    List<Client> findByVille(String ville);
    List<Client> findByActif(boolean actif);
    Client save(Client client);

    List<Client> saveAll(List<Client> clients);

    int update(String ref, Client nvClient);
    int updatePartial(String ref, Map<String, Object> updates);
    int delete(String ref);
}
