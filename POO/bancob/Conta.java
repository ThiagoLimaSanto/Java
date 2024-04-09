package com.mycompany.bancob;

public class Conta {

    PessoaFisica p;

    public Conta(PessoaFisica p) {
        this.p = p;
    }

    public void depositar(double valorDepositar) {
        p.setSaldo(valorDepositar + p.getSaldo());
    }

    public void sacar(double saque) {
        p.setSaldo(p.getSaldo() - saque);
    }

    public void transferir(double valor, String pix, PessoaFisica c2) {
        sacar(valor);
        this.p = c2;
        depositar(valor);
    }
}
