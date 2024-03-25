package com.mycompany.bancob;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<ContaCorrente> contas = new ArrayList<>();

        int escolha = 0;
        double valor = 0.00;
        int voltar = 0;
        String usuarioTransferencia;

        System.out.println("Criar conta");
        System.out.println("Nome: ");
        String nome = scan.nextLine();

        System.out.println("cpf: ");
        String cpf = scan.nextLine();

        System.out.println("Senha: ");
        String password = scan.nextLine();

        contas.add(new ContaCorrente(nome, password, cpf, "Thiago@gamail.com"));
        contas.add(new ContaCorrente("Pedro", 0.0, "pedro@gmail.com", "123456789", "98765"));
        ContaCorrente c1 = contas.get(0);
        ContaCorrente c2 = contas.get(1);

        while (true) {
            if (escolha != 0) {
                System.out.println(""
                        + "[0]-Logar\n"
                        + "[1]-Finalizar programa");
                escolha = scan.nextInt();
                scan.nextLine();
                if (escolha == 1) {
                    break;
                }
            }
            System.out.println("Acessar conta: ");
            System.out.println("cpf: ");
            String cpfVerifica = scan.nextLine();

            System.out.println("Senha: ");
            String passwordVerifica = scan.nextLine();

            while (escolha != 4) {
                for (int i = 0; i < contas.size(); i++) {
                    ContaCorrente verificaConta = contas.get(i);
                    if (cpfVerifica.equals(contas.get(i).getCpf()) && passwordVerifica.contains(contas.get(i).getSenhaDoTitular())) {

                        voltar = 0;

                        System.out.println("Ola, " + verificaConta.getNomeDoTitular());
                        System.out.println("Saldo: R$" + verificaConta.getSaldoDoTitular());
                        System.out.println("O que deseja fazer: ");
                        System.out.println(""
                                + "[1]-Sacar \n"
                                + "[2]-Depositar \n"
                                + "[3]-Trasnferir \n"
                                + "[4]-Voltar\n");

                        escolha = scan.nextInt();
                        scan.nextLine();

                        switch (escolha) {

                            case 1:
                                while (voltar != 2) {
                                    System.out.println("Quantos R$ deseja sacar? R$");
                                    valor = scan.nextDouble();
                                    scan.nextLine();
                                    boolean retorno = verificaConta.sacar(valor);

                                    if (retorno) {
                                        System.out.println("Saque realizado com sucesso!");
                                        break;
                                    } else {
                                        System.out.println("Nao possivel fazer saque!\nSaque disponivel: " + verificaConta.getSaldoDoTitular());
                                        System.out.println(""
                                                + "[1]-Tente Novamente\n"
                                                + "[2]-voltar");
                                        voltar = scan.nextInt();
                                        scan.nextLine();
                                        if (voltar != 1 && voltar != 2) {
                                            System.out.println("valor invalido!");
                                            break;
                                        }
                                    }

                                }
                                break;

                            case 2:
                                System.out.println("Quanto(s) R$ deseja depositar?  R$");
                                valor = scan.nextDouble();
                                boolean retorno = verificaConta.depositar(valor);
                                if (retorno) {
                                    System.out.println("Deposito realizado com sucesso!");
                                } else {
                                    System.out.println("Valores negativos nao sao aceitos");
                                }
                                break;

                            case 3:
                                System.out.println("Quanto(s) R$ deseja enviar via pix: R$");
                                valor = scan.nextDouble();
                                scan.nextLine();
                                System.out.println("Pra quem deseja enviar? ");
                                usuarioTransferencia = scan.nextLine();
                                
                                boolean retorno1 = verificaConta.transferir(valor, usuarioTransferencia, c1);
                                boolean retorno2 = verificaConta.transferir(valor, usuarioTransferencia, c2);

                                if (retorno1 || retorno2) {
                                    System.out.println("Transferencia pix realizada com sucesso!");
                                } else {
                                    System.out.println("Falha ao realizar transferencia!");
                                }
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println("Valor inserido invalido");
                                escolha = 0;
                                break;
                        }
                    }
                }
                if (escolha == 0) {
                    System.out.println("Dados inseridos estao invalidos! Tente Novamente!");
                    break;
                }
            }
        }
    }
}
