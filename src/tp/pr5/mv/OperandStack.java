package tp.pr5.mv;

import java.util.ArrayList;

import tp.pr5.mv.MVC.IObservers.StackObserver;
import tp.pr5.mv.exceptions_mv.EmptyOSException;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;

/**
 * Pila de operandos en la que se realizan las operaciones.
 * Gran parte de las distintas instrucciones de la maquina virtual trabajan sobre
 * la pila de operandos, cogiendo de ella valores y/o dejando en ella resultados.
 * Se implementa el comportamiento de una pila con un array de enteros => Probar clase stack
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class OperandStack {
	
	private int[] ray; //stack
	private int numElems;
	private ArrayList<StackObserver> vistas;
	
	/**
	 * Default constructor
	 */
	public OperandStack () {
		this.ray      = new int[20];
		this.numElems = 0;
		this.vistas   = new ArrayList<StackObserver>();
	}

	/**
	 * Devuelve el tamanno de la pila
	 * @return
	 */
	public int size(){
		return this.numElems;
	}
	
	/**
	 * Redefinicion del metodo toString()
	 * Muestra todos los elementos almacenados
	 */
	public String toString(){
		String s = "Pila de operandos:";
		if(this.numElems > 0){
			for(int i = 0; i < this.numElems; i++){
				s +=  " " + this.ray[i];
			}
		}
		else{
			s += " <vacia>";
		}
		return s;
	}
	
	/**
	 * Apila en la pila de operandos el entero n de la instruccion.
	 * @param n - entero para annadir
	 * @return true si y solo si se ha annadido correctamente
	 */
	public boolean push(int n){//deberia funcionar siempre... memoria ilimitada...
		this.ray[this.numElems] = n;
		this.numElems++;
		if(this.numElems == this.ray.length){
			int[] aux = this.ray.clone();
			this.ray = new int[this.numElems * 2];
			for(int i = 0; i < this.numElems; i++){
				this.ray[i] = aux[i];
			}
		}
		for(StackObserver o : this.vistas)
			o.onPush(n);
		return true;
	}

	/**
	 * Extrae un elemento de la cima de la pila
	 * @return int - elemento de la cima
	 * @throws InstructionExecutionException 
	 */
	public boolean pop() throws InstructionExecutionException{
		boolean check = false;
		if(!this.esVacia()){
			this.numElems--;
			check = true;
		}
		else{
			throw new InstructionExecutionException(this.toString());//, this.numElems);
		}
		for(StackObserver o : this.vistas)
			o.onPop();
		return check;
	}
	
	/**
	 * Devuelve el elemento cima
	 * @return int cima
	 * @throws EmptyOSException 
	 */
	public int getCima(){
		if(this.esVacia() ){
			throw new ArrayIndexOutOfBoundsException("Error: Pila vacia");
		}
		return this.ray[this.numElems - 1];
	}
	
	/**
	 * Comprueba si la pila es vacia
	 * @return true si y solo si esta vacia
	 */
	public boolean esVacia(){
		return this.numElems == 0;
	}

	public String toWindowString() {
		String s = "";
		if(this.numElems > 0){
			for(int i = 0; i < this.numElems; i++){
				s +=  " " + this.ray[i];
			}
		}
		else{
			s += "<vacia>";
		}
		return s;
	}

	public void addObs(StackObserver obs){
		this.vistas.add(obs);
	}

}
