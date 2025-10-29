package br.com.fiap.veiculo.pagamento.infraestructure.repository;

import br.com.fiap.veiculo.pagamento.domain.model.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, Long>{
}
