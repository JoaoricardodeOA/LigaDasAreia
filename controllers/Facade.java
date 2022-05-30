package controllers;

public class Facade {
    Ranking ranking;
    Warrior jogador, jogador2;
    Monster inimigo;
    private static Facade instance;

    protected Facade(){
        ranking = Ranking.getInstance();
    }

    public static Facade getInstance(){
        if(instance == null){
            instance = new Facade();
        }
        return instance;
    }

    public void adicionar(String nomeJogador, String senha){
        jogador = new Warrior(nomeJogador, senha);
        ranking.add(jogador);
    } 
     public void exibirRanking(){
        ranking.exibir();
     }

    public boolean modificarUsuario(int indicie,String nomeJogador, String senha,String nomeJogador2, String senha2){
        jogador = ranking.get(indicie);
        if(autenticacao(nomeJogador,senha,jogador.getNome(),jogador.getSenha())){
            jogador.setSenha(senha2);
            jogador.setNome(nomeJogador2);
            ranking.set(indicie, jogador);
            return true;
        }else{
            return false;
        }
    }

    private boolean autenticacao(String nomeJogador, String senha,String nomeJogador2, String senha2){
        if(senha.equals(senha2) && nomeJogador.equals(nomeJogador2)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean iniciarJogo(int indicie,String nomeJogador, String senha){
        inimigo = new Monster("Monster");
        jogador = ranking.get(indicie);
        if(autenticacao(nomeJogador,senha,jogador.getNome(),jogador.getSenha())){
            jogador.reiniciar();
            System.out.print("\n" + jogador.toString() + "\n");
            System.out.print("\n" + inimigo.toString() + "\n");
            return true;
        }else{
            return false;
        }
    }
    
    public void menuJogador(){
        System.out.print("\n-----------------------");
                    System.out.print("\n  " + jogador.getNome());
                    System.out.print("\n-----------------------");
                    System.out.print("\n1 - Atacar             ");
                    System.out.print("\n2 - Tomar poção de cura");
                    System.out.print("\n3 - Fortificar         ");
                    System.out.print("\n-----------------------");
                    System.out.print("\n>>> ");
    }
     public void opcoesJogador(int op, int turno){
        switch (op) {
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
     }
     public void opcoesInimigo(int op, int turno){
        System.out.print("\n-------------");
        System.out.print("\n   INIMIGO   ");
        System.out.print("\n-------------");
        System.out.print("\n1 - Atacar   ");
        System.out.print("\n2 - Recuperar");
        System.out.print("\n3 - Endurecer");
        System.out.print("\n-------------");
        switch (op) {

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
        }

     }
     public boolean status(){
        System.out.print("\n" + jogador.toString());
        System.out.print("\n" + inimigo.toString() + "\n");
        if ((inimigo.getHp() <= 0))
                  jogador.setRanking(jogador.getRanking() + 2);

        if ((jogador.getHp() <= 0) || (inimigo.getHp() <= 0))
                  return true;
        return false;
     }
    public void fimDeJogo(){
        System.out.print("\n\n##################");
              System.out.print("\n JOGO FINALIZADO!  ");
              System.out.print("\n##################");

              System.out.print("\n" + jogador.toString());
              System.out.print("\n" + inimigo.toString());

              System.out.print("\n\n##################\n\n");
    } 
}
