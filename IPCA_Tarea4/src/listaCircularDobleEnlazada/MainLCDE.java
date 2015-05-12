package listaCircularDobleEnlazada;

public class MainLCDE {

	public static void main(String[] args) {
		ListaCDE listacircdoblenla = new ListaCDE();
		listacircdoblenla.agregar(1);
		listacircdoblenla.agregar(3);
		listacircdoblenla.agregar(6);
		listacircdoblenla.mostrar();
		System.out.println(listacircdoblenla.inicio.numero);
		System.out.println(listacircdoblenla.inicio.siguiente.numero);
		System.out.println(listacircdoblenla.inicio.siguiente.siguiente.numero);
	}

}
