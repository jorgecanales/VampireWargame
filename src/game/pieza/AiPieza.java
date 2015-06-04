package game.pieza;

import game.tablero.Tablero;

import java.util.ArrayList;

public class AiPieza {

	Tablero tablero;

	public AiPieza(Tablero tablero) {
		try {
			this.tablero = tablero;
		} catch (NullPointerException e) {
			System.out.println("Tablero null");
		}
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public ArrayList<Pieza> getPiezasAdyacentes(Pieza pieza) {
		ArrayList<Pieza> piezasAdyacentes = new ArrayList<Pieza>();

		int x = pieza.getX();
		int y = pieza.getY();

		Pieza derecha_arriba = tablero.getPiezaAt(x + 1, y + 1);
		addToArray(piezasAdyacentes, derecha_arriba);

		Pieza derecha_centro = tablero.getPiezaAt(x + 1, y);
		addToArray(piezasAdyacentes, derecha_centro);

		Pieza derecha_abajo = tablero.getPiezaAt(x + 1, y - 1);
		addToArray(piezasAdyacentes, derecha_abajo);

		Pieza izquierda_arriba = tablero.getPiezaAt(x - 1, y + 1);
		addToArray(piezasAdyacentes, izquierda_arriba);

		Pieza izquierda_centro = tablero.getPiezaAt(x - 1, y);
		addToArray(piezasAdyacentes, izquierda_centro);

		Pieza izquierda_abajo = tablero.getPiezaAt(x - 1, y - 1);
		addToArray(piezasAdyacentes, izquierda_abajo);

		Pieza centro_arriba = tablero.getPiezaAt(x, y + 1);
		addToArray(piezasAdyacentes, centro_arriba);

		Pieza centro_abajo = tablero.getPiezaAt(x, y - 1);
		addToArray(piezasAdyacentes, centro_abajo);

		
		return piezasAdyacentes;

	}

	public ArrayList<Pieza> getPiezasAtacables(Pieza pieza) {
		ArrayList<Pieza> piezasAdyacentes = getPiezasAdyacentes(pieza);
		ArrayList<Pieza> piezasAtacables = new ArrayList<Pieza>();

		for (int c = 0; c < piezasAdyacentes.size(); c++)
			if (piezasAdyacentes.get(c).isBlanco() != pieza.isBlanco())
				piezasAtacables.add(piezasAdyacentes.get(c));

		
		return piezasAtacables;
	}

	public ArrayList<Coordenada> getCoordenadasAdyacentes(Pieza pieza) {
		int x = pieza.getX();
		int y = pieza.getY();

		ArrayList<Coordenada> coordenadasAdyacentes = new ArrayList<Coordenada>();

		if (x < 5) {

			Coordenada derecha_centro = new Coordenada(x + 1, y);
			coordenadasAdyacentes.add(derecha_centro);

			if (y < 5) {
				Coordenada derecha_arriba = new Coordenada(x + 1, y + 1);
				coordenadasAdyacentes.add(derecha_arriba);
			}

			if (y >= 1) {
				Coordenada derecha_abajo = new Coordenada(x + 1, y - 1);
				coordenadasAdyacentes.add(derecha_abajo);
			}
		}

		if (x >= 1) {

			Coordenada izquierda_centro = new Coordenada(x-1, y);
			coordenadasAdyacentes.add(izquierda_centro);

			if (y < 5) {
				Coordenada izquierda_arriba = new Coordenada(x-1, y + 1);
				coordenadasAdyacentes.add(izquierda_arriba);
			}

			if (y >= 1) {
				Coordenada izquierda_abajo = new Coordenada(x-1, y - 1);
				coordenadasAdyacentes.add(izquierda_abajo);
			}
		}
		
		if(y < 5)
		{
			Coordenada centro_arriba = new Coordenada(x, y+1);
			coordenadasAdyacentes.add(centro_arriba);
		}
		
		if(y >= 1)
		{
			Coordenada centro_abajo = new Coordenada(x, y-1);
			coordenadasAdyacentes.add(centro_abajo);
		}
		
		return coordenadasAdyacentes;
	}

	public ArrayList<Coordenada> getCoordenadasAdyacentesLibres(Pieza pieza)
	{
		ArrayList<Coordenada> coordenadasAdyacentes = getCoordenadasAdyacentes(pieza);
		ArrayList<Pieza> piezasAdyacentes = getPiezasAdyacentes(pieza);
		
		for(int c = 0; c<coordenadasAdyacentes.size(); c++)
		{
			boolean flag_remove = false;
		
			for(int j = 0; j<piezasAdyacentes.size(); j++)
			{
				Coordenada coordenadaAdyacente = coordenadasAdyacentes.get(c);
				Pieza piezaAdyacente = piezasAdyacentes.get(j);
				
				if( coordenadaAdyacente.equals(piezaAdyacente.getCoordenada()) )
					flag_remove = true;
			}
			
			if(flag_remove)
				coordenadasAdyacentes.remove(c);
		}
		
		return coordenadasAdyacentes;
	}
	
	public ArrayList<Coordenada> getMovimientosDisponibles(Pieza pieza)
	{
		ArrayList<Coordenada> coordenadasAdyacentesLibres = getCoordenadasAdyacentesLibres(pieza);
		
		if(pieza instanceof HombreLobo)
		{
			int x = pieza.getX();
			int y = pieza.getY();
			int speed = pieza.getSpeed();
			
			//X + 2, y + 0 
			if(tablero.posicionDisponible(x+speed, y))
				coordenadasAdyacentesLibres.add(new Coordenada(x+speed,y));

			//X - 2, y + 0
			if(tablero.posicionDisponible(x-speed, y))
				coordenadasAdyacentesLibres.add(new Coordenada(x-speed,y));
			
			//X + 0, y: +2,-2
			if(tablero.posicionDisponible(x, y+speed))
				coordenadasAdyacentesLibres.add(new Coordenada(x,y+speed));
			
			if(tablero.posicionDisponible(x, y-speed))
				coordenadasAdyacentesLibres.add(new Coordenada(x,y-speed));
			
			//X + 2, y: +2,-2
			
			if(tablero.posicionDisponible(x+speed, y+speed))
				coordenadasAdyacentesLibres.add(new Coordenada(x+speed,y+speed));
			
			if(tablero.posicionDisponible(x+speed, y-speed))
				coordenadasAdyacentesLibres.add(new Coordenada(x+speed,y-speed));
			
			//X - 2, y: +2,-2
			
			if(tablero.posicionDisponible(x-speed, y+speed))
				coordenadasAdyacentesLibres.add(new Coordenada(x-speed,y+speed));
			
			if(tablero.posicionDisponible(x-speed, y-speed))
				coordenadasAdyacentesLibres.add(new Coordenada(x-speed,y-speed));
			
			
		}
		return coordenadasAdyacentesLibres;
	}
	
	private void addToArray(ArrayList<Pieza> piezas, Pieza pieza) {
		if (pieza != null)
			piezas.add(pieza);
	}

}
