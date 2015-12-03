package tp.pr5.mv.ventaner.restoV.cpuV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.MVC.IObservers.MemoryObserver;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;

public class MemoryControlPanel extends JPanel implements MemoryObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton    writeButton;
	private JLabel     positionLabel;
	private JTextField positionText;
	private JLabel     valueLabel;
	private JTextField valueText;
	private WController cntrl;

	public MemoryControlPanel(WController cntrl){
		this.cntrl = cntrl;
		this.positionLabel = new JLabel ("Pos: ");
		this.positionText  = new JTextField(5);
		this.valueLabel    = new JLabel ("Val: ");
		this.valueText     = new JTextField(5);
		this.writeButton   = new JButton("Write");
		this.writeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				onStore();
			}
		});
		
		this.add(this.positionLabel);
		this.add(this.positionText);
		this.add(this.valueLabel);
		this.add(this.valueText);
		this.add(this.writeButton);
		
		this.writeButton.setActionCommand("WRITE");
	}

	public void onStore() {
		if(!this.positionText.getText().equalsIgnoreCase("") &&
				!this.valueText.getText().equalsIgnoreCase("")){
			try{
				int position = Integer.parseInt(this.positionText.getText());
				int value    = Integer.parseInt(this.valueText.getText());
				if(position >= 0){
					this.cntrl.write(value, position);
				}
				else{
					JOptionPane.showOptionDialog(
						null, "Error: No hay posiciones negativas", "",
						JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
						null, new Object[] {"Aceptar"},"");
				}
			}catch(NumberFormatException nfe){
				JOptionPane.showOptionDialog(
						null, nfe.getMessage(), "",
						JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
						null, new Object[] {"Aceptar"},"");
			} catch (InstructionExecutionException e) {
				JOptionPane.showOptionDialog(
						null, e.getMessage(), "",
						JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
						null, new Object[] {"Aceptar"},"");
			} catch (InstructionMemoryException e) {
				JOptionPane.showOptionDialog(
						null, e.getMessage(), "",
						JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
						null, new Object[] {"Aceptar"},"");
			} catch (DivByZero e) {
				JOptionPane.showOptionDialog(
						null, e.getMessage(), "",
						JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
						null, new Object[] {"Aceptar"},"");
			}
		}
		this.positionText.setText("");
		this.valueText.setText("");
	}

}
