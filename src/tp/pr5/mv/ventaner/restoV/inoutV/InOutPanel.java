package tp.pr5.mv.ventaner.restoV.inoutV;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.MVC.IObservers.InObserver;
import tp.pr5.mv.MVC.IObservers.OutObserver;

public class InOutPanel extends JPanel implements InObserver, OutObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InPanel  inpanel;
	private OutPanel outpanel;
	private WController cntrl;

	public InOutPanel(WController cntrl){
		this.cntrl = cntrl;
		this.setLayout(new GridLayout(2,0));
		this.inpanel  = new InPanel (new JTextArea(cntrl.getInput()));
		this.add(this.inpanel);
		this.outpanel = new OutPanel(new JTextArea());
		this.add(this.outpanel);
		
		cntrl.addObsInS(this);
		cntrl.addObsOutS(this);
	}

	@Override
	public void OnOut() {
		// TODO Auto-generated method stub
		this.outpanel.setText(this.cntrl.getOutput());
	}

	@Override
	public void OnIn() {
		// TODO Auto-generated method stub
		String s = this.cntrl.getInput();
		if(!s.equalsIgnoreCase("")){
			String er = "";
			s.replaceFirst(er, "*");
		}
		this.inpanel.setText(s);
	}

	
	
}
