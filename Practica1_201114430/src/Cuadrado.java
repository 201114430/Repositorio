import java.util.Scanner;


public class Cuadrado {

	Cuadrado() {
		Scanner entrada= new Scanner(System.in);
		System.out.println("Programa que construye un cuadrado de n asteriscos. \n"+"Ingrese el numero asteriscos.");
		int num=0;
		num = entrada.nextInt();
		for(int h=1;h<=1;h++){
			for(int i=num-h;i>=0;i--){
				System.out.print("* ");				
			}
			System.out.println("");
			for(int j=0;j<num-2;j++){
				System.out.print("*");
				for(int k=0;k<=2*num-4;k++){
					System.out.print(" ");
				}
				System.out.println("*");
			}
			for(int i=num-h;i>=0;i--){
				System.out.print("* ");
			}

			
		}

	}

}
