import transport.Bicicleta;
import transport.Carro;
import transport.IMeioTransporte;
import transport.Trem;

import java.util.Scanner;

public class TransporteMenu {
    private IMeioTransporte[] meiosTransporte;

    public TransporteMenu() {
        meiosTransporte = new IMeioTransporte[] {
                new Bicicleta(),
                new Carro(),
                new Trem()
        };
    }

    public void mostrarMenu(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Transporte ---");
            System.out.println("1. Acelerar Todos");
            System.out.println("2. Frear Todos");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Use o scanner passado

            switch (opcao) {
                case 1:
                    for (IMeioTransporte meio : meiosTransporte) {
                        meio.acelerar();
                    }
                    break;
                case 2:
                    for (IMeioTransporte meio : meiosTransporte) {
                        meio.frear();
                    }
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }
}
