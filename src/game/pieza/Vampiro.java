package game.pieza;

import utilidades.Utils;

public class Vampiro extends Pieza implements Movible {
	
	public Vampiro(){}
	public Vampiro(boolean blanco, int x, int y)
	{
		this.blanco = blanco;
		identificador = (blanco) ? "BV" : "NV";
		setX(x);
		setY(y);
		setHp(4);
		setEscudo(5);
		ataque = 3;
	}
	
	public Vampiro(boolean blanco, int escudo, int ataque, 
			int hp, int x, int y, String identificador)
	{
		super(blanco,escudo,ataque,hp,x,y,identificador);
	}
	
	public void menuPiezaSeleccionada() {
		
		Utils.clearConsole();
		System.out.println("Muerte : ");
		System.out.println("HP : " + getHp());
		System.out.println("Escudo : " + getEscudo());
		System.out.println("Ataque : " + getAtaque());
		System.out.println("1 : Mover");
		System.out.println("2 : Atacar");
		System.out.println("3 : Chupar Sangre");
		Utils.separador();
	}
	
}
