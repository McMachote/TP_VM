package tp.pr5.mv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import tp.pr5.mv.MVC.IObservers.MemoryObserver;

/**
 * Una memoria capaz de almacenar datos.
 * La unidad minima de memoria es el entero, es decir en cada celda almacena un entero completo
 * (y no un byte como suele ocurrir en las maquinas reales).
 * La capacidad de la memoria es ilimitada, es decir se podra escribir en cualquier direccion (mayor o igual que cero),
 * hasta que la memoria de la maquina fisica subyacente "aguante".
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Memory extends ArrayList <MemoryCell> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<MemoryObserver> vistas;
	
	/**
	 * Constructor por defecto
	 */
	public Memory(){
		super();
		this.vistas = new ArrayList<MemoryObserver>();
	}
	
	/**
	 * Comparador que utiliza solo el atributo posicion de MemoryCell,
	 * asi podemos utilizarlo para hacer busqueda binaria
	 */
	private Comparator <MemoryCell> c = new Comparator <MemoryCell> () {
	      public int compare(MemoryCell mc1, MemoryCell mc2) {
	        return Integer.valueOf(mc1.getPos()).compareTo(Integer.valueOf(mc2.getPos()) );
	      }
	};
		
	/**
	 * Almacena un nuevo elemento
	 * @param mc - MemoryCell que va a insertarse en orden
	 * @return true Si y solo si no ha habido fallos
	 */
	public boolean store (MemoryCell mc){
		boolean check = false;
		if(this.isEmpty()){
			this.add(mc);
			check = true;
		}
		else{
			int pos = Collections.binarySearch(this, mc, c);//Mas eficiente que contains ya que tenemos orden
			if(pos >= 0){
				this.set(pos, mc);
			}
			else{
				int addIndex = this.buscaPuntoInsercion(mc.getPos());
				this.add(addIndex, mc);
			}
			check = true;
		}
		for(MemoryObserver o : this.vistas)
			o.onStore();
		return check;
	}
	
	/**
	 * Calcula la posicion en la que se va a insertar un elemento para preservar el orden
	 * @param pos - Determinara el orden
	 * @return int - posicion en la que se va a insertar
	 */
	private int buscaPuntoInsercion(int pos) {
		int i = 0;
		int aux = 0;
		while (i < this.size()) {
			aux = this.get(i).getPos();
			if(aux > pos){
				return i;
			}
			i++;
		}
		return i;
	}

	/**
	 * Devuelve el elemento en la posicion indicada.
	 * Si este no se encuentra en memoria nos devolvera null 
	 * @param pos - Indica la posicion en que vamos a buscar
	 * @return mc - MemoryCell que buscabamos o null si esta no existe
	 */
	public MemoryCell load (int index){
		MemoryCell mc = new MemoryCell(0, index);
		int pos = Collections.binarySearch(this, mc, c);
		if(pos > -1){
			mc = this.get(pos);
			return mc;
		}
		return null;
	} 
	
	//------------------------- Redefinicion de metodos -------------------------//
	
	/**
	 * Redefinicion del iterador
	 */
    public Iterator <MemoryCell> iterator () {
    	return super.iterator();
    }
	
    /**
     * Redefinicion del metodo toString() para mostrar el estado de la memoria
     */
	public String toString () {
		String s = "";
		int aux = this.size();
		if(aux > 0){
			s += "Memoria:";
			for(int index = 0; index < aux; index++){
				s += "  [" + this.get(index).getPos() + "]:" + this.get(index).getContenido();
			}
			s += Constants.LS;
		}
		else{
			s += "Memoria: <vacia>" + Constants.LS;
		}
		return s;
	}
	
	public String toWindowString (){
		String s = "";
		int aux = this.size();
		if(aux > 0){
			for(int index = 0; index < aux; index++){
				s += this.get(index).getPos() + "," + this.get(index).getContenido() + ";";
			}
		}
		return s;
	}
	
	public void addObs(MemoryObserver obs){
		this.vistas.add(obs);
	}

	/*
	 * Pause
	 * 	ActionPermormer{
	 * 		hebra.interrupt();
	 * */
	
}
