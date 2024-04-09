package com.mycompany.bancob;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String senha, String nmrConta, double saldo, String pix, String cpf) {
        super(nome, senha, nmrConta, saldo, pix);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}