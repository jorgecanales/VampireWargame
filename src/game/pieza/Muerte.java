package game.pieza;

import java.util.ArrayList;

import utilidades.Utils;

public class Muerte extends Pieza implements Movible {

	ArrayList<Zombie> zombies;
	public Muerte(){}
	public Muerte(boolean blanco, int x, int y)
	{
		zombies = new ArrayList<Zombie>();
		this.blanco = blanco;
		identificador = (blanco) ? "BM" : "NM";
		setX(x);
		setY(y);
		setHp(3);
		setEscudo(1);
		ataque = 4;
	}
	
	public Muerte(boolean blanco, int escudo, int ataque, 
			int hp, int x, int y, String identificador)
	{
		super(blanco,escudo,ataque,hp,x,y,identificador);
	}
	public void menuPiezaSeleccionada() 
	{
		System.out.println("Muerte : ");
		System.out.println("HP : " + getHp());
		System.out.println("Escudo : " + getEscudo());
		System.out.println("Ataque : " + getAtaque());
		System.out.println("Zombies : " + getNumeroDeZombies());
		System.out.println("1 : Mover");
		System.out.println("2 : Atacar con lanza");
		System.out.println("3 : Atacar con zombie");
		System.out.println("4 : Conjurar Zombie");
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

}
