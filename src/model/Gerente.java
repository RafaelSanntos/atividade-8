package model;

public class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.20; // 20% do salário
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está gerenciando a equipe.");
    }
}
