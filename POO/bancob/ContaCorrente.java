package com.mycompany.bancob;

public class ContaCorrente {

    private double saldoDoTitular;
    private String senhaDoTitular;
    private String nomeDoTitular;
    private String receberPix;
    private String cpf;
    

    public ContaCorrente(String nome, String senha, String cpf){
        this.saldoDoTitular = 0.00;
        this.senhaDoTitular = senha;
        this.nomeDoTitular = nome;
        this.cpf = cpf;
        this.receberPix = "joaozinho123@gamail.com";
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

    public void setCpf(String agenciaDoBanco) {
        this.cpf = agenciaDoBanco;
    }

    public String getReceberPix() {
        return receberPix;
    }

    public void setReceberPix(String receberPix) {
        this.receberPix = receberPix;
    }

    
    public boolean depositar(double valorDepositar) {
        if(valorDepositar > 0){
            this.setSaldoDoTitular(saldoDoTitular + valorDepositar);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean sacar(double saque) {
        if (saque > this.getSaldoDoTitular()) {
            return false;
        } else {
            this.setSaldoDoTitular(saldoDoTitular - saque);
            return true;
        }
    }

    public boolean transferir(double valor, String pix) {
        if (sacar(valor) && pix.equals(this.getReceberPix())) {
                depositar(valor);
                sacar(valor);
                return true;
        }
        return false;
    }
}
