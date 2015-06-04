package game.pieza;


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
	}
	
	public HombreLobo(boolean blanco, int escudo, int ataque, 
			int hp, int x, int y, String identificador)
	{
		super(blanco,escudo,ataque,hp,x,y,identificador);
	}
	
	public void menuPiezaSeleccionada() 
	{	
		System.out.println("Hombre lobo : ");
		System.out.println("HP : " + getHp());
		System.out.println("Escudo : " + getEscudo());
		System.out.println("Ataque : " + getAtaque());
		System.out.println("1 : Mover");
		System.out.println("2 : Atacar");
		System.out.println("3 : Saltar");
	}
}
