package br.com.fiap.veiculo.pagamento.presentation.dto;

public record ClienteDto(
        Long id,
        String nome,
        String documento,
        String nascimento,
        String sexo,
        ContatoDto contato,
        EnderecoDto endereco
) {
}
