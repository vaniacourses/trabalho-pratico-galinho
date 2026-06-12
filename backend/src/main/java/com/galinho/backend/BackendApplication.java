package com.galinho.backend;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.galinho.backend.model.Servicos.HistoricoServico;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.model.Servicos.Tarefa.TarefaAdicional;
import com.galinho.backend.model.Servicos.Tarefa.TarefaEntity;
import com.galinho.backend.model.Servicos.Tarefa.TarefaSimples;
import com.galinho.backend.repository.ClienteRepository;
import com.galinho.backend.repository.HistoricoServicoRepository;
import com.galinho.backend.repository.ServicoRepository;
import com.galinho.backend.repository.VeiculoRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private HistoricoServicoRepository historicoServicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    
    	//Testando
		Cliente cliente = new Cliente("cliente@gmail.com",
				new BCryptPasswordEncoder().encode("123"),
				"Cliente 1",
				"12345678920",
				"22997512135",
				"rua tal");
		usuarioRepository.save(cliente);
    
    	Veiculo veiculo1 = new Veiculo("abc2034", cliente, null, null, null, null);
    
		cliente = new Cliente("cliente2@gmail.com",
					new BCryptPasswordEncoder().encode("123"),
					"Cliente 2",
					"12345678910",
					"22997512135",
					"rua tal");
		usuarioRepository.save(cliente);
    
    	Veiculo veiculo2 = new Veiculo("def2034", cliente, null, null, null, null);

		Usuario usuario = new Caixa("caixa@gmail.com",
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
		
		Servico servico1 = new Servico("teste", new BigDecimal(10000), LocalDateTime.of(2010, 10, 10, 10, 30, 0), veiculo1);
		Servico servico2 = new Servico("teste2", new BigDecimal(10002), LocalDateTime.of(2010, 10, 10, 10, 30, 0), veiculo1);
		Servico servico3 = new Servico("teste3", new BigDecimal(10004), LocalDateTime.of(2010, 10, 10, 10, 30, 0), veiculo2);
    
    	TarefaEntity tarefa1 = new TarefaSimples(LocalDateTime.now(), new BigDecimal(50), "Tarefa base 1");
		TarefaEntity tarefa1_1 = new TarefaAdicional(LocalDateTime.now(), new BigDecimal(100), "Tarefa cobertura de 1", tarefa1);
		TarefaEntity tarefa1_2 = new TarefaAdicional(LocalDateTime.now(), new BigDecimal(100), "Tarefa cobertura de 1_1", tarefa1_1);;
		//servico1.setConjuntoTarefas(tarefa1);
		//servico1.setConjuntoTarefas(tarefa1_1);
		servico1.setConjuntoTarefas(tarefa1_2);
		
		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);
		servicoRepository.save(servico1);
		servicoRepository.save(servico2);
		servicoRepository.save(servico3);
		//historicoServicoRepository.save(hist1);
		//historicoServicoRepository.save(hist2);
		//historicoServicoRepository.save(hist3);


	}
}
