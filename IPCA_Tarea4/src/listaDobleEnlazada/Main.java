package listaDobleEnlazada;

public class Main {

	public static void main(String[] args) {
		ListaDobleEnlazada listadoblementenlazada = new ListaDobleEnlazada();
		for(int i = 0;i<5;i++){
			listadoblementenlazada.agregarInicio(i);
			listadoblementenlazada.agregarFinal(5-i);
		}
		listadoblementenlazada.mostrar();
		System.out.println("Primer elemento incertado " + listadoblementenlazada.inicio.numero);
		System.out.println("Segundo elemento incertado " + listadoblementenlazada.inicio.siguiente.numero);
		System.out.println("Segundo elemento apunta al Primer elemento incertado " + listadoblementenlazada.inicio.siguiente.anterior.numero);
	}

}
