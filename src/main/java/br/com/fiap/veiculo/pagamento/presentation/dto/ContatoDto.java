package br.com.fiap.veiculo.pagamento.presentation.dto;

public record ContatoDto(
        Long id,
        String telefone,
        String celular,
        String email
) {
}
