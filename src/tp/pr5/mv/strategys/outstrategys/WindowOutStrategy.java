package tp.pr5.mv.strategys.outstrategys;

import java.util.ArrayList;

import tp.pr5.mv.MVC.IObservers.OutObserver;

public class WindowOutStrategy implements OutStrategy {

	private OutStrategy f;
	private String texto;
	private ArrayList<OutObserver> vistas;
	
	public WindowOutStrategy(OutStrategy outS){
		this.f = outS;
		this.texto = "";
		this.vistas = new ArrayList<OutObserver>();
	}
	
	public void write(char mander){
		this.texto += String.valueOf(mander);
		this.f.write(mander);
		for(OutObserver obs : this.vistas){
			obs.OnOut();
		}
	}

	public String getName(){
		return "WINDOWOUTSTRATEGY";
	}

	public String toString(){
		return this.texto;
	}
	
	public void addObs(OutObserver obs){
		this.vistas.add(obs);
	}

}
