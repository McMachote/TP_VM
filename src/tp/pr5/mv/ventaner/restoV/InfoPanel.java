package tp.pr5.mv.ventaner.restoV;

import java.awt.GridLayout;

import javax.swing.JPanel;

import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.ventaner.restoV.cpuV.CpuStatePanel;
import tp.pr5.mv.ventaner.restoV.inoutV.InOutPanel;

public class InfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CpuStatePanel cpuStatePanel;
	private InOutPanel    inoutPanel;

	public InfoPanel(WController cntrl){
		this.setLayout(new GridLayout(2,0));
		this.cpuStatePanel = new CpuStatePanel(cntrl);
		this.add(this.cpuStatePanel);
		this.inoutPanel = new InOutPanel(cntrl);
		this.add(this.inoutPanel);
	}

}
