import java.util.Scanner;
public class TablaMultiplicar {

	TablaMultiplicar() {
		System.out.println("Bienvenido al Programa Tablas de Multiplicar.\n"+"Ingrese un numero del 0 al 10 para desplegar la tabla de multiplicaicion.");
		int num=1;
		Scanner entrada = new Scanner(System.in);
		num=entrada.nextInt();
		if(num>=0 & num<=10)
			for(int i=10;i>=0;i--)
				System.out.println(num+" x "+ i +" = "+(num*i));
		else
			System.out.println("Tabla no Disponible.");

	}

}
