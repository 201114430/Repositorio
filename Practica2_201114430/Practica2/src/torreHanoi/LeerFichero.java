package torreHanoi;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;


public class LeerFichero{
	public String nombreJugador,disc,tiempo;
	public int numeroFichero = 3;
	public final String ruta = System.getProperties().getProperty("user.dir");
	//String urlW = "C:\\Users\\Juan JP\\OneDrive\\Dropbox\\Proyecto de IPC1\\Eclipse\\InterfazGrafica\\bin\\Datos\\data.th";
	//String urlU = "/home/juandelcid/Escritorio/data.th";
	public LeerFichero(){
		cargarFichero();
		
	}
	public String urlS(int discoEscogido){//Recibe numero de disco seleccionado por jugador y Devuelve la ruta del archivo
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
	public void cargarFichero(){
		
		System.out.println("********* TreeMap *********");
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		String cadenaLlave = null;
		String parametro = null;
		int llave = 0;
		////////////////////
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
		         // Abre fichero y lo carga en bufferedreader
		         archivo = new File (urlS(numeroFichero));
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);
		 
		         // Lectura del fichero
		         String linea;
		         while((linea=br.readLine())!=null){
		        	
		        //////////////////////////tree map//////////
		        	 System.out.println("linea del documento "+linea);
		        	 parametro = linea;//linea toma lo que lee y lo graba en parametro
		         String[] argtext = parametro.split("/");
		         cadenaLlave = argtext[0];
		         String[] tiempo = argtext[1].split(":");
		         llave = Integer.parseInt(tiempo[0]+tiempo[1]);
		         System.out.println(llave);
		         treeMap.put(llave,cadenaLlave);
			            
					//System.out.println(linea);
			        //System.out.println("Nombre de fichero  data"+ numeroFichero+"txt");
			        }
		}
		catch(Exception e){
			e.printStackTrace();
			}
		finally{
		         // Se cierra el fichero, para asegurar que se cierra todo.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         	}
		}
		//Los datos almacenados en tree Map los guardo en fichero th
		Iterator<Integer> it;
		it = treeMap.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.println(treeMap.get(key) + "||" + key );
			System.out.println("Grabando fichero de texto a disco...");	
		try{
			BufferedWriter ficheroSalida = new BufferedWriter(
            new FileWriter(new File(urlS(numeroFichero)),true));
			ficheroSalida.write(treeMap.get(key) + "/" + key);
            ficheroSalida.newLine();
            ficheroSalida.close();
        }
        catch (IOException errorDeFichero){
            System.out.println(
            		"No se guardaron los datos: " +
            errorDeFichero.getMessage() );
        }
		}	
	}
	public static void main(String[] args){
		LeerFichero leefic = new LeerFichero();
	}
	
}
