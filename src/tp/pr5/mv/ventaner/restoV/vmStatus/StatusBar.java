package tp.pr5.mv.ventaner.restoV.vmStatus;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.MVC.IObservers.MemoryObserver;
import tp.pr5.mv.MVC.IObservers.ProgramObserver;
import tp.pr5.mv.MVC.IObservers.StackObserver;

public class StatusBar extends JPanel implements StackObserver, MemoryObserver, ProgramObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StatusLabel sl;
	private JCheckBox jcMem;
	private JCheckBox jcStack;

	public StatusBar(WController wc){
		this.sl = new StatusLabel("Num. Instrucciones ejecutadas: ", wc);
		this.add(this.sl);
		this.jcMem = new JCheckBox();
		this.jcMem.setEnabled(false);
		this.jcMem.setSelected(false);
		this.add(this.jcMem);
		JLabel memLabel = new JLabel("Memoria modificada");
		this.add(memLabel);
		this.jcStack = new JCheckBox();
		this.jcStack.setEnabled(false);
		this.jcStack.setSelected(false);
		this.add(this.jcStack);
		JLabel stackLabel = new JLabel("Pila modificada");
		this.add(stackLabel);
		wc.addObsMemory(this);
		wc.addObsStack(this);
		wc.addObsProgram(this);
		
	}

	@Override
	public void onStore() {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jcMem.setSelected(true);
				jcStack.setSelected(false);
			}
		});
	}

	@Override
	public void onPop() {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jcStack.setSelected(true);
				jcMem.setSelected(false);
			}
		});
	}

	@Override
	public void onPush(int i) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jcStack.setSelected(true);
				jcMem.setSelected(false);
			}
		});
	}

	@Override
	public void onClear() {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jcMem.setSelected(false);
				jcStack.setSelected(false);
			}
		});
	}

	@Override
	public int onStep() {
		// TODO Auto-generated method stub
		return 0;
	}

}
