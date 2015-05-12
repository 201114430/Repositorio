import java.util.Scanner;
//import java.util.regex.Pattern;
public class ConvertirHora {
	public static boolean esHorAM(int hora){
		if(hora>=0 & hora<=11)
				return true;
		return false;
		}
	public static boolean esHora(int hora){
		if(hora>=12 & hora<=23)
				return true;
		return false;
		}
	public static boolean esMinu(int min){
		if(min>=0 & min<=59)
				return true;
		return false;
		}
	ConvertirHora() {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Bienvenido al programa que cambia el formato de la hora. \n"+"Ingrese la hora en formato militar");
		String horaStr = entrada.next();
		//valido para que los caracteres ingresados sean 5
		if(horaStr.length()==5){
			
			String puntos = ":";
			String[] matrizh;
			matrizh = horaStr.split(puntos);
			int[] horanum;
			horanum =  new int[2];
			//for para pasar de arreglo String a arreglo int
			for(int i=0;i<2;i++){				
				horanum[i]=Integer.parseInt(matrizh[i]);
			}
			if(esHorAM(horanum[0]) && esMinu(horanum[1])){/*para validar el rango de la hora am*/
				if(horanum[1]<10)
				System.out.println((horanum[0])+":0"+horanum[1]+" AM");
				else
					System.out.println((horanum[0])+":"+horanum[1]+" AM");
			}
			else if(esHora(horanum[0]) && horanum[0]==12){
				if(horanum[1]<10)
					System.out.println((horanum[0])+":0"+horanum[1]+" PM");
					else
						System.out.println((horanum[0])+":"+horanum[1]+" PM");
			}
			else if(esHora(horanum[0]) && esMinu(horanum[1])){/*para validar el rango de la hora pm*/
				if(horanum[1]<10)
				System.out.println((horanum[0]-12)+":0"+horanum[1]+" PM");
				else
					System.out.println((horanum[0]-12)+":"+horanum[1]+" PM");
			}
			else
				System.out.println("Hora no valida. verifique la hora o los minutos en ingrese de nuevo.");
		}
		else
		System.out.println("Hora no valida o con formato erroneo, ingresar exactamente 5 caracteres ejemplo 09:00");
	}

}
