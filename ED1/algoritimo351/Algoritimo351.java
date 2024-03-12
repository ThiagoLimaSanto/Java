package com.mycompany.algoritimo351;

import java.util.Scanner;

public class Algoritimo351 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] matriz = new String[5][1];

        for (int l = 0; l < 5; l++) {
            System.out.println("Digite um nome");
            String nome = scan.nextLine();
            matriz[l][0] = nome;
        }

        System.out.println("Digite um numero entre 1-5");
        int index = scan.nextInt();
        System.out.println(matriz[index-1][0]);
    }
}
