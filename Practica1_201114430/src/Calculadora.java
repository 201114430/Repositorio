import java.util.Scanner;


public class Calculadora {

	static boolean esnum(String subparametro){
		if((subparametro).matches("([0-9]|\\.)+"))
				return true;
		return false;
		}
	static boolean esletra(char letra){
		if(letra=='S' || letra=='s')
				return true;
		if(letra=='R' || letra=='r')
			return true;
		if(letra=='M' || letra=='m')
			return true;
		if(letra=='D' || letra=='d')
			return true;
		return false;
		}
	static int opcion(char letra){
		if(letra=='S' || letra=='s')
			return 1;
		else if(letra=='R' || letra=='r')
			return 2;
		else if(letra=='M' || letra=='m')
			return 3;
		else if(letra=='D' || letra=='d')
			return 4;
		return 0;
		}
	
	Calculadora() {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Bienvenido al programa Calculadora. \n"+ "Donde X,Y es cualquier numero entero o decimal. \n"+"Suma X,Y,s. \n"+"Resta X,Y,r. \n"+"Multiplicacion X,Y,m. \n"+"Division X,Y,d. \n");
		String parametro = entrada.next();
		String[] argtext = parametro.split(",");
		
		char letra[];
		letra = argtext[2].toCharArray();
			if(esnum(argtext[0]) & esnum(argtext[1])){
				if(esletra(letra[0])){
					Double num1;
					Double num2;
					num1 =Double.parseDouble(argtext[0]);
					num2 =Double.parseDouble(argtext[1]);
					switch(opcion(letra[0])){
						case 1:
							System.out.println("Suma = "+(num1+num2));
							break;
						case 2:
							System.out.println("Resta = "+(num1-num2));
							break;
						case 3:
							System.out.println("Multiplicacion = "+(num1*num2));
							break;
						case 4:
							System.out.println("Division = "+(num1/num2));
							break;
						case 0:
					}	
				}
				else
					System.out.println("Argumento de operacion incorrecto.");
			}
			else
				System.out.println("Ingreso de argumento incorrecto");
	}
}
