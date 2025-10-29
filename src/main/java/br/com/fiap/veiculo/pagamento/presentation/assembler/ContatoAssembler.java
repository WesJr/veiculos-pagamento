package br.com.fiap.veiculo.pagamento.presentation.assembler;

import br.com.fiap.veiculo.pagamento.domain.model.Contato;
import br.com.fiap.veiculo.pagamento.presentation.dto.ContatoDto;
import org.springframework.stereotype.Component;

@Component
public class ContatoAssembler {

    public Contato dtoParaModelo(ContatoDto contatoDto){
        Contato contato = new Contato();
        contato.setId(contatoDto.id());
        contato.setTelefone(contatoDto.telefone());
        contato.setCelular(contatoDto.celular());
        contato.setEmail(contatoDto.email());

        return contato;
    }

    public ContatoDto modeloParaDto(Contato contato) {
        return new ContatoDto(
                contato.getId(),
                contato.getTelefone(),
                contato.getCelular(),
                contato.getEmail());
    }
}
