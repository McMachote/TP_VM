package tp.pr5.mv.ventaner.restoV.inoutV;

import javax.swing.JTextArea;

//CLASE QUE DEBERIA USARSE... PERO INPANEL ES JSCROLL --> CLASE ANONIMA EN EL CONSTRUCTOR
public class InputArea extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InputArea(String in){
		super();
		this.setText(in);
	}

}
