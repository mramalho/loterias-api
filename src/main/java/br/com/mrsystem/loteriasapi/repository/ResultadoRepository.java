package br.com.mrsystem.loteriasapi.repository;

import java.util.List;
import java.util.Optional;

import br.com.mrsystem.loteriasapi.model.Resultado;
import br.com.mrsystem.loteriasapi.model.ResultadoId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends MongoRepository<Resultado, ResultadoId> {

	List<Resultado> findById_Loteria(String loteria);

	@Query(sort = "{ '_id.concurso' : -1 }")
	Optional<Resultado> findTopById_Loteria(String loteria);

}
