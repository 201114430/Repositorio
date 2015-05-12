import java.util.ArrayList;

public class Filo {
	
	private ArrayList<Object> filo= new ArrayList();
	//AGREGAR VALORES A LA PILA
	public void push(Object o){
		filo.add(o);
	}

	//MOSTRAR EL ULTIMO VALOR Y LO ELIMINA
	public Object pop(){
		if(!(filo.isEmpty())){
			Object o = filo.get(filo.size()-1);
            filo.remove(filo.size()-1);
            return o;
       }
		else{
               return null;
       }
	       
	}
	//MOSTRAR EL ULTIMO VALOR
	public Object peek(){
		
		
		 if(!(filo.isEmpty())){
             return filo.get(filo.size()-1);
     }else{
             return null;
     }
		 
	}
	//PILA LLENA O VACIA
	public boolean empty(){
		return filo.isEmpty();
	}
	
	public static void main(String[] args) {
       Filo pilaEntra = new Filo();
       Filo cola = new Filo();
		

		pilaEntra.push("primero");
		pilaEntra.push("segundo");
		pilaEntra.push("tercero");
		pilaEntra.push("cuarto");
		pilaEntra.push("quinto");
		pilaEntra.push("sexto");
		

		
		cola.push(pilaEntra.pop());
		cola.push(pilaEntra.pop());
		cola.push(pilaEntra.pop());
		cola.push(pilaEntra.pop());
		cola.push(pilaEntra.pop());
		cola.push(pilaEntra.pop());
		
		
		System.out.println("ultimo valor Cola"); 
		System.out.println(cola.peek()); 

		System.out.println(" "); 
		System.out.println(" ");
		 
		System.out.println("Datos Cola");
		while(cola.empty()==false){
			System.out.println(cola.pop()); 
		}
	}

}