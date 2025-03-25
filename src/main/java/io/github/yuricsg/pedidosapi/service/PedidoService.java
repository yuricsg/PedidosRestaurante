package io.github.yuricsg.pedidosapi.service;

import io.github.yuricsg.pedidosapi.controller.mappers.PedidoMapper;
import io.github.yuricsg.pedidosapi.dto.PedidoDTO;
import io.github.yuricsg.pedidosapi.model.Cliente;
import io.github.yuricsg.pedidosapi.model.Pedido;
import io.github.yuricsg.pedidosapi.repository.ClienteRepository;
import io.github.yuricsg.pedidosapi.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoService {

    @Autowired
    private PedidosRepository pedidoRepository;

    @Autowired
    public PedidoMapper pedidoMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido salvarPedido(PedidoDTO dto) {
        Pedido pedido = pedidoMapper.toEntity(dto, clienteRepository);
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPedido(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido atualizarPedido(Long id, PedidoDTO dto) {
        Pedido pedido = buscarPedido(id);
        pedido.setValor(dto.valor());
        pedido.setStatus(dto.status());

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        pedido.setCliente(cliente);

        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        Pedido pedido = buscarPedido(id);
        pedidoRepository.delete(pedido);
    }

}
