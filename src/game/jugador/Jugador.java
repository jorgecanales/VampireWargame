package game.jugador;

import game.pieza.HombreLobo;
import game.pieza.Muerte;
import game.pieza.Pieza;
import game.pieza.Vampiro;
import game.tablero.Tablero;
public class Jugador {

	Tablero tablero;
	public Pieza[]piezas;
	boolean blanco;
	
	public Jugador(boolean blanco)
	{
		piezas = new Pieza[6];
		this.blanco = blanco;
		int y = (blanco) ? 0 : 5;
		
		piezas[0] = new HombreLobo(blanco,0,y);
		piezas[1] = new Vampiro(blanco,1,y);
		piezas[2] = new Muerte(blanco,2,y);
		piezas[3] = new Muerte(blanco,3,y);
		piezas[4] = new Vampiro(blanco,4,y);
		piezas[5] = new HombreLobo(blanco,5,y);
	}
	public void checkHpPiezas()
	{
		for(int j = 0; j<6; j++)
			if(piezas[j] != null)
			{
				if(piezas[j] instanceof Muerte)
					((Muerte)piezas[j]).checkHpZombies();
				
				if(piezas[j].getHp() <= 0)
				{
					if(piezas[j] instanceof Muerte)
						((Muerte)piezas[j]).clearZombies();
						piezas[j] = null;
				}
			}
	}
	public int getCantidadDePiezas()
	{
		int numero_de_piezas = 0;
		
		for(int j = 0 ; j<6 ; j++)
			if(piezas[j] != null)
				numero_de_piezas++;
		
		return numero_de_piezas;
	}
}
