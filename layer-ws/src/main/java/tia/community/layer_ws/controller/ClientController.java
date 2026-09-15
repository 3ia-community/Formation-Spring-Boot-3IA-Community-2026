package tia.community.layer_ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tia.community.layer_ws.dto.request.ClientDtoRequest;
import tia.community.layer_ws.dto.response.ClientDtoResponse;
import tia.community.layer_ws.entity.Client;
import tia.community.layer_ws.service.facade.ClientService;

import java.util.List;
import java.util.Map;

/**
 * @author Ezzaim Mohammed
 */

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @RequestMapping(path = "{ref}", method = RequestMethod.GET)
    public ClientDtoResponse findByRef(@PathVariable String ref) {
        Client client = clientService.findByRef(ref);
        ClientDtoResponse clientDto = convertEntityToDto(client);
        return clientDto;
    }

    private ClientDtoResponse convertEntityToDto(Client client) {
        ClientDtoResponse clientDto = ClientDtoResponse.builder()
                .ref(client.getRef())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .ville(client.getVille())
                .actif(client.isActif())
                .build();

        return clientDto;
    }

    @RequestMapping(path = "ville/{ville}", method = RequestMethod.GET)
    public List<Client> findByVille(@PathVariable String ville) {
        return clientService.findByVille(ville);
    }

    @RequestMapping(path = "isActif/{actif}", method = RequestMethod.GET)
    public List<Client> findByActif(@PathVariable boolean actif) {
        return clientService.findByActif(actif);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ClientDtoResponse save(@RequestBody ClientDtoRequest clientDtoRequest) {
        Client client = convertDtoToEntity(clientDtoRequest);
        return convertEntityToDto(clientService.save(client));
    }

    private Client convertDtoToEntity(ClientDtoRequest clientDtoRequest) {
        Client client = Client.builder()
                .nom(clientDtoRequest.getNom())
                .prenom(clientDtoRequest.getPrenom())
                .email(clientDtoRequest.getEmail())
                .password(clientDtoRequest.getPassword())
                .ville(clientDtoRequest.getVille())
                .actif(clientDtoRequest.isActif())
                .build();
        return client;
    }


    @RequestMapping(path = "saveAll", method = RequestMethod.POST)
    public List<Client> saveAll(@RequestBody List<Client> clients) {
        return clientService.saveAll(clients);
    }


    @RequestMapping(path = "{ref}", method = RequestMethod.PUT)
    public int update(@PathVariable String ref, @RequestBody Client nvClient) {
        return clientService.update(ref, nvClient);
    }

    @RequestMapping(path = "{ref}", method = RequestMethod.PATCH)
    public int updatePartial(@PathVariable String ref, @RequestBody Map<String, Object> updates) {
        return clientService.updatePartial(ref, updates);
    }

    @RequestMapping(path = "{ref}", method = RequestMethod.DELETE)
    public int delete(@PathVariable String ref) {
        return clientService.delete(ref);
    }
}