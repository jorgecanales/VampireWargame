package game.pieza;

import game.jugador.Jugador;
import game.partida.Partida;

import java.util.ArrayList;
import java.util.Scanner;

import utilidades.Utils;

public abstract class Pieza {
	
	protected boolean blanco = true;
	protected Coordenada coordenada;
	protected int hp = 0,speed = 1,escudo = 0,ataque = 0;
	protected String identificador = "--";
	protected int index;
	protected TipoDePiezas tipo;
	
	public Pieza(){}
	
	public Pieza(int x, int y)
	{
		coordenada = new Coordenada(x,y);
	}
	public Pieza(boolean blanco, int escudo, int ataque, int hp, int x, int y, String identificador)
	{
		this.identificador = identificador;
		this.blanco = blanco;
		this.ataque = ataque;
		setHp(hp);
		coordenada = new Coordenada(x,y);
		setEscudo(escudo);
		
	}
	
	public boolean atacar(Pieza pieza)
	{
		if(pieza != null && pieza.blanco != this.blanco)
		{
			System.out.println("Resumen del ataque : ");
			System.out.println("Fuerza de ataque : " + getAtaque());
			System.out.println("HP de la pieza atacada antes del ataque: " + pieza.getHp());
			System.out.println("Escudo de la pieza atacada antes del ataque: " + pieza.getEscudo());
			int ataque = getAtaque();
			
			pieza.setEscudo(pieza.getEscudo() - ataque);
			if(pieza.getEscudo() < 0)
			{
				ataque = (pieza.getEscudo()*-1);
				pieza.setEscudo(0);
				pieza.setHp(pieza.getHp() - ataque);
				if(pieza.getHp() < 0)
					pieza.setHp(0);
			}
			System.out.println("HP resultante : " + pieza.getHp());
			System.out.println("Escudo resultante : " + pieza.getEscudo());
			return true;
		}
		return false;
	}
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	
	public int getEscudo() {return escudo;}
	public void setEscudo(int escudo) {this.escudo = escudo;}
	
	public int getX() {return coordenada.getX();}
	public void setX(int x) {coordenada.setX(x);}
	
	public int getY() {return coordenada.getY();}
	public void setY(int y) {coordenada.setY(y);}
	
	public int getAtaque() {return ataque;}	
	public boolean getColor(){return blanco;}
	public String getIdentificador(){return identificador;}
	public int getIndex() {return index;}
	public void setIndex(int index) {this.index = index;} 
	public boolean isBlanco(){return blanco;}
	public Coordenada getCoordenada(){return coordenada;}
	public void setCoordenada(int x, int y){coordenada.set(x, y);}
	public void setCoordenada(Coordenada coordenada){this.coordenada.set(coordenada);}
	public int getSpeed(){return speed;}
	
	@Override
	public boolean equals(Object object) {
		
		if(object instanceof Pieza)
		{
			Pieza pieza = (Pieza)object;
			return (pieza.isBlanco() == this.isBlanco()) 
					&& (pieza.index == this.getIndex());
		}
		return false;
	}
	
	protected Jugador getDueno(Partida partida)
	{
		if(partida.jugador_1.isBlanco() == this.isBlanco())
			return partida.jugador_1;
		else
			return partida.jugador_2;
		
	}
	
	protected boolean seleccion_mover(Scanner scanner, Jugador jugador)
	{
		
		ArrayList<Coordenada> movimientosDisponibles = jugador.ai.getMovimientosDisponibles(this);
		
		System.out.print("Coordenadas para movimientos disponibles : ");
		for(Coordenada coordenada : movimientosDisponibles)
			System.out.print(coordenada + ", ");
		
		System.out.println();
		System.out.println("Ingrese las coordenadas destino de la pieza : ");
		Utils.separador();
		int x = 0;
		int y = 0;
		System.out.print("X : ");
		x = scanner.nextInt();
		System.out.print("Y : ");
		y = scanner.nextInt();
		System.out.println();
		Utils.separador();
		return jugador.moverPieza(x, y, this);
		
	}
	
	protected boolean seleccion_atacar(Scanner scanner, Jugador jugador)
	{
		ArrayList<Pieza> piezasAtacables = jugador.ai.getPiezasAtacables(this);
		
		System.out.print("Coordenadas para piezas que pueden ser atacadas : ");
		for(Pieza pieza : piezasAtacables)
			System.out.print(pieza.getCoordenada() + ", ");
		
		System.out.println();
		System.out.println("Ingrese las coordenadas  de la pieza a atacar : ");
		Utils.separador();
		int x = 0;
		int y = 0;
		System.out.print("X : ");
		x = scanner.nextInt();
		System.out.print("Y : ");
		y = scanner.nextInt();
		Utils.separador();
		Pieza pieza = jugador.tablero.getPiezaAt(x, y);
		if(pieza != null)
			return jugador.atacarPieza(this, pieza);
		return false;
	}
}
