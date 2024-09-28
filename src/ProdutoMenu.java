import model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoMenu {
    private List<Produto> produtos;

    public ProdutoMenu() {
        this.produtos = new ArrayList<>();  // Inicializa a lista de produtos
    }

    public void mostrarMenu(Scanner scanner) {
        int opcaoModel;

        do {
            System.out.println("\n--- Produtos ---");
            System.out.println("1. Criar Produto");
            System.out.println("2. Lista de Produtos");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoModel = scanner.nextInt();

            switch (opcaoModel) {
                case 1:
                    criarProduto(scanner);  // Cria um novo produto
                    break;
                case 2:
                    listarProdutos(scanner);  // Lista todos os produtos criados
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);  // Sai do programa
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoModel != 3);
    }

    // Criar Produto
    private void criarProduto(Scanner scanner) {
        String nomeProduto;
        double preco = -1;
        int estoque = -1;

        // Solicitar nome do produto
        System.out.print("Nome do produto: ");
        nomeProduto = scanner.next();

        // Solicitar preço do produto até que seja positivo
        while (preco < 0) {
            System.out.print("Preço do produto (positivo): ");
            preco = scanner.nextDouble();
            if (preco < 0) {
                System.out.println("Erro: não aceita valores negativos. Tente novamente.");
            }
        }

        // Solicitar quantidade em estoque até que seja positiva
        while (estoque < 0) {
            System.out.print("Quantidade em estoque (positiva): ");
            estoque = scanner.nextInt();
            if (estoque < 0) {
                System.out.println("Erro: não aceita quantidades negativas. Tente novamente.");
            }
        }

        // Criar e adicionar o produto
        Produto produto = new Produto(nomeProduto, preco, estoque);
        produtos.add(produto);  // Adiciona o produto na lista
        System.out.println("Produto " + nomeProduto + ", cadastrado com sucesso!");
    }

    // Listar Produtos
    private void listarProdutos(Scanner scanner) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");  // Mensagem corrigida
            return;
        }

        System.out.println("\n--- Lista de Produtos ---");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i).getNome());
        }

        // Solicitar escolha do produto
        int opcaoProduto;
        do {
            System.out.println("\nEscolha um produto para acessar, ou 0 para voltar:");
            opcaoProduto = scanner.nextInt();

            if (opcaoProduto > 0 && opcaoProduto <= produtos.size()) {
                acessarProduto(scanner, produtos.get(opcaoProduto - 1));  // Acessa um produto específico
            } else if (opcaoProduto != 0) {
                System.out.println("Esse item não existe. Por favor, insira um número válido.");
            }
        } while (opcaoProduto != 0);  // Permite voltar ao menu
    }

    // Acessar Produto
    private void acessarProduto(Scanner scanner, Produto produto) {
        int opcaoAcessar;

        do {
            System.out.println("\n--- Produto: " + produto.getNome() + " ---");
            System.out.println("1. Ver detalhes do produto");
            System.out.println("2. Aplicar desconto");
            System.out.println("3. Voltar ao menu de produtos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoAcessar = scanner.nextInt();

            switch (opcaoAcessar) {
                case 1:
                    verDetalhesProduto(produto);  // Mostra detalhes do produto
                    break;
                case 2:
                    aplicarDesconto(scanner, produto);  // Aplica desconto no produto
                    break;
                case 3:
                    System.out.println("Voltando ao menu de produtos...");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoAcessar != 3);
    }

    // Ver Detalhes do Produto
    private void verDetalhesProduto(Produto produto) {
        System.out.println("\n--- Detalhes do Produto ---");
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: " + produto.getPreco());
        System.out.println("Quantidade em estoque: " + produto.getQuantidadeEstoque());
    }

    // Aplicar Desconto
    private void aplicarDesconto(Scanner scanner, Produto produto) {
        System.out.print("Porcentagem de desconto: ");
        double desconto = scanner.nextDouble();

        try {
            produto.aplicarDesconto(desconto);
            System.out.println("Desconto aplicado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
