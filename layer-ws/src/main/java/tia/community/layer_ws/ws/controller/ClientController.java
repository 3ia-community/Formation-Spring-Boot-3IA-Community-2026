package tia.community.layer_ws.ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tia.community.layer_ws.ws.converter.ClientConverter;
import tia.community.layer_ws.ws.dto.request.ClientDtoRequest;
import tia.community.layer_ws.ws.dto.response.ClientDtoResponse;
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
    private final ClientConverter clientConverter;

    @RequestMapping(method = RequestMethod.GET)
    public List<ClientDtoResponse> findAll() {
        List<Client> clients = clientService.findAll();
        return clientConverter.toDtos(clients);
    }

    @RequestMapping(path = "{ref}", method = RequestMethod.GET)
    public ClientDtoResponse findByRef(@PathVariable String ref) {
        Client client = clientService.findByRef(ref);
        return clientConverter.toDto(client);
    }

    @RequestMapping(path = "ville/{ville}", method = RequestMethod.GET)
    public List<ClientDtoResponse> findByVille(@PathVariable String ville) {
        return clientConverter.toDtos(clientService.findByVille(ville));
    }

    @RequestMapping(path = "isActif/{actif}", method = RequestMethod.GET)
    public List<ClientDtoResponse> findByActif(@PathVariable boolean actif) {
        return clientConverter.toDtos(clientService.findByActif(actif));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ClientDtoResponse save(@RequestBody ClientDtoRequest clientDtoRequest) {
        Client client = clientConverter.toEntity(clientDtoRequest);
        return clientConverter.toDto(client);
    }

    @RequestMapping(path = "saveAll", method = RequestMethod.POST)
    public List<ClientDtoResponse> saveAll(@RequestBody List<ClientDtoRequest> dtos) {
        List<Client> entities =  clientConverter.toEntities(dtos);
        return clientConverter.toDtos(clientService.saveAll(entities));
    }


    @RequestMapping(path = "{ref}", method = RequestMethod.PUT)
    public int update(@PathVariable String ref, @RequestBody ClientDtoRequest dto) {
        return clientService.update(ref, clientConverter.toEntity(dto));
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