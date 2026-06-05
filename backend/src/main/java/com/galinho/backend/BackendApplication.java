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

import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.model.Usuarios.Cliente;
import com.galinho.backend.repository.ClienteRepository;
import com.galinho.backend.repository.ServicoRepository;
import com.galinho.backend.repository.VeiculoRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private ServicoRepository servicoRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
    
    //Testando
		Usuario usuario = new Cliente("cliente@gmail.com",
				new BCryptPasswordEncoder().encode("123"),
				"Cliente 1",
				"12345678920",
				"22997512135",
				"rua tal");
		usuarioRepository.save(usuario);
    
    Veiculo veiculo1 = new Veiculo("abc2034", usuario);
    
    usuario = new Cliente("cliente2@gmail.com",
				new BCryptPasswordEncoder().encode("123"),
				"Cliente 2",
				"12345678910",
				"22997512135",
				"rua tal");
		usuarioRepository.save(usuario);
    
    Veiculo veiculo2 = new Veiculo("def2034", usuario);

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
		
		Servico servico1 = new Servico("teste", 10000, null, veiculo1);
		Servico servico2 = new Servico("teste2", 10002, null, veiculo1);
		Servico servico3 = new Servico("teste3", 10004, null, veiculo2);
		
		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);
		servicoRepository.save(servico1);
		servicoRepository.save(servico2);
		servicoRepository.save(servico3);
	}
}
