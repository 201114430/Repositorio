import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcion = 0;
		do{
			System.out.println("Bienvenidos al menu principal de la Practica 1:");
			System.out.println("1.) Nivel 1. \n"+"2.) Nivel 2. \n"+"0.) Salir. \n");
			opcion = entrada.nextInt();
			switch(opcion){
			case 0:
				System.out.print("Espere...\n" + "Programa Finalizado");
				System.exit(0);
				break;
			case 1:
				Nivel1 nivel1 = new Nivel1();
				nivel1.getClass();
	
				break;
			case 2:
				Nivel2 nivel2 = new Nivel2();
				nivel2.getClass();
				break;
			default:
				System.out.print("Opcion No Valida.");
				break;
			}
		}while(opcion!=0);

	}

}