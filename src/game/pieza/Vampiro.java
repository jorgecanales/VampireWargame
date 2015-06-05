package game.pieza;

import java.util.Scanner;

import game.jugador.Jugador;
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
		while(!end)
		{
			Utils.separador();
			System.out.println("Vampiro : ");
			System.out.println("HP : " + getHp());
			System.out.println("Escudo : " + getEscudo());
			System.out.println("Ataque : " + getAtaque());
			Utils.separador();
			System.out.println("1 : Mover");
			System.out.println("2 : Atacar");
			Utils.separador();
			Jugador jugador = getDueno(partida);
			respuesta = scanner.nextInt();
			Utils.separador();
			int x = 0;
			int y = 0;
			switch(respuesta)
			{
				case 1 : 
						end = seleccion_mover(scanner, jugador);
						if(!end)
							System.out.println("Movimiento invalido!");
					break;
				case 2 :
						end = seleccion_atacar(scanner, jugador);
						if(!end)
							System.out.println("Movimiento invalido!");
					
					break;
			}
		}
	}
	
}
