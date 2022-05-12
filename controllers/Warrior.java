package controllers;
import entities.Character;


public class Warrior extends Character implements Comparable<Warrior> {
	
  private int pocaoDeCura;
  private int ranking;
  private String senha;
  
	public Warrior(String nome, String senha) {
		super(nome,20,3,"Normal",5);
		this.pocaoDeCura = 1;
    this.senha = senha;
	}

	public void atacar(Monster inimigo) {
		int hpInimigo = inimigo.getHp();
		if ((hpInimigo + this.getAtaque()) >= 0)
			hpInimigo -= this.getAtaque();
		else hpInimigo = 0;
		inimigo.setHp(hpInimigo);
	}

	public void tomarPocaoDeCura() {
		if (this.pocaoDeCura > 0) {
			int hpJogador = super.getHp();
			if ((hpJogador + 10) <= 20)
				hpJogador = hpJogador + 10;
			else hpJogador = 20;
			this.pocaoDeCura = 0;
			super.setHp(hpJogador );
		}
	}

	public int fortificar(Monster inimigo, int turno) {
			int pM = super.getPoderMagico();
			if (pM >= 5){
				pM = pM - 5;
				super.setStatus("Fortificado");
				super.setAtaque(super.getAtaque()+2);
				super.setPoderMagico(pM);
			}else {
			  super.setPoderMagico(pM+2);
		}
		return turno;
	}
  public void setRanking(int ranking){
    this.ranking = ranking; 
  }
  public int getRanking(){
    return ranking;
  }
  public String getSenha() {
	return senha;
}
  public void setSenha(String senha) {
	this.senha = senha;
} 
  public void reiniciar(){
    super.setStatus("Normal");
    this.pocaoDeCura = 1;
    super.setHp(20);
    super.setAtaque(3);
    super.setPoderMagico(5);
  }
  @Override
public int compareTo(Warrior guerreiro) {	  
	return this.senha.compareTo(guerreiro.getSenha());
}
  
	@Override
	public String toString(){
		return
				super.toString() + 
				"\nPOÇÃO DE CURA .: " + this.pocaoDeCura;
	}
}