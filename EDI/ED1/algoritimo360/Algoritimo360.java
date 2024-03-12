package com.mycompany.algoritimo360;

import java.util.Scanner;

public class Algoritimo360 {

    public static void main(String[] args) {
        String valor = "";
        
        Scanner scan = new Scanner(System.in);
        String[][] matriz = new String[12][3];
        
        matriz[0][0] = "1";
        matriz[0][1] = "20";
        matriz[0][2] = "capricornio";
        matriz[1][0] = "2";
        matriz[1][1] = "19";
        matriz[1][2] = "aquario";
        matriz[2][0] = "3";
        matriz[2][1] = "20";
        matriz[2][2] = "peixes";
        matriz[3][0] = "4";
        matriz[3][1] = "20";
        matriz[3][2] = "aries";
        matriz[4][0] = "5";
        matriz[4][1] = "20";
        matriz[4][2] = "touro";
        matriz[5][0] = "6";
        matriz[5][1] = "20";
        matriz[5][2] = "gemeos";
        matriz[6][0] = "7";
        matriz[6][1] = "21";
        matriz[6][2] = "cancer";
        matriz[7][0] = "8";
        matriz[7][1] = "22";
        matriz[7][2] = "leao";
        matriz[8][0] = "9";
        matriz[8][1] = "22";
        matriz[8][2] = "virgem";
        matriz[9][0] = "10";
        matriz[9][1] = "22";
        matriz[9][2] = "libra";
        matriz[10][0] = "11";
        matriz[10][1] = "21";
        matriz[10][2] = "escorpiao";
        matriz[11][0] = "12";
        matriz[11][1] = "21";
        matriz[11][2] = "sargitario";
        
        while(true){
            System.out.println("Qual sua data de nascimento: (mes/dia/ano)");
            valor = scan.nextLine();
            if(valor.equals("9999")){break;}
            
            String[] data = valor.split("/");
            int mes = Integer.parseInt(data[0]);
            int dia = Integer.parseInt(data[1]);
            
            String condicao = matriz[mes-1][1];
            int ultdia = Integer.parseInt(condicao);
            int diaa = dia;
            if(diaa <= ultdia){
                System.out.println(matriz[mes-1][2]);
            }else{
                if(mes == 12){
                    mes = 0;
                }
                System.out.println(matriz[mes][2]);
            }
        }    
    }
}
