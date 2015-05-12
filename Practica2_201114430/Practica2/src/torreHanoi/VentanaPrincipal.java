package torreHanoi;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

public class VentanaPrincipal extends JFrame implements MouseListener{
	VentanaUsuario ventanausuario = new VentanaUsuario();
	public javax.swing.JComboBox dificultad;
	public javax.swing.JButton disco1,disco2,disco3,disco4,disco5,disco6,disco7,disco8,disco9,disco10,disco11,disco12,disco13,disco14,disco15,disco16,disco17,disco18,disco19,disco20,disco21,disco22,disco23,disco24,botonJugar,botonDemo,pausa,continuar;
	public javax.swing.JLabel barraEstado,barraMovimiento,pasosResolucion,nombreJugador,cronometro,infcronometro,numeroTorre;
	public final String ruta = System.getProperties().getProperty("user.dir");
	public int[] torre1 = {-1,1,2,3,4,5,6,7,8,0,0};
	public int[] torre2 = {-1,0,0,0,0,0,0,0,0,0,0};
	public int[] torre3 = {-1,0,0,0,0,0,0,0,0,0,0};
	public int DEM;//numero de "Disco En Movimiento"
	public int copyDEM;
	public int UET1;//ultimo disco en entrar en torre 1
	public int UET2;//ultimo disco en entrar en torre 2
	public int UET3;//ultimo disco en entrar en torre 3
	public int NRAVD;//Numero de Retorno Al Validar Disco
	public int CONTADOR;
	public int NIVEL = 8;
	boolean cronoActivo;
	boolean juegopausado;
	public String tiempo;
	public String nomJuga;
	public Clip sondisc;
 	public VentanaPrincipal(){//constructor de la clase JFrame 		
 		configuracionVentana();
		barraMenu();
		iniciaBoton();
		dificultad();
		iniciaEtiqueta();
		initDiscBoton(this.torre1,this.torre2,this.torre3);
		iniTorre();
		initfondo();//fondo de la Ventana Principal si funciona
		repaint();
		JOptionPane.showMessageDialog(VentanaPrincipal.this, "Bienvenido a la red \n"+"La frontera Digital.","Torre Hanoi", JOptionPane.INFORMATION_MESSAGE);
		ventanausuario.setVisible(true);
 	}
 	public void guardarDatos(String nombreJugador,int NIVEL,int CONTADOR,String tiempo){
 		EscribirFichero escribirfichero = new EscribirFichero();
 		escribirfichero.escribeDato(nomJuga,NIVEL,CONTADOR,tiempo);
 	}
 	public void configuracionVentana(){
		setSize(1030, 680);
		setTitle("Torres de Hanoi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		
	}
	private void iniciaEtiqueta() {
		setLayout(null);
		////////Etiqueta Muestra numero de torre////////
		numeroTorre = new JLabel();
		numeroTorre.setBounds(150, 500, 650, 30);
		numeroTorre.setFont(new java.awt.Font("Tr2n", 0, 18));
		numeroTorre.setForeground( Color.cyan);
		numeroTorre.setText("TORRE 1                     TORRE 2                     TORRE 3");
		add(numeroTorre);
		////////Etiqueta Muestra el Estado de los Disco////////
		barraEstado = new JLabel();
		barraEstado.setBounds(20, 560, 400, 25);
		barraEstado.setFont(new java.awt.Font("Tr2n", 0, 20));
		barraEstado.setForeground( Color.green);
		add(barraEstado);
		///////////////////Pasos para Resolucion/////////
		pasosResolucion = new JLabel();
		pasosResolucion.setBounds(240, 100, 580, 35);
		pasosResolucion.setFont(new java.awt.Font("Vineta BT", 0, 20));
		pasosResolucion.setForeground(Color.white);
		add(pasosResolucion);
		 
		////////Etiqueta Muestra los movimientos Realizador////////
		barraMovimiento  = new JLabel();
		barraMovimiento.setBounds(20, 590, 300, 20);
		barraMovimiento.setFont(new java.awt.Font("Tr2n", 0, 18));
		barraMovimiento.setForeground( Color.cyan );
		add(barraMovimiento);
		////////Dificultad Numero de Discos////////
		JLabel etiquetaDificultad = new JLabel();
		etiquetaDificultad.setBounds(600, 585, 210, 20);
		etiquetaDificultad.setFont(new java.awt.Font("Tr2n", 0, 17));
		etiquetaDificultad.setForeground( Color.yellow );
		etiquetaDificultad.setText("Numero de discos");
		add(etiquetaDificultad);
		//////////////////Muestra Nombre del JugadoR/////////////////////////////
		nombreJugador = new JLabel();
		nombreJugador.setBounds(5, 5, 330, 50);
		nombreJugador.setFont(new java.awt.Font("Tr2n",1,25));
		nombreJugador.setForeground( Color.cyan );
		//nombreJugador.setText("nomJuga dentro la clase"+nomJuga);
		System.out.println(nomJuga);
		add(nombreJugador);
		////////////////////Cronometro/////////////////////////////
		cronometro = new JLabel();
		cronometro.setBounds(830, 570, 200, 35);
		cronometro.setFont(new java.awt.Font("Tr2n", 1, 35));
		cronometro.setForeground( Color.white );
		cronometro.setText("00:00");
		add(cronometro);
		////////////////////informacion Cronometro/////////////////////////////
		infcronometro = new JLabel();
		infcronometro.setBounds(835, 545, 200, 25);
		infcronometro.setFont(new java.awt.Font("Tr2n", 1, 20));
		infcronometro.setForeground( Color.orange );
		infcronometro.setText("min : seg");
		add(infcronometro);	
	}
	public void barraMenu(){
		JMenuBar barraMenu = new javax.swing.JMenuBar();
		setJMenuBar(barraMenu);
		//////////////////////////MENU ARCHIVO////////////////////
		JMenu archivo = new JMenu( "Archivo" );
		archivo.setMnemonic( 'A' );
		barraMenu.add(archivo);
		// Establecer elemento Cambiar Jugador del Menu Archivo
		JMenuItem cambiaJugador = new JMenuItem( "Cambiar de Jugador." );
		cambiaJugador.setMnemonic( 'c' );
		archivo.add( cambiaJugador );
		cambiaJugador.addActionListener(
		      new ActionListener() {  // clase interna an�nima
		    	  public void actionPerformed( ActionEvent evento ){
		    		  /*VentanaUsuario ventanausuario = new VentanaUsuario();
		    		  nombreJugador.setText(ventanausuario.nombre);
		    		  nomJuga = ventanausuario.caja;
		    		  //ventanausuario.setDefaultCloseOperation(HIDE_ON_CLOSE);*/
		    		  ventanausuario.setVisible(true);
		         }
		      }
		);
		// Establecer elemento Cambiar Salir del Menu Archivo
		JMenuItem salir = new JMenuItem( "Salir" );
		salir.setMnemonic( 'S' );
		archivo.add( salir );
		salir.addActionListener(
		      new ActionListener() {  // clase interna anonima
		    	  public void actionPerformed( ActionEvent evento ){
		    		  System.exit( 0 );
		    	  }
		      }
		);
		//////////////////////MENU AYUDA///////////////////////////
		JMenu ayuda = new JMenu("Ayuda");
		ayuda.setMnemonic('y');
		barraMenu.add(ayuda);
		// Establecer elemento Instrucciones del Menu Ayuda
		JMenuItem instruccion = new JMenuItem("Instrucciones");
		instruccion.setMnemonic('I');
		ayuda.add(instruccion);
		instruccion.addActionListener(
				new ActionListener() {  // clase interna anonima
			    	  public void actionPerformed( ActionEvent evento ){
			    		  VentanaInstruccion ventanainstruccion = new VentanaInstruccion();
			    		  //ventanainstruccion.setVisible(true);
			    	  }
			      }				
		);
		// Establecer elemento Sitio web del Menu Ayuda
		JMenuItem sitioWeb = new JMenuItem("Sitio web");
		sitioWeb.setMnemonic('S');
		ayuda.add(sitioWeb);
		sitioWeb.addActionListener(
				new ActionListener() {  // clase interna anonima
			    	  public void actionPerformed( ActionEvent evento ){
			    		  try {
			    			  if (Desktop.isDesktopSupported()) {
			    			  Desktop desktop = Desktop.getDesktop();
			    			  if (desktop.isSupported(Desktop.Action.BROWSE)) {
			    			  desktop.browse(new URI("http://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i"));
			    			  }
			    			  }
			    			  } catch (Exception e) {
			    			  e.printStackTrace();
			    			  }
			    	  }
			      }
		);
		// Establecer elemento Acerca de del Menu Ayuda
		JMenuItem acercaDe = new JMenuItem("Acerca de...");
		acercaDe.setMnemonic('A');
		ayuda.add(acercaDe);
		acercaDe.addActionListener(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog( VentanaPrincipal.this,
					               "Torre de Hanoi version Beta \n"+ "Practica 2 Introduccion a la programacion y computacion.\n"+"01/05/2015",
					               "Acerca de", JOptionPane.PLAIN_MESSAGE );
						
					}
				}
		);
		//////////////////////MENU ?///////////////////////////
		JMenu developer = new JMenu("?");
		developer.setMnemonic('D');
		barraMenu.add(developer);
		// Establecer elemento Autor
		JMenuItem autor = new JMenuItem("Autor");
		autor.setMnemonic('A');
		developer.add(autor);
		autor.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent evento) {
						JOptionPane.showMessageDialog(VentanaPrincipal.this, "Bienvenido a la red \n"+"La frontera Digital.","Torre Hanoi", JOptionPane.INFORMATION_MESSAGE);
						try {
			    			  if (Desktop.isDesktopSupported()) {
			    			  Desktop desktop = Desktop.getDesktop();
			    			  if (desktop.isSupported(Desktop.Action.BROWSE)) {
			    			  desktop.browse(new URI("https://www.youtube.com/user/JUANJESUSPEREZDELCID/videos"));
			    			  }
			    			  }
			    			  } catch (Exception e) {
			    			  e.printStackTrace();
			    			  }
						
					}
				}
		);
		
	}
	public void iniciaBoton(){
		///////////////////Boton Jugar////////////////////////
		botonJugar = new JButton("Jugar");
		botonJugar.setBounds(690, 605, 80, 20);
		add(botonJugar);
		botonJugar.addMouseListener(this);
		///////////////////Boton Demo/////////////////////////
		botonDemo = new JButton("Demo");
		botonDemo.setBounds(900,5,80,20);
		add(botonDemo);
		botonDemo.addMouseListener(this);
		///////////////////Boton pausa/////////////////////////
		pausa = new JButton("Pausar");
		pausa.setBounds(800,605,90,20);
		add(pausa);
		pausa.setEnabled(false);
		pausa.addMouseListener(this);
		/////////////////Boton Continuar/////////////////////////
		continuar = new JButton("Continuar");
		continuar.setBounds(900, 605, 120, 20);
		add(continuar);
		continuar.setEnabled(false);
		continuar.addMouseListener(this);       
	}
	public void dificultad(){//Selector de numero de Discos/////////////////////
		dificultad = new JComboBox();
        dificultad.setEditable(true);
        dificultad.setBounds(620, 605, 35, 20);
        for(int f=3;f<=8;f++) {
            dificultad.addItem(String.valueOf(f));
        }
        add(dificultad);
	}

	public void initDiscBoton(int[] torreA,int[] torreB,int[] torreC){//Construye los botones para los Discos
		setLayout(null);
		Container container = getContentPane();
		this.torre1 = torreA;
		this.torre2 = torreB;
		this.torre3 = torreC;

		//Disco 1
        disco1=new JButton();
        disco1.setBounds(87, 430, 206, 35);	
        container.add(disco1);
        disco1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[1]))));
        disco1.setBorderPainted(false);
        disco1.setContentAreaFilled(false);
        disco1.addMouseListener(this);

		//Disco 2
        disco2=new JButton();
		disco2.setBounds(90, 395, 200, 35);
		container.add(disco2);
        disco2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[2]))));
        disco2.setBorderPainted(false);
        disco2.setContentAreaFilled(false);
        disco2.addMouseListener(this);
		
		//Disco 3
        disco3=new JButton();
		disco3.setBounds(90, 360, 200, 35);
		container.add(disco3);
        disco3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[3]))));
        disco3.setBorderPainted(false);
        disco3.setContentAreaFilled(false);
        disco3.addMouseListener(this);
		
		//Disco 4
        disco4=new JButton();
		disco4.setBounds(90, 325, 200, 35);
		container.add(disco4);
        disco4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[4]))));
        disco4.setBorderPainted(false);
        disco4.setContentAreaFilled(false);
        disco4.addMouseListener(this);
		
		//Disco 5
        disco5=new JButton();
		container.add(disco5);
		disco5.setBounds(90, 290, 200, 35);
        disco5.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[5]))));
        disco5.setBorderPainted(false);
        disco5.setContentAreaFilled(false);
        disco5.addMouseListener(this);
		
		//Disco 6
        disco6=new JButton();
		container.add(disco6);
		disco6.setBounds(90, 255, 200, 35);
        add(disco6);
        disco6.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[6]))));
        disco6.setBorderPainted(false);
        disco6.setContentAreaFilled(false);
        disco6.addMouseListener(this);
		
		//Disco 7
        disco7=new JButton();
		container.add(disco7);
		disco7.setBounds(90, 220, 200, 35);
        add(disco7);
        disco7.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[7]))));
        disco7.setBorderPainted(false);
        disco7.setContentAreaFilled(false);
        disco7.addMouseListener(this);
		
		//Disco 8
        disco8=new JButton();
		container.add(disco8);
		disco8.setBounds(90, 185, 200, 35);
        add(disco8);
        disco8.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[8]))));
        disco8.setBorderPainted(false);
        disco8.setContentAreaFilled(false);
        disco8.addMouseListener(this);
		
		//////Inicia Torre 2//////
		//Disco 9
        disco9=new JButton();
		container.add(disco9);
		disco9.setBounds(357, 430, 206, 35);
        add(disco9);
        disco9.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[1]))));
        disco9.setBorderPainted(false);
        disco9.setContentAreaFilled(false);
        disco9.addMouseListener(this);
		
		//Disco 10
        disco10=new JButton();
		container.add(disco10);
		disco10.setBounds(360, 395, 200, 35);
        add(disco10);
        disco10.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[2]))));
        disco10.setBorderPainted(false);
        disco10.setContentAreaFilled(false);
        disco10.addMouseListener(this);
		
		//Disco 11
        disco11=new JButton();
		container.add(disco11);
		disco11.setBounds(360, 360, 200, 35);
        add(disco11);
        disco11.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[3]))));
        disco11.setBorderPainted(false);
        disco11.setContentAreaFilled(false);
        disco11.addMouseListener(this);
		
		//Disco 12
        disco12=new JButton();
		container.add(disco12);
		disco12.setBounds(360, 325, 200, 35);
        add(disco12);
        disco12.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[4]))));
        disco12.setBorderPainted(false);
        disco12.setContentAreaFilled(false);
        disco12.addMouseListener(this);
		
		//Disco 13
        disco13=new JButton();
		container.add(disco13);
		disco13.setBounds(360, 290, 200, 35);
        add(disco13);
        disco13.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[5]))));
        disco13.setBorderPainted(false);
        disco13.setContentAreaFilled(false);
        disco13.addMouseListener(this);
		
		//Disco 14
        disco14=new JButton();
		container.add(disco14);
		disco14.setBounds(360, 255, 200, 35);
        add(disco14);
        disco14.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[6]))));
        disco14.setBorderPainted(false);
        disco14.setContentAreaFilled(false);
        disco14.addMouseListener(this);
		
		//Disco 15
        disco15=new JButton();
		container.add(disco15);
		disco15.setBounds(360, 220, 200, 35);
        add(disco15);
        disco15.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[7]))));
        disco15.setBorderPainted(false);
        disco15.setContentAreaFilled(false);
        disco15.addMouseListener(this);
		
		//Disco 16
        disco16=new JButton();
		container.add(disco16);
		disco16.setBounds(360, 185, 200, 35);
        add(disco16);
        disco16.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[8]))));
        disco16.setBorderPainted(false);
        disco16.setContentAreaFilled(false);
        disco16.addMouseListener(this);
		
		///Inicia Torre 3 ////
		//Disco 17
        disco17=new JButton();
		container.add(disco17);
		disco17.setBounds(637, 430, 206, 35);
        add(disco17);
        disco17.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[1]))));
        disco17.setBorderPainted(false);
        disco17.setContentAreaFilled(false);
        disco17.addMouseListener(this);
		
		//Disco 18
        disco18=new JButton();
		container.add(disco18);
		disco18.setBounds(640, 395, 200, 35);
        add(disco18);
        disco18.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[2]))));
        disco18.setBorderPainted(false);
        disco18.setContentAreaFilled(false);
        disco18.addMouseListener(this);
		
		//Disco 19
        disco19=new JButton();
		container.add(disco19);
		disco19.setBounds(640, 360, 200, 35);
        add(disco19);
        disco19.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[3]))));
        disco19.setBorderPainted(false);
        disco19.setContentAreaFilled(false);
        disco19.addMouseListener(this);

		//Disco 20
        disco20=new JButton();
		container.add(disco20);
		disco20.setBounds(640, 325, 200, 35);
        add(disco20);
        disco20.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[4]))));
        disco20.setBorderPainted(false);
        disco20.setContentAreaFilled(false);
        disco20.addMouseListener(this);
		
		//Disco 21
        disco21=new JButton();
		container.add(disco21);
		disco21.setBounds(640, 290, 200, 35);
        add(disco21);
        disco21.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[5]))));
        disco21.setBorderPainted(false);
        disco21.setContentAreaFilled(false);
        disco21.addMouseListener(this);
		
		//Disco 22
		disco22=new JButton();
		container.add(disco22);
		disco22.setBounds(640, 255, 200, 35);
        add(disco22);
        disco22.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[6]))));
        disco22.setBorderPainted(false);
        disco22.setContentAreaFilled(false);
        disco22.addMouseListener(this);
		
		//Disco 23
        disco23=new JButton();
		container.add(disco23);
		disco23.setBounds(640, 220, 200, 35);
        add(disco23);
        disco23.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[7]))));
        disco23.setBorderPainted(false);
        disco23.setContentAreaFilled(false);
        disco23.addMouseListener(this);
		
		//Disco 24
        disco24=new JButton();
		container.add(disco24);
		disco24.setBounds(640, 185, 200, 35);
        add(disco24);
        disco24.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[8]))));
        disco24.setBorderPainted(false);
        disco24.setContentAreaFilled(false);
        disco24.addMouseListener(this);
}
	private void iniTorre(){//Construye las tres torres de la clase torres
		setLayout(null);
		Container container = getContentPane();
		container.setLayout(null);
		//torre Izquierda
		Torre torre1 = new Torre(70, 130, 240, 370);
		container.add(torre1);
		torre1.addMouseListener(this);
		//torre Media
		Torre torre2 = new Torre(340, 130, 240, 370);
		container.add(torre2);
		//torre Derecha
		Torre torre3 = new Torre(620, 130, 240, 370);
		container.add(torre3);
		torre3.addMouseListener(this);
	}
 	private void initfondo(){//fondo de la Ventana Principal si funciona
		setLayout(null);
		Container container = getContentPane();
		Fondo fondo = new Fondo(0,0,1024,630);
		container.add(fondo);		
	}
	public void listaPeek(){//Actualiza el ultimo elemento en las torres
		//////////////////////CIMA///////////////
		UET1 = 0;
		UET2 = 0;
		UET3 = 0;
		int a = 1,b = 1,c = 1;
		// Torre 1
		do{
			if (torre1[a]!=0){
			UET1=torre1[a];
			}
			a=a+1;
		}while(torre1[a]!=0);
		// Torre 2
		do{
			if (torre2[b]!=0){
				UET2=torre2[b];
			}
			b=b+1;
		}while(torre2[b]!=0);
		// Torre 3
		do{
			if (torre3[c]!=0){
				UET3=torre3[c];
			}
			c=c+1;
		}while(torre3[c]!=0);
		//copyDEM = a;
		/*System.out.println("a "+a);
		System.out.println("b "+b);
		System.out.println("c "+c);
		System.out.println("copyDEM "+copyDEM);
		System.out.println("DEM "+DEM);*/
		//System.out.println(UET1+","+UET2+","+UET3);
	
		////////////////FINAL CODIGO CIMA////////
	}
	public void verificaGana(int NIVEL){
		this.NIVEL = NIVEL;
		switch(NIVEL){
		case 3:
			if(torre2[3] == 8 || torre3[3] == 8){
				modificaEtiqueta(9);
				guardarDatos(nomJuga,NIVEL,CONTADOR,tiempo);
				this.juegopausado = false;///estetica
				pausa.setEnabled(false);///estetica
			}
			break;
		case 4:
			if(torre2[4] == 8 || torre3[4] == 8){
				modificaEtiqueta(9);
				guardarDatos(nomJuga,NIVEL,CONTADOR,tiempo);
				this.juegopausado = false;
				pausa.setEnabled(false);
			}
			break;
		case 5:
			if(torre2[5] == 8 || torre3[5] == 8){
				System.out.println("contenido "+tiempo);
				if(tiempo=="Demo"){
					modificaEtiqueta(11);
					this.juegopausado = false;
					pausa.setEnabled(false);
					}
				else{
					modificaEtiqueta(9);
					guardarDatos(nomJuga,NIVEL,CONTADOR,tiempo);
					this.juegopausado = false;
					pausa.setEnabled(false);
				}
			}
			break;
		case 6:
			if(torre2[6] == 8 || torre3[6] == 8){
				modificaEtiqueta(9);
				guardarDatos(nomJuga,NIVEL,CONTADOR,tiempo);
				this.juegopausado = false;
				pausa.setEnabled(false);
			}
			break;
		case 7:
			if(torre2[7] == 8 || torre3[7] == 8){
				modificaEtiqueta(9);
				guardarDatos(nomJuga,NIVEL,CONTADOR,tiempo);
				this.juegopausado = false;
				pausa.setEnabled(false);
			}
			break;
		case 8:
			if(torre2[8] == 8 || torre3[8] == 8){
				modificaEtiqueta(9);
				guardarDatos(nomJuga,NIVEL,CONTADOR,tiempo);
				this.juegopausado = false;
				pausa.setEnabled(false);
			}
			break;
		}
	}
	///////////////Acciones del MOUSELISTENER////////////////
	@SuppressWarnings("deprecation")
	@Override
 	public void mousePressed(MouseEvent e) {
		if (e.getSource()==botonJugar) {
	        String selecItem=(String)dificultad.getSelectedItem();
	        this.NIVEL=Integer.parseInt(selecItem);
	        for(int i=1;i<=10;i++){
	        	torre1[i] = 0;
				torre2[i] = 0;
				torre3[i] = 0;		
			}
	        for(int i=1;i<=NIVEL;i++){
	        	torre1[i] = 8-(NIVEL-i);				
			}
        	discoescogido(torre1,torre2,torre3);
        	DEM = 0;
        	UET1 = 0;
        	UET2 = 0;
        	UET3 = 0;
        	NRAVD = 0;
        	//copyDEM = DEM;
        	CONTADOR = 0;
        	barraMovimiento.setText(CONTADOR + " Movimientos");
        	pasosResolucion.setText("");
        	////////Habilita Boton Pausa
        	pausa.setEnabled(true);
        	////////llama al metodo cronometro e inicia el cronometro
        	pararCronos();
        	iniciarCronos();
        	this.nomJuga = ventanausuario.nombre;
    		nombreJugador.setText(nomJuga);
        	//System.out.println("nombre del jugador "+nomJuga);
        	nombreJugador.setText(nomJuga);
        	ventanausuario.setVisible(false);
        	this.juegopausado = true;
		}
		/////// Boton Demo
		if(e.getSource()==botonDemo){
			resolver();
			hilo1.suspend();
		}
		if(e.getSource()==continuar){
			hilo1.resume();
			continuar.setEnabled(false);
			pausa.setEnabled(true);
			this.juegopausado = true;
			System.out.println(juegopausado);
		}
		///////Boton Pausa
		if(e.getSource()==pausa){
			hilo1.suspend();
			//pausa.setEnabled(true);
			pausa.setEnabled(false);
			continuar.setEnabled(true);
			this.juegopausado = false;
			System.out.println(juegopausado);
		}
		/////DISCO 1
		if (e.getSource()==disco1 && juegopausado) {
			modificaDisco(1);
			}
		/////DISCO 2
		if (e.getSource()==disco2 && juegopausado) {
			modificaDisco(2);
		}
		/////DISCO 3
		if (e.getSource()==disco3 && juegopausado) {
			modificaDisco(3);
		}
		/////DISCO 4
		if (e.getSource()==disco4 && juegopausado) {
			modificaDisco(4);
		}
		/////DISCO 5
		if (e.getSource()==disco5 && juegopausado) {
			modificaDisco(5);
		}
		/////DISCO 6
		if (e.getSource()==disco6 && juegopausado) {
			modificaDisco(6);
		}
		/////DISCO 7
		if (e.getSource()==disco7 && juegopausado) {
			modificaDisco(7);
		}
		/////DISCO 8
		if (e.getSource()==disco8 && juegopausado) {
			modificaDisco(8);
		}
		/////DISCO 9
		if (e.getSource()==disco9 && juegopausado) {
			modificaDisco(9);
		}
		/////DISCO 10
		if (e.getSource()==disco10 && juegopausado) {
			modificaDisco(10);
		}
		/////DISCO 11
		if (e.getSource()==disco11 && juegopausado) {
			modificaDisco(11);
		}
		/////DISCO 12
		if (e.getSource()==disco12 && juegopausado) {
			modificaDisco(12);
		}
		/////DISCO 13
		if (e.getSource()==disco13 && juegopausado) {
			modificaDisco(13);
		}
		/////DISCO 14
		if (e.getSource()==disco14 && juegopausado) {
			modificaDisco(14);
		}
		/////DISCO 15
		if (e.getSource()==disco15 && juegopausado) {
			modificaDisco(15);
		}
		/////DISCO 16
		if (e.getSource()==disco16 && juegopausado) {
			modificaDisco(16);
		}
		/////DISCO 17
		if (e.getSource()==disco17 && juegopausado) {
			modificaDisco(17);
		}
		/////DISCO 18
		if (e.getSource()==disco18 && juegopausado) {
			modificaDisco(18);
		}
		/////DISCO 19
		if (e.getSource()==disco19 && juegopausado) {
			modificaDisco(19);
		}
		/////DISCO 20
		if (e.getSource()==disco20 && juegopausado) {
			modificaDisco(20);
		}		
		/////DISCO 21
		if (e.getSource()==disco21 && juegopausado) {
			modificaDisco(21);
		}
		/////DISCO 22
		if (e.getSource()==disco22 && juegopausado) {
			modificaDisco(22);
		}
		/////DISCO 23
		if (e.getSource()==disco23 && juegopausado) {
			modificaDisco(23);
		}
		/////DISCO 24
		if (e.getSource()==disco24 && juegopausado) {
			modificaDisco(24);
		}
	}
	public int numeroDeMovimiento(int a){//contador de movimientos
			if(copyDEM != a){
				CONTADOR += 1;//CONTADOR + 1;
				modificaEtiqueta(4);
			}
				
		return 0;
	}
	public void modificaDisco(int a){
		switch(a){
		case 1:
			NRAVD = validaMovimiento(DEM,torre1[0],torre1[1],torre1[2],torre1[3]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 1;
				DEM = torre1[1];
				disco1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre1[1]=0;
				break;
			case 2:
				disco1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre1[1]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(1);
				break;
			}
			break;
		case 2:
			NRAVD = validaMovimiento(DEM,torre1[1],torre1[2],torre1[3],torre1[4]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 2;
				DEM = torre1[2];
				disco2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre1[2]=0;
				break;
			case 2:
				disco2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre1[2]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(2);
				break;
			}
			break;
		case 3:
			NRAVD = validaMovimiento(DEM,torre1[2],torre1[3],torre1[4],torre1[5]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 3;
				DEM = torre1[3];
				disco3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre1[3]=0;
				break;
			case 2:
				disco3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre1[3]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(3);
				break;
			}
			break;
		case 4:
			NRAVD = validaMovimiento(DEM,torre1[3],torre1[4],torre1[5],torre1[6]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 4;
				DEM = torre1[4];
				disco4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre1[4]=0;
				break;
			case 2:
				disco4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre1[4]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(4);
				break;
			}
			break;
		case 5:
			NRAVD = validaMovimiento(DEM,torre1[4],torre1[5],torre1[6],torre1[7]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 5;
				DEM = torre1[5];
				disco5.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre1[5]=0;
				break;
			case 2:
				disco5.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre1[5]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(5);
				break;
			}
			break;
		case 6:
			NRAVD = validaMovimiento(DEM,torre1[5],torre1[6],torre1[7],torre1[8]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 6;
				DEM = torre1[6];
				disco6.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre1[6]=0;
				break;
			case 2:
				disco6.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre1[6]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(6);
				break;
			}
			break;
		case 7:
			NRAVD = validaMovimiento(DEM,torre1[6],torre1[7],torre1[8],torre1[9]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 7;
				DEM = torre1[7];
				disco7.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre1[7]=0;
				break;
			case 2:
				disco7.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre1[7]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(7);
				break;
			}
			break;
		case 8:
			NRAVD = validaMovimiento(DEM,torre1[7],torre1[8],torre1[9],torre1[10]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 8;
				DEM = torre1[8];
				disco8.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre1[8]=0;
				break;
			case 2:
				disco8.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre1[8]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(8);
				break;
			}
			break;
		case 9:
			NRAVD = validaMovimiento(DEM,torre2[0],torre2[1],torre2[2],torre2[3]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 9;
				DEM = torre2[1];
				disco9.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre2[1]=0;
				break;
			case 2:
				disco9.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre2[1]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(9);
				break;
			}
			break;
		case 10:
			NRAVD = validaMovimiento(DEM,torre2[1],torre2[2],torre2[3],torre2[4]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 10;
				DEM = torre2[2];
				disco10.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre2[2]=0;
				break;
			case 2:
				disco10.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre2[2]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(10);
				break;
			}
			break;
		case 11:
			NRAVD = validaMovimiento(DEM,torre2[2],torre2[3],torre2[4],torre2[5]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 11;
				DEM = torre2[3];
				disco11.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre2[3]=0;
				break;
			case 2:
				disco11.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre2[3]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(11);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 12:
			NRAVD = validaMovimiento(DEM,torre2[3],torre2[4],torre2[5],torre2[6]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 12;
				DEM = torre2[4];
				disco12.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre2[4]=0;
				break;
			case 2:
				disco12.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre2[4]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(12);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 13:
			NRAVD = validaMovimiento(DEM,torre2[4],torre2[5],torre2[6],torre2[7]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 13;
				DEM = torre2[5];
				disco13.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre2[5]=0;
				break;
			case 2:
				disco13.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre2[5]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(13);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 14:
			NRAVD = validaMovimiento(DEM,torre2[5],torre2[6],torre2[7],torre2[8]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 14;
				DEM = torre2[6];
				disco14.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre2[6]=0;
				break;
			case 2:
				disco14.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre2[6]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(14);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 15:
			NRAVD = validaMovimiento(DEM,torre2[6],torre2[7],torre2[8],torre2[9]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 15;
				DEM = torre2[7];
				disco15.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre2[7]=0;
				break;
			case 2:
				disco15.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre2[7]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(15);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 16:
			NRAVD = validaMovimiento(DEM,torre2[7],torre2[8],torre2[9],torre2[10]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 16;
				DEM = torre2[8];
				disco16.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre2[8]=0;
				break;
			case 2:
				disco16.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre2[8]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(16);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 17:
			NRAVD = validaMovimiento(DEM,torre3[0],torre3[1],torre3[2],torre3[3]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 17;
				DEM = torre3[1];
				disco17.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre3[1]=0;
				break;
			case 2:
				disco17.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre3[1]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(17);
				break;
			}
			break;
		case 18:
			NRAVD = validaMovimiento(DEM,torre3[1],torre3[2],torre3[3],torre3[4]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 18;
				DEM = torre3[2];
				disco18.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre3[2]=0;
				break;
			case 2:
				disco18.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre3[2]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(18);
				break;
			}
			break;
		case 19:
			NRAVD = validaMovimiento(DEM,torre3[2],torre3[3],torre3[4],torre3[5]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 19;
				DEM = torre3[3];
				disco19.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre3[3]=0;
				break;
			case 2:
				disco19.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre3[3]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(19);
				verificaGana(NIVEL);
				this.copyDEM = 0;
				break;
			}
			break;
		case 20:
			NRAVD = validaMovimiento(DEM,torre3[3],torre3[4],torre3[5],torre3[6]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 20;
				DEM = torre3[4];
				disco20.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre3[4]=0;
				break;
			case 2:
				disco20.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre3[4]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(20);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 21:
			NRAVD = validaMovimiento(DEM,torre3[4],torre3[5],torre3[6],torre3[7]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 21;
				DEM = torre3[5];
				disco21.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre3[5]=0;
				break;
			case 2:
				disco21.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre3[5]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(21);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 22:
			NRAVD = validaMovimiento(DEM,torre3[5],torre3[6],torre3[7],torre3[8]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 22;
				DEM = torre3[6];
				disco22.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre3[6]=0;
				break;
			case 2:
				disco22.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre3[6]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(22);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 23:
			NRAVD = validaMovimiento(DEM,torre3[6],torre3[7],torre3[8],torre3[9]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 23;
				DEM = torre3[7];
				disco23.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre3[7]=0;
				break;
			case 2:
				disco23.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre3[7]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(23);
				verificaGana(NIVEL);
				break;
			}
			break;
		case 24:
			NRAVD = validaMovimiento(DEM,torre3[7],torre3[8],torre3[9],torre3[10]);
			modificaEtiqueta(NRAVD);
			listaPeek();
			switch(NRAVD){
			case 1:
				this.copyDEM = 24;
				DEM = torre3[8];
				disco24.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(0))));
				torre3[8]=0;
				break;
			case 2:
				disco24.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(DEM))));
				torre3[8]= DEM;
				DEM = 0;
				listaPeek();
				numeroDeMovimiento(24);
				verificaGana(NIVEL);
				break;
			}
			break;
		}
	}
 	public int validaMovimiento(int DEM,int dAA,int dA, int dS,int dSS){
 		listaPeek();		
 		this.DEM = DEM;
 		//////////////Portapapeles Vacio/////////////////
		if(DEM==0){
		//Si copiar
			if(dA==UET1 || dA==UET2 || dA==UET3 )
				return 1;
		//No Copiar
			else
				return 0;
		}
		//////////////////Portapapeles Lleno///////////
		//Pegar
		else if(DEM!=0 && !tieneDisco(dA) && DEM>dAA){
			//Pegar
			if(dAA!=0){
				return 2;
			}	
		}
		else if(DEM!=0 && tieneDisco(dA))
			return 3;
		return 10;
	}
 	public boolean tieneDisco(int a){
		int a1 = a;
		if(a1!=0)
			return true;
	return false;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//Recibe un numero y muestra un mensaje segun numero 
	public void modificaEtiqueta(int a){
		switch(a){
		case 0:
			barraEstado.setText("MOVIMIENTO NO VALIDO.");
			break;
		case 1:
			barraEstado.setText("DISCO SELECCIONADO.");
			barraMovimiento.setText(CONTADOR + " MOVIMIENTOS");
			break;
		case 2:
			barraEstado.setText("DISCO MOVIDO.");
			break;
		case 3:
			barraEstado.setText("YA HAY UN DISCO EN ESTA POSICION.");
			break;
		case 4:
			barraMovimiento.setText(CONTADOR + " MOVIMIENTOS");
			break;
		case 9:
			pararCronos();
			JOptionPane.showMessageDialog(this, "Usted Gano. \n"+CONTADOR+" Movimientos realizados. \n"+"Tiempo trancurrido. "+tiempo,"Torre Hanoi", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 10:
			barraEstado.setText("");
			break;
		case 11:
			JOptionPane.showMessageDialog(this, "Demostracion Finalizada \n"+CONTADOR+" Movimientos realizados.","Torre Hanoi", JOptionPane.INFORMATION_MESSAGE);
			barraEstado.setText("");
			break;
		}
	}
	public void discoescogido(int[] torre1,int[] torre2,int[] torre3){
		this.torre1 = torre1;
		this.torre2 = torre2;
		this.torre3 = torre3;
		DEM = 0;
		disco1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[1]))));
        disco2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[2]))));
        disco3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[3]))));
        disco4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[4]))));
        disco5.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[5]))));
        disco6.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[6]))));
        disco7.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[7]))));
        disco8.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[8]))));
        disco9.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[1]))));
        disco10.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[2]))));
        disco11.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[3]))));
        disco12.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[4]))));
        disco13.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[5]))));
        disco14.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[6]))));
        disco15.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[7]))));
        disco16.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[8]))));
        disco17.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[1]))));
        disco18.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[2]))));
        disco19.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[3]))));
        disco20.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[4]))));
        disco21.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[5]))));
        disco22.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[6]))));
        disco23.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[7]))));
        disco24.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[8]))));
		barraEstado.setText("A seleccionado "+ NIVEL + " discos.");
	}
	public String imagenDisc(int i) {
		int numDisco = i;
		if(numDisco==1)
			return "/Imagen/1.png";
		else if(numDisco==2)
			return "/Imagen/2.png";
		else if(numDisco==3)
			return "/Imagen/3.png";
		else if(numDisco==4)
			return "/Imagen/4.png";
		else if(numDisco==5)
			return "/Imagen/5.png";
		else if(numDisco==6)
			return "/Imagen/6.png";
		else if(numDisco==7)
			return "/Imagen/7.png";
		else if(numDisco==8)
			return "/Imagen/8.png";
		else 
			return "/Imagen/0.png";		
	}
	public String imagenDisc1(int i){
		int numDisco = i;
		if(numDisco==1)
			return "/Imagen/11.png";
		else if(numDisco==2)
			return "/Imagen/22.png";
		else if(numDisco==3)
			return "/Imagen/33.png";
		else if(numDisco==4)
			return "/Imagen/44.png";
		else if(numDisco==5)
			return "/Imagen/55.png";
		else if(numDisco==6)
			return "/Imagen/66.png";
		else if(numDisco==7)
			return "/Imagen/77.png";
		else if(numDisco==8)
			return "/Imagen/88.png";
		else 
			return "/Imagen/0.png";
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		  if (e.getSource() == disco1){
			  disco1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre1[1]))));
			  if(torre1[1] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco2){
			  disco2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre1[2]))));
			  if(torre1[2] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco3){
			  disco3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre1[3]))));
			  if(torre1[3] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco4){
			  disco4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre1[4]))));
			  if(torre1[4] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco5){
			  disco5.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre1[5]))));
			  if(torre1[5] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco6){
			  disco6.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre1[6]))));
			  if(torre1[6] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco7){
			  disco7.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre1[7]))));
			  if(torre1[7] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco8){
			  disco8.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre1[8]))));
			  if(torre1[8] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco9){
			  disco9.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre2[1]))));
			  if(torre2[1] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco10){
			  disco10.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre2[2]))));
			  if(torre2[2] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco11){
			  disco11.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre2[3]))));
			  if(torre2[3] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco12){
			  disco12.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre2[4]))));
			  if(torre2[4] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco13){
			  disco13.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre2[5]))));
			  if(torre2[5] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco14){
			  disco14.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre2[6]))));
			  if(torre2[6] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco15){
			  disco15.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre2[7]))));
			  if(torre2[7] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco16){
			  disco16.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre2[8]))));
			  if(torre2[8] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco17){
			  disco17.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre3[1]))));
			  if(torre3[1] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco18){
			  disco18.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre3[2]))));
			  if(torre3[2] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco19){
			  disco19.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre3[3]))));
			  if(torre3[3] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco20){
			  disco20.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre3[4]))));
			  if(torre3[4] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco21){
			  disco21.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre3[5]))));
			  if(torre3[5] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco22){
			  disco22.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre3[6]))));
			  if(torre3[6] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco23){
			  disco23.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre3[7]))));
			  if(torre3[7] != 0){
				  efectoSonido();
			  }
			  }
		  if (e.getSource() == disco24){
			  disco24.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc1(torre3[8]))));
			  if(torre3[8] != 0){
				  efectoSonido();
			  }
			  }
	}
	@Override
	public void mouseExited(MouseEvent e) {
		  if (e.getSource() == disco1){
			  disco1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[1]))));
			  }
		  if (e.getSource() == disco2){
			  disco2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[2]))));
			  }
		  if (e.getSource() == disco3){
			  disco3.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[3]))));
			  }
		  if (e.getSource() == disco4){
			  disco4.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[4]))));
			  }
		  if (e.getSource() == disco5){
			  disco5.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[5]))));
			  }
		  if (e.getSource() == disco6){
			  disco6.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[6]))));
			  }
		  if (e.getSource() == disco7){
			  disco7.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[7]))));
			  }
		  if (e.getSource() == disco8){
			  disco8.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre1[8]))));
			  }
		  if (e.getSource() == disco9){
			  disco9.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[1]))));
			  }
		  if (e.getSource() == disco10){
			  disco10.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[2]))));
			  }
		  if (e.getSource() == disco11){
			  disco11.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[3]))));
			  }
		  if (e.getSource() == disco12){
			  disco12.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[4]))));
			  }
		  if (e.getSource() == disco13){
			  disco13.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[5]))));
			  }
		  if (e.getSource() == disco14){
			  disco14.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[6]))));
			  }
		  if (e.getSource() == disco15){
			  disco15.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[7]))));
			  }
		  if (e.getSource() == disco16){
			  disco16.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre2[8]))));
			  }
		  if (e.getSource() == disco17){
			  disco17.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[1]))));
			  }
		  if (e.getSource() == disco18){
			  disco18.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[2]))));
			  }
		  if (e.getSource() == disco19){
			  disco19.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[3]))));
			  }
		  if (e.getSource() == disco20){
			  disco20.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[4]))));
			  }
		  if (e.getSource() == disco21){
			  disco21.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[5]))));
			  }
		  if (e.getSource() == disco22){
			  disco22.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[6]))));
			  }
		  if (e.getSource() == disco23){
			  disco23.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[7]))));
			  }
		  if (e.getSource() == disco24){
			  disco24.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagenDisc(torre3[8]))));
			  }		
	}
	////////////////DEMO DEL JUEGO CON CINCO DISCOS /////////////////////////
	public void pasosResolver(int CONTADOR){
		int[] selectDisc = {1,2,1,3,1,2,1,4,1,2,1,3,1,2,1,5,1,2,1,3,1,2,1,4,1,2,1,3,1,2,1};
		int[] torreBase = {1,1,3,1,2,2,1,1,3,3,2,3,1,1,3,1,2,2,1,2,3,3,2,2,1,1,3,1,2,2,1};
		int[] torreFinal = {3,2,2,3,1,3,3,2,2,1,1,2,3,2,2,3,1,3,3,1,2,1,1,3,3,2,2,3,1,3,3};
		pasosResolucion.setText("Mover disco "+ selectDisc[CONTADOR] + " desde torre " + torreBase[CONTADOR] + " a torre " + torreFinal[CONTADOR]);
	}
	Runnable correr = new Runnable(){
		public void run(){
			try{
				while(true){
				int[] S5Disc = {5,17,4,9,17,10,3,17,10,3,9,18,3,19,2,9,19,10,18,2,10,3,17,10,3,17,2,11,17,12,1,17,12,1,11,18,1,19,10,1,19,10,18,2,10,3,9,18,3,19,2,9,19,10,1,19,10,1,9,20,1,21};
				for(int a=0;a<=S5Disc.length;a++){
					System.out.println(S5Disc[a]);
					modificaDisco(S5Disc[a]);
					pasosResolver(CONTADOR);
					hilo.sleep(1000);
				}
				}
			}catch(Exception e){
				
			}
		}
	};
	Thread hilo = new Thread(correr);
	public void resolver(){
		/////////////Borra contenido de arreglos///////////
        for(int i=1;i<=10;i++){
        	torre1[i] = 0;
			torre2[i] = 0;
			torre3[i] = 0;		
		}
        ///////llena arreglo Torre1 con cinco discos y llama a la funcion que llena los discos
        NIVEL = 5;
        for(int i=1;i<=NIVEL;i++){
        	torre1[i] = 8-(NIVEL-i);				
		} 
    	discoescogido(torre1,torre2,torre3);
    	/////////Establece las variables a Cero
    	DEM = 0;
    	UET1 = 0;
    	UET2 = 0;
    	UET3 = 0;
    	NRAVD = 0;
    	copyDEM = DEM;
    	CONTADOR = 0;
    	barraMovimiento.setText(CONTADOR + " Movimientos");
    	tiempo = "Demo";
    	cronometro.setText("00:00");
		///////////////////////
		hilo = new Thread(correr);
		hilo.start();
	}
	//////////////FIN DEL DEMO DEL JUEGO CON CINCO DISCOS /////////////////////
	
	///////////////CRONOMETRO HILO Y METODO /////////////////////////
	Runnable cronos = new Runnable(){
		public void run(){
			try{
				while(cronoActivo){
				for(int min = 0;min < 60;min++){
					for(int seg = 0;seg < 60; seg++){
						if(min<10){
							if(seg<10){
								cronometro.setText("0" + min + ":0" + seg);
								tiempo =  "0" + min + ":0" + seg;
							}
							else{
							cronometro.setText("0" + min + ":" + seg);
							tiempo =  "0" + min + ":" + seg;
							}
						}
						else{
							if(seg<10){
								cronometro.setText(min + ":0" + seg);
								tiempo = min + ":0" + seg;
							}
							else{
							cronometro.setText(min + ":" + seg);
							tiempo =  min + ":" + seg;
							}
						}
						hilo1.sleep(1000);
					}
					
				}
				}
			}catch(Exception e){
				
			}
			cronometro.setText( "00:00" );
		}
	};
	Thread hilo1 = new Thread();
    public void iniciarCronos() {
    	cronoActivo = true;
        hilo1 = new Thread(cronos);
        hilo1.start();
    }
    public void pararCronos(){
        cronoActivo = false;
        hilo1.stop();
    }
///////////////FIN DEL CRONOMETRO HILO Y METODO /////////////////////////
    
    ///////////////PRUEBA DE SONIDO //////////////
    public void efectoSonido(){
        try{
        	Clip sondisc=AudioSystem.getClip();
        	sondisc.open(AudioSystem.getAudioInputStream(new File("sdisc1.wav")));
           sondisc.start();
        }catch(Exception ex){
     	   System.err.println( ex.getMessage() );
         }
     }
    ////////////////FIN PRUEBA DE SONIDO//////////
	public static void main(String[] args){
		VentanaPrincipal ventanaprincipal = new VentanaPrincipal();
	}
}
