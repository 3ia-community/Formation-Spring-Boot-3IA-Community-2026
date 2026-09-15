package tia.community.layer_ws.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tia.community.layer_ws.entity.Client;
import tia.community.layer_ws.repository.ClientRepository;
import tia.community.layer_ws.service.facade.ClientService;

import java.util.List;
import java.util.Map;

/**
 * @author Ezzaim Mohammed
 */

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByRef(String ref) {
        return clientRepository.findByRef(ref);
    }

    @Override
    public List<Client> findByVille(String ville) {
        return clientRepository.findByVille(ville);
    }

    @Override
    public List<Client> findByActif(boolean actif) {
        return clientRepository.findByActif(actif);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> saveAll(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    @Override
    public int update(String ref, Client nvClient) {
        if (ref == null || ref.isBlank() || nvClient == null) {
            return -1;
        } else {
            Client clientInDB = clientRepository.findByRef(ref);
            if (clientInDB == null) return -2;
            else {
                clientInDB.setNom(nvClient.getNom());
                clientInDB.setPrenom(nvClient.getPrenom());
                clientInDB.setEmail(nvClient.getEmail());
                clientInDB.setPassword(nvClient.getPassword());
                clientInDB.setVille(nvClient.getVille());
                clientInDB.setActif(nvClient.isActif());

                clientRepository.save(clientInDB);
                return 1;
            }
        }
    }

    @Override
    public int updatePartial(String ref, Map<String, Object> updates) {
        if (ref == null || ref.isBlank() || updates == null) {
            return -1;
        } else {
            Client clientInDB = clientRepository.findByRef(ref);
            if (clientInDB == null) return -2;
            else {
                if (updates.containsKey("nom")) {
                    clientInDB.setNom(updates.get("nom").toString());
                }

                if (updates.containsKey("prenom")) {
                    clientInDB.setPrenom(updates.get("prenom").toString());
                }

                if (updates.containsKey("email")) {
                    clientInDB.setEmail(updates.get("email").toString());
                }

                if (updates.containsKey("ville")) {
                    clientInDB.setVille(updates.get("ville").toString());
                }
                if (updates.containsKey("active")) {
                    clientInDB.setActif(Boolean.parseBoolean(updates.get("nom").toString()));
                }

                clientRepository.save(clientInDB);
                return 1;
            }
        }

    }

    @Override
    public int delete(String ref) {
        if (ref == null || ref.isBlank()) {
            return -1;
        } else {
            Client clientInDB = clientRepository.findByRef(ref);
            if (clientInDB == null) return -2;
            else {
                clientRepository.delete(clientInDB);
                return 1;
            }
        }
    }
}