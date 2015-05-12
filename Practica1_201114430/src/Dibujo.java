import java.util.Scanner;

public class Dibujo {

	Dibujo() {
		System.out.println("Programa que genera un rombo con asteriscos.");
		//Scanner entrada = new Scanner(System.in);
		//System.out.println("Ingrese una numero menor que 10 para el numero de filas del Patron");
		//int a = entrada.nextInt();
		int a = 9;
		//int a debe ser = 9 o menor para que funcione
		//Parte de Arriba
		for(int h=1;h<a-3;h++)
		{
			for(int i=5-h;i>0;i--)
			{
				System.out.print("  ");
			}
			
			for(int j=0;j<2*h-1;j++)
			{
				System.out.print("* ");
			}
			System.out.println("");
			System.out.println("");
		}
		//Parte de Abajo
		for(int h=a-5;h>=1;h--)
		{
			for(int i=h;i<5;i++)
			{
				System.out.print("  ");
			}
			
			for(int j=2*h-1;j>0;j--)
			{
				System.out.print("* ");
			}
			System.out.println("");
			System.out.println("");
		}
	}		
}