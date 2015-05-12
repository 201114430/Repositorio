import java.util.Scanner;

public class Puntuacion {
	//funcion rango
	static boolean esNota(int aux){
	if(aux<0 || aux>100)
			return false;
	return true;
	}
	public static char promedio(double num){
		if(num>=90)
			return 'A';
		else if(num>=80)
			return 'B';
		else if(num>=70)
			return 'C';
		else if(num>=60)
			return 'D';
		else if(num>=0)
			return 'E';
		return (' ');
		}

	Puntuacion() {
		int sumaTotal=0;
		int aux=0;
		byte stop=0;
		Scanner entrada = new Scanner(System.in);
		
		int puntuacion[];
		puntuacion = new int[6];
		int calificacion[];
		calificacion = new int[6];
		char letra[];
		letra =new char[5];
		int A=(int)'A';
		System.out.println("Bienvenido al Programa Puntuacion.");
		for(int i=0;i<6;i++)
		{
			System.out.println("Ingrese la puntuacion "+(i+1));
			aux = entrada.nextInt();
			if(esNota(aux))
			{
				puntuacion[i]=aux;
				if(puntuacion[i]>=90)
					calificacion[0]=calificacion[0]+1;
				else if(puntuacion[i]>=80)
					calificacion[1]=calificacion[1]+1;
				else if(puntuacion[i]>=70)
					calificacion[2]=calificacion[2]+1;
				else if(puntuacion[i]>=60)
					calificacion[3]=calificacion[3]+1;
				else if(puntuacion[i]>=0)
					calificacion[4]=calificacion[4]+1;
			}
			else
			{
				System.out.println("Nota no permitada, ");
				System.out.println("Ingresar de nuevo. 1, Ir al inicio. 0");
				stop = entrada.nextByte();
				if(stop==1){
					i=i-1;
					continue;
				}
				else if(stop==0)
					Menu.main(null);
				//break;
				//System.exit(0);
			}		
		}
		for(int i=0;i<6;i++)
		{
		sumaTotal = sumaTotal+puntuacion[i];
		}
		System.out.println("Rango      Media   Puntuacion   Promedio");
		String rango[]={"(90-100)   ","(80-89)    ","(70-79)    ","(60-69)    ","(0-59)     "};
		for(int i=0;i<5;i++)
		{
			System.out.print(rango[i]+"  "+(letra[i] = (char)(A+i))+"          "+calificacion[i]);
			if(promedio(sumaTotal/6)==letra[i]){
			System.out.print(" ........ " + (sumaTotal/6));}
			System.out.println("");

		}
		System.out.println("Promedio = "+ sumaTotal/6);

	}
}
