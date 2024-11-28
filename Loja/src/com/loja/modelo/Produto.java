package com.loja.modelo;

public class Produto {

    private Integer id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private String categoria;

    // Construtores usado para criar um novo produto com os dados fornecidos.

    public Produto(String nome, double preco, int quantidadeEstoque, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    // Get e set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        // Exibe as informações do produto
        return "ID: " + id + " | Nome: " + nome + " | Preço: R$ " + preco + " | Estoque: " + quantidadeEstoque + " | Categoria: " + categoria;
    }
}
