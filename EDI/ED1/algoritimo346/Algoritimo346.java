package com.mycompany.algoritimo346;

import java.util.Scanner;

public class Algoritimo346 {

    public static void main(String[] args) {
        int escolha = 0;
        int parada = 0;
        
        Scanner scan = new Scanner(System.in);
        
        while(parada != 4){
            System.out.println("---------------------Menu---------------------");
            System.out.println(
                      "[1]- Imprime o comprimento da frase\n"
                    + "[2]- Imprime os dois primeiros e os dois últimos caracteres da frase\n"
                    + "[3]- Imprime a frase espelhada\n"
                    + "[4]- Termina o algoritmo");
            escolha = scan.nextInt();
            scan.nextLine();
            
            switch(escolha){

                case 1:
                    System.out.println("Digite uma frase: ");
                    String frase = scan.nextLine().replaceAll("\\s", "");
                    System.out.println("O tamanho da frase é: "+ frase.length());
                    break;
                    
                case 2:
                    System.out.println("Digite uma frase: ");
                    frase = scan.nextLine().replaceAll("\\s", "");
                    String comeco2Digitos = frase.substring(0, 2);
                    String termina2Digitos = frase.substring(frase.length()-2);
                    System.out.println("Os dois primeiros caracteres: "+comeco2Digitos);
                    System.out.println("Os dois ultimos caracteres: "+termina2Digitos);
                    break;
                    
                case 3:
                    System.out.println("digite uma frase: ");
                    frase = scan.nextLine();
                    for(int i = frase.length()-1; i >= 0; i--){
                        System.out.print(frase.charAt(i));
                    }
                    System.out.println("");
                    break;
                    
                case 4:
                    parada = 4;
                    break;
                    
                default:
                    System.out.println("ERROR!!!");
                    break;
            }
        }
    }
}
