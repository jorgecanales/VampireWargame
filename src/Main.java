
import game.jugador.Jugador;
import game.partida.Partida;
import game.ui.Usuario;

import java.sql.Date;


/**
 * @authors napky, wupa
 *
 */
public class Main {

	
		
	public static void main(String [] args)
	{

		System.out.println("UNGH");
		
		Usuario u1 = new Usuario("Brandon","2125112",new Date(6, 6, 6));
		Usuario u2 = new Usuario("Daniel","2125112",new Date(6, 6, 6));
		Jugador j1 = new Jugador(u1,true);
		Jugador j2 = new Jugador(u2,false);
		
		Partida partida = new Partida(j1,j2);
		partida.play();



		
		
	}
}
