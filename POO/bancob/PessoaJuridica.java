package com.mycompany.bancob;

public class PessoaJuridica extends Cliente{
   private String cnpj;

    public PessoaJuridica(String nome, String senha, String nmrConta, double saldo, String pix, String cnpj) {
        super(nome, senha, nmrConta, saldo, pix);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}