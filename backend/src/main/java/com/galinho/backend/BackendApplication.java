package com.galinho.backend;

import com.galinho.backend.model.Usuarios.*;
import com.galinho.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuario = new Cliente("leticia@gmail.com",
				new BCryptPasswordEncoder().encode("123"),
				"Leticia",
				"12345678910",
				"22997512135",
				"rua tal");
		usuarioRepository.save(usuario);

		usuario = new Caixa("caixa@gmail.com",
				new BCryptPasswordEncoder().encode("123"),
				"Caixa",
				"12345678911",
				"21997512135");
		usuarioRepository.save(usuario);

		usuario = new Gerente("gerente@gmail.com",
				new BCryptPasswordEncoder().encode("123"),
				"Gerente",
				"12345678912",
				"23997512135");
		usuarioRepository.save(usuario);

		usuario = new GestorDeEstoque("gestor@gmail.com",
				new BCryptPasswordEncoder().encode("123"),
				"Gestor",
				"12345678913",
				"24997512135");
		usuarioRepository.save(usuario);

		usuario = new Mecanico("mecanico@gmail.com",
				new BCryptPasswordEncoder().encode("123"),
				"Mecanico",
				"12345678914",
				"25997512135",
				List.of("habilidade 1","habilidade 2"));
		usuarioRepository.save(usuario);
	}
}
