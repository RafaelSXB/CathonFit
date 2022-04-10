package com.fit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.fit.demo.model.produto;

public interface ProdutosRepository extends CrudRepository<produto, Long> {

	produto findById(long id);
	
	produto findByNome(String nome);
	
	// Query para a busca
	@Query(value = "select u from produto u where u.nome like %?1%")
	List<produto>findByNomes(String nome);

}
