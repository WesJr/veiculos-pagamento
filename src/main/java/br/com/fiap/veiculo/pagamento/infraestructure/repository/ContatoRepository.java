package br.com.fiap.veiculo.pagamento.infraestructure.repository;

import br.com.fiap.veiculo.pagamento.domain.model.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Long> {
}
