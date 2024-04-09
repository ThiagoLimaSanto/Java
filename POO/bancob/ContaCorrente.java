package com.mycompany.bancob;

public class ContaCorrente extends Conta {

    public ContaCorrente(PessoaFisica p) {
        super(p);
    }
    public boolean verificaDeposito(double valorDepositar) {
        if (valorDepositar > 0) {
            depositar(valorDepositar);
            return true;
        }
        return false;
    }
    public boolean verificaSaque(double saque) {
        if (saque <= p.getSaldo()) {
            sacar(saque);
            return true;
        }
        return false;
    }

    public boolean verificaTransferencia(double valor, String pix, PessoaFisica c2) {
        if (valor <= p.getSaldo() && pix.contains(c2.getPix())) {
            transferir(valor, pix, c2);
            return true;
        }
        return false;
    }
}