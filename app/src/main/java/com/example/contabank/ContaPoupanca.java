package com.example.contabank;

public class ContaPoupanca extends ContaBancaria {
    private int diaDeRendimento;

    public ContaPoupanca(String cliente, int num_conta, float saldoInicial, int diaDeRendimento) {
        super(cliente, num_conta, saldoInicial);
        this.diaDeRendimento = diaDeRendimento;
    }

    public void calcularNovoSaldo(float taxaRendimento) {
        saldo += saldo * taxaRendimento;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "cliente='" + cliente + '\'' +
                ", num_conta=" + num_conta +
                ", saldo=" + saldo +
                ", diaDeRendimento=" + diaDeRendimento +
                '}';
    }
}
