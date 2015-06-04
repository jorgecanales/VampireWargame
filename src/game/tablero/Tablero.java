package game.tablero;

import game.jugador.Jugador;
import game.pieza.Coordenada;
import game.pieza.Pieza;
public class Tablero {

	Jugador jugador_1;
	Jugador jugador_2;
	Pieza[][] piezas;
	
	public Tablero(Jugador jugador_1, Jugador jugador_2)
	{
		piezas = new Pieza[6][6];
		this.jugador_1=jugador_1;
		this.jugador_1=jugador_2;
		
		int x =0,y = 0;
		for(int i = 0; i<6; i++)
		{
			x = jugador_1.piezas[i].getX();
			y = jugador_1.piezas[i].getY();
			piezas[y][x] = jugador_1.piezas[i];
			
			x = jugador_2.piezas[i].getX();
			y = jugador_2.piezas[i].getY();
			piezas[y][x] = jugador_2.piezas[i];
		}
	}
	
	public void printTablero()
	{
		String output = "";
		
		for(int x = 0; x<6; x++)
		{
			if(x == 0 )
				System.out.print("     " + x);
			else
				System.out.print("  " + x);
		}
		System.out.println();
		for(int y = 0; y<6; y++)
		{	
			for(int x = 0; x<6; x++)
			{
				output = "";
				if(x == 0)
					output = String.valueOf(y) + ": | ";
								
				output += (piezas[y][x] == null) ? "--" : piezas[y][x].getIdentificador();  
				output += " ";
				
				if(x == 5)
					output +=  "| ";
				
				System.out.print(output);
			}
			System.out.println();
		}
	}
	
	public boolean posicionDisponible(int x, int y)
	{
		if(x >= 0 && x<6)
			if(y >= 0 && y < 6 )
				return piezas[y][x] == null;
		return false;
		
	}
	
	public Pieza getPiezaAt(int x, int y)
	{
		if(x >= 0 && x<6)
			if(y >= 0 && y < 6 )
				return piezas[y][x];
		return null;
	}
	public void setPiezaAt(Pieza pieza, int x, int y){ piezas[y][x] = pieza;}
	
	public boolean moverPieza(Coordenada destino, Pieza pieza)
	{
		return moverPieza(destino.getX(), destino.getY(), pieza);
	}
	
	public boolean moverPieza(int destino_x, int destino_y, Pieza pieza)
	{
		if(pieza != null && getPiezaAt( pieza.getX(), pieza.getY()) != null)
		{
			int x = pieza.getX();
			int y = pieza.getY();
			
			if(posicionDisponible(destino_x, destino_y))
			{
				piezas[destino_y][destino_x] = pieza;
				pieza.setCoordenada(x, y);
				piezas[y][x] = null;
				return true;
			}
		}
		return false;
	}
}
