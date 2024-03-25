package com.mycompany.bancob;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoB {

    public static void main(String[] args) {
        int escolha = 0;
        double valor = 0.00;
        int voltar = 0;
        String usuarioTransferencia;

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
        contas.add(new ContaCorrente("Pedro", 0.0, "pedro@gmail.com", "123456789"));
        ContaCorrente c1 = contas.get(0);
        ContaCorrente c2 = contas.get(1);

        while (escolha != 4) {
            System.out.println("Acessar conta: ");
            System.out.println("cpf: ");
            String cpfVerifica = scan.nextLine();

            System.out.println("Senha: ");
            String passwordVerifica = scan.nextLine();

            while (escolha != 4) {
                voltar = 0;

                if (cpfVerifica.contains(c1.getCpf()) && passwordVerifica.contains(c1.getSenhaDoTitular())) {
                    System.out.println("Ola, " + c1.getNomeDoTitular());
                    System.out.println("Saldo: R$" + c1.getSaldoDoTitular());
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
                                valor = scan.nextDouble();
                                scan.nextLine();
                                boolean retorno = c1.sacar(valor);

                                if (retorno) {
                                    System.out.println("Saque realizado com sucesso!");
                                    break;
                                } else {
                                    System.out.println("Nao possivel fazer saque!\nSaque disponivel: " + c1.getSaldoDoTitular());
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
                            boolean retorno = c1.depositar(valor);
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

                            for (int i = 0; i < contas.size(); i++) {
                                ContaCorrente contaRecuperada = contas.get(i);
                                if (contaRecuperada.getNomeDoTitular().equals(c1.getNomeDoTitular())) {
                                    System.out.println("A conta do Joseph foi recuperada com sucesso!");
                                }
                            }
                            boolean retornoo = c1.transferir(valor, usuarioTransferencia, c2);
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
