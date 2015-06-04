package game.ui;
import game.jugador.Jugador;
import game.partida.Partida;

import java.util.Date;
import java.util.Scanner;

public class VampireWarGame {

	private Scanner in;
	private UserManager userManager;
	private Usuario userActivo;

	public VampireWarGame() {
		in = new Scanner(System.in);
		userManager = new UserManager();
		userActivo = null;
	}

	public void correr() {
		menuInicial();
	}

	private void menuInicial() {
		String input = "";

		do {
			System.out.println("\n\t\t-----Vampire War Game-----");

			System.out.println("\n\t\t1) Log In");
			System.out.println("\t\t2) Crear Player");
			System.out.println("\t\t3) Salir");

			System.out.print("\n\t\tIngrese una opcion valida: ");
			input = in.next();

			switch (input) {

			case "1":
				if (logIn())
					menuPrincipal();
				break;

			case "2":
				if (crearPlayer(true))
					menuPrincipal();
				break;

			case "3":
				in.close();
				System.out.println("\n\t\tHasta la proxima!");
				break;
			}

		} while (!input.equals("3"));
	}

	private boolean crearPlayer(boolean log) {
		String username = "", password = "";

		System.out.println("\n\t\t-----Crear Player-----");

		System.out.print("\n\t\tIngrese su username: ");
		username = in.next();

		System.out.println("\n\t\tValidando username...");

		if (userNameEsRepetido(username)) {
			System.out
					.println("\n\t\tNombre de usuario repetido. Ingrese uno disponible.");
			return false;
		}

		System.out.println("\n\t\tUsername disponible!");

		System.out.print("\n\t\tIngrese su password(8 caracteres): ");
		password = in.next();

		System.out.println("\n\t\tValidando password...");
		
		if(password.length() != 8){
			System.out.println("\n\t\tLa password ingresada es invalida. "
					+ "Ingrese una de exactamente 8 caracteres.");
			return false;
		}

		System.out.println("\n\t\tPassword valida!\n\t\tCreando player...");
		userManager.addUser(username, password, new Date());
		System.out.println("\n\t\tPlayer creado exitosamente!");

		if(log)
		userActivo = userManager.getUser(username);

		return true;
	}

	private boolean userNameEsRepetido(String username) {
		return userManager.getUser(username) != null;
	}

	private boolean logIn() {
		Usuario user = null;
		String username = "", password = "";
		
		
		System.out.println("\n\t\t-----Log In-----");
		
		System.out.print("\n\t\tIngrese su username: ");
		username = in.next();
		
		user = userManager.getUser(username);
		
		if(user == null){
			System.out.println("\n\t\tNo existe ese usuario.");
			return false;
		}
		
		System.out.print("\n\t\tIngrese su password: ");
		password = in.next();
		
		if(!user.getPassword().equals(password)){
			System.out.println("\n\t\tPassword incorrecta.");
			return false;
		}
		
		user.setActivo(true);
		userActivo = user;
		
		return true;
	}

	private void menuPrincipal() {
          String input = "";
          
          System.out.println("\n\t\tBienvenido "+userActivo.getUsername()+"!");
          
          do{
        	  System.out.println("\n\t\t-----Menu Principal-----");
        	  
        	  System.out.println("\n\t\t1) Jugar Vampire WarGame");
        	  System.out.println("\t\t2) Mi Cuenta");
        	  System.out.println("\t\t3) Reportes");
        	  System.out.println("\t\t4) Log Out");
        	  
        	  System.out.print("\n\t\tIngrese una opcion valida: ");
        	  input = in.next();
        	  
        	  switch(input){
        	  case "1":
        		  jugar();
        		  break;
        	  case "2":
        		  miCuenta();
        		  break;
        	  case "3":
        		  reportes();
        		  break;
        	  case "4":
        		  userActivo = null;
        		  System.out.println("\n\t\tSesion terminada.");
        		  break;
        	  }
          } while(!input.equals("4") && userActivo.isActivo());
	}

	private void jugar() {
		String input = "";
        
        do{
      	  System.out.println("\n\t\t-----Jugar-----");
      	  
      	  System.out.println("\n\t\t1) Nueva Partida");
      	  System.out.println("\t\t2) Cargar Partida");
      	  System.out.println("\t\t3) Eliminar Partida");
      	  System.out.println("\t\t4) Transferir Partida");
      	  System.out.println("\t\t5) Regresar a Menu Principal");
      	  
      	  System.out.print("\n\t\tIngrese una opcion valida: ");
      	  input = in.next();
      	  
      	  switch(input){
      	  case "1":
      		  nuevaPartida();
      		  break;
      	  case "2":
      		  cargarPartida();
      		  break;
      	  case "3":
      		System.out.println("\n\t\tOpcion estara pronto!");
      		  break;
      	  case "4":
      		System.out.println("\n\t\tOpcion estara pronto!");
      		  break;
      	  }
        } while(!input.equals("5") && userActivo.isActivo());
		
	}

	private void nuevaPartida() {
		String usernameP1 = "", usernameP2 = "";
		Usuario jugador1 = null, jugador2 = null;
		
		System.out.println("\n\t\t-----Nueva Partida-----");
		
		System.out.print("\n\t\tIngrese username de jugador 1: ");
		usernameP1 = in.next();
		
		jugador1 = userManager.getUser(usernameP1);
		
		if(jugador1 == null){
			crearPlayer(false);
			jugador1 = userManager.getUser(userManager.getUserCount()-1);
		}
		
		System.out.print("\n\t\tIngrese username de jugador 2: ");
		usernameP2 = in.next();
		
		jugador2 = userManager.getUser(usernameP2);
		
		if(jugador2 == null){
			crearPlayer(false);
			jugador2 = userManager.getUser(userManager.getUserCount()-1);
		}
		
		if(jugador2.equals(jugador1)){
			System.out.println("\n\t\tIngrese otro username para el jugador 2!");
			return;
		}
		
		Jugador j1 = new Jugador(jugador1, true);
		Jugador j2 = new Jugador(jugador2, false);
		Partida nuevaPartida = new Partida(j1, j2);
		
		userActivo.getPartidas().addUser(nuevaPartida);
		
		nuevaPartida.play();
	}
	
	private void cargarPartida() {
		System.out.println("\n\t\tOpcion estara pronto!");
	}

	private void miCuenta() {
        String input = "";
        
        do{
      	  System.out.println("\n\t\t-----Mi Cuenta-----");
      	  
      	  System.out.println("\n\t\t1) Ver Mi Informacion");
      	  System.out.println("\t\t2) Cambiar Password");
      	  System.out.println("\t\t3) Cancelar Cuenta");
      	  System.out.println("\t\t4) Regresar a Menu Principal");
      	  
      	  System.out.print("\n\t\tIngrese una opcion valida: ");
      	  input = in.next();
      	  
      	  switch(input){
      	  case "1":
      		  System.out.println(userActivo);
      		  break;
      	  case "2":
      		  cambiarPassword();
      		  break;
      	  case "3":
      		  cancelarCuenta();
      		  break;
      	  }
        } while(!input.equals("4") && userActivo.isActivo());
		
	}

	private void cambiarPassword() {
		String pwActual = "", nuevaPW = "";
		
		System.out.println("\n\t\t-----Cambiar Password-----");
		
		System.out.print("\n\t\tIngrese su password actual: ");
		pwActual = in.next();
		
		if(!pwActual.equals(userActivo.getPassword())) {
			System.out.println("\n\t\tLa password no coincide.");
			return;
		}
		
		System.out.print("\n\t\tIngrese su nueva password: ");
		nuevaPW = in.next();
		
		if(nuevaPW.length() != 8){
			System.out.println("\n\t\tPassword debe ser de 8 caracteres!");
			return;
		}
		
		userActivo.setPassword(nuevaPW);
		System.out.println("\n\t\tSu password ha sido cambiada!");
	}

	private void cancelarCuenta() {
		String pwIngresada = "";
		
		System.out.println("\n\t\t-----Cancelar Cuenta-----");
		
		System.out.print("\n\t\tIngrese su password: ");
		pwIngresada = in.next();
		
		if(!userActivo.getPassword().equals(pwIngresada)){
			System.out.println("\n\t\tPassword incorrecta.");
			return;
		}
		
		userActivo.setActivo(false);
		System.out.println("\n\t\tSu cuenta ha sido cancelada.");
	}
	
	private void reportes() {
        String input = "";
        
        do{
      	  System.out.println("\n\t\t-----Reportes-----");
      	  
      	  System.out.println("\n\t\t1) Ranking");
      	  System.out.println("\t\t2) Log de Partidas");
      	  System.out.println("\t\t3) Regresar a Menu Principal");
      	  
      	  System.out.print("\n\t\tIngrese una opcion valida: ");
      	  input = in.next();
      	  
      	  switch(input){
      	  case "1":
      		  System.out.println("\n\t\tOpcion estara pronto!");
      		  break;
      	  case "2":
      		  System.out.println("\n\t\tOpcion estara pronto!");
      		  break;
      	  }
        } while(!input.equals("3") && userActivo.isActivo());
		
	}
	
	

}
