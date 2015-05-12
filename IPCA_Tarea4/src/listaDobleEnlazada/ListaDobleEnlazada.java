package listaDobleEnlazada;

public class ListaDobleEnlazada {
	public Nodo inicio = null;
	public Nodo ultimo = null;
	
	public void agregarInicio(int numero){
		Nodo nuevo = new Nodo(numero);
		if(inicio == null){
			inicio = nuevo;
		}
		else{
			nuevo.siguiente = inicio;
			inicio.anterior = nuevo;
			inicio = nuevo;
		}	
	}
	public void agregarFinal(int numero){
		Nodo nuevo = new Nodo(numero);
		if(inicio==null){
			inicio = nuevo;			
		}
		else{
			Nodo nodoTemporal = inicio;
			while(nodoTemporal.siguiente != null){
				nodoTemporal = nodoTemporal.siguiente;				
			}
			nodoTemporal.siguiente = nuevo;
			nuevo.anterior = nodoTemporal;			
		}
	}

	public void mostrar(){
		Nodo nodoTemporal = inicio;
		if(inicio == null){
			System.out.println("Lista doblemente enlazada Vacia.");
		}
		else{
			System.out.print("[");
			do{
				System.out.print(nodoTemporal.numero + ",");
				nodoTemporal = nodoTemporal.siguiente;
			}while(nodoTemporal.siguiente != null);
			System.out.println("]");
		}
	}

}
