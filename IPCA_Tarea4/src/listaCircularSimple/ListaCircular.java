package listaCircularSimple;

public class ListaCircular {
	
	public NodoCircular inicio;
	public NodoCircular ultimo;
	public ListaCircular(){
		inicio = null;
		ultimo = null;
	}
	
	public void insertar(int numero){
		NodoCircular nodocircular = new NodoCircular(numero);
		if(inicio == null){
			inicio = nodocircular;
			ultimo = inicio;
		}
		else{
			NodoCircular nodoTemporal = inicio;
			while(nodoTemporal.siguiente != inicio){
				nodoTemporal = nodoTemporal.siguiente;
				
			}
			nodoTemporal.siguiente = nodocircular;
			nodocircular.siguiente = inicio;
			ultimo = nodocircular;
			
		}
	}
	public void recorrer(){
		NodoCircular nodoTemporal = inicio;
		if(nodoTemporal == null){
			System.out.println("Lista Circular vacia");			
		}
		else{
			System.out.print("[");
			do{
				System.out.print(nodoTemporal.numero + ",");
				nodoTemporal = nodoTemporal.siguiente;
				
			}while(nodoTemporal.siguiente == ultimo);
			System.out.print(nodoTemporal.numero);
			System.out.print("] \n");
		}
	}
}
