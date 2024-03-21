package com.mycompany.bancob;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoB {

    public static void main(String[] args) {
        int escolha = 0;
        double saque = 0.00;
        int voltar = 0;
        double deposito = 0.00;
        String usuarioTransferencia;
        double valorTransferencia;

        Scanner scan = new Scanner(System.in);
        ArrayList<ContaCorrente> contas = new ArrayList<>();

        System.out.println("Criar conta");
        System.out.println("Nome: ");
        String nome = scan.nextLine();

        System.out.println("cpf: ");
        String cpf = scan.nextLine();

        System.out.println("Senha: ");
        String password = scan.nextLine();

        contas.add(new ContaCorrente(nome, password, cpf));
        ContaCorrente verificaConta = contas.get(0);

        while (escolha != 4) {
            System.out.println("Acessar conta: ");
            System.out.println("cpf: ");
            String cpfVerifica = scan.nextLine();

            System.out.println("Senha: ");
            String passwordVerifica = scan.nextLine();

            while (escolha != 4) {
                voltar = 0;
                
                if (verificaConta.getCpf().equals(cpfVerifica) && verificaConta.getSenhaDoTitular().equals(passwordVerifica)) {
                    System.out.println("Ola, " + verificaConta.getNomeDoTitular());
                    System.out.println("Saldo: R$" + verificaConta.getSaldoDoTitular());
                    System.out.println("O que deseja fazer: ");
                    System.out.println(""
                            + "[1]-Sacar \n"
                            + "[2]-Depositar \n"
                            + "[3]-Trasnferir \n"
                            + "[4]-sair");
                    escolha = scan.nextInt();
                    scan.nextLine();

                    if (escolha == 4) {
                        break;
                    }

                    switch (escolha) {

                        case 1:
                            while (voltar != 2) {
                                System.out.println("Quantos R$ deseja sacar? R$");
                                saque = scan.nextDouble();
                                scan.nextLine();
                                boolean retorno = verificaConta.sacar(saque);

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
                            deposito = scan.nextDouble();
                            boolean retorno = verificaConta.depositar(deposito);
                            if (retorno) {
                                System.out.println("Deposito realizado com sucesso!");
                            } else {
                                System.out.println("Valores negativos nao sao aceitos");
                            }
                            break;

                        case 3:
                            System.out.println("Quanto(s) R$ deseja enviar via pix: R$");
                            valorTransferencia = scan.nextDouble();
                            scan.nextLine();
                            System.out.println("Pra quem deseja enviar? ");
                            usuarioTransferencia = scan.nextLine();

                            boolean retornoo = verificaConta.transferir(valorTransferencia, usuarioTransferencia);
                            if (retornoo) {
                                System.out.println("Transferencia pix realizada com sucesso!");
                            } else {
                                System.out.println("Falha ao realizar transferencia!");
                            }
                            break;

                        default:
                            System.out.println("Valor inserido invalido");
                            escolha = 0;
                            break;
                    }

                } else {
                    System.out.println("Os dados inseridos estão invalidos! Tente Novamente");
                    break;
                }
            }
        }
    }
}
