package com.luan.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luan.helpdesk.domain.Chamado;
import com.luan.helpdesk.domain.Cliente;
import com.luan.helpdesk.domain.Tecnico;
import com.luan.helpdesk.domain.enums.Perfil;
import com.luan.helpdesk.domain.enums.Prioridade;
import com.luan.helpdesk.domain.enums.Status;
import com.luan.helpdesk.repositories.ChamadoRepository;
import com.luan.helpdesk.repositories.ClienteRepository;
import com.luan.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired //responsável por criar a instancia daquela interface, classe e gerenciar e destruir no tempo correto
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private ChamadoRepository chamadoRepository; //estou injetando dependencias

	public void instanciaDB() {
		
		

		Tecnico tec1 = new Tecnico(null, "Luan", "80421951419", "luan.ap07@outlook.com", "a1c3");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "joana", "84587411990", "joana@gmail.com", "abc");
		Tecnico tec3 = new Tecnico(null, "joão", "12373844273", "joao@hotmail.com", "joao");
		Tecnico tec4 = new Tecnico(null, "marco", "72818548381", "marco@outlook.com", "marco07");
		Tecnico tec5 = new Tecnico(null, "alice", "13156408212", "alice@hotmail.com", "alice@_");

		Cliente cli1 = new Cliente(null, "Maria", "08297103102", "maria@gmail.com", "123");
		Cliente cli2 = new Cliente(null, "igor", "59294617831", "igor07@gmail.com", "igor07");
		Cliente cli3 = new Cliente(null, "jessica", "51874378959", "jessica_j@outlook.com", "jessica123");
		Cliente cli4 = new Cliente(null, "debora", "30864618450", "debora@outlook.com", "debora!");
		Cliente cli5 = new Cliente(null, "alex", "56725105742", "alex@outlook.com", "alex123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "chamado 02", "segundo chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "chamado 03", "terceiro chamado", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 04", "quarto chamado", tec4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "chamado 05", "quinto chamado", tec5, cli5);

		// instancias criadas e salvas
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

	}

}
