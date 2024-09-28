import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Funcionario;
import model.Gerente;
import model.Desenvolvedor;

public class FuncionarioMenu {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Funcionários ---");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3 && opcao != 4);
    }

    private void cadastrarFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer

        if (salario < 0) {
            System.out.println("Salário não pode ser negativo. Tente novamente.");
            return;
        }

        System.out.print("Digite o tipo de funcionário (1 - Gerente, 2 - Desenvolvedor): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Funcionario funcionario;
        if (tipo == 1) {
            funcionario = new Gerente(nome, salario);
        } else {
            funcionario = new Desenvolvedor(nome, salario);
        }

        funcionarios.add(funcionario);
        System.out.println("Funcionário " + nome + " cadastrado com sucesso!");
    }

    private void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("--- Lista de Funcionários ---");
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
            System.out.println((i + 1) + ". " + f.getNome() + " - Salário: " + f.getSalario() + " - Bônus: " + f.calcularBonus());
            f.trabalhar(); // Chama o método trabalhar para cada funcionário
        }
    }
}
