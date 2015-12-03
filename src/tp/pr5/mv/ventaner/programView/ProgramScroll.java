package tp.pr5.mv.ventaner.programView;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ProgramScroll extends JScrollPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProgramScroll(JList<String> l){
		super(l,
				  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setBorder(BorderFactory.createTitledBorder("Programa"));
	}
	
}
