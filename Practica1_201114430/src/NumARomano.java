import java.util.Scanner;
public class NumARomano {
	static boolean esNum(String subparametro){
		if((subparametro).matches("([0-9]|\\.)+"))
				return true;
		return false;
		}
	NumARomano() {  
		Scanner entrada = new Scanner(System.in);  
	      String Unidad[]={"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};  
	      String Decena[]={"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};  
	      String Centena[]={"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	      String Millar[]={"", "M", "MM", "MMM", "IV'", "V'", "VI'", "VII'", "VIII'", "IX'"};
	      
	      System.out.println("Ingresa numero entre 1 y 9999");
	      String numletra;
	      numletra = entrada.next();
	      if(esNum(numletra)){
	    	  int num = Integer.parseInt(numletra);
		      int unidad = num%10;  
		      int decena = (num/10)%10;  
		      int centena = (num/100)%10;
		      int millar = (num/1000)%10;
		      if(num>=10000){
	    	  System.out.println("Numero supera la programacion.");
		      }
	    	  else if(num>=1000){
		    	  System.out.println(Millar[millar]+Centena[centena]+Decena[decena]+Unidad[unidad]);
		      }
		      else if(num>=100){           
		          System.out.println(Centena[centena]+Decena[decena]+Unidad[unidad]);   
		      }
		      else if(num>=10){
		              System.out.println(Decena[decena]+Unidad[unidad]);            
		      }
		      else if(num>=0){  
		              System.out.println(Unidad[num]);            
		      }
		   }
	      else
	    	  System.out.println("Argumento incorrecto");
	}
}