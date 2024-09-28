import folhaDePagamento.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FolhaDePagamentoMenu {
    private List<Funcionario> funcionarios;

    public FolhaDePagamentoMenu() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void listarFuncionarios() {
        System.out.println("\n--- Lista de Funcionários ---");
        for (Funcionario f : funcionarios) {
            String cargo = f.getClass().getSimpleName();
            System.out.println("Nome: " + f.getNome() + ", Salário: " + f.calcularSalario() + ", Cargo: " + cargo);
        }
    }

    public void calcularFolhaPagamento() {
        double totalSalarios = 0;
        double totalBonus = 0;

        for (Funcionario f : funcionarios) {
            totalSalarios += f.calcularSalario();
            totalBonus += f.calcularBonus();
        }

        System.out.println("Total de Salários: " + totalSalarios);
        System.out.println("Total de Bônus: " + totalBonus);
    }

    public void promoverFuncionario(Funcionario funcionario, Funcionario novoFuncionario) {
        funcionarios.remove(funcionario);
        funcionarios.add(novoFuncionario);
    }

    public void mostrarMenu(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n--- Menu Folha de Pagamento ---");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Lista de Funcionários");
            System.out.println("3. Calcular Folha de Pagamento");
            System.out.println("4. Promover Funcionário");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarFuncionarioMenu(scanner);
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    calcularFolhaPagamento();
                    break;
                case 4:
                    promoverFuncionarioMenu(scanner);
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                case 6:
                    System.out.println("Saindo da aplicação...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);
    }

    private void adicionarFuncionarioMenu(Scanner scanner) {
        System.out.print("Nome do Funcionário: ");
        String nome = scanner.next();
        System.out.print("Salário Base: ");
        double salarioBase = scanner.nextDouble();
        System.out.println("Tipo de Funcionário (1-Gerente, 2-Desenvolvedor, 3-Estagiário): ");
        int tipo = scanner.nextInt();

        Funcionario funcionario = null;
        switch (tipo) {
            case 1:
                funcionario = new Gerente(nome, salarioBase);
                break;
            case 2:
                funcionario = new Desenvolvedor(nome, salarioBase);
                break;
            case 3:
                funcionario = new Estagiario(nome, salarioBase);
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        adicionarFuncionario(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    private void promoverFuncionarioMenu(Scanner scanner) {
        System.out.print("Nome do Funcionário a ser promovido: ");
        String nome = scanner.next();
        Funcionario funcionario = null;

        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(nome)) {
                funcionario = f;
                break;
            }
        }

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        System.out.println("Novo Tipo de Funcionário (1-Gerente, 2-Desenvolvedor, 3-Estagiário): ");
        int tipo = scanner.nextInt();
        Funcionario novoFuncionario = null;

        switch (tipo) {
            case 1:
                novoFuncionario = new Gerente(funcionario.getNome(), funcionario.getSalarioBase());
                break;
            case 2:
                novoFuncionario = new Desenvolvedor(funcionario.getNome(), funcionario.getSalarioBase());
                break;
            case 3:
                novoFuncionario = new Estagiario(funcionario.getNome(), funcionario.getSalarioBase());
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        promoverFuncionario(funcionario, novoFuncionario);
        System.out.println("Funcionário promovido com sucesso!");
    }
}
