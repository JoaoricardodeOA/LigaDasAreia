package controllers;

import java.util.ArrayList;

public class Ranking {
    ArrayList<Warrior> warriors;
    private static Ranking instance;

    protected Ranking(){
        warriors = new ArrayList<>();
    }

    public static Ranking getInstance(){
        if(instance == null){
            instance = new Ranking();
        }
        return instance;
    }

    public void add(Warrior jogador){
        warriors.add(jogador);
        System.out.println("indicíe do jogador---" + warriors.indexOf(jogador));
    }

    public Warrior get(int i){
        return warriors.get(i);
    }

    public void set(int i,Warrior jogador){
        warriors.set(i,jogador);
    }

    public void exibir(){
        for (Warrior player : warriors) {
            System.out.println(player.getNome() + "---" + player.getRanking());
          }
    }
}