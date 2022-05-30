package exception;

import controllers.Warrior;

public class AutenticacaoException extends Exception {
  public AutenticacaoException(boolean validade) {
    super("jogador inexistente!");
  }
}