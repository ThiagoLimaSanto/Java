package com.mycompany.sistema;

import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Venda produto = new Venda();
        
        String nome = "televisao";
        String marca = "sony";
        double preco = 1500.00;
        int estoque = 20;
        String codigoUnico = "12345";
        
        
        Banco dados = new Banco(nome, marca, preco, estoque, codigoUnico);
        
        
        System.out.println("codigo unico do produto");
        String codigo = scan.nextLine();
        
        
        boolean retorno = produto.venda(codigo, dados.getCodigoUnico());
        
        if(retorno){
            System.out.println("Venda realizada com sucesso!");
            produto.setRegistraVenda(+1);
            dados.setEstoque(-1);
        }else{
            System.out.println("ERROR");
        }
        
        System.out.println("Estoque: "+dados.getEstoque());
        System.out.println("Vendas: "+produto.getRegistraVenda());
        
        System.out.println("Qual novo valor do preco do produto: ");
        double precoNovo = scan.nextDouble();
        scan.nextLine();
        
        dados.setPreco(precoNovo);
        
        System.out.println("Novo preco do produto: R$"+dados.getPreco());
    }
}
