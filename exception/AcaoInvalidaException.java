package exception;

public class AcaoInvalidaException extends Exception {
  public AcaoInvalidaException(int num) {
    super("Ação errada!");
  }
}