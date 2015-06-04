package game.partida;

import java.util.ArrayList;

public class ManagerPartidas {

	private ArrayList<Partida> partidas;
	
	public ManagerPartidas() {
		partidas = new ArrayList<Partida>();
	}
	
	public void addUser(Partida partida){
		partidas.add(partida);
	}
	
	public void erasePartida(int pos){
		partidas.remove(pos);
	}
	
	public Partida getPartida(int pos){
		return partidas.get(pos);
	}
	
	public int getPartidaCount(){
		return partidas.size();
	}
	
	public void clear(){
		partidas.clear();
	}
	
}
