package listaDobleEnlazada;

public class Nodo {
	public int numero;
	Nodo siguiente;
	Nodo anterior;

	public Nodo(int numero) {
		this.numero = numero;
		siguiente = null;
		anterior = null;
	}
}
