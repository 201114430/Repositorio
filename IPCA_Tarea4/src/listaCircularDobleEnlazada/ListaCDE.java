package listaCircularDobleEnlazada;

import listaDobleEnlazada.Nodo;

public class ListaCDE {
	public NodoCircular inicio;
	public NodoCircular ultimo;

	public void agregar(int numero){
		NodoCircular nuevo = new NodoCircular(numero);
		if(inicio == null){
			inicio = nuevo;
			ultimo = inicio;
		}
		else{
			NodoCircular nodoCTemporal = inicio;
					while(nodoCTemporal.siguiente != null){
						nodoCTemporal = nodoCTemporal.siguiente;
					}
			nodoCTemporal.siguiente = nuevo;
			nuevo.anterior = nodoCTemporal;
		}
		/*else{
			nuevo.siguiente = inicio;
			inicio.anterior = nuevo;
			inicio = nuevo;
			ultimo = inicio;
		}*/
	}
	public void mostrar(){
		NodoCircular nodoCTemporal = inicio;
		if(inicio == null){
			System.out.println("Lista circular doblemente enlazada vacia");
		}
		else{
			System.out.print("[");
			do{
				System.out.print(nodoCTemporal.numero + ",");
				nodoCTemporal = nodoCTemporal.siguiente;
			}while(nodoCTemporal == ultimo);
			System.out.print(nodoCTemporal.numero);
			System.out.print("] \n");
		}
		
	}

}
