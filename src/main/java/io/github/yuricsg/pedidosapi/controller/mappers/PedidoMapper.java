package io.github.yuricsg.pedidosapi.controller.mappers;

import io.github.yuricsg.pedidosapi.dto.PedidoDTO;
import io.github.yuricsg.pedidosapi.model.Cliente;
import io.github.yuricsg.pedidosapi.model.Pedido;
import io.github.yuricsg.pedidosapi.repository.ClienteRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "cliente", source = "clienteId", qualifiedByName = "mapCliente")
    Pedido toEntity(PedidoDTO dto, @Context ClienteRepository clienteRepository);

    @Mapping(target = "clienteId", source = "cliente.id")
    PedidoDTO toDTO(Pedido pedido);

    @Named("mapCliente")
    default Cliente mapCliente(Long clienteId, @Context ClienteRepository clienteRepository) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
