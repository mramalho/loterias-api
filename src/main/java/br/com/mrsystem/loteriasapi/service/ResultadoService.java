package br.com.mrsystem.loteriasapi.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.mrsystem.loteriasapi.model.Resultado;
import br.com.mrsystem.loteriasapi.model.ResultadoId;
import br.com.mrsystem.loteriasapi.repository.ResultadoRepository;

@Service
public class ResultadoService {

	@Autowired
	private ResultadoRepository repository;

	@Cacheable("resultados")
	public List<Resultado> findByLoteria(String loteria) {
		return repository.findById_Loteria(loteria) //
				.stream() //
				.sorted(Comparator.comparing(Resultado::getConcurso).reversed()) //
				.collect(Collectors.toList());
	}

	public Resultado findByLoteriaAndConcurso(String loteria, int concurso) {
		return repository.findById(new ResultadoId(loteria, concurso)).orElse(null);
	}

	public Resultado findLatest(String loteria) {
		return repository.findTopById_Loteria(loteria).orElse(new Resultado());
	}

	public Resultado save(Resultado resultado) {
		return repository.save(resultado);
	}

	public void saveAll(List<Resultado> resultados) {
		repository.saveAll(resultados);
	}

}
