package br.com.fiap.veiculo.pagamento.domain.service;

import br.com.fiap.veiculo.pagamento.domain.model.Contato;
import br.com.fiap.veiculo.pagamento.domain.model.Endereco;
import br.com.fiap.veiculo.pagamento.infraestructure.repository.ClienteRepository;
import br.com.fiap.veiculo.pagamento.presentation.assembler.ClienteAssembler;
import br.com.fiap.veiculo.pagamento.presentation.assembler.ContatoAssembler;
import br.com.fiap.veiculo.pagamento.presentation.assembler.EnderecoAssembler;
import br.com.fiap.veiculo.pagamento.presentation.dto.ClienteDto;
import br.com.fiap.veiculo.pagamento.presentation.dto.ContatoDto;
import br.com.fiap.veiculo.pagamento.presentation.dto.EnderecoDto;
import br.com.fiap.veiculo.pagamento.presentation.exception.ClienteException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteAssembler assembler;
    private final ClienteRepository repository;
    private final EnderecoService enderecoService;
    private final EnderecoAssembler enderecoAssembler;
    private final ContatoService contatoService;
    private final ContatoAssembler contatoAssembler;

    public ClienteService(ClienteAssembler assembler, ClienteRepository repository, EnderecoService enderecoService, EnderecoAssembler enderecoAssembler, ContatoService contatoService, ContatoAssembler contatoAssembler) {
        this.assembler = assembler;
        this.repository = repository;
        this.enderecoService = enderecoService;
        this.enderecoAssembler = enderecoAssembler;
        this.contatoService = contatoService;
        this.contatoAssembler = contatoAssembler;
    }

    public void inserirCliente(ClienteDto clienteDto) {
        Endereco endereco = enderecoService.insereEndereco(clienteDto.endereco());
        EnderecoDto enderecoDto = enderecoAssembler.modeloParaDto(endereco);

        Contato contato = contatoService.inserirContato(clienteDto.contato());
        ContatoDto contatoDto = contatoAssembler.modeloParaDto(contato);

        repository.save(assembler.dtoParaModelo(clienteDto, enderecoDto, contatoDto));
    }

    public List<ClienteDto> listarTodosOsClientes() {
        List<ClienteDto> listaClienteDto = new ArrayList<>();

        repository.findAll().forEach(cliente -> {
            listaClienteDto.add(assembler.modeloParaDto(cliente));
        });
        return listaClienteDto;
    }

    public ClienteDto consultarPorId(Long id) throws ClienteException {
        return repository.findById(id)
                .map(assembler::modeloParaDto)
                .orElseThrow(() -> new ClienteException("Cliente não cadastrado"));
    }
}
