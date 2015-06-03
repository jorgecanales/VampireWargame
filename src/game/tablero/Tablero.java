package game.tablero;

import game.jugador.Jugador;
import utilidades.Utils;
import game.pieza.*;
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
	
	
	
}
