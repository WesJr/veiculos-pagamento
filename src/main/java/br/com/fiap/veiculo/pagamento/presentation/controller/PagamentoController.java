package br.com.fiap.veiculo.pagamento.presentation.controller;

import br.com.fiap.veiculo.pagamento.domain.service.PagamentoService;
import br.com.fiap.veiculo.pagamento.presentation.dto.PagamentoDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/realizar")
    public void incluirPagamento(@RequestBody PagamentoDto pagamentoDto) {

        pagamentoService.incluirPagamento(pagamentoDto);
    }

    @GetMapping("/sucesso")
    public String getMensagemSucesso() {
        return "SUCESSO!!!!";
    }

}
