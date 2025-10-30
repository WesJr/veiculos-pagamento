package br.com.fiap.veiculo.pagamento.domain.service;

import br.com.fiap.veiculo.pagamento.infraestructure.proxy.VeiculoProxy;
import br.com.fiap.veiculo.pagamento.presentation.dto.ReservaDto;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final VeiculoProxy proxy;

    public ReservaService(VeiculoProxy proxy) {
        this.proxy = proxy;
    }

    public ReservaDto buscarReservaPorCodigo(String codigo) {
        return proxy.buscarReservaPorCodigo(codigo);
    }
}
