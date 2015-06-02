package piezas;
import utilidades.Utils;;
public abstract class Pieza {
	
	boolean blanco;
	int escudo;
	int ataque;
	int x,y,hp;
	String identificador;
	public Pieza()
	{
	
	}
	
	public abstract void menuPiezaSeleccionada();
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAtaque() {
		return ataque;
	}

	
	
	
	
}
