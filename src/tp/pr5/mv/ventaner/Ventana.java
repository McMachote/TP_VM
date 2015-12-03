package tp.pr5.mv.ventaner;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import tp.pr5.mv.MVC.View;
import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.MVC.IObservers.ProgramObserver;
import tp.pr5.mv.ventaner.actionsV.ActionButtonPanel;
import tp.pr5.mv.ventaner.programView.ProgramScroll;
import tp.pr5.mv.ventaner.restoV.InfoPanel;
import tp.pr5.mv.ventaner.restoV.vmStatus.StatusBar;

public class Ventana extends JFrame implements View, ProgramObserver {
	
	//Vista del programa jscroll, anonimo, no puede hacer onSteps
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProgramScroll progPanel;
	private InfoPanel infoPanel;
	private ActionButtonPanel actionPanel;
	private DefaultListModel<String> pmvListModel;
	private JList<String> l;
	private String[] ld;
	private WController control;
	private StatusBar sb;

	public Ventana(WController cntr) {
		super("Maquina virtual de TP");
		this.control = cntr;
		try {
			Image imgStep = ImageIO.read(getClass().getResource("/tp/pr5/mv/ventaner/iconos/SONIC_CORRIENDO.gif"));
			this.setIconImage(imgStep);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setName("Maquina virtual de TP");
		this.setLayout(new BorderLayout());
		this.actionPanel = new ActionButtonPanel(this.control);
		this.add(this.actionPanel, BorderLayout.NORTH);
		String programaASM = this.control.getProgram();

		this.pmvListModel = new DefaultListModel<String>();
		this.l = new JList<String>();
		this.l.setModel(this.pmvListModel);
		this.ld = programaASM.split(System.lineSeparator());
		int n = control.getPc();
		for(int i = 0; i < this.ld.length; i++){
			String line = "   ";
			if(i == n){
				line = "*  ";
			}
			line += this.ld[i] + "     ";
			this.pmvListModel.add(i, line);
		}
		this.progPanel = new ProgramScroll(l);
		this.add(this.progPanel, BorderLayout.WEST);
		
		this.infoPanel = new InfoPanel(cntr);		//HORROR!!!
		this.add(this.infoPanel, BorderLayout.CENTER);

		this.sb = new StatusBar(cntr);
		this.add(this.sb, BorderLayout.SOUTH);

		this.setBounds(100, 100, 750, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.control.addObsProgram(this);
	}

	@Override
	public void run() {
		this.setVisible(true);
	}

	@Override
	public void quit() {//no utilizado!
		// TODO Auto-generated method stub
		//this.control.quit();
	}

	@Override
	public int onStep() {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				int n = control.getPc();
				pmvListModel.clear();//NIAPA
				for(int i = 0; i < ld.length; i++){
					String line = "   ";
					if(i == n){
						line = "*  ";
					}
					line += ld[i] + "     ";
					pmvListModel.add(i, line);
				}
			}
		});
		return 0;
	}

	@Override
	public void showStatus(String string) {
		// TODO Auto-generated method stub
		//
	}

	@Override
	public void onClear() {
		// TODO Auto-generated method stub
		
	}

}
