package game.pieza;

import java.util.Scanner;

import game.partida.Partida;
import utilidades.Utils;

public class Vampiro extends Pieza implements Movible {
	
	public Vampiro(){}
	public Vampiro(boolean blanco, int x, int y)
	{
		super(x,y);
		this.blanco = blanco;
		identificador = (blanco) ? "BV" : "NV";
		setHp(4);
		setEscudo(5);
		ataque = 3;
		tipo = TipoDePiezas.VAMPIRO;
	}
	
	public Vampiro(boolean blanco, int escudo, int ataque, 
			int hp, int x, int y, String identificador)
	{
		super(blanco,escudo,ataque,hp,x,y,identificador);
	}
	
	public void menuPiezaSeleccionada(Partida partida) {
		
		int respuesta = -1;
		boolean end = false;
		Scanner scanner = new Scanner(System.in);
		Utils.separador();
		System.out.println("Muerte : ");
		System.out.println("HP : " + getHp());
		System.out.println("Escudo : " + getEscudo());
		System.out.println("Ataque : " + getAtaque());
		Utils.separador();
		System.out.println("1 : Mover");
		System.out.println("2 : Atacar");
		System.out.println("3 : Chupar Sangre");
		Utils.separador();
	}
	
}
