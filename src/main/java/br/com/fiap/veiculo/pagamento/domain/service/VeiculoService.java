package br.com.fiap.veiculo.pagamento.domain.service;

import br.com.fiap.veiculo.pagamento.infraestructure.proxy.VeiculoProxy;
import br.com.fiap.veiculo.pagamento.infraestructure.repository.PagamentoRepository;
import br.com.fiap.veiculo.pagamento.presentation.enumerado.Status;
import org.springframework.stereotype.Service;


@Service
public class VeiculoService {

    private final VeiculoProxy proxy;
    private final PagamentoRepository repository;

    public VeiculoService(VeiculoProxy proxy, PagamentoRepository repository) {
        this.proxy = proxy;
        this.repository = repository;
    }

    public void atualizaVeiculoParaVendido() {
        repository.findByStatus(Status.APROVADO).forEach(pagamento -> {
            proxy.atualizarVeiculo(pagamento.getVeiculoId());
            System.out.print("Veiculo id: " + pagamento.getVeiculoId() + " atuzalizado!");
        });
    }
}
