package game.pieza;

import game.jugador.Jugador;
import game.partida.Partida;

import java.util.ArrayList;
import java.util.Scanner;

import utilidades.Utils;


public class HombreLobo extends Pieza implements Movible {
	
	public HombreLobo(){}
	public HombreLobo(boolean blanco, int x, int y)
	{
		super(x,y);
		this.blanco = blanco;
		identificador = (blanco) ? "BL" : "NL";
		setHp(5);
		setEscudo(2);
		ataque = 5;
		speed = 2;
		tipo = TipoDePiezas.HOMBRELOBO;
	}
	
	public HombreLobo(boolean blanco, int escudo, int ataque, 
			int hp, int x, int y, String identificador)
	{
		super(blanco,escudo,ataque,hp,x,y,identificador);
	}
	
	public void menuPiezaSeleccionada(Partida partida) 
	{	
		int respuesta = -1;
		boolean end = false;
		Scanner scanner = new Scanner(System.in);
		while(!end)
		{
		
			Utils.separador();
			System.out.println("Hombre lobo : ");
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
