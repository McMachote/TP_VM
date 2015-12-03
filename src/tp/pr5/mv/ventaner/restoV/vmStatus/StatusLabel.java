package tp.pr5.mv.ventaner.restoV.vmStatus;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.MVC.IObservers.ProgramObserver;

public class StatusLabel extends JLabel implements ProgramObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private String text;

	public StatusLabel(String s, WController wc){
		super(s);
		this.text = s;
		this.num = 0;
		wc.addObsProgram(this);
	}

	@Override
	public int onStep() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				num++;
				setText(text + Integer.toString(num));
			}
		});
		return 0;
	}

	@Override
	public void onClear() {
		// TODO Auto-generated method stub
		
	}
	
}
