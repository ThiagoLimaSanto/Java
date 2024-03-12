package com.mycompany.algoritimo348;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algoritimo348 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Map<String, List<Double>> mapa = new HashMap<>();
        
        List<Double> lista = new ArrayList();
        List<Double> lista2 = new ArrayList();
        
        Alunos aluno = new Alunos();
        Alunos aluno2 = new Alunos();
        Alunos notas = new Alunos();
        
        
        System.out.println("Qual o nome do aluno 1: ");
        aluno.nome = scan.nextLine();
        for(int i = 0; i<5; i++){
            System.out.printf("Qual a %d nota: ",i+1 , "\n");
            notas.notas = scan.nextInt();
            scan.nextLine();
            lista.add(notas.notas);
        }
        
        System.out.println("Qual o nome do aluno 2: ");
        aluno2.nome = scan.nextLine();
       
        for(int i = 0; i<5; i++){
            System.out.printf("Qual a %d nota: ",i+1 , "\n");
            notas.notas = scan.nextInt();
            lista2.add(notas.notas);
        }
     
        mapa.put(aluno.nome, lista);
        mapa.put(aluno2.nome, lista2);
        
        System.out.println(aluno.nome+" = "+mapa.get(aluno.nome));
        System.out.println(aluno2.nome+" = "+mapa.get(aluno2.nome));
    }
}
