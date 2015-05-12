package torreHanoi;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class VentanaUsuario extends JFrame implements MouseListener {

	public javax.swing.JButton guardar,buscar,eliminar,records;
	public javax.swing.JComboBox selecDiscRecord;
	public JTextField cajanombre;
	public String nombre;
	public javax.swing.JTable tabla;
	public String[] lista0 = {"Nombre", "Disco", "Movimientos", "Tiempo"};
	public String[] lista1 = {"","","",""};
	public String[] lista2,lista3,lista4,lista5,lista6,lista7,lista8,lista9,lista10;
	public String[][] dato = {lista0,lista1,lista2,lista3,lista4,lista5,lista6,lista7,lista8,lista9,lista10};
	public int numeroFichero;
	public final String ruta = System.getProperties().getProperty("user.dir");
	public String nombreJugador,disc,tiempo;

 	public VentanaUsuario() {
 		configuracionVentana();
		iniciaComponente();
		generaRecord();
	}
	public void configuracionVentana(){
		setLayout(null);
		//setVisible(false); //comentar cuando la integre con la ventanaprincipal
		setSize(650, 400);
		setTitle("Jugador");
		setResizable(true);
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //activa cuando se integre con la ventana principal
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// desactiva cuando se integre con la ventana principal
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
	}
	public void iniciaComponente(){
		setLayout(null);
		Container container = getContentPane();
		///////////////////Boton Jugar////////////////////////
		guardar = new JButton("Guardar y Jugar");
		guardar.setBounds(100, 75, 150, 30);
		container.add(guardar);
		guardar.addMouseListener(this);
		/////////////////Boton ver Records/////////////////////
		records = new JButton("Ver Records");
		records.setBounds(430, 40, 120, 30);
		container.add(records);
		records.addMouseListener(this);
		////////////////Selector de disco//////////////////////
		selecDiscRecord = new JComboBox();
		selecDiscRecord.setEditable(true);
        selecDiscRecord.setBounds(380, 45, 35, 20);
        for(int f=3;f<=8;f++) {
        	selecDiscRecord.addItem(String.valueOf(f));
        }
        container.add(selecDiscRecord);
		////////////////Caja de texto Nombre////////////////////////////////
		cajanombre = new JTextField();
		cajanombre.setBounds(50,35,250,30);
		cajanombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		container.add(cajanombre);
		
		//////// Numero de Discos////////
			JLabel nombreEtiqueta = new JLabel();
			nombreEtiqueta.setBounds(70, 10, 230, 20);
			nombreEtiqueta.setFont(new java.awt.Font("Tr2n", 1,20));
			nombreEtiqueta.setForeground( Color.black );
			nombreEtiqueta.setText("Ingrese Nombre");
			add(nombreEtiqueta);
			setVisible(true);
		//////// Numero de Discos////////
		JLabel numDisco = new JLabel();
		numDisco.setBounds(350, 10, 230, 20);
		numDisco.setFont(new java.awt.Font("Tr2n", 1,20));
		numDisco.setForeground( Color.black );
		numDisco.setText("Seleccione Disco");
		add(numDisco);
		setVisible(true);
		
	}
	public void generaRecord(){
		tabla = new JTable();
		tabla.setBounds(90,150,450,180);
		add(tabla);	
	}			
	public String urlS(int numeroFichero){//Recibe numero de disco seleccionado por jugador y Devuelve la ruta del archivo
			this.numeroFichero = numeroFichero;
			if(numeroFichero==3)
				return ruta+"//data3.th";
			else if(numeroFichero==4)
				return ruta+"//data4.th";
			else if(numeroFichero==5)
				return ruta+"//data5.th";
			else if(numeroFichero==6)
				return ruta+"//data6.th";
			else if(numeroFichero==7)
				return ruta+"//data7.th";
			else if(numeroFichero==8)
				return ruta+"//data8.th";
			return null;		
		}
	public void cargarFichero(int numeroFichero){
			this.numeroFichero = numeroFichero ;
			
			//System.out.println("********* TreeMap *********");
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
			        	 System.out.println("linea del documento: "+linea);
			        	 parametro = linea;//linea toma lo que lee y lo graba en parametro
			         String[] argtext = parametro.split("/");
			         cadenaLlave = argtext[0];
			         String[] tiempo = argtext[1].split(":");
			         llave = Integer.parseInt(tiempo[0]+tiempo[1]);
			         //System.out.println(llave);
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
			///////////////////////inicia carga de TREE MAP A LA JTABLE
			//Los datos almacenados en tree Map los guardo en fichero th
			String lallave = null;
			String datoLeido = null;
			
			Iterator<Integer> it;
			it = treeMap.keySet().iterator();
	        DefaultListModel modeloLista = new DefaultListModel();
	        DefaultTableModel modeloTabla = new DefaultTableModel();
	        modeloTabla.addColumn("Nombre");
	        modeloTabla.addColumn("Numero de Discos");
	        modeloTabla.addColumn("Movimientos");
	        modeloTabla.addColumn("Tiempo");
	        modeloTabla.addRow(lista0);
			while(it.hasNext()){
				Integer key = it.next();
				lallave = Integer.toString(key);
				System.out.println(treeMap.get(key) + "||" + key );
				datoLeido = treeMap.get(key);
				lista1 = datoLeido.split(",");
				//lista1[3] = lallave;
				//modeloLista.addElement(treeMap.get(key));
	            modeloTabla.addRow(lista1);
	            //modeloTabla.addRow(new String[]{lallave});
				
				//System.out.println("Grabando fichero de texto a disco...");
	            //////////////////inicia escritura de treemap en archivo///////////
			/*try{
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
	        }*/
				//////////////finaliza escritura de treemap en archivo///////////
			tabla.setModel(modeloTabla);
			}	
		}		
	@Override
	public void mousePressed(MouseEvent even) {
		if (even.getSource()==guardar) {
			nombre = cajanombre.getText();
			setVisible(false);
		}
		if(even.getSource()==records){
			String selecItem=(String)selecDiscRecord.getSelectedItem();
	        this.numeroFichero=Integer.parseInt(selecItem);
			//LeerFichero();
			cargarFichero(numeroFichero);
		}
	}
	@Override
	public void mouseClicked(MouseEvent even) {
		if (even.getSource()==guardar) {
			System.out.println("Nombre jugador guardado "+nombre);
		}
	}
	@Override
	public void mouseEntered(MouseEvent even) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent even) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent even) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args){
		VentanaUsuario ventanausuario = new VentanaUsuario();
		//ventanausuario.pack();
		ventanausuario.setVisible(true);
	
	}	
}
