package game.partida;

import game.jugador.Jugador;
import game.pieza.TipoDePiezas;
import game.tablero.Tablero;

import java.util.Random;
import java.util.Scanner;

import utilidades.Utils;

public class Partida {

	Tablero tablero;
	private Random random;
	TipoDePiezas tipo;
	Scanner scanner;
	public Partida(Jugador jugador_1, Jugador jugador_2)
	{
		tablero = new Tablero(jugador_1,jugador_2);
		jugador_1.setTablero(tablero);
		jugador_2.setTablero(tablero);
		random = new Random();
		scanner = new Scanner(System.in);
		
	}
	
	public int play()
	{
		Utils.clearConsole();
		System.out.println(" :: Vampire Wargame ::");
		
		boolean gameOver = false;
		boolean turno_jugador_1 = true;
		while(!gameOver)
		{
			Utils.separador();
			tablero.printTablero();
			Utils.separador();
			
			ejecutarTurno(true);
			gameOver = true;
			
		}
		return -1;
	}


	public  int randomInt(int min, int max) 
	{
	    int randomNum = random.nextInt((max - min) + 1) + min;
	
	    return randomNum;
	}
	
	public TipoDePiezas getRandomTipoDePieza()
	{
		int randomInt = randomInt(0, 2);
		TipoDePiezas tipoDePieza = tipo.HOMBRELOBO;
		switch(randomInt)
		{
			case 0 : tipoDePieza = TipoDePiezas.HOMBRELOBO; break;
			case 1 : tipoDePieza = TipoDePiezas.MUERTE; break;
			case 2 : tipoDePieza = TipoDePiezas.VAMPIRO; break;
		}
		return tipoDePieza;
	}
	
	public void printMenu()
	{
		
		System.out.println("1 : Inspeccionar pieza");
		System.out.println("2 : Seleccionar pieza");
		Utils.separador();
	}
	
	public void ejecutarTurno(boolean turno_jugador_uno)
	{
		boolean end_turno = false;
		while(!end_turno){
			if(turno_jugador_uno)
			{
				if(turno_jugador_uno)
					System.out.println("Turno del jugador 1");
				else
					System.out.println("Turno del jugador 2");
				
				tipo = getRandomTipoDePieza();	
				
				printMenu();
				System.out.println("Ruleta : " + tipo.name());
			}
		}
		
	}
	
}

