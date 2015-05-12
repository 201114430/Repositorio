import java.util.Scanner;

public class OrdenaRomano {
	// todas las funciones para convertir numero a letras exportadas de la clase NumeroLetras
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

	//funcion para realizar ordenamiento
	public static void ordenaBurbuja(int[] a){
		int aux;
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					aux =a[i];
					a[i]=a[j];
					a[j]=aux;
				}
				
			}
			
		}
	}
	
	//funcion con los simbolos romanos y su equivalencia
	public static int valorRomano(char numRom){
			if(numRom=='I')
				return 1;
			else if(numRom=='V')
				return 5;
			else if(numRom=='X')
				return 10;
			else if(numRom=='L')
				return 50;
			else if(numRom=='C')
				return 100;
			else if(numRom=='D')
				return 500;
			else if(numRom=='M')
				return 1000;
			return 0;
				
			}

		OrdenaRomano() {
			System.out.println("Programa que Recibe una Lista de Numeros en notacion romana \n"+"los ordena e imprime el primero y el ultimo en letras. \n"+"Ingrese Datos...");
			Scanner entrada = new Scanner(System.in);
			String listaEntrada = entrada.next();
			String[] listaEntradaSeccionada = listaEntrada.split(",");
			String[] numBaseD;
			numBaseD = new String[listaEntradaSeccionada.length];
			for(int i=0;i<listaEntradaSeccionada.length;i++){
                int numeroAra=0;
                char numChar[];
                numChar = listaEntradaSeccionada[i].toCharArray();
                numeroAra=valorRomano(numChar[0]);
                for(int j=0;j<listaEntradaSeccionada[i].length()-1;j++){
                if(valorRomano(numChar[j])<valorRomano(numChar[j+1]))
                    numeroAra=valorRomano(numChar[j+1])-numeroAra;                    
                else if(valorRomano(numChar[j])>=valorRomano(numChar[j+1]))
                    numeroAra=numeroAra+valorRomano(numChar[j+1]);
                }
                numBaseD[i] = Integer.toString(numeroAra);
			}
			for(int h=0;h<listaEntradaSeccionada.length;h++){
				if((Integer.parseInt(numBaseD[h])<-0) & (Integer.parseInt(numBaseD[h])>-10))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+20);
				if((Integer.parseInt(numBaseD[h])<-10) & (Integer.parseInt(numBaseD[h])>-20))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+40);
				if((Integer.parseInt(numBaseD[h])<-20) & (Integer.parseInt(numBaseD[h])>-30))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+60);
				if((Integer.parseInt(numBaseD[h])<-30) & (Integer.parseInt(numBaseD[h])>-40))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+80);
				if((Integer.parseInt(numBaseD[h])<-40) & (Integer.parseInt(numBaseD[h])>-50))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+100);
				if((Integer.parseInt(numBaseD[h])<-50) & (Integer.parseInt(numBaseD[h])>-60))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+120);
				if((Integer.parseInt(numBaseD[h])<-60) & (Integer.parseInt(numBaseD[h])>-70))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+140);
				if((Integer.parseInt(numBaseD[h])<-70) & (Integer.parseInt(numBaseD[h])>-80))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+160);
				if((Integer.parseInt(numBaseD[h])<-80) & (Integer.parseInt(numBaseD[h])>-90))
					numBaseD[h]=Integer.toString(Integer.parseInt(numBaseD[h])+180);
			}
			/*para pasar de strin arreglo de numeros romanos convertidos a indoarabigos a un arreglo int*/
			int[] numIndoa;
			numIndoa =  new int[listaEntradaSeccionada.length];
			for(int i=0;i<listaEntradaSeccionada.length;i++){
				numIndoa[i] = Integer.parseInt(numBaseD[i]);
				//System.out.println(numIndoa[i]);
			}
			ordenaBurbuja(numIndoa);
			for(int j=0;j<listaEntradaSeccionada.length;j++){
				System.out.println(numIndoa[j]+", ");
			}
			///////////////////////////////////////////////////////////
			///codigo para pasar de numeros a letras el numero menor///
			System.out.println("Valor inicial "+numIndoa[0]+ " Valor final "+numIndoa[listaEntradaSeccionada.length-1]);    
			if(numIndoa[0]<101){
				int limInf = 0;
				int limSup = 0;
				limInf =numIndoa[0];
				limSup = numIndoa[listaEntradaSeccionada.length-1];
				if(limInf<101){
					//Desconpongo el numAleatorio  
					int numAleatorio = numIndoa[0];
					String numAleaString = Integer.toString(numAleatorio);//convierto el numero generado aleatoriamente a String
					System.out.println("Numero MENOR = "+numAleatorio);
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
						
			//finaliza codigo para pasar numero menor a letras
			
			///////////////////////////////////////////////////////////
			///codigo para pasar de numeros a letras el numero mayor///  
			System.out.println("");
			if(numIndoa[0]<101){
				int limInf = 0;
				int limSup = 0;
				/*limInf=Integer.parseInt(argtext[0]);//convierto de string a int argtext[0] es el limite inferior
				limSup=Integer.parseInt(argtext[1]);//convierto de string a int argtext[1] es el limite superior*/
				limInf =numIndoa[listaEntradaSeccionada.length-1];
				limSup = numIndoa[0];
				if(limInf<101){
					//int numAleatorio = (int) Math.floor(Math.random()*(limSup-limInf+1)+limInf);
					int numAleatorio = numIndoa[listaEntradaSeccionada.length-1] ;
					String numAleaString = Integer.toString(numAleatorio);//convierto el numero generado aleatoriamente a String
					System.out.println("Numero MAYOR = "+numAleatorio);
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
						
			//finaliza codigo para pasar numero mayor a letras
				
		}
}
