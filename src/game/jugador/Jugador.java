package game.jugador;


import game.pieza.AiPieza;
import game.pieza.Coordenada;


import game.pieza.HombreLobo;
import game.pieza.Muerte;
import game.pieza.Pieza;
import game.pieza.Vampiro;
import game.tablero.Tablero;


import java.util.ArrayList;

import game.ui.Usuario;


public class Jugador {

	public Tablero tablero;
	public Pieza[] piezas;
	boolean blanco;
	public AiPieza ai;
	public Usuario user;
	
	
	public Jugador(Usuario user, boolean blanco)
	{
		
		this.user = user;
		piezas = new Pieza[6];
		this.blanco = blanco;
		int y = (blanco) ? 0 : 5;

		piezas[0] = new HombreLobo(blanco, 0, y);
		piezas[1] = new Vampiro(blanco, 1, y);
		piezas[2] = new Muerte(blanco, 2, y);
		piezas[3] = new Muerte(blanco, 3, y);
		piezas[4] = new Vampiro(blanco, 4, y);
		piezas[5] = new HombreLobo(blanco, 5, y);

		for (int c = 0; c < 6; c++)
			piezas[c].setIndex(c);

	}

	public void checkHpPiezas() {
		for (int j = 0; j < 6; j++)
			if (piezas[j] != null) {
				if (piezas[j] instanceof Muerte) {
					for (Pieza pieza : ((Muerte) piezas[j]).getZombies())
						if (pieza != null)
							if (pieza.getHp() <= 0)
								tablero.setPiezaAt(null, pieza.getX(),
										pieza.getY());
					((Muerte) piezas[j]).checkHpZombies();
				}

				if (piezas[j].getHp() <= 0) {
					if (piezas[j] instanceof Muerte) {
						for (Pieza pieza : ((Muerte) piezas[j]).getZombies())
							if (pieza != null)
								tablero.setPiezaAt(null, pieza.getX(),
										pieza.getY());

						((Muerte) piezas[j]).clearZombies();
					}

					tablero.setPiezaAt(null, piezas[j].getX(), piezas[j].getY());
					piezas[j] = null;

				}
			}
	}

	public int getCantidadDePiezas() {
		int numero_de_piezas = 0;

		for (int j = 0; j < 6; j++)
			if (piezas[j] != null) {
				if (piezas[j] instanceof Muerte)
					numero_de_piezas += ((Muerte) piezas[j])
							.getNumeroDeZombies();
				numero_de_piezas++;
			}
		return numero_de_piezas;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
		ai = new AiPieza(tablero);
	}

	public boolean moverPieza(int destino_x, int destino_y, Pieza pieza) {

		Coordenada coordenada_destino = new Coordenada(destino_x, destino_y);
		ArrayList<Coordenada> movimientosDisponibles = ai
				.getMovimientosDisponibles(pieza);
		boolean is_coordenada_libre = false;

		for (int c = 0; c < movimientosDisponibles.size(); c++)
			if (coordenada_destino.equals(movimientosDisponibles.get(c)))
				is_coordenada_libre = true;

		if (is_coordenada_libre) {
			tablero.moverPieza(coordenada_destino, pieza);
			pieza.setX(destino_x);
			pieza.setY(destino_y);
			return true;
		}
		return false;
	}

	public boolean moverPiezaPor(int delta_x, int delta_y, Pieza pieza) {

		if ((delta_x <= pieza.getSpeed() && delta_x >= (pieza.getSpeed() * -1))
				&& (delta_y <= pieza.getSpeed() && delta_y >= (pieza.getSpeed() * -1)))
			return moverPieza(pieza.getX() + delta_x, pieza.getY() + delta_y,
					pieza);
		return false;
	}
	
	public boolean atacarPieza(Pieza atacante, Pieza atacada)
	{
		ArrayList<Pieza> piezasAtacables = ai.getPiezasAtacables(atacante);
		for(Pieza pieza : piezasAtacables)
			if(pieza.equals(atacada))
			{
				atacante.atacar(pieza);
				return true;
			}
				
		return false;
	}
	
	public boolean isBlanco()
	{
		return blanco;
	}
	
	public int getCantidadDePiezasMovibles()
	{
		int contador = 0;
		for(int c = 0 ; c<6;c++)
			if(piezas[c] != null)
				contador++;
		return contador;
	}

}
