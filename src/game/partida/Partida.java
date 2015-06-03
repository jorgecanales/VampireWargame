package game.partida;

import game.jugador.Jugador;
import game.tablero.Tablero;
public class Partida {

	Tablero tablero;
	
	Partida(Jugador jugador_1, Jugador jugador_2)
	{
		tablero = new Tablero(jugador_1,jugador_2);
	}
}
