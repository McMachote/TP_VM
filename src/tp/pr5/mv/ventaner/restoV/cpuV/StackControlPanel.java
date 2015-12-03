package tp.pr5.mv.ventaner.restoV.cpuV;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import tp.pr5.mv.MVC.View;
//import tp.pr5.mv.CPU;
import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.MVC.IObservers.ProgramObserver;
//import tp.pr5.mv.MVC.IObservers.StackObserver;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;

public class StackControlPanel extends JPanel implements ProgramObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel cosa;
	private JButton pushButton;
	private JButton popButton;
	private JTextField numT;

	public StackControlPanel (final WController cntrl) {
		cntrl.addObsProgram(this);
		this.setLayout(new FlowLayout());
		this.cosa  = new JLabel("Valor: ");
		this.add(this.cosa);
		this.numT = new JTextField(5);
		this.add(this.numT);
		this.pushButton = new JButton("Push");
		this.pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cntrl.push(Integer.parseInt(numT.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showOptionDialog(null, e1.getMessage(), "",
							JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
							null, new Object[] {"Aceptar"},
							   "");
				} catch (InstructionExecutionException e1) {
					JOptionPane.showOptionDialog(null, e1.getMessage(), "",
							JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
							null, new Object[] {"Aceptar"},
							   "");
				} catch (InstructionMemoryException e1) {
					JOptionPane.showOptionDialog(null, e1.getMessage(), "",
							JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
							null, new Object[] {"Aceptar"},
							   "");
				} catch (DivByZero e1) {
					JOptionPane.showOptionDialog(null, e1.getMessage(), "",
							JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
							null, new Object[] {"Aceptar"},
							   "");
				} finally{
					numT.setText("");
				}
			}
		});
		this.add(this.pushButton);
		this.popButton  = new JButton("Pop");
		this.popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cntrl.pop();
				} catch (InstructionMemoryException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showOptionDialog(null, e1.getMessage(), "",
							JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
							null, new Object[] {"Aceptar"},
							   "");
				} catch (InstructionExecutionException e1) {
					JOptionPane.showOptionDialog(null, e1.getMessage(), "",
							JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
							null, new Object[] {"Aceptar"},
							   "");
				} catch (DivByZero e1) {
					JOptionPane.showOptionDialog(null, e1.getMessage(), "",
							JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
							null, new Object[] {"Aceptar"},
							   "");
				}
			}
		});
		this.add(this.popButton);
		this.pushButton.setActionCommand("PUSH");
		this.popButton.setActionCommand("POP");
	}
	
	public String getV(){
		String s = this.numT.getText();
		this.numT.setText("");
		return s;
	}

	@Override
	public int onStep() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onClear() {
		// TODO Auto-generated method stub
		
	}

}