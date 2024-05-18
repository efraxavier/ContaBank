package com.example.contabank;

public class ContaEspecial extends ContaBancaria {
    private float limite;

    public ContaEspecial(String cliente, int num_conta, float saldoInicial, float limite) {
        super(cliente, num_conta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public void sacar(float valor) {
        if (valor > saldo + limite) {
            System.out.println("Saldo insuficiente. Limite excedido.");
        } else {
            saldo -= valor;
        }
    }

    @Override
    public String toString() {
        return "ContaEspecial{" +
                "cliente='" + cliente + '\'' +
                ", num_conta=" + num_conta +
                ", saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }
}
