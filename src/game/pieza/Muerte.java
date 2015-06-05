package game.pieza;

import game.jugador.Jugador;
import game.partida.Partida;

import java.util.ArrayList;
import java.util.Scanner;

import utilidades.Utils;

public class Muerte extends Pieza implements Movible {

	ArrayList<Zombie> zombies;
	public Muerte(){}
	public Muerte(boolean blanco, int x, int y)
	{
		super(x,y);
		zombies = new ArrayList<Zombie>();
		this.blanco = blanco;
		identificador = (blanco) ? "BM" : "NM";
		setHp(3);
		setEscudo(1);
		ataque = 4;
		tipo = TipoDePiezas.MUERTE;
	}
	
	public Muerte(boolean blanco, int escudo, int ataque, 
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
			System.out.println("Muerte : ");
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
	public void clearZombies(){zombies.clear();}
	public int getNumeroDeZombies(){return zombies.size();}
	public void addZombie(int x, int y){zombies.add(new Zombie(this.blanco, x, y));}
	
	public void checkHpZombies()
	{
		for(int j = 0 ; j<zombies.size(); j++)
			if(zombies.get(j) != null)
				if(zombies.get(j).getHp() <= 0)
					zombies.remove(j);
	}
	
	public ArrayList<Zombie> getZombies(){return zombies;}

}
