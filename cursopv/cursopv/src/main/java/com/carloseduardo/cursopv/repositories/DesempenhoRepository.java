package com.carloseduardo.cursopv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carloseduardo.cursopv.domain.Desempenho;

@Repository
public interface DesempenhoRepository extends JpaRepository<Desempenho, Integer> {

	
}
