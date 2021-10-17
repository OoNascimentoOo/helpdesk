package com.luan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luan.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
	
	

}
