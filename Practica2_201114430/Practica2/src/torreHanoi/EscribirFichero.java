package torreHanoi;

import java.io.*;

public class EscribirFichero {
	public String nombreJugador,disc,tiempo;
	//public int discoEscogido;
	public final String ruta = System.getProperties().getProperty("user.dir");
	//String urlW = "C:\\Users\\Juan JP\\OneDrive\\Dropbox\\Proyecto de IPC1\\Eclipse\\InterfazGrafica\\bin\\Datos\\data.th";
	//String urlU = "/home/juandelcid/Escritorio/data.th";
	public EscribirFichero(){
 		
	}
	public String urlS(int discoEscogido){//escoge ruta segun discos seleccionados
		if(discoEscogido==3)
			return ruta+"//data3.th";
		else if(discoEscogido==4)
			return ruta+"//data4.th";
		else if(discoEscogido==5)
			return ruta+"//data5.th";
		else if(discoEscogido==6)
			return ruta+"//data6.th";
		else if(discoEscogido==7)
			return ruta+"//data7.th";
		else if(discoEscogido==8)
			return ruta+"//data8.th";
		return null;		
	}
	public void escribeDato(String nombreJugador,int discoEscogido,int movimientoRealizado,String tiempo){
		disc= Integer.toString(discoEscogido);
		System.out.println("Grabando fichero de texto a disco...");
		try
		{
			BufferedWriter ficheroSalida = new BufferedWriter(new FileWriter(new File(urlS(discoEscogido)),true));
			ficheroSalida.write(nombreJugador + "," + disc + "," + movimientoRealizado + "," + tiempo + "/" + tiempo);
            ficheroSalida.newLine();
            ficheroSalida.close();
        }
        catch (IOException errorDeFichero)
        {
            System.out.println(
            		"No se guardaron los datos: " +
            errorDeFichero.getMessage() );
        }
		
	}
}