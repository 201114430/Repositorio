import java.util.Scanner;


public class Fechas {
	//verifica el ingreso correcto de las fechas
	static boolean esNum(String fechag){
		if((fechag).matches("([0-9]|\\/)+"))
				return true;
		return false;
		}
	//verifica el rango de dias, meses, años
	public static boolean esDia(int dia){
		if(dia>=1 | dia<=30)
				return true;
		return false;
		}
	public static boolean esMes(int mes){
		if(mes>=1 | mes<=11)
				return true;
		return false;
		}
	public static boolean esYear(int year){
		if(year>=1 | year<=1000)
				return true;
		return false;
		}
	Fechas() {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Programa que calcula cuantos dias hay entre dos fechas. \n"+"Formato: dia / mes / año \n"+"Ingrese primera fecha.");
		String fecha1 = entrada.next();
		System.out.println("Ingrese Segunda fecha.");
		String fecha2 = entrada.next();
		String[] fechacadena1 = fecha1.split("/");
		String[] fechacadena2 = fecha2.split("/");
		int[] fechanum1;
                int[] fechanum2;
		fechanum1 =  new int[3];
		fechanum2 =  new int[3];
		//for para convertir fecha cadena String a un arreglo int
		for(int i=0;i<3;i++){				
			fechanum1[i]=Integer.parseInt(fechacadena1[i]);
			fechanum2[i]=Integer.parseInt(fechacadena2[i]);
			//System.out.println(fechanum1[i]);
			//System.out.println(fechanum2[i]);
		}
			if(esNum(fecha1) & esNum(fecha2)){
				if((esDia(fechanum1[0]) & esMes(fechanum1[1]) & esYear(fechanum1[2])) & (esDia(fechanum2[0]) & esMes(fechanum2[1]) & esYear(fechanum2[2]))){
					System.out.println("Numero de Dias entre ambas fechas: "+(((fechanum2[2]-fechanum1[2])*360)+((fechanum2[1]-fechanum1[1])*30)+(fechanum2[0]-fechanum1[0])));	
				}
				else
					System.out.println("Fecha incorrecta revise los dias, meses, años");
					
			}
			else
				System.out.println("Argumento incorrecto,");
	}

}