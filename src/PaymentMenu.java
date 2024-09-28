import payment.Boleto;
import payment.CartaoCredito;
import payment.FormaPagamento;
import payment.Pix;

import java.util.Scanner;

public class PaymentMenu {
    private Scanner scanner;

    public PaymentMenu(Scanner scanner) { // Recebe o scanner como parâmetro
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcao;
        double valor;
        FormaPagamento pagamento = null;

        do {
            System.out.println("\n--- Menu de Pagamento ---");
            System.out.println("1. Cartão de Crédito");
            System.out.println("2. Boleto");
            System.out.println("3. Pix");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 3) {
                System.out.print("Digite o valor do pagamento: R$");
                valor = scanner.nextDouble();

                switch (opcao) {
                    case 1:
                        pagamento = new CartaoCredito(); // Certifique-se de que está importado
                        break;
                    case 2:
                        pagamento = new Boleto(); // Certifique-se de que está importado
                        break;
                    case 3:
                        pagamento = new Pix(); // Certifique-se de que está importado
                        break;
                }

                if (pagamento != null) {
                    pagamento.processarPagamento(valor);
                }
            } else if (opcao != 4) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }
}
