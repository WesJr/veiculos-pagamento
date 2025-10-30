package br.com.fiap.veiculo.pagamento.presentation.dto;

import br.com.fiap.veiculo.pagamento.presentation.enumerado.Status;

import java.math.BigDecimal;

public record PagamentoDto(
        Long id,
        String dataVenda,
        BigDecimal valorRemanescente,
        Status status,
        String codigoPagamento
) {
}
