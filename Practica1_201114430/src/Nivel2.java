import java.io.IOException;
import java.util.Scanner;


public class Nivel2 {

	Nivel2() {
		Scanner entrada = new Scanner(System.in);
		int opcion = 0;
		do{
		System.out.println("Bienvenidos al Nivel 2:");
		System.out.println("6.) Ejercicio 6. \n"+"7.) Ejercicio 7. \n"+"8.) Ejercicio 8. \n"+"9.) Ejercicio 9. \n"+"10.) Ejercicio 10. \n"+"11.) Ejercicio 11. \n"+"12.) Ejercicio 12. \n"+"13.) Ejercicio 13. \n"+"14.) Ejercicio 14. \n"+"15.) Ejercicio 15. \n" +"0.) Menu Principal. \n");
		opcion = entrada.nextInt();
		switch(opcion){
		case 0:
			Menu menu = new Menu();
			menu.main(null);
			break;
		case 6:
			Calculadora calc = new Calculadora();
			calc.getClass();
			congela();
			Nivel2 n1 = new Nivel2();
			n1.getClass();
		case 7:
			TablaMultiplicar tabla = new TablaMultiplicar();
			tabla.getClass();
			congela();
			Nivel2 n2 = new Nivel2();
			n2.getClass();
		case 8:
			NumeroLetras numeroletras = new NumeroLetras();
			numeroletras.getClass();
			congela();
			Nivel2 n3 = new Nivel2();
			n3.getClass();
		case 9:
			NumARomano numeroromanoarabigo = new NumARomano();
			numeroromanoarabigo.getClass();
			congela();
			Nivel2 n4 = new Nivel2();
			n4.getClass();
		case 10:
			PiramideNumero piramidenumero = new PiramideNumero();
			piramidenumero.getClass();
			congela();
			Nivel2 n5 = new Nivel2();
			n5.getClass();
		case 11:
			OrdenaRomano ordenaromano = new OrdenaRomano();
			ordenaromano.getClass();
			congela();
			Nivel2 n6 = new Nivel2();
			n6.getClass();
		case 12:
			Passaword passaword = new Passaword();
			passaword.getClass();
			congela();
			Nivel2 n7 = new Nivel2();
			n7.getClass();
		case 13:
			JuegoAbc juegoabc = new JuegoAbc();
			juegoabc.getClass();
			congela();
			Nivel2 n8 = new Nivel2();
			n8.getClass();
		case 14:
			Cuadrado cuadrado = new Cuadrado();
			cuadrado.getClass();
			congela();
			Nivel2 n9 = new Nivel2();
			n9.getClass();
		case 15:
			PrimoEnUnRango primoenunrango = new PrimoEnUnRango();
			primoenunrango.getClass();
			congela();
			Nivel2 n10 = new Nivel2();
			n10.getClass();
		default:
			System.out.println("Opcion No Valida.");				
			break;
		}
		}while(opcion!=0);
		

	}
	public void congela(){
		System.out.println("\nPara continuar presiones la tecla (Enter)...");
		try {
			System.in.read();
			
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

}
