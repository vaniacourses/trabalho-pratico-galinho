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
		// Testando
		Cliente cliente1 = new Cliente("lucas");
		Cliente cliente2 = new Cliente("joao");
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);

		Veiculo veiculo1 = new Veiculo("abc2034", cliente1, null, null, null, null);
		Veiculo veiculo2 = new Veiculo("def2034", cliente2, null, null, null, null);
		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);

		// Usando setters para garantir que os tipos (como o BigDecimal) estão corretos
		Servico servico1 = new Servico();
		servico1.setDescricao("Troca de Óleo");
		servico1.setOrcamento(new java.math.BigDecimal("350.00"));
		servico1.setVeiculo(veiculo1);

		Servico servico2 = new Servico();
		servico2.setDescricao("Revisão Completa");
		servico2.setOrcamento(new java.math.BigDecimal("1200.00"));
		servico2.setVeiculo(veiculo1);

		Servico servico3 = new Servico();
		servico3.setDescricao("Troca de Pneus");
		servico3.setOrcamento(new java.math.BigDecimal("800.00"));
		servico3.setVeiculo(veiculo2);

		servicoRepository.save(servico1);
		servicoRepository.save(servico2);
		servicoRepository.save(servico3);
	}
}	