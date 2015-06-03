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
				if(logIn())
					menuPrincipal();
				break;

			case "2":
				if(crearPlayer())
					menuPrincipal();
				break;

			case "3":
				in.close();
				System.out.println("\n\t\tHasta la proxima!");
				break;
			}

		} while (!input.equals("3"));
	}

	private boolean crearPlayer() {
		String username = "", password = "";
		boolean repetido = false, contrasenaInvalida = false;
		
		System.out.println("\n\t\t-----Crear Player-----");

		do{
			if(repetido)
				System.out.println("\n\t\tNombre de usuario repetido. Ingrese uno disponible.");
			
			System.out.print("\n\t\tIngrese su username: ");
			username = in.next();
			
			System.out.println("\n\t\tValidando username...");
			repetido = userNameEsRepetido(username);
			
		} while(repetido);
		
		System.out.println("\n\t\tUsername disponible!");
		
		do{
			if(contrasenaInvalida)
				System.out.println("\n\t\tLa password ingresada es invalida. "
						+ "Ingrese una de exactamente 8 caracteres.");
			
			System.out.print("\n\t\tIngrese su password(8 caracteres): ");
			password = in.next();
			
			System.out.println("\n\t\tValidando password...");
			contrasenaInvalida = password.length() != 8;
			
		} while(contrasenaInvalida);
        		
        System.out.println("\n\t\tPassword valida!\n\t\tCreando player...");
        userManager.addUser(username, password, new Date());
        System.out.println("\n\t\tPlayer creado exitosamente!");
        
        if(userActivo != null) userActivo.setActivo(false);
        
        userActivo = userManager.getUser(username);
        
        return true;
	}

	private boolean userNameEsRepetido(String username) {
		return userManager.getUser(username) != null;
	}

	private boolean logIn() {
		return true;
	}
	
	private void menuPrincipal(){
		
	}

}
