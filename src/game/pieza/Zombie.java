package game.pieza;



public class Zombie extends Pieza {
	
	public Zombie(){}
	public Zombie(boolean blanco, int x, int y)
	{
		super(x,y);
		this.blanco = blanco;
		identificador = (blanco) ? "BZ" : "NZ";
		setHp(1);
		setEscudo(0);
		ataque = 1;
		tipo = TipoDePiezas.ZOMBIE;
	}
	
	public Zombie(boolean blanco, int escudo, int ataque, 
			int hp, int x, int y, String identificador)
	{
		super(blanco,escudo,ataque,hp,x,y,identificador);
	}

}
