import game.jugador.Jugador;
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
		tablero.printTablero();
		
	}
}
