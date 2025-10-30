package br.com.fiap.veiculo.pagamento.infraestructure.repository;

import br.com.fiap.veiculo.pagamento.domain.model.Pagamento;
import br.com.fiap.veiculo.pagamento.presentation.enumerado.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

    List<Pagamento> findByStatusAndAtualizado(Status status, boolean atualizado);
    
}
