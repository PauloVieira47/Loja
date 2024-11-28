package com.loja.gerenciador;

import com.loja.modelo.Produto;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
    private List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    // Criar um novo produto
    public void criar(Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }


}
