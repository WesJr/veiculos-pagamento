package br.com.fiap.veiculo.pagamento.presentation.dto;

public record EnderecoDto(
        Long id,
        String logradouro,
        String numero,
        String cidade,
        String uf,
        String cep
) {
}
