package tia.community.layer_ws.ws.converter;

import org.springframework.stereotype.Component;
import tia.community.layer_ws.ws.dto.request.ClientDtoRequest;
import tia.community.layer_ws.ws.dto.response.ClientDtoResponse;
import tia.community.layer_ws.entity.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezzaim Mohammed
 */

@Component
public class ClientConverter {

    public Client toEntity(ClientDtoRequest dto) {
        if (dto == null) {
            return null;
        }
        Client entity = Client.builder()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .ville(dto.getVille())
                .actif(dto.isActif())
                .build();
        return entity;
    }

    public ClientDtoResponse toDto(Client entity) {
        if (entity == null) return null;

        ClientDtoResponse dto = ClientDtoResponse.builder()
                .ref(entity.getRef())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .email(entity.getEmail())
                .ville(entity.getVille())
                .actif(entity.isActif())
                .build();
        return dto;
    }

    public List<ClientDtoResponse> toDtos(List<Client> entities) {
        if (entities == null) return null;
        List<ClientDtoResponse> dtos = new ArrayList<>();

        for (Client entity: entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<Client> toEntities(List<ClientDtoRequest> dtos) {
        if (dtos == null) return null;
        List<Client> entities = new ArrayList<>();
        for (ClientDtoRequest dto: dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}