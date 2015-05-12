import java.util.ArrayList;

public class Cola {

	//PRIMERO QUE ENTRA PRIMERO QUE SALE
	
	private ArrayList<Object> fifo= new ArrayList();
	
	//AGREGAR VALORES A LA COLA
	public void offer(Object o){
		
	fifo.add(o);
	
	}

	//MOSTRAR EL ULTIMO VALOR Y LO ELIMINA	
	public Object poll(){

		 
		if(!(fifo.isEmpty())){
               Object o = fifo.get(0);
               fifo.remove(0);
               return o;
		}else{
            return null;
    }
		
	}
	//DEVUELVE EL PRIMER VALOR DE ENTRADA
	public Object peek(){
		

		if(!(fifo.isEmpty())){
             return fifo.get(0);
		}else{
            return null;
    }

	}

	public static void main(String[] args) {

	       Cola cola = new Cola();
	       Cola fila1 = new Cola();
	       Cola fila2 = new Cola();
			

			cola.offer("primero");
			cola.offer("segundo");
			cola.offer("tercero");
			cola.offer("cuarto");
			cola.offer("quinto");
			cola.offer("sexto");

			fila1.offer(cola.poll());
			fila1.offer(cola.poll());
			fila1.offer(cola.poll());
			fila1.offer(cola.poll());
			fila1.offer(cola.poll());
			fila1.offer(cola.poll());
					
			
			fila2.offer(fila1.poll());
			fila2.offer(fila1.poll());
			fila2.offer(fila1.poll());
			fila2.offer(fila1.poll());
			fila2.offer(fila1.poll());
			fila2.offer(fila1.poll());
					
					
			System.out.println("Primer valor Fila"); 
			System.out.println(cola.peek()); 

			System.out.println(" "); 
			System.out.println(" "); 

			System.out.println("Datos Fila"); 

			while(fila2.peek()!=null){ 
			System.out.println(fila2.poll()); 
			}

		
	}

}