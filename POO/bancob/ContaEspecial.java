package com.mycompany.bancob;

public class ContaEspecial extends Conta{
    private double cheque;

    public ContaEspecial(PessoaFisica p) {
        super(p);
        this.cheque = 2000;
    }

    public double getCheque() {
        return cheque;
    }

    public void setCheque(double cheque) {
        this.cheque = cheque;
    }
    
    public boolean verificaLimite(double saque){
        if(saque <= (p.getSaldo() + getCheque())){
            sacar(saque);
            return true;
        }
        return false;
    }
    
    public boolean transferencia(double valor, String pix, PessoaFisica c2){
        if(valor <= (p.getSaldo() + getCheque())){
            transferir(valor, pix, c2);
            return true;
        }
        return false;
    }
}