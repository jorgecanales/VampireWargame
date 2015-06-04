package game.pieza;

import utilidades.Utils;

public class Zombie extends Pieza {
	
	public Zombie(){}
	public Zombie(boolean blanco, int x, int y)
	{
		this.blanco = blanco;
		identificador = (blanco) ? "BZ" : "NZ";
		setX(x);
		setY(y);
		setHp(1);
		setEscudo(0);
		ataque = 1;
	}
	
	public Zombie(boolean blanco, int escudo, int ataque, 
			int hp, int x, int y, String identificador)
	{
		super(blanco,escudo,ataque,hp,x,y,identificador);
	}

}
