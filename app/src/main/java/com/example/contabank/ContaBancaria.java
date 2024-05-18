package com.example.contabank;

public class ContaBancaria {
    protected String cliente;
    protected int num_conta;
    protected float saldo;

    public ContaBancaria(String cliente, int num_conta, float saldoInicial) {
        this.cliente = cliente;
        this.num_conta = num_conta;
        this.saldo = saldoInicial;
    }

    public String getCliente() {
        return cliente;
    }

    public int getNumConta() {
        return num_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void sacar(float valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
        }
    }

    public void depositar(float valor) {
        saldo += valor;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "cliente='" + cliente + '\'' +
                ", num_conta=" + num_conta +
                ", saldo=" + saldo +
                '}';
    }
}
