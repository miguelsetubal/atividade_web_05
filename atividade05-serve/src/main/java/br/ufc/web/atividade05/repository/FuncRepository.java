package br.ufc.web.atividade05.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.web.atividade05.model.Func;

public interface FuncRepository extends JpaRepository<Func, Integer>{
	List<Func> findByCargo(String cargo);
	
	@Query(value = "SELECT * FROM funcionarios LIMIT ?1", nativeQuery = true)
	List<Func> findByQtd(int qtd);
}
