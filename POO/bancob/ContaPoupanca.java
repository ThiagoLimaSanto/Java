package com.mycompany.bancob;

public class ContaPoupanca {
    PessoaFisica p;

    public ContaPoupanca(PessoaFisica conta) {
        this.p = conta;
    }
    
    public boolean rendimento(int periodo){
        if(periodo > 2){
            p.setSaldo((p.getSaldo() * 0.005)+ p.getSaldo());
            return true;
        }
        return false;
    }
}