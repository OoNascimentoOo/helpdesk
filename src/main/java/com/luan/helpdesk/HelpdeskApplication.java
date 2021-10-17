package com.luan.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luan.helpdesk.domain.Chamado;
import com.luan.helpdesk.domain.Cliente;
import com.luan.helpdesk.domain.Tecnico;
import com.luan.helpdesk.domain.enums.Perfil;
import com.luan.helpdesk.domain.enums.Prioridade;
import com.luan.helpdesk.domain.enums.Status;
import com.luan.helpdesk.repositories.ChamadoRepository;
import com.luan.helpdesk.repositories.ClienteRepository;
import com.luan.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired //responsável por criar a instancia daquela interface, classe e gerenciar e destruir no tempo correto
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private ChamadoRepository chamadoRepository; //estou injetando dependencias

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Luan", "80421951419", "luan.ap07@outlook.com", "a1c3");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Maria", "08297103102", "maria@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		//instancias criadas e salvas
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
		
		
		
		
		
		
		
	}

}
