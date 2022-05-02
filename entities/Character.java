package entities;
public abstract class Character {
	
	private String nome;
	private int hp;
	private int ataque;
	private String status;
	private int poderMagico;

	public Character(String nome, int hp, int ataque, String status, int poderMagico) {
		this.nome = nome;
		this.hp = hp;
		this.ataque = ataque;
		this.status = status;
		this.poderMagico = poderMagico;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int valor) {
		this.hp = valor;
	}

	public int getAtaque() {
		return this.ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPoderMagico() {
		return this.poderMagico;
	}

	public void setPoderMagico(int poderMagico) {
		this.poderMagico = poderMagico;
	}

	@Override
	public String toString(){
		return
				"\nNome ..........: " + this.nome        + 
				"\nHP ............: " + this.hp          + 
				"\nATAQUE ........: " + this.ataque      + 
				"\nSTATUS ........: " + this.status      + 
				"\nPODER MÁGICO ..: " + this.poderMagico;
	}

}