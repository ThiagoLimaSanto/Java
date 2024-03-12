package com.mycompany.sistema;

public class Banco {
    private double preco;
    private int estoque;
    private String nome;
    private String marca;
    private String codigoUnico;
    
    public Banco(String nome, String marca, double preco, int estoque, String codigoUnico){
        this.estoque = estoque;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.codigoUnico = codigoUnico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if(estoque <= 0){
            this.estoque += estoque ;
        }else{
            this.estoque -= estoque;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
        
    }
    
    public String getCodigoUnico(){
        return codigoUnico;
    }
    public void setCodigoUnico(String codigoUnico){
        this.codigoUnico = codigoUnico;
    }
}
