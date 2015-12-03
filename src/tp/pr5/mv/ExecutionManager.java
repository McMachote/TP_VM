package tp.pr5.mv;

import java.util.ArrayList;

import tp.pr5.mv.MVC.IObservers.ProgramObserver;

/**
 * Clase que gestiona la ejecucion del programa.
 * Se utiliza desde CPU
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class ExecutionManager {
	
	private int nextPc;
	private boolean halt;
	private int progSize;
	private ArrayList<ProgramObserver> vistas;
	
	/**
	 * Default constructor
	 */
	public ExecutionManager(){
		this.nextPc = 0;
		this.halt = false;
		this.progSize = 0;
		this.vistas = new ArrayList<ProgramObserver>();
	}
	
	/**
	 * Param constructor
	 * */
	public ExecutionManager(int n){
		this.nextPc = 0;
		this.halt = false;
		this.progSize = n;
		this.vistas = new ArrayList<ProgramObserver>();
	}

	/**
	 * Permite conocer cual sera la siguiente instruccion a ejecutar
	 * @return int - nextPc
	 */
	public int getNextPc(){
		return this.nextPc;
	}

	/**
	 * Salto absoluto en la ejecucion del programa
	 * @param n - posicion a la que se saltara
	 * @return true - si y solo si la posicion existe en el programa cargado en CPU
	 */
	public boolean jumpingJackFlash(int n){
		//boolean check;
		if(n >= 0 && n < this.progSize){
			//check = true;
			this.nextPc = n-1;
		}
		else{
			this.halt = true;
			this.nextPc = this.progSize;
			//check = true;
		}
		//if(this.vistas != null)
		for(ProgramObserver obs : this.vistas){
			obs.onClear();
		}
		for(ProgramObserver obs : this.vistas){
			obs.onStep();
		}
		return true;
	}

	/**
	 * Consulta si la maquina se ha parado
	 * @return true - solo si se ha parado
	 */
	public boolean isHalted(){
		return this.halt;
	}

	/**
	 * Avanza la ejecucion del programa
	 */
	public void incrementPc(){
		this.nextPc++;
		if(this.nextPc >= this.progSize || this.nextPc < 0){
			this.halt = true;
		}
		if(this.vistas != null && this.vistas.size() != 0)
		for(ProgramObserver obs : this.vistas){
			obs.onStep();
		}
	}
	
	/**
	 * Para la maquina
	 */
	public void stop(){
		this.halt = true;
	}
	
	public void addObs(ProgramObserver obs){
		this.vistas.add(obs);
	}

}
