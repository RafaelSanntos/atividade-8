import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcaoPrincipal;

        ProdutoMenu produtoMenu = new ProdutoMenu();
        FuncionarioMenu funcionarioMenu = new FuncionarioMenu();
        FolhaDePagamentoMenu folhaDePagamentoMenu = new FolhaDePagamentoMenu();
        AnimalMenu animalMenu = new AnimalMenu();
        TransporteMenu transporteMenu = new TransporteMenu();
        PaymentMenu paymentMenu = new PaymentMenu(scanner);

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Produtos");
            System.out.println("2. Funcionários");
            System.out.println("3. Animais");
            System.out.println("4. Transportes");
            System.out.println("5. Pagamentos");
            System.out.println("6. Calcular Folha de Pagamento");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = scanner.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    produtoMenu.mostrarMenu(scanner);
                    break;
                case 2:
                    funcionarioMenu.mostrarMenu(scanner);
                    break;
                case 3:
                    animalMenu.mostrarMenu(scanner);
                    break;
                case 4:
                    transporteMenu.mostrarMenu(scanner);
                    break;
                case 5:
                    paymentMenu.mostrarMenu();
                    break;
                case 6:
                    folhaDePagamentoMenu.mostrarMenu(scanner);
                    break;
                case 7:
                    System.out.println("Saindo da aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoPrincipal != 7);

        scanner.close();
    }
}
