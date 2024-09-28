package model;

public class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public double calcularBonus() {
        return 0; // Método a ser sobrescrito
    }

    public void trabalhar() {
        System.out.println(nome + " está trabalhando.");
    }
}
