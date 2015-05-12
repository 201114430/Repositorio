import java.util.Scanner;

public class Tarea3_201114430 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int a = 0;
		System.out.println("Ingrese un numero");
		a = entrada.nextInt();
		if (a % 2 == 0)
			System.out.println("El numero "+ a + " es par");
		else 
			System.out.println("El numero "+ a + " es impar");
	}

}
