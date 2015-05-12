import java.util.Scanner;
public class Passaword {

	Passaword() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese la cadena:");
		String passaword = entrada.nextLine();
		char passawordchar[] = passaword.toCharArray();
		for(int i = 0;i<passaword.length();i++){
			if(passawordchar[i]!=' '){
				System.out.print("*");}
			else
				System.out.print(" ");
		}
	}

}
