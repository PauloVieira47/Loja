package com.loja.gerenciador;

import com.loja.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
    private List<Produto> produtos;
    private int proximoId;

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
        this.proximoId = 1;
    }

    // Criar um novo produto e adicionar na lista
    public void criar(Produto produto) {
        validarProduto(produto);
        produto.setId(proximoId++);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Buscar produto por ID
    public Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    // Atualizar dados de um produto
    public boolean atualizar(Produto produto) {
        Produto produtoExistente = buscarPorId(produto.getId());
        if (produtoExistente != null) {
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());
            produtoExistente.setQuantidadeEstoque(produto.getQuantidadeEstoque());
            produtoExistente.setCategoria(produto.getCategoria());
            System.out.println("Produto atualizado com sucesso!");
            return true;
        }
        return false;
    }

    // Deletar um produto pelo ID
    public boolean deletar(int id) {
        Produto produto = buscarPorId(id);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto deletado com sucesso!");
            return true;
        }
        return false;
    }

    // Buscar produto por nome
    public List<Produto> buscarPorNome(String nome) {
        List<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(produto);
            }
        }
        return encontrados;
    }

    // Buscar produto por categoria
    public List<Produto> buscarPorCategoria(String categoria) {
        List<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getCategoria().toLowerCase().contains(categoria.toLowerCase())) {
                encontrados.add(produto);
            }
        }
        return encontrados;
    }

    // Validar os dados do produto
    private void validarProduto(Produto produto) {
        if (produto.getNome().isEmpty() || produto.getNome().length() < 2) {
            throw new IllegalArgumentException("Nome do produto deve ter no mínimo 2 caracteres.");
        }
        if (produto.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        if (produto.getQuantidadeEstoque() < 0) {
            throw new IllegalArgumentException("Quantidade no estoque não pode ser negativa.");
        }
        if (produto.getCategoria().isEmpty()) {
            throw new IllegalArgumentException("Categoria não pode ser vazia.");
        }
    }
}
