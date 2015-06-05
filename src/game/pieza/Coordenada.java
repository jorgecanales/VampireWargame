package game.pieza;

public class Coordenada {

	protected int x,y=0;
	
	public Coordenada(int x, int y)
	{
		setX(x);
		setY(y);
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
	
	@Override
	public boolean equals(Object object) {
		
		if(object instanceof Coordenada){
			Coordenada coordenada = (Coordenada)object;
			return (getX() == coordenada.getX()) 
					&& (getY() == coordenada.getY());
		}
		return false;
	}
	
	public void set(int x, int y){setX(x);setY(y);}
	public void set(Coordenada coordenada){setX(coordenada.getX());setY(coordenada.getY());}
	
	@Override
	public String toString() {
		return "{" + getX() + "," + getY() + "}" ;
	}
	
}
