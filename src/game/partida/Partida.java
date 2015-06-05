package game.partida;

import game.jugador.Jugador;
import game.pieza.Movible;
import game.pieza.Pieza;
import game.pieza.TipoDePiezas;
import game.pieza.Zombie;
import game.tablero.Tablero;

import java.util.Random;
import java.util.Scanner;

import utilidades.Utils;

public class Partida {

	Tablero tablero;
	private Random random;
	TipoDePiezas tipo;
	Scanner scanner;
	public Jugador jugador_1;
	public Jugador jugador_2;
	boolean turno_jugador_1 = true;

	public Partida(Jugador jugador_1, Jugador jugador_2) {
		this.jugador_1 = jugador_1;
		this.jugador_2 = jugador_2;
		tablero = new Tablero(jugador_1, jugador_2);
		jugador_1.setTablero(tablero);
		jugador_2.setTablero(tablero);
		random = new Random();
		scanner = new Scanner(System.in);

	}

	public int play() {
		Utils.clearConsole();
		System.out.println(" :: Vampire Wargame ::");

		boolean gameOver = false;

		while (!gameOver) {
			Utils.separador();
			tablero.printTablero();
			Utils.separador();

			ejecutarTurno(turno_jugador_1);
			
			this.checkHpDePiezas();
			int piezas_movibles_jugador_1 = jugador_1.getCantidadDePiezasMovibles();
			int piezas_movibles_jugador_2 = jugador_2.getCantidadDePiezasMovibles();
			int piezas_totales_jugador_1 = jugador_1.getCantidadDePiezas();
			int piezas_totales_jugador_2 = jugador_2.getCantidadDePiezas();
			
			if(piezas_totales_jugador_1 == 0 || piezas_totales_jugador_2 == 0)
				gameOver=true;
			
			if (turno_jugador_1)
				turno_jugador_1 = false;
			else
				turno_jugador_1 = true;

		}
		System.out.println("Game is over");
		return -1;
	}

	public int randomInt(int min, int max) {
		int randomNum = random.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public TipoDePiezas getRandomTipoDePieza() {
		int randomInt = randomInt(0, 2);
		TipoDePiezas tipoDePieza = tipo.HOMBRELOBO;
		switch (randomInt) {
		case 0:
			tipoDePieza = TipoDePiezas.HOMBRELOBO;
			break;
		case 1:
			tipoDePieza = TipoDePiezas.MUERTE;
			break;
		case 2:
			tipoDePieza = TipoDePiezas.VAMPIRO;
			break;
		}
		return tipoDePieza;
	}

	public void printMenu() {

		System.out.println("1 : Inspeccionar pieza");
		System.out.println("2 : Seleccionar pieza");
		Utils.separador();
	}

	private void ejecutarTurno(boolean turno_jugador_uno) {
		boolean end_turno = false;
		int respuesta = 0;
		tipo = getRandomTipoDePieza();
		while (!end_turno) {
			if (turno_jugador_uno)
				System.out.println("Turno del jugador : "
						+ jugador_1.user.getUsername() + "| Blanco");
			else
				System.out.println("Turno del jugador : "
						+ jugador_2.user.getUsername() + "| Negro");

			printMenu();
			System.out.println("Ruleta : " + tipo.name());
			System.out.print("User input : ");
			respuesta = scanner.nextInt();
			Utils.separador();

			switch (respuesta) {
			case 1:
				inspeccionarPieza();
				break;
			case 2:
				end_turno = seleccionarPieza();
				break;
			}
		}

	}

	public void inspeccionarPieza() {
		tablero.printTablero();
		Utils.separador();
		System.out.println("Introduzca las coordenadas de la pieza a inspeccionar : ");
		System.out.println("Piezas Inspeccionables : ");
		
		System.out.print("Piezas del jugador 1 : " + jugador_1.user.getUsername());
		for(int c = 0 ; c<6; c++)
			if(jugador_1.piezas[c] != null)
				System.out.print(jugador_1.piezas[c].getCoordenada() + ", ");
		System.out.println();
		System.out.print("Piezas del jugador 2 : " + jugador_2.user.getUsername());
		for(int c = 0 ; c<6; c++)
			if(jugador_2.piezas[c] != null)
				System.out.print(jugador_2.piezas[c].getCoordenada() + ", ");
		
			
		System.out.println();
		int x = 0;
		int y = 0;

		System.out.print("X : ");
		x = scanner.nextInt();
		System.out.print("Y : ");
		y = scanner.nextInt();

		Pieza pieza = tablero.getPiezaAt(x, y);

		if (pieza != null) {
			Utils.separador();
			System.out.println("Identificador : " + pieza.getIdentificador());
			System.out.println("HP : " + pieza.getHp());
			System.out.println("Ataque : " + pieza.getAtaque());
			System.out.println("Escudo : " + pieza.getEscudo());
			System.out.println("Coordenadas : " + pieza.getCoordenada());
		} else
			System.out.println("Coordenada Incorrecta");

		Utils.separador();
	}

	public boolean seleccionarPieza() {
		tablero.printTablero();
		Utils.separador();
		System.out.println("Introduzca las coordenadas de la pieza a seleccionar : ");
		System.out.print("Piezas seleccionables : ");
		for(int c = 0 ; c<6; c++)
			if(getJugadorEnTurno().piezas[c] != null)
				System.out.print(getJugadorEnTurno().piezas[c].getCoordenada() + ", ");
		System.out.println();
		int x = 0;
		int y = 0;

		System.out.print("X : ");
		x = scanner.nextInt();
		System.out.print("Y : ");
		y = scanner.nextInt();
		Utils.separador();
		Pieza pieza = tablero.getPiezaAt(x, y);

		if (pieza != null) {
			if (pieza instanceof Zombie)
				System.out.println("La seleccion de zombies es invalida");
			else if (pieza.getColor() != turno_jugador_1)
				System.out
						.println("La seleccion de piezas del oponente es invalida");
			else {
				if (pieza instanceof Movible) {
					Movible movible = (Movible) pieza;
					movible.menuPiezaSeleccionada(this);
					return true;
				}
			}
		} else
			System.out.println("Coordenada Incorrecta");

		Utils.separador();
		return false;
	}
	
	public Jugador getJugadorEnTurno()
	{
		if(turno_jugador_1)
			return jugador_1;
		else
			return jugador_2;
	}
	
	private void checkHpDePiezas()
	{
		jugador_1.checkHpPiezas();
		jugador_2.checkHpPiezas();
	}
}
