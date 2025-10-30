package br.com.fiap.veiculo.pagamento.domain.service;

import br.com.fiap.veiculo.pagamento.domain.model.Pagamento;
import br.com.fiap.veiculo.pagamento.infraestructure.repository.PagamentoRepository;
import br.com.fiap.veiculo.pagamento.presentation.assembler.PagamentoAssembler;
import br.com.fiap.veiculo.pagamento.presentation.dto.PagamentoDTO;
import br.com.fiap.veiculo.pagamento.presentation.dto.ReservaDto;
import br.com.fiap.veiculo.pagamento.presentation.enumerado.Status;
import br.com.fiap.veiculo.pagamento.presentation.exception.PagamentoException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;
    private final PagamentoAssembler assembler;
    private final ReservaService reservaService;

    public PagamentoService(PagamentoRepository repository, PagamentoAssembler assembler, ReservaService reservaService) {

        this.repository = repository;
        this.assembler = assembler;
        this.reservaService = reservaService;
    }

    public void incluirPagamento(PagamentoDTO pagamentoDto) {

        Pagamento pagamento = assembler.dtoParaModelo(pagamentoDto);
        ReservaDto reserva = reservaService.buscarReservaPorCodigo(pagamentoDto.codigoPagamento());

        try {
            if(Objects.nonNull(reserva)) {
                pagamento.setStatus(Status.APROVADO);
                repository.save(pagamento);

//                Veiculo veiculo = veiculoAssembler.dtoParaModelo(veiculoService.consultarPorId(reserva.veiculoDto().id()));
//                veiculo.setVendido(true);
//
//                veiculoService.inserirVeiculo(veiculoAssembler.modeloParaDto(veiculo));

            } else {
                pagamento.setStatus(Status.RECUSADO);
                repository.save(pagamento);
                throw new PagamentoException("O pagamento não pode ser realizado sem reserva posterior");
            }
        } catch (Exception e) {
            throw new PagamentoException("O pagamento não foi realizado", e);
        }


    }
}
