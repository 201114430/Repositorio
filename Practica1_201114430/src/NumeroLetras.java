import java.util.Scanner;
import java.util.Random;

public class NumeroLetras {
	//funcion que verifica si hay solo numeros
	static boolean esNum(String subparametro){
		if((subparametro).matches("([0-9]|\\.)+"))
				return true;
		return false;
	}
	/*nombre de la funcion Entero Limite Inferior Limite Superior
	 * verifica que los numeros esten entre 0 100
	 */
	static boolean ELILS(int a,int b){
		if((a>=0 & b<101) && a<b)
				return true;
		return false;
	}
	public static String base(char primerDigito){
		if(primerDigito=='0')
			return "cero.";		
		else if(primerDigito=='1')
			return "uno.";
		else if(primerDigito=='2')
				return "dos.";
		else if(primerDigito=='3')
				return "tres.";
		else if(primerDigito=='4')
				return "cuatro.";
		else if(primerDigito=='5')
				return "cinco.";
		else if(primerDigito=='6')
				return "seis.";
		else if(primerDigito=='7')
			return "siete.";
		else if(primerDigito=='8')
				return "ocho.";
		else if(primerDigito=='9')
				return "nueve.";
		return null;
		}
	
	NumeroLetras() {
		System.out.println("Programa que genera un numero aleatorio y lo convierte en numero a letras. \n"+"Ingrese dos numero del 0 al 100 separados por coma.\n"+"X,Y");
		Scanner entrada = new Scanner(System.in);
		String parametro = entrada.next();
		//secciono el string parametro en un array argtext de 2 elementos
		String[] argtext = parametro.split(",");
		if(esNum(argtext[0]) & esNum(argtext[1])){
			int limInf = 0;
			int limSup = 0;
			limInf=Integer.parseInt(argtext[0]);//convierto de string a int argtext[0] es el limite inferior
			limSup=Integer.parseInt(argtext[1]);//convierto de string a int argtext[1] es el limite superior
			if(ELILS(limInf,limSup) && limInf<limSup){
				int numAleatorio = (int) Math.floor(Math.random()*(limSup-limInf+1)+limInf);
				String numAleaString = Integer.toString(numAleatorio);//convierto el numero generado aleatoriamente a String
				System.out.println("numero aleatorio = "+numAleatorio);
				char letra[];
				letra = numAleaString.toCharArray();
				/*
				 * convierto el numero generado aleatoriamente de String a char donde solo utilizo letra[0] que
				 * contiene las unidades. para unir los siguienes if con la funcion base
				 */
				if(numAleatorio==100){
					System.out.print("Cien");}
				else if(numAleatorio==90)
					System.out.print("Noventa");
				else if(numAleatorio>90)
					System.out.print("Noventa y "+base(letra[1]));
				else if(numAleatorio==80)
					System.out.print("Ochenta");
				else if(numAleatorio>80)
					System.out.print("Ochenta y "+base(letra[1]));
				else if(numAleatorio==70)
					System.out.print("Setenta");
				else if(numAleatorio>70)
					System.out.print("Setenta y "+base(letra[1]));
				else if(numAleatorio==60)
					System.out.print("Sesenta");
				else if(numAleatorio>60)
					System.out.print("Sesenta y "+base(letra[1]));
				else if(numAleatorio==50)
					System.out.print("Cincuenta");
				else if(numAleatorio>50)
					System.out.print("Cincuenta y "+base(letra[1]));
				else if(numAleatorio==40)
					System.out.print("Cuarenta");
				else if(numAleatorio>40)
					System.out.print("Cuarenta y "+base(letra[1]));
				else if(numAleatorio==30)
					System.out.print("Treinta");
				else if(numAleatorio>30)
					System.out.print("Treinta y "+base(letra[1]));
				else if(numAleatorio==20)
					System.out.print("Veinte");
				else if(numAleatorio>20)
					System.out.print("Veinti"+base(letra[1]));
				else if(numAleatorio>=16)
					System.out.print("Dieci"+base(letra[1]));
				else if(numAleatorio==15)
					System.out.print("Quince");
				else if(numAleatorio==14)
					System.out.print("Catorce");
				else if(numAleatorio==13)
					System.out.print("Trece");
				else if(numAleatorio==12)
					System.out.print("Doce");
				else if(numAleatorio==11)
					System.out.print("Once");
				else if(numAleatorio==10)
					System.out.print("Diez");
				else if(numAleatorio<10)
					System.out.print(base(letra[0]));
			}
			else
				System.out.println("Revise los limites");
		}
		else
			System.out.println("Argumento incorrecto");
	}
}
