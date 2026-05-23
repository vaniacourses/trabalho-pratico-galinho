package com.galinho.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.model.Usuarios.Cliente;
import com.galinho.backend.repository.ClienteRepository;
import com.galinho.backend.repository.ServicoRepository;
import com.galinho.backend.repository.VeiculoRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
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
		//Testando
		Cliente cliente1 = new Cliente("lucas");
		Cliente cliente2 = new Cliente("joao");
		Veiculo veiculo1 = new Veiculo("abc2034", cliente1);
		Veiculo veiculo2 = new Veiculo("def2034", cliente2);
		Servico servico1 = new Servico("teste", 10000, null, veiculo1);
		Servico servico2 = new Servico("teste2", 10002, null, veiculo1);
		Servico servico3 = new Servico("teste3", 10004, null, veiculo2);
		clienteRepository.save(cliente2);
		clienteRepository.save(cliente1);
		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);
		servicoRepository.save(servico1);
		servicoRepository.save(servico2);
		servicoRepository.save(servico3);


	}
}
