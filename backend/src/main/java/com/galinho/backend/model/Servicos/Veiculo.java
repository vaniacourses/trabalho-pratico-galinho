package com.galinho.backend.model.Servicos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.galinho.backend.model.Usuarios.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String placa;
    
    @OneToMany(mappedBy = "veiculo")
    @JsonIgnore
    private List<Servico> servicos;
    
    @ManyToOne
    private Cliente cliente;

    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    public Veiculo(String placa, Cliente cliente, String marca, String modelo, String ano, String cor) {
        this.placa = placa;
        this.cliente = cliente;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public Veiculo orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }
}
