package tia.community.layer_ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public Client findByRef(@PathVariable String ref) {
        return clientService.findByRef(ref);
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
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
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