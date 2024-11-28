package com.loja;

import com.loja.modelo.Produto;
import com.loja.gerenciador.GerenciadorProdutos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância do Gerenciador de Produtos
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();

        // Cria e cadastra alguns produtos
        Produto p1 = new Produto("Notebook", 2500.00, 10, "Eletronicos");
        Produto p2 = new Produto("Smartphone", 1500.00, 20, "Eletronicos");
        Produto p3 = new Produto("Cadeira", 450.00, 5, "Móveis");

        gerenciador.criar(p1);
        gerenciador.criar(p2);
        gerenciador.criar(p3);



        }
    }

