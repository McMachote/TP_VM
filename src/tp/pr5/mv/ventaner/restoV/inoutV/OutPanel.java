package tp.pr5.mv.ventaner.restoV.inoutV;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OutPanel extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea jta;

	public OutPanel (JTextArea jta){
		super(jta,
				  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//por defecto
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);    //por defecto
		this.setBorder(BorderFactory.createTitledBorder("Salida del programa") );
		this.jta  = jta;
		this.jta.setEditable(false);
	}
	
	public void setText(String s){
		this.jta.setText(s);
	}

}
