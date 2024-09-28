package model;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.10; // 10% do salário
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está desenvolvendo software.");
    }
}
