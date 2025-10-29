package br.com.fiap.veiculo.pagamento.presentation.controller;

import br.com.fiap.veiculo.pagamento.domain.service.ClienteService;
import br.com.fiap.veiculo.pagamento.presentation.dto.ClienteDto;
import br.com.fiap.veiculo.pagamento.presentation.exception.ClienteException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/inserir")
    public void inserirCliente(@RequestBody ClienteDto clienteDto) {
        service.inserirCliente(clienteDto);
    }

    @GetMapping("/listar")
    public List<ClienteDto> listarTodosOsClientes(){
        return service.listarTodosOsClientes();
    }

    @GetMapping("/consultar/{id}")
    public ClienteDto consultarCliente(@PathVariable(name = "id") Long id) throws ClienteException {
        return service.consultarPorId(id);
    }
}
