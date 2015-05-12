import java.util.Scanner;

public class PrimoEnUnRango {
	public static boolean esPrimo(int num){
		for(int i=2;i<num;i++)
			if(num%i==0)
				return false;
		return true;
	}

	PrimoEnUnRango() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Programa que busca numeros primos de 1 hasta n. \n"+"Ingrese numero");
		int num = entrada.nextInt();
		int contador = 0;
		for(int i=2;i<=num;i++){
			if(esPrimo(i)){
				contador=contador+1;
				System.out.print(i+", ");
			}
			
		}
		System.out.println("");
		System.out.println("Del 1 al "+num+" hay "+contador+" numeros primos");
	}

}
