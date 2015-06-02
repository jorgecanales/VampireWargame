package game.pieza;

import utilidades.Utils;

public class HombreLobo extends Pieza implements Movible {
	
	public HombreLobo(){}
	public HombreLobo(boolean blanco, int x, int y)
	{
		this.blanco = blanco;
		identificador = (blanco) ? "BL" : "NL";
		setX(x);
		setY(y);
		setHp(5);
		setEscudo(2);
		ataque = 5;
	}
	
	public HombreLobo(boolean blanco, int escudo, int ataque, 
			int hp, int x, int y, String identificador)
	{
		super(blanco,escudo,ataque,hp,x,y,identificador);
	}
	
	public void menuPiezaSeleccionada() {
		
		Utils.clearConsole();
		System.out.println("1 : Mover");
		System.out.println("2 : Atacar");
		System.out.println("3 : Saltar");
		Utils.separador();
	}

	public void mover() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
