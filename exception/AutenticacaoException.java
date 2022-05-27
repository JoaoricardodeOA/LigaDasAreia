package exception;

import controllers.Warrior;

public class AutenticacaoException extends Exception {
  public AutenticacaoException(Warrior player1, Warrior player2) {
    super("jogador inexistente!");
  }
}