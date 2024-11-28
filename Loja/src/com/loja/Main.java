package com.loja;

import com.loja.modelo.Produto;

public class Main {

    public static void main(String[] args) {

        Produto produto1 = new Produto("Camiseta", 49.90, 100, "Roupas");
        Produto produto2 = new Produto("Notebook", 2500.00, 30, "Eletrônicos");
        Produto produto3 = new Produto("Tênis", 199.90, 50, "Roupas");

        System.out.println("Produto 1: " + produto1);
        System.out.println("Produto 2: " + produto2);
        System.out.println("Produto 3: " + produto3);
        System.out.println("\nProduto 1 após atualização: " + produto1);
    }
}
