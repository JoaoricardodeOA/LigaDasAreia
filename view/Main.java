package view;

import java.util.Random;
import java.util.Scanner;

import controllers.Facade;
import exception.AcaoInvalidaException;
import exception.AutenticacaoException;

class Main {


  public static void main(String[] args) {
    Facade interfacade = Facade.getInstance();
    String nomeJogador, nomeJogador2;
    String senha, senha2;
    boolean validade;
    Scanner scanf = new Scanner(System.in);
    Random rand = new Random();
    int acao, turno, op = 5, indicie;
    System.out.println("\n\nSEJA BEM-VINDO A ARENA, GUERREIRO!!!");

    do {
      try {
        menu();
        op = scanf.nextInt();
        scanf.nextLine();
        opcaoI(op);
        switch (op) {
          case 1:
            System.out.print("\nDIGA-NOS SEU NOME: ");
            nomeJogador = scanf.nextLine();
            System.out.print("\nDIGA-NOS SUA SENHA: ");
            senha = scanf.nextLine();
            System.out.print("\nDIGA-NOS O INDÍCIE: ");
            indicie = scanf.nextInt();
            scanf.nextLine();          
            try {
              validade = interfacade.iniciarJogo(indicie, nomeJogador, senha);
              autenticacao(validade);

              turno = 0;

              while (true) {

                turno++;

                if ((turno % 2) != 0) {
                  try {
                    interfacade.menuJogador();
                    acao = scanf.nextInt();
                    acao = opcao(acao);
                    scanf.nextLine();
                    interfacade.opcoesJogador(acao, turno);

                  } catch (AcaoInvalidaException a) {
                    System.out.print("\ncomando invalido...");

                  }

                } else {
                  acao = gerarAleatorio(rand);
                  try{
                    acao = opcao(acao);
                    interfacade.opcoesInimigo(acao, turno);
                }
                  catch (AcaoInvalidaException a) {
                    System.out.print("\ncomando invalido...");

                  }
                }
                validade = interfacade.status();
                if(validade == true) break;
              }
              interfacade.fimDeJogo();
            } catch (AutenticacaoException a) {
              System.out.println("Seu usuário ainda não foi criado.");
            } catch (IndexOutOfBoundsException b) {
              System.out.println("Seu usuário ainda não foi criado.");
            }
            break;
          case 2:
            System.out.print("\nDIGA-NOS SEU NOME: ");
            nomeJogador = scanf.nextLine();
            System.out.print("\nDIGA-NOS SUA SENHA: ");
            senha = scanf.nextLine();
            interfacade.adicionar(nomeJogador, senha);
            break;
          case 3:
            System.out.print("\nDIGA-NOS SEU NOME: ");
            nomeJogador = scanf.nextLine();
            System.out.print("\nDIGA-NOS SUA SENHA: ");
            senha = scanf.nextLine();
            System.out.print("\nDIGA-NOS O INDÍCIE: ");
            indicie = scanf.nextInt();
            scanf.nextLine();
            System.out.print("\nDIGA-NOS SEU NOVO NOME: ");
            nomeJogador2 = scanf.nextLine();
            System.out.print("\nDIGA-NOS SUA NOVA SENHA: ");
            senha2 = scanf.nextLine();
            try {
              validade = interfacade.modificarUsuario(indicie, nomeJogador, senha, nomeJogador2, senha2);
              autenticacao(validade);
            } catch (AutenticacaoException a) {
              System.out.println("Seu usuário e/ou senha, não está(ão) correto(s).");
            } catch (IndexOutOfBoundsException b) {
              System.out.println("Seu usuário ainda não foi criado.");
            }
            break;
          case 4:
            interfacade.exibirRanking();
            break;
        }
      } catch (AcaoInvalidaException a) {
        System.out.println("Opção inválida.");
      }
    } while (op != 0);

    scanf.close();

  }

  private static int gerarAleatorio(Random r) {
    double probabilidades[] = { 0.7, 0.1, 0.2 };
    int numeros[] = { 1, 2, 3 };
    double soma = 0.0, p = r.nextDouble();
    int i = 0;
    while (soma < p) {
      soma += probabilidades[i];
      i++;
    }
    return numeros[i - 1];
  }
 
  public static boolean autenticacao(Boolean validade) throws AutenticacaoException {
    if (validade == true) {
      return true;
    } else {
      AutenticacaoException sie;
      sie = new AutenticacaoException(validade);
      throw sie;
    }
  }

  public static int opcao(int num) throws AcaoInvalidaException {
    if (num == 1 || num == 2 || num == 3) {
      return num;
    } else {
      AcaoInvalidaException sie;
      sie = new AcaoInvalidaException(num);
      throw sie;
    }

  }
  
  public static int opcaoI(int num) throws AcaoInvalidaException {
    if (num == 0 || num == 1 || num == 2 || num == 3 || num == 4) {
      return num;
    } else {
      AcaoInvalidaException sie;
      sie = new AcaoInvalidaException(num);
      throw sie;
    }

  }

  public static void menu() {
    System.out.println("Digite:");
    System.out.println("1-jogo:");
    System.out.println("2-adicionar usuário:");
    System.out.println("3-modificar usuário:");
    System.out.println("4-ver ranking:");
    System.out.println("0-sair:");
  }
}