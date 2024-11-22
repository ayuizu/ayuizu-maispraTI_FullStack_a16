package com.example.teste.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
}
