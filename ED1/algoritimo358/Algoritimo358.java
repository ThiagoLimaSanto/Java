package com.mycompany.Algoritimo358;

import java.util.ArrayList;
import java.util.Random;

public class Algoritimo358 {

    public static void main(String[] args) {
        int mercadoriasAbaixoDe10 = 0;
        int mercadoriasMaior10 = 0;
        int mercadoriasMaior20 = 0;
        
        Random aleatorio = new Random();
        ArrayList<Integer> listaCompra = new ArrayList(100);
        ArrayList<Integer> listaVenda = new ArrayList(100);
        ArrayList<Integer> lucros = new ArrayList(100);
        
        for(int i = 0; i <100; i++){
            int numero = aleatorio.nextInt(1, 100);
            listaVenda.add(numero);
            numero = aleatorio.nextInt(1, 100);
            listaCompra.add(numero);
        }
        for(int i = 0; i<100; i++){
            int lucro = ((listaVenda.get(i) - listaCompra.get(i))/listaCompra.get(i))*100;
            lucros.add(lucro);
        }
        for(int i = 0; i<100; i++){
            if(lucros.get(i) < 10){
                mercadoriasAbaixoDe10 ++;
            }else if(lucros.get(i)>= 10 && lucros.get(i) <= 20){
                mercadoriasMaior10 ++;
            }else{
                mercadoriasMaior20 ++;
            }
        }
        
        
        System.out.println("lucro < 10% = "+mercadoriasAbaixoDe10);
        System.out.println("10 % <= lucro <= 20 % = "+ mercadoriasMaior10);
        System.out.println("lucro > 20 % = "+ mercadoriasMaior20);
    }
}