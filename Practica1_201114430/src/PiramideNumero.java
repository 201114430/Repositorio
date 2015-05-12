import java.util.Scanner;

public class PiramideNumero {

	PiramideNumero() {
		Scanner entrada= new Scanner(System.in);
		System.out.println("Programa que construye una piramide invertida de numeros. \n"+"Ingrese el numero de la base.");
		int num=0;
		num = entrada.nextInt();
		for(int i=1;i<=num;i++){
			for(int k=0;k<=i-2;k++){
				System.out.print(" ");
			}
			for(int j=num-i;j>=0;j--){
				System.out.print(i+" ");				
			}

			System.out.println("");
		}

	}

}
