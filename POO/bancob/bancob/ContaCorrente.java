package com.mycompany.bancob;

public class ContaCorrente {

    private double saldoDoTitular;
    private String senhaDoTitular;
    private String nomeDoTitular;
    private String pix;
    private String cpf;
    

    public ContaCorrente(String nome, String senha, String cpf){
        this.saldoDoTitular = 0.00;
        this.senhaDoTitular = senha;
        this.nomeDoTitular = nome;
        this.cpf = cpf;
    }
    
    public ContaCorrente(String nome, double saldo, String pix, String cpf){
        this.saldoDoTitular = saldo;
        this.nomeDoTitular = nome;
        this.pix = pix;
        this.cpf = cpf;
    }

    public double getSaldoDoTitular() {
        return saldoDoTitular;
    }

    public void setSaldoDoTitular(double saldoDoTitular) {
        this.saldoDoTitular = saldoDoTitular;
    }

    public String getSenhaDoTitular() {
        return senhaDoTitular;
    }

    public void setSenhaDoTitular(String senhaDoTitular) {
        this.senhaDoTitular = senhaDoTitular;
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getReceberPix() {
        return pix;
    }

    public void setReceberPix(String receberPix) {
        this.pix = receberPix;
    }
  
    public boolean depositar(double valorDepositar) {
        if(valorDepositar > 0){
            this.setSaldoDoTitular(saldoDoTitular + valorDepositar);
            return true;
            }
        return false;
    }
    
    public boolean sacar(double saque) {
        if (saque > this.getSaldoDoTitular()) {
            return false;
        } else {
            this.setSaldoDoTitular(saldoDoTitular - saque);
            return true;
        }
    }

    public boolean transferir(double valor, String pix, ContaCorrente c2) {
        if (valor <= this.getSaldoDoTitular() && pix.contains(c2.pix)) {
                sacar(valor);
                c2.depositar(valor);
                return true;
        }
        return false;
    }
}
