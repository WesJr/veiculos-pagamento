package br.com.fiap.veiculo.pagamento.domain.model;

import br.com.fiap.veiculo.pagamento.presentation.enumerado.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "pagamento", schema = "public")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_venda")
    private LocalDateTime dataVenda;

    @Column(name = "valor_remanescente")
    private BigDecimal valorRemanescente;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "codigo_pagamento")
    private String codigoPagamento;
}
