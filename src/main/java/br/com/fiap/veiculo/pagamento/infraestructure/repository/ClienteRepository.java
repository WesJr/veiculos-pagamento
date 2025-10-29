package br.com.fiap.veiculo.pagamento.infraestructure.repository;

import br.com.fiap.veiculo.pagamento.domain.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
