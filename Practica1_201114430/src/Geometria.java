import java.util.Scanner;
public class Geometria {
	public static Double pi=3.141592;
	static boolean esnum(String subparametro){
		if((subparametro).matches("([0-9]|\\.)+"))
				return true;
		return false;
		}
	static boolean esletra(char letra){
		if(letra=='C' || letra=='c')
				return true;
		if(letra=='U' || letra=='u')
			return true;
		if(letra=='T' || letra=='t')
			return true;
		return false;
		}
	static int opcion(char letra){
		if(letra=='C' || letra=='c')
			return 1;
			else if(letra=='U' || letra=='u')
				return 2;
			else if(letra=='T' || letra=='t')
				return 3;
		return 0;
		}
	
	Geometria() {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Bienvenido al programa que calcula: \n"+"Circulo: Area, Perimetro y radio. Ingrese C,X \n" + "Cuadrado: Area, Perimetro. Ingrese U,X \n" + "Triangulo Equilatero: Area, Perimetro y altura. Ingrese T,X \n"+ "Donde X es cualquier numero entero o decimal.");
		String parametro = entrada.next();
			char letra[];
			letra = parametro.toCharArray();
			if(esletra(letra[0]) & letra[1]==','){
				String subparametro=parametro.substring(2,parametro.length());

				if(esnum(subparametro)){
					Double num;
					num =Double.parseDouble(parametro.substring(2,parametro.length()));
					switch(opcion(letra[0])){
						case 1:
							System.out.println("Circulo");
							System.out.println("Area = "+(pi*num*num)+" Perimetro = "+(2*pi*num)+ "  Radio = "+num);
							break;
						case 2:
							System.out.println("Cuadrado");
							System.out.println("Area = "+(num*num)+" Perimetro = "+(4*num));
							break;
						case 3:
							System.out.println("Triangulo equilatero");
							System.out.println("Area = "+(num*num*(Math.sqrt(3)/4))+" Perimetro = "+(3*num)+ "  Altura = "+(num*(Math.sqrt(3)/2)));
							break;							
						case 0:
					}	
				}
				else
					System.out.println("No es un numero Valido");
			}
			else
				System.out.println("Ingreso de argumento incorrecto");
	}
}
