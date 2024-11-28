package com.loja.ui;

import com.loja.gerenciador.GerenciadorProdutos;
import com.loja.modelo.Produto;

import java.util.List;
import java.util.Scanner;

public class MenuProdutos {
    private final GerenciadorProdutos gerenciador;
    private final Scanner scanner;

    // Construtor que inicializa o gerenciador de produtos e o scanner
    public MenuProdutos() {
        this.gerenciador = new GerenciadorProdutos();
        this.scanner = new Scanner(System.in);
    }

    // Método que exibe o menu principal de opções
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Buscar Produto por ID");
            System.out.println("3. Listar Todos os Produtos");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Deletar Produto");
            System.out.println("6. Buscar por Nome");
            System.out.println("7. Buscar por Categoria");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> buscarProdutoPorId();
                case 3 -> listarProdutos();
                case 4 -> atualizarProduto();
                case 5 -> deletarProduto();
                case 6 -> buscarPorNome();
                case 7 -> buscarPorCategoria();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    // Método para cadastrar um novo produto
    private void cadastrarProduto() {
        String nome = lerEntradaString("Digite o nome do produto: ");
        double preco = lerEntradaDouble("Digite o preço do produto: ");
        int quantidade = lerEntradaInteira("Digite a quantidade do produto: ");
        String categoria = lerEntradaString("Digite a categoria do produto: ");

        Produto produto = new Produto(nome, preco, quantidade, categoria);
        gerenciador.criar(produto);
    }

    // Método para buscar um produto por ID
    private void buscarProdutoPorId() {
        int id = lerEntradaInteira("Digite o ID do produto: ");
        Produto produto = gerenciador.buscarPorId(id);
        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Método para listar todos os produtos cadastrados
    private void listarProdutos() {
        List<Produto> produtos = gerenciador.listarTodos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    // Método para atualizar um produto existente
    private void atualizarProduto() {
        int id = lerEntradaInteira("Digite o ID do produto que deseja atualizar: ");
        Produto produto = gerenciador.buscarPorId(id);
        if (produto != null) {
            String nome = lerEntradaString("Digite o novo nome do produto: ");
            double preco = lerEntradaDouble("Digite o novo preço do produto: ");
            int quantidade = lerEntradaInteira("Digite a nova quantidade do produto: ");
            String categoria = lerEntradaString("Digite a nova categoria do produto: ");

            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidadeEstoque(quantidade);
            produto.setCategoria(categoria);

            gerenciador.atualizar(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Método para deletar um produto existente
    private void deletarProduto() {
        int id = lerEntradaInteira("Digite o ID do produto que deseja deletar: ");
        boolean sucesso = gerenciador.deletar(id);
        if (sucesso) {
            System.out.println("Produto deletado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Método para buscar produto por nome
    private void buscarPorNome() {
        String nome = lerEntradaString("Digite o nome do produto: ");
        List<Produto> produtos = gerenciador.buscarPorNome(nome);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    // Método para buscar produto por categoria
    private void buscarPorCategoria() {
        String categoria = lerEntradaString("Digite a categoria do produto: ");
        List<Produto> produtos = gerenciador.buscarPorCategoria(categoria);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    // Métodos auxiliares para validar e ler entradas do usuário

    // Ler entrada de string
    private String lerEntradaString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    // Ler entrada de double com validação
    private double lerEntradaDouble(String mensagem) {
        double valor;
        while (true) {
            try {
                System.out.print(mensagem);
                valor = Double.parseDouble(scanner.nextLine());
                if (valor <= 0) {
                    System.out.println("O preço deve ser maior que zero. Tente novamente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
        return valor;
    }

    // Ler entrada de inteiro com validação
    private int lerEntradaInteira(String mensagem) {
        int valor;
        while (true) {
            try {
                System.out.print(mensagem);
                valor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
        return valor;
    }
}
