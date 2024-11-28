package com.loja;

import com.loja.modelo.Produto;
import com.loja.gerenciador.GerenciadorProdutos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância do Gerenciador de Produtos
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();

        // Cria e cadastra alguns produtos
        Produto p1 = new Produto("Notebook", 2500.00, 10, "Eletrônicos");
        Produto p2 = new Produto("Smartphone", 1500.00, 20, "Eletrônicos");
        Produto p3 = new Produto("Cadeira", 450.00, 5, "Móveis");

        gerenciador.criar(p1);
        gerenciador.criar(p2);
        gerenciador.criar(p3);

        // Lista todos os produtos
        System.out.println("=== Lista de Produtos ===");
        List<Produto> produtos = gerenciador.listarTodos();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }

        // Busca por ID (exemplo com ID 2)
        System.out.println("\n=== Buscar Produto por ID (ID: 2) ===");
        Produto produtoBuscado = gerenciador.buscarPorId(2);
        if (produtoBuscado != null) {
            System.out.println("Produto encontrado: " + produtoBuscado);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
