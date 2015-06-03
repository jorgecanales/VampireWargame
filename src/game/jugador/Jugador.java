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
}
