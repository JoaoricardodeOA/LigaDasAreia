package controllers;

import entities.Character;

public class Monster extends Character {

	public Monster(String nome) {
		super(nome, 24, 4, "Normal", 6);
	}

	public void atacar(Warrior jogador) {
		int hpJogador = jogador.getHp();
		if ((hpJogador + this.getAtaque()) >= 0)
			hpJogador -= this.getAtaque();
		else
			hpJogador = 0;
		jogador.setHp(hpJogador);
	}

	public void recuperacao() {
		int hpMonster = super.getHp();
		if ((hpMonster + 2) > 24)
			hpMonster = 24;
		else
			hpMonster = hpMonster + 2;
		super.setPoderMagico(super.getPoderMagico() - 1);
		super.setHp(hpMonster);
	}

	public int endurecer(Warrior jogador, int turno) {
		int pM = super.getPoderMagico();
		if (pM >= 7) {
			pM = pM - 2;
			super.setStatus("Fortificado");
			super.setAtaque(super.getAtaque() + 2);
			super.setPoderMagico(pM);
		} else {
			super.setPoderMagico(pM + 1);
		}
		return turno;
	}

}