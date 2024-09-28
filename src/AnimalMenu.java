import animal.Animal;
import animal.Cachorro;
import animal.Gato;
import animal.Vaca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalMenu {
    private List<Animal> animais;

    public AnimalMenu() {
        animais = new ArrayList<>();
        inicializarAnimais();
    }

    private void inicializarAnimais() {
        animais.add(new Cachorro());
        animais.add(new Gato());
        animais.add(new Vaca());
    }

    public void mostrarMenu(Scanner scanner) { // Use o scanner passado
        int opcao;
        do {
            System.out.println("\n--- Menu Animais ---");
            System.out.println("1. Emitir Som de Todos os Animais");
            System.out.println("2. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Use o scanner passado

            switch (opcao) {
                case 1:
                    for (Animal animal : animais) {
                        animal.emitirSom();
                    }
                    break;
                case 2:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 2);
    }
}
