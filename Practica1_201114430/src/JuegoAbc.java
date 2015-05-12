import java.util.Scanner;
public class JuegoAbc {

	JuegoAbc() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Bienvenidos al Juego Adivina la letra. \n"+"Ingrese la letra a Adivinar");
		
		String letraIng = entrada.next();
		char letra[];
		letra = letraIng.toCharArray();
		
		for(int i=0;i<100;i++)
			System.out.println("");
		/*int a=(int)'a';
		int A=(int)'A';
		char matrizabc[];
		char matrizABC[];
		matrizabc = new char[26];
		matrizABC = new char[65];
		for(int i=0;i<matrizabc.length;i++){
			matrizabc[i]=(char)(a+i);
			matrizABC[i]=(char)(A+i);
		}*/
        System.out.println("Inicio del Juego ingrese una letra hasta adivinar");
		String segundaLetra = entrada.next();
		char segundachar[];
		segundachar = segundaLetra.toCharArray();
		if(letra[0]==segundachar[0])
			System.out.println("Usted Gano");
		while(letra[0]!=segundachar[0]){
			if(segundachar[0]<letra[0]){
				System.out.println("Antes");
                segundaLetra = entrada.next();
                segundachar = segundaLetra.toCharArray();
                if(letra[0]==segundachar[0])
    				System.out.print("Usted Gano");
			}
            else if(segundachar[0]>letra[0]){
            	System.out.println("Despues");
				segundaLetra = entrada.next();
				segundachar = segundaLetra.toCharArray();
				if(letra[0]==segundachar[0])
					System.out.print("Usted Gano");
            }
        }
	}
}