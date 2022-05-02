package entities;
public class AcaoInvalidaException extends Exception{
  public AcaoInvalidaException(int num){
    super("Ação errada!");
  }
}