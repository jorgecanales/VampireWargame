package piezas;

import utilidades.Utils;

public class HombreLobo extends Pieza{
	
	public HombreLobo(boolean blanco, int x, int y)
	{
		this.blanco = blanco;
		identificador = (blanco) ? "BL" : "NL";
		this.x = x;
		this.y = y;
	}
	
	public void menuPiezaSeleccionada() {
		
		Utils.clearConsole();
		System.out.println("1 : Mover");
		System.out.println("2 : Atacar");
		System.out.println("3 : Saltar");
		
	}
	

}
