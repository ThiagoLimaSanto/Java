package com.mycompany.algoritimo356;

import java.util.Scanner;

public class Algoritimo356 {

    public static void main(String[] args) {
        double media = 0.00;
        double notas = 0.00;

        int linha = 2;
        int coluna = 5;

        Scanner scan = new Scanner(System.in);
        Object[][] matriz = new Object[linha][coluna];

        for (int l = 0; l < linha; l++) {
            media = 0.00;
            System.out.println("Digite um nome: ");
            String nome = scan.nextLine();
            matriz[l][0] = nome;
            for (int c = 1; c < coluna - 2; c++) {
                System.out.println("nota: ");
                notas = scan.nextDouble();
                scan.nextLine();
                media += notas;
                matriz[l][c] = notas;
            }
            media = media / 2;
            matriz[l][3] = media;
            if (media >= 6.0) {
                matriz[l][4] = "Aprovado!";
            } else {
                matriz[l][4] = "reprovado!";
            }
        }
        System.out.println("Nome | PR1 | PR2 | Media | Situacao");
        for (int l = 0; l < linha; l++) {
            for (int c = 0; c < coluna; c++) {
                System.out.print(matriz[l][c] + " | ");
            }
            System.out.print("\n");
        }
    }
}
