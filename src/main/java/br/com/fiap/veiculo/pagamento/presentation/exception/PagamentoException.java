package br.com.fiap.veiculo.pagamento.presentation.exception;

public class PagamentoException extends RuntimeException {

    public PagamentoException(String message) {
        super(message);
    }

    public PagamentoException(String message, Throwable cause) {
        super(message, cause);
    }
}
