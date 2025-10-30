package br.com.fiap.veiculo.pagamento.domain.job;

import br.com.fiap.veiculo.pagamento.domain.service.PagamentoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoJob {

    private final PagamentoService service;

    public PagamentoJob(PagamentoService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 5000)
    public void atualizaVeiculoParaVendido (){
        service.atualizaVeiculoParaVendido();
    }

    @Scheduled(fixedRate = 5000)
    public void executarComCron() {
        System.out.println("Executando job via CRON às: " + LocalDateTime.now());
    }
}
