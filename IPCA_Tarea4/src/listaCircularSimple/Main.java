package listaCircularSimple;

public class Main {

	public static void main(String[] args) {
		ListaCircular listacircular = new ListaCircular();
		listacircular.insertar(1);
		listacircular.insertar(3);
		listacircular.insertar(4);
		listacircular.recorrer();
		System.out.println("Primer elemento ingresado " + listacircular.inicio.numero);
		System.out.println("Ultimo elemento ingresado " + listacircular.inicio.siguiente.siguiente.numero);
		System.out.println("Ultimo elemento ingresado apunta al Primer elemento ingresado " + listacircular.inicio.siguiente.siguiente.siguiente.numero);

	}

}
