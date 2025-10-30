package br.com.fiap.veiculo.pagamento.presentation.controller;

import br.com.fiap.veiculo.pagamento.domain.service.PagamentoService;
import br.com.fiap.veiculo.pagamento.presentation.dto.PagamentoDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/incluir")
    public void incluirPagamento(@RequestBody PagamentoDTO pagamentoDto) {

//        pagamentoService.incluirPagamento(pagamentoDto);
    }

    @GetMapping("/sucesso")
    public String getMensagemSucesso() {
        return "SUCESSO!!!!";
    }

}
