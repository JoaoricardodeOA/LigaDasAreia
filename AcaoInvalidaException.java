public class AcaoInvalidaException extends Exception{
  private int num;
  public AcaoInvalidaException(int num){
    super("Ação errada!");
    this.num = num;
  }
}