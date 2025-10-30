package br.com.fiap.veiculo.pagamento.infraestructure.repository;

import br.com.fiap.veiculo.pagamento.domain.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    
}
