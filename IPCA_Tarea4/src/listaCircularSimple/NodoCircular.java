package listaCircularSimple;

public class NodoCircular {
	public int numero;
	public NodoCircular siguiente;
	
	public NodoCircular(int numero){
		this.numero = numero;
		siguiente = this;
	}
}