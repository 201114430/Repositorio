package proyectoFinal;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal_201114430 extends JFrame implements MouseListener{
	Icono_201114430 botonVenta = new Icono_201114430(30, 100, 220, 220,1);
	Icono_201114430 botonEmpleado = new Icono_201114430(280, 100, 220, 220,2);
	Icono_201114430 botonProducto = new Icono_201114430(530, 100, 220, 220,3);
	Icono_201114430 botonCliente = new Icono_201114430(780, 100, 220, 220,4);
	Icono_201114430 botonVenExt = new Icono_201114430(70, 400,1);
	Icono_201114430 botonEmpExt = new Icono_201114430(340, 400,2);
	Icono_201114430 botonProExt = new Icono_201114430(590, 400,3);
	Icono_201114430 botonCliExt = new Icono_201114430(840, 400,4);
	Ventas_201114430 ventas;
	Empleado_201114430 empleado;
	Producto_201114430 producto;
	Cliente_201114430 cliente;
	//File fichero;
	
	public javax.swing.JLabel etiquetaIcon;
	public javax.swing.JButton ingresar,reporte;
 	public VentanaPrincipal_201114430(){//constructor de la clase JFrame 		
 		configuracionVentana();
		iniciaIcono();
		repaint();
 	}

 	public boolean ingresarDatos;
 	public boolean generarReportes;
 	
	public void configuracionVentana(){
		setSize(1030, 680);
		setTitle("Servicio General al Cliente S.A.");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		
	}
	public void iniciaIcono(){
		setLayout(null);
		Container container = getContentPane();
		container.setLayout(null);
		///////////////////Boton Venta////////////////////////
		container.add(botonVenta);
		//botonVenta.setVisible(true);
		//botonVenta.setEnabled(false);
		botonVenta.addMouseListener(this);
		///////////////////Boton Empleado//////////////////////
		container.add(botonEmpleado);
		//botonEmpleado.setVisible(true);
		//botonEmpleado.setEnabled(false);
		botonEmpleado.addMouseListener(this);
		///////////////////Boton Producto//////////////////////
		container.add(botonProducto);
		//botonProducto.setVisible(true);
		//botonProducto.setEnabled(false);
		botonProducto.addMouseListener(this);
		///////////////////Boton Cliente///////////////////////
		container.add(botonCliente);
		//botonCliente.setVisible(true);
		//botonCliente.setEnabled(false);
		botonCliente.addMouseListener(this);
		///////////////////Boton Ingresar///////////////////////
        ingresar=new JButton("Agregar o Eliminar:");
        ingresar.setBounds(10, 10, 270, 40);	
        container.add(ingresar);
		ingresar.setVisible(true);
		ingresar.setFont(new java.awt.Font("CONSOLA", 0, 20));
		ingresar.addMouseListener(this);
		///////////////////Boton Reporte///////////////////////
        reporte=new JButton("Generar Reportes:");
        reporte.setBounds(280, 10, 250, 40);	
        container.add(reporte);
		reporte.setVisible(true);
		reporte.setFont(new java.awt.Font("CONSOLA", 0, 20));
		reporte.addMouseListener(this);
		////////////////////////Botones para seleccionar Fichero y generar reporte//////////////
		///////////////////Boton Venta Fichero Externo////////////////////////
		container.add(botonVenExt);
		botonVenExt.addMouseListener(this);
		///////////////////Boton Empleado Fichero Externo////////////////////////
		container.add(botonEmpExt);
		botonEmpExt.addMouseListener(this);
		///////////////////Boton Producto Fichero Externo////////////////////////
		container.add(botonProExt);
		botonProExt.addMouseListener(this);
		///////////////////Boton Cliente Fichero Externo////////////////////////
		container.add(botonCliExt);
		botonCliExt.addMouseListener(this);
		///////////////////Etiqueta Iconos///////////////////////
		etiquetaIcon = new JLabel();
		etiquetaIcon.setBounds(100, 70, 850, 30);
		etiquetaIcon.setFont(new java.awt.Font("CONSOLA", 0, 25));
		etiquetaIcon.setForeground( Color.black);
		etiquetaIcon.setText("Ventas                 Empleados                Productos                Clientes");
		add(etiquetaIcon);
		///////////////////Etiqueta Iconos///////////////////////
		etiquetaIcon = new JLabel();
		etiquetaIcon.setBounds(100, 350, 850, 30);
		etiquetaIcon.setFont(new java.awt.Font("CONSOLA", 0, 25));
		etiquetaIcon.setForeground( Color.black);
		etiquetaIcon.setText("Generar Reporte desde archivos.");
		add(etiquetaIcon);
	}
	
	public String extencionFichero(int archivoEscogido){//escoge ruta segun actividad seleccionada
		if(archivoEscogido==1)
			return "fct";
		else if(archivoEscogido==2)
			return "emp";
		else if(archivoEscogido==3)
			return "prt";
		else if(archivoEscogido==4)
			return "clt";
		return null;		
	}
	
    public void escogerFichero(int numF){
    	
  		JFileChooser seleccionarFichero = new JFileChooser();
  		FileNameExtensionFilter filtraArchivo = new FileNameExtensionFilter("fct, emp, prt, clt", extencionFichero(numF));
  		seleccionarFichero.setFileFilter(filtraArchivo);
  		
  		int resultado = seleccionarFichero.showOpenDialog(null);
  		if(resultado == JFileChooser.APPROVE_OPTION){
  			File direccionFichero = seleccionarFichero.getSelectedFile();
  			System.out.println(direccionFichero);
  		}     
  	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource()==botonVenta && ingresarDatos) {
			ventas = new Ventas_201114430();
		}
		if (e.getSource()==botonEmpleado && ingresarDatos) {
			empleado = new Empleado_201114430();
		}
		if(e.getSource()==botonProducto && ingresarDatos){
			producto = new Producto_201114430();
		}
		if(e.getSource()==botonCliente && ingresarDatos){
			cliente = new Cliente_201114430();
		}
		if(e.getSource() == reporte){
			botonVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/rv.png")));
			botonEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/re.png")));
			botonProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/rp.png")));
			botonCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ce.png")));
			this.generarReportes = true;
			this.ingresarDatos = false;
			reporte.setEnabled(false);
			ingresar.setEnabled(true);
		}
		if(e.getSource() == ingresar){
			botonVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/v1.png")));
			botonEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/e4.png")));
			botonProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/p2.png")));
			botonCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/rc.png")));
			this.generarReportes = false;
			this.ingresarDatos = true;
			ingresar.setEnabled(false);
			reporte.setEnabled(true);
			
			botonVenta.setVisible(true);
			botonEmpleado.setVisible(true);
			botonProducto.setVisible(true);
			botonCliente.setVisible(true);
		}
		if(e.getSource()==botonVenta && generarReportes){
			
		}
		if(e.getSource() == botonVenExt){
			escogerFichero(1);
		}
		if(e.getSource() == botonEmpExt){
			escogerFichero(2);
		}
		if(e.getSource() == botonProExt){
			escogerFichero(3);
		}
		if(e.getSource() == botonCliExt){
			escogerFichero(4);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	public static void main(String[] args){
		VentanaPrincipal_201114430 ventanaprincipal = new VentanaPrincipal_201114430();
	}
}