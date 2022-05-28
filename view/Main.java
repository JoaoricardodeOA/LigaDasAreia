package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import controllers.Monster;
import controllers.Warrior;
import exception.AcaoInvalidaException;
import exception.AutenticacaoException;

class Main {

  public static void main(String[] args) {
    ArrayList<Warrior> warriors = new ArrayList<>();
    String nomeJogador;
    String senha;
    Warrior jogador, jogador2;
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
        Monster inimigo = new Monster("Monster");
        switch (op) {
          case 1:
            System.out.print("\nDIGA-NOS SEU NOME: ");
            nomeJogador = scanf.nextLine();
            System.out.print("\nDIGA-NOS SUA SENHA: ");
            senha = scanf.nextLine();
            System.out.print("\nDIGA-NOS O INDÍCIE: ");
            indicie = scanf.nextInt();
            scanf.nextLine();
            jogador2 = new Warrior(nomeJogador, senha);
            try {
              jogador = warriors.get(indicie);
              autenticacao(jogador, jogador2);
              jogador.reiniciar();
              System.out.print("\n" + jogador.toString() + "\n");
              System.out.print("\n" + inimigo.toString() + "\n");

              turno = 0;

              while (true) {

                turno++;

                if ((turno % 2) != 0) {
                  try {
                    System.out.print("\n-----------------------");
                    System.out.print("\n  " + jogador.getNome());
                    System.out.print("\n-----------------------");
                    System.out.print("\n1 - Atacar             ");
                    System.out.print("\n2 - Tomar poção de cura");
                    System.out.print("\n3 - Fortificar         ");
                    System.out.print("\n-----------------------");
                    System.out.print("\n>>> ");
                    acao = scanf.nextInt();
                    acao = opcao(acao);
                    scanf.nextLine();

                    switch (acao) {
                      case 1:
                        jogador.atacar(inimigo);
                        System.out.print("\n[ Ataque realizado com sucesso ]");
                        break;

                      case 2:
                        jogador.tomarPocaoDeCura();
                        System.out.print("\n[ Pocão Ok ]");
                        break;

                      case 3:
                        turno = jogador.fortificar(inimigo, turno);
                        System.out.print("\n[ Fortificado ]");
                        break;
                    }
                  } catch (AcaoInvalidaException a) {
                    System.out.print("\ncomando invalido...");

                  }

                } else {
                  System.out.print("\n-------------");
                  System.out.print("\n   INIMIGO   ");
                  System.out.print("\n-------------");
                  System.out.print("\n1 - Atacar   ");
                  System.out.print("\n2 - Recuperar");
                  System.out.print("\n3 - Endurecer");
                  System.out.print("\n-------------");
                  acao = gerarAleatorio(rand);
                  switch (acao) {

                    case 1:
                      inimigo.atacar(jogador);
                      System.out.print("\n\n[ Você é atacado com sucesso ]");
                      break;

                    case 2:
                      inimigo.recuperacao();
                      System.out.print("\n\n[ O inimigo foi recuperado ]");
                      break;

                    case 3:
                      turno = inimigo.endurecer(jogador, turno);
                      System.out.print("\n\n[ O inimigo foi endurecido ]");
                      break;

                    default:
                      System.out.print("\nDigite um comando valido...");
                      break;
                  }
                }
                System.out.print("\n" + jogador.toString());
                System.out.print("\n" + inimigo.toString() + "\n");
                if ((inimigo.getHp() <= 0))
                  jogador.setRanking(jogador.getRanking() + 2);

                if ((jogador.getHp() <= 0) || (inimigo.getHp() <= 0))
                  break;
              }

              System.out.print("\n\n##################");
              System.out.print("\n JOGO FINALIZADO!  ");
              System.out.print("\n##################");

              System.out.print("\n" + jogador.toString());
              System.out.print("\n" + inimigo.toString());

              System.out.print("\n\n##################\n\n");
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
            jogador = new Warrior(nomeJogador, senha);
            warriors.add(jogador);
            System.out.println("indicíe do jogador---" + warriors.indexOf(jogador));
            break;
          case 3:
            System.out.print("\nDIGA-NOS SEU NOME: ");
            nomeJogador = scanf.nextLine();
            System.out.print("\nDIGA-NOS SUA SENHA: ");
            senha = scanf.nextLine();
            System.out.print("\nDIGA-NOS O INDÍCIE: ");
            indicie = scanf.nextInt();
            scanf.nextLine();
            jogador2 = new Warrior(nomeJogador, senha);
            try {
              jogador = warriors.get(indicie);
              autenticacao(jogador, jogador2);
              System.out.print("\nDIGA-NOS SEU NOVO NOME: ");
              nomeJogador = scanf.nextLine();
              System.out.print("\nDIGA-NOS SUA NOVA SENHA: ");
              senha = scanf.nextLine();
              jogador.setSenha(senha);
              jogador.setNome(nomeJogador);
              warriors.set(indicie, jogador);
            } catch (AutenticacaoException a) {
              System.out.println("Seu usuário e/ou senha, não está(ão) correto(s).");
            } catch (IndexOutOfBoundsException b) {
              System.out.println("Seu usuário ainda não foi criado.");
            }
            break;
          case 4:
            for (Warrior player : warriors) {
              System.out.println(player.getNome() + "---" + player.getRanking());
            }
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
 
  public static boolean autenticacao(Warrior player1, Warrior player2) throws AutenticacaoException {
    if (player2.getSenha().equals(player1.getSenha()) && player2.getNome().equals(player1.getNome())) {
      return true;
    } else {
      AutenticacaoException sie;
      sie = new AutenticacaoException(player1, player2);
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