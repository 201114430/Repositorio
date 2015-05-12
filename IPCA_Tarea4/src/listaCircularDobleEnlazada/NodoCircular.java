package listaCircularDobleEnlazada;

public class NodoCircular {
	public int numero;
	public NodoCircular siguiente;
	public NodoCircular anterior;

	public NodoCircular(int numero) {
		this.numero = numero;
		siguiente = null;
		anterior = null;		
	}

}