package tp.pr5.mv.ventaner.restoV.cpuV;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.MVC.IObservers.StackObserver;

public class StackPanel extends JPanel implements StackObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane stackTextPanel;
	private StackControlPanel stackCommands;
	private DefaultListModel<String> stackListModel;
	private JList<String> l;

	public StackPanel(WController cntrl) {
		this.setBorder(BorderFactory.createTitledBorder("Pila de operandos:"));
		this.setLayout(new BorderLayout());// ///JUGUEMOS PARA PONER BOTONES
		this.stackListModel = new DefaultListModel<String>();
		this.stackListModel.add(0, "<vacia>");
		this.l = new JList<String>();
		this.l.setModel(this.stackListModel);
		this.stackTextPanel = new JScrollPane(l);
		this.add(this.stackTextPanel, BorderLayout.CENTER);
		this.stackCommands = new StackControlPanel(cntrl);
		this.add(this.stackCommands, BorderLayout.SOUTH);
	}

	@Override
	public void onPush(final int i) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				if (!stackListModel.isEmpty()
						&& stackListModel.get(0).equalsIgnoreCase("<vacia>")) {
					stackListModel.clear();
				}
				stackListModel.add(0, Integer.toString(i));// FUNCIONA CON EL
															// VALOR DEL CAMPO
															// DE TEXTO
			}
		});
	}

	@Override
	public void onPop() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (!stackListModel.isEmpty()) {
					stackListModel.remove(0);
				}
				if (stackListModel.isEmpty()) {
					stackListModel.add(0, "<vacia>");
				}
			}
		});
	}

}
