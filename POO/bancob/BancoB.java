package com.mycompany.bancob;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<PessoaFisica> contas = new ArrayList<>();

        boolean retorno = false;
        boolean retorno1 = false;
        boolean retorno2= false;
        int periodo = 0;
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

        contas.add(new PessoaFisica(nome, password, "12345", 0.0, "Thiago@gamail.com", cpf));
        contas.add(new PessoaFisica("Pedro", "1243", "4321", 0.0, "pedro@gmail.com", "123456789"));
        PessoaFisica c1 = contas.get(0);
        PessoaFisica c2 = contas.get(1);

        while (true) {
            if (escolha != 0) {
                periodo++;
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
                    PessoaFisica verificaConta = contas.get(i);
                    ContaEspecial contaEspecial = new ContaEspecial(verificaConta);
                    ContaCorrente contaCorrente = new ContaCorrente(verificaConta);
                    ContaPoupanca contaPoupanca = new ContaPoupanca(verificaConta);

                    if (cpfVerifica.equals(verificaConta.getCpf()) && passwordVerifica.equals(verificaConta.getSenha())) {

                        voltar = 0;
                        if (contaPoupanca.rendimento(periodo)) {
                            System.out.println("Sua conta teve rendimentos!");
                        }
                        System.out.println("Ola, " + verificaConta.getNome());
                        System.out.println("Saldo: R$" + verificaConta.getSaldo());
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
                                    System.out.println("[1]-ContaCorrente\n"
                                            + "[2]-ContaEspecial");
                                    int escolhaConta = scan.nextInt();
                                    scan.nextLine();

                                    System.out.println("Quantos R$ deseja sacar? R$");
                                    valor = scan.nextDouble();
                                    scan.nextLine();

                                    if (escolhaConta == 1) {
                                        retorno = contaCorrente.verificaSaque(valor);
                                    } else {
                                        retorno = contaEspecial.verificaLimite(valor);
                                    }

                                    if (retorno) {
                                        System.out.println("Saque realizado com sucesso!");
                                        break;
                                    } else {
                                        System.out.println("Nao possivel fazer saque!\nSaldo disponivel: " + verificaConta.getSaldo());
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

                                retorno = contaCorrente.verificaDeposito(valor);

                                if (retorno) {
                                    System.out.println("Deposito realizado com sucesso!");
                                } else {
                                    System.out.println("Valores negativos nao sao aceitos");
                                }
                                break;

                            case 3:
                                System.out.println("[1]-ContaCorrente\n"
                                            + "[2]-ContaEspecial");
                                    int escolhaConta = scan.nextInt();
                                    scan.nextLine();
                                System.out.println("Quanto(s) R$ deseja enviar via pix: R$");
                                valor = scan.nextDouble();
                                scan.nextLine();
                                
                                System.out.println("Pra quem deseja enviar? ");
                                usuarioTransferencia = scan.nextLine();

                                if (escolhaConta == 1) {
                                    retorno1 = contaCorrente.verificaTransferencia(valor, usuarioTransferencia, c1);
                                    retorno2 = contaCorrente.verificaTransferencia(valor, usuarioTransferencia, c2);
                                } else {
                                    retorno1 = contaEspecial.transferencia(valor, usuarioTransferencia, c1);
                                    retorno2 = contaEspecial.transferencia(valor, usuarioTransferencia, c2);
                                }

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
                                escolha = -1;
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
