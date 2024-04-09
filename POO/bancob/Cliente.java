package com.mycompany.bancob;

public class Cliente {
    private String nome;
    private String senha;
    private String nmrConta;
    private String pix;
    private double saldo;

    public Cliente(String nome, String senha, String nmrConta, double saldo, String pix) {
        this.nome = nome;
        this.senha = senha;
        this.nmrConta = nmrConta;
        this.pix = pix;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNmrConta() {
        return nmrConta;
    }

    public void setNmrConta(String nmrConta) {
        this.nmrConta = nmrConta;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }   

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}