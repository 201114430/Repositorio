import java.util.Scanner;
import java.io.IOException;


public class Nivel1 {

<dibujo> Nivel1() {
		Scanner entrada = new Scanner(System.in);
		int opcion = 0;
		int opcion1 = 0;
		do{
		System.out.println("Bienvenidos al Nivel 1:");
		System.out.println("1.) Ejercicio 1. \n"+"2.) Ejercicio 2. \n"+"3.) Ejercicio 3. \n"+"4.) Ejercicio 4. \n"+"5.) Ejercicio 5. \n" +"0.) Menu Principal. \n");
		opcion = entrada.nextInt();
		switch(opcion){
		case 0:
			Menu menu = new Menu();
			menu.main(null);
		case 1:
			Dibujo dibujo = new Dibujo();
			dibujo.getClass();
			congela();
			Nivel1 n1 = new Nivel1();
			n1.getClass();
		case 2:
			Puntuacion punt = new Puntuacion();
			punt.getClass();
			congela();
			Nivel1 n2 = new Nivel1();
			n2.getClass();
		case 3:
			ConvertirHora ch = new ConvertirHora();
			ch.getClass();
			congela();
			Nivel1 n3 = new Nivel1();
			n3.getClass();
		case 4:
			Geometria geo = new Geometria();
			geo.getClass();
			congela();
			Nivel1 n4 = new Nivel1();
			n4.getClass();
		case 5:
			Fechas fe = new Fechas();
			fe.getClass();
			congela();
			Nivel1 n5 = new Nivel1();
			n5.getClass();
		default:
			System.out.println("Opcion No Valida.");
			break;
		}

		}while(opcion!=0);

	}


	public void congela(){
		System.out.println("Para continuar presione la tecla (Enter).");
		try {
			System.in.read();
			
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

}