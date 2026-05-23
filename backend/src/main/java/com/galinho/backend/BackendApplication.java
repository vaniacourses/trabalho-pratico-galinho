package com.galinho.backend;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.galinho.backend.model.Financeiro.HistoricoFinanceiro;
import com.galinho.backend.model.Servicos.HistoricoServico;
import com.galinho.backend.model.Servicos.Servico;
import com.galinho.backend.model.Servicos.Veiculo;
import com.galinho.backend.model.Usuarios.Cliente;
import com.galinho.backend.repository.ClienteRepository;
import com.galinho.backend.repository.HistoricoServicoRepository;
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
	@Autowired
	private HistoricoServicoRepository historicoServicoRepository;

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
		Servico servico1 = new Servico("teste", new BigDecimal(10000), null, veiculo1);
		Servico servico2 = new Servico("teste2", new BigDecimal(10002), null, veiculo1);
		Servico servico3 = new Servico("teste3", new BigDecimal(10004), null, veiculo2);
		//HistoricoServico hist1 = new HistoricoServico(servico1.getStatus(), servico1.getOrcamento(), servico1);
        //HistoricoServico hist2 = new HistoricoServico(servico2.getStatus(), servico2.getOrcamento(), servico2);
        //HistoricoServico hist3 = new HistoricoServico(servico3.getStatus(), servico3.getOrcamento(), servico3);
		

		clienteRepository.save(cliente2);
		clienteRepository.save(cliente1);
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
