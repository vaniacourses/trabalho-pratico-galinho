package com.galinho.backend.controller.Financeiro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.galinho.backend.dto.Financeiro.FluxoFinanceiroCreate;
import com.galinho.backend.dto.Financeiro.FluxoFinanceiroDto;
import com.galinho.backend.dto.Financeiro.PagamentoCartaoCreate;
import com.galinho.backend.dto.Financeiro.PagamentoDinheiroCreate;
import com.galinho.backend.dto.Financeiro.PagamentoDto;
import com.galinho.backend.dto.Financeiro.PagamentoPixCreate;
import com.galinho.backend.service.Financeiro.CaixaService;
import com.galinho.backend.service.Financeiro.RecebimentoService;
import com.galinho.backend.service.Financeiro.RegistroFinanceiroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/financeiro")
@CrossOrigin("*")
public class FinanceiroController{
    @Autowired
    RecebimentoService recebimentoService;

    @Autowired
    CaixaService caixaService;

    @Autowired
    RegistroFinanceiroService registroService;
    

    // RECEBIMENTOS 
    @PostMapping("pagamentos/dinheiro/{idServico}")
    public ResponseEntity<PagamentoDto> pagarComDinheiro(
        @PathVariable Long idServico,
        @RequestBody @Valid PagamentoDinheiroCreate dto
    ){
        PagamentoDto dinheiro = recebimentoService.registrarPagamentoDinheiro(idServico, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dinheiro);
    }

    @PostMapping("pagamentos/pix/{idServico}")
    public ResponseEntity<PagamentoDto> pagarComPix(
        @PathVariable Long idServico,
        @RequestBody @Valid PagamentoPixCreate dto
    ){
        PagamentoDto pix = recebimentoService.registrarPagamentoPix(idServico, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pix);
    }

    @PostMapping("pagamentos/cartao/{idServico}")
    public ResponseEntity<PagamentoDto> pagarComCartao(
        @PathVariable Long idServico,
        @RequestBody @Valid PagamentoCartaoCreate dto
    ){
        PagamentoDto cartao = recebimentoService.registrarPagamentoCartao(idServico, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartao);
    }

    //CAIXA
    @PostMapping("/fluxos")
    public ResponseEntity<FluxoFinanceiroDto> adicionarFluxoManual(@RequestBody @Valid FluxoFinanceiroCreate dto) {
        FluxoFinanceiroDto novoFluxo = caixaService.gerarFluxo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFluxo);
    }

    @GetMapping("/fluxos/{id}")
    public ResponseEntity<FluxoFinanceiroDto> buscarFluxoPorId(@PathVariable Long id) {
        FluxoFinanceiroDto fluxo = caixaService.buscarPorId(id);
        return ResponseEntity.ok(fluxo);
    }

    @GetMapping("/fluxos")
    public ResponseEntity<List<FluxoFinanceiroDto>> listarTodosFluxos() {
        List<FluxoFinanceiroDto> fluxos = caixaService.listarFluxos();
        return ResponseEntity.ok(fluxos);
    }

    @DeleteMapping("/fluxos/{id}")
    public ResponseEntity<Void> deletarFluxo(@PathVariable Long id) {
        caixaService.deletarFluxo(id);
        return ResponseEntity.noContent().build();
    }

    // "EXTRATOS"
    @GetMapping("/fluxos/entradas")
    public ResponseEntity<List<FluxoFinanceiroDto>> listarEntradas() {
        List<FluxoFinanceiroDto> entradas = registroService.listarFluxosDeEntrada();
        return ResponseEntity.ok(entradas);
    }

    @GetMapping("/fluxos/saidas")
    public ResponseEntity<List<FluxoFinanceiroDto>> listarSaidas() {
        List<FluxoFinanceiroDto> saidas = registroService.listarFluxosDeSaida();
        return ResponseEntity.ok(saidas);
    }
}