package br.com.fiap.veiculo.pagamento.domain.service;

import br.com.fiap.veiculo.pagamento.domain.model.Contato;
import br.com.fiap.veiculo.pagamento.infraestructure.repository.ContatoRepository;
import br.com.fiap.veiculo.pagamento.presentation.assembler.ContatoAssembler;
import br.com.fiap.veiculo.pagamento.presentation.dto.ContatoDto;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private final ContatoRepository repository;
    private final ContatoAssembler assembler;

    public ContatoService(ContatoRepository repository, ContatoAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public Contato inserirContato(ContatoDto contatoDto) {

        return repository.save(assembler.dtoParaModelo(contatoDto));
    }
}
