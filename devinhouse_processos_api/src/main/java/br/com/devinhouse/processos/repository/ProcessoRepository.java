package br.com.devinhouse.processos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devinhouse.processos.entity.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer> {
	
}