package br.com.fiap.veiculo.pagamento.infraestructure.proxy;

import br.com.fiap.veiculo.pagamento.presentation.dto.ReservaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "veiculos", url = "http://localhost:8080")
public interface VeiculoProxy {

    @GetMapping("/reserva/consultar/codigo/{codigo}")
    ReservaDto buscarReservaPorCodigo(@PathVariable(name = "codigo") String codigo);

    @PutMapping("/veiculo/vendido/{veiculoId}")
    void atualizarVeiculo(@PathVariable("veiculoId") Long veiculoId);
}
