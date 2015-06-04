package game.ui;
import java.util.ArrayList;
import java.util.Date;


public class UserManager {

	private ArrayList<Usuario> usuarios;
	
	public UserManager(){
		usuarios = new ArrayList<>();
	}
	
	public void addUser(Usuario user){
		usuarios.add(user);
	}
	
    public void addUser(String username, String password, Date fechaIngreso){
		usuarios.add(new Usuario(username, password, fechaIngreso));
	}
	
	public void eraseUser(Usuario user){
		usuarios.remove(user);
	}
	
	public void eraseUser(String username){
		Usuario elim = getUser(username);
		
		if(elim != null) usuarios.remove(elim);
	}
	
	public void eraseUser(int pos){
		usuarios.remove(pos);
	}
	
	public Usuario getUser(String username){
		return busquedaPorUsername(username);
	}
	
	public Usuario getUser(int pos){
		return usuarios.get(pos);
	}
	
	public int getUserCount(){
		return usuarios.size();
	}
	
	private Usuario busquedaPorUsername(String username){
		for(Usuario u : usuarios){
			if(u.getUsername().equals(username))
				return u;
		}
		
		return null;
	}
	
}
