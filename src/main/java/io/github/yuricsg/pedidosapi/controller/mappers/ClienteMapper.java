package io.github.yuricsg.pedidosapi.controller.mappers;

import io.github.yuricsg.pedidosapi.dto.ClienteDTO;
import io.github.yuricsg.pedidosapi.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDTO(Cliente cliente);
}
