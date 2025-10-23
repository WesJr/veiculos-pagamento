package br.com.fiap.veiculo.pagamento.presentation.dto;

import java.math.BigDecimal;

public record ReservaDTO(
        Long id,
        BigDecimal valorReserva,
        String codigoPagamento,
        ClienteDto clienteDto,
        VeiculoDto veiculoDto
) {
}
