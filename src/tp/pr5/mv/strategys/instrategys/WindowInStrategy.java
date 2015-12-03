package tp.pr5.mv.strategys.instrategys;

import java.util.ArrayList;

import tp.pr5.mv.MVC.IObservers.InObserver;

public class WindowInStrategy implements InStrategy {

	private FileInputStrategy f;
	private String text;
	private int asterix;
	private ArrayList<InObserver> vistas;
	
	public WindowInStrategy(FileInputStrategy fileInputStrategy){
		this.asterix = 0;
		this.f = fileInputStrategy;
		this.text = "";
		int  i;
	    char c;
	    try{
	    	while((i = this.f.read())!=-1){
	    		c = (char)i;
	    		this.text += c;
	        }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    this.vistas = new ArrayList<InObserver>();
	}
	
	public int read() {
		//////
		//AQUI MODIFICAREMOS ENTRADA ***...*
		char mander = 0;
		if(!this.text.equalsIgnoreCase("") && this.asterix < this.text.length()){
			String er = "";
			mander = this.text.charAt(this.asterix);
			if(mander != '\n' || mander == '.'){
				er = String.valueOf(mander); 
				this.text = this.text.replaceFirst(er, "*");//REEMPLAZA GUAY
			}
			this.asterix++;
		}
		else{
			return -1;
		}
		for(InObserver obs : this.vistas){
    		obs.OnIn();
    	}
		return (int)mander;//this.f.read();
	}

	public String getName(){
		return "WINDOWINSTRATEGY";
	}

	public String toString(){
		return this.text;
	}
	
	public void addObs(InObserver obs){
		this.vistas.add(obs);
	}

}
