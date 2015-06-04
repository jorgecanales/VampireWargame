package game.pieza;
import utilidades.Utils;
public abstract class Pieza {
	
	protected boolean blanco = true;
	protected int x = 0 ,y = 0,hp = 0,escudo = 0,ataque = 0;
	protected String identificador = "--";
	
	public Pieza(){}
	
	public Pieza(boolean blanco, int escudo, int ataque, int hp, int x, int y, String identificador)
	{
		this.identificador = identificador;
		this.blanco = blanco;
		this.ataque = ataque;
		setHp(hp);
		setX(x);
		setY(y);
		setEscudo(escudo);
		
	}
	
	
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	
	public int getEscudo() {return escudo;}
	public void setEscudo(int escudo) {this.escudo = escudo;}
	
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	
	public int getAtaque() {return ataque;}	
	public boolean getColor(){return blanco;}
	public String getIdentificador(){return identificador;}
}
