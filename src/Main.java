import game.jugador.Jugador;
import game.pieza.Movible;
import game.tablero.Tablero;


/**
 * @author napky
 *
 */
public class Main {

	
		
	public static void main(String [] args)
	{
		System.out.println("UNGH");
		
		Jugador jugador_1 = new Jugador(true);
		Jugador jugador_2 = new Jugador(false);
		
		Tablero tablero = new Tablero(jugador_1,jugador_2);
		jugador_1.setTablero(tablero);
		jugador_2.setTablero(tablero);
		
		
		jugador_1.moverPiezaPor(0, 2, jugador_1.piezas[0]);
		
		
		jugador_1.moverPiezaPor(0, -1, jugador_1.piezas[0]);
		utilidades.Utils.separador();	
		tablero.printTablero();
	}
}
