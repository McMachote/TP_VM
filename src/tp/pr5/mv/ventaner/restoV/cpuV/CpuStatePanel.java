package tp.pr5.mv.ventaner.restoV.cpuV;

import java.awt.GridLayout;

import javax.swing.JPanel;

import tp.pr5.mv.MVC.Controllers.WController;

public class CpuStatePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StackPanel stackPanel;
	private MemoryStatePanel memoryPanel;
	private WController wc;

	public CpuStatePanel(WController cntrl) {
		this.setLayout(new GridLayout(0, 2));
		this.stackPanel = new StackPanel(cntrl);
		this.add(this.stackPanel);
		this.memoryPanel = new MemoryStatePanel(cntrl);
		this.add(this.memoryPanel);
		this.wc = cntrl;
		this.wc.addObsStack(this.stackPanel);
		this.wc.addObsMemory(this.memoryPanel);
	}

	public void showStatus() {
		// TODO Auto-generated method stub
		// this.stackPanel.actualiza();
	}

}
