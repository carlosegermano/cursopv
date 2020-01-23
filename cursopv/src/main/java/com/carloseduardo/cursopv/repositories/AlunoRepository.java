package com.carloseduardo.cursopv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carloseduardo.cursopv.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	@Transactional(readOnly=true)
	Aluno findByEmail(String email);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Aluno obj WHERE obj.nome LIKE %:nome%")
	Aluno search(@Param("nome") String nome);
}
