<<<<<<< HEAD
import game.jugador.Jugador;
import game.partida.Partida;

=======
import game.ui.VampireWarGame;
>>>>>>> 53923857d3e082f489f86d9a85b192d8b3a0a26c

/**
 * @authors napky, wupa
 *
 */
public class Main {

	
		
	public static void main(String [] args)
	{
<<<<<<< HEAD
		System.out.println("UNGH");
		
		Jugador jugador_1 = new Jugador(true);
		Jugador jugador_2 = new Jugador(false);
		
		Partida partida = new Partida(jugador_1, jugador_2);
		
		partida.play();
		
		
=======
		VampireWarGame vwg = new VampireWarGame();
>>>>>>> 53923857d3e082f489f86d9a85b192d8b3a0a26c
		
		vwg.correr();
	}
}
