package game.pieza;
public abstract class Pieza {
	
	protected boolean blanco = true;
	protected Coordenada coordenada;
	protected int hp = 0,speed = 1,escudo = 0,ataque = 0;
	protected String identificador = "--";
	protected int index;
	protected TipoDePiezas tipo;
	public Pieza(){}
	
	public Pieza(int x, int y)
	{
		coordenada = new Coordenada(x,y);
	}
	public Pieza(boolean blanco, int escudo, int ataque, int hp, int x, int y, String identificador)
	{
		this.identificador = identificador;
		this.blanco = blanco;
		this.ataque = ataque;
		setHp(hp);
		coordenada = new Coordenada(x,y);
		setEscudo(escudo);
		
	}
	
	public boolean atacar(Pieza pieza)
	{
		if(pieza != null && pieza.blanco != this.blanco)
		{
			System.out.println("Fuerza de ataque : " + getAtaque());
			System.out.println("HP : " + pieza.getHp());
			System.out.println("Escudo : " + pieza.getEscudo());
			int ataque = getAtaque();
			
			pieza.setEscudo(pieza.getEscudo() - ataque);
			if(pieza.getEscudo() < 0)
			{
				ataque = (pieza.getEscudo()*-1);
				pieza.setEscudo(0);
				pieza.setHp(pieza.getHp() - ataque);
				if(pieza.getHp() < 0)
					pieza.setHp(0);
			}
			System.out.println("HP : " + pieza.getHp());
			System.out.println("Escudo : " + pieza.getEscudo());
			return true;
		}
		return false;
	}
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	
	public int getEscudo() {return escudo;}
	public void setEscudo(int escudo) {this.escudo = escudo;}
	
	public int getX() {return coordenada.getX();}
	public void setX(int x) {coordenada.setX(x);}
	
	public int getY() {return coordenada.getY();}
	public void setY(int y) {coordenada.setY(y);}
	
	public int getAtaque() {return ataque;}	
	public boolean getColor(){return blanco;}
	public String getIdentificador(){return identificador;}
	public int getIndex() {return index;}
	public void setIndex(int index) {this.index = index;} 
	public boolean isBlanco(){return blanco;}
	public Coordenada getCoordenada(){return coordenada;}
	public void setCoordenada(int x, int y){coordenada.set(x, y);}
	public void setCoordenada(Coordenada coordenada){this.coordenada.set(coordenada);}
	public int getSpeed(){return speed;}
	
	@Override
	public boolean equals(Object object) {
		
		if(object instanceof Pieza)
		{
			Pieza pieza = (Pieza)object;
			return (pieza.isBlanco() == this.isBlanco()) 
					&& (pieza.index == this.getIndex());
		}
		return false;
	}
}
