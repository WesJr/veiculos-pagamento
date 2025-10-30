package br.com.fiap.veiculo.pagamento.presentation.assembler;

import br.com.fiap.veiculo.pagamento.presentation.dto.PagamentoDTO;
import br.com.fiap.veiculo.pagamento.domain.model.Pagamento;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoAssembler {

    public Pagamento dtoParaModelo(PagamentoDTO pagamentoDto) {

        Pagamento pagamento = new Pagamento();

        pagamento.setId(pagamentoDto.id());
        pagamento.setDataVenda(LocalDateTime.now());
        pagamento.setValorRemanescente(pagamentoDto.valorRemanescente());
        pagamento.setCodigoPagamento(pagamentoDto.codigoPagamento());

        return pagamento;

    }
}
