package proyectoFinal;

import java.util.Date;

public class NodoVenta_201114430 {
	
	NodoVenta_201114430 siguienteVe;
	String nombreProducto,nombreEmpleado,nombreCliente;
	Date fechaProducto;
	int cantidadProducto;
	public NodoVenta_201114430(String nombreProducto,Date fechaProducto,int cantidadProducto,String nombreEmpleado,String nombreClient){
		this.nombreProducto = nombreProducto;
		this.fechaProducto = fechaProducto;
		this.cantidadProducto = cantidadProducto;
		this.nombreEmpleado = nombreEmpleado;
		this.nombreCliente = nombreClient;
		
	}
}
