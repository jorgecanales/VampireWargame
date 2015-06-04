package game.ui;
import game.partida.ManagerPartidas;

import java.util.ArrayList;
import java.util.Date;


public class Usuario {

	
	private String username;
	private String password;
	private int puntos;
	private Date fechaIngreso;
	private boolean activo;
	private ManagerPartidas partidas;
	
	public Usuario(String username, String password, Date fechaIngreso){
		setUsername(username);
		setPassword(password);
		setFechaIngreso(fechaIngreso);
		setPuntos(0);
		setActivo(true);
		partidas = new ManagerPartidas();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public ManagerPartidas getPartidas() {
		return partidas;
	}
	
	
	@Override
	public String toString() {
		return "\n\t\tUsername: " + username + "\n\t\tPassword: " + password +
				"\n\t\tPuntos: " + puntos + "\n\t\tFecha de Ingreso: " + fechaIngreso.toString() +
				"\n\t\tActivo: " + (activo ? "Si" : "No");
	}
	
	
	
}
