package tp.pr5.mv.ventaner.actionsV;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.exceptions_mv.ProgramEnd;

public class ActionButtonPanel extends JPanel {

	private JButton actionRun;
	private JButton actionStep;
	private JButton actionPause;
	private JButton actionQuit;
	
	private Thread worker;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionButtonPanel(final WController controller) {//FINAL????
		worker = null;
		this.actionStep  = new JButton();
		this.actionRun   = new JButton();
		this.actionPause = new JButton();
		this.actionQuit  = new JButton();
		this.setBorder(BorderFactory.createTitledBorder("Acciones"));
		Image imgStep;
		try {
			imgStep = ImageIO.read(getClass().getResource("/tp/pr5/mv/ventaner/iconos/step.png"));
			this.actionStep.setIcon(new ImageIcon(imgStep));
		} catch (IOException e) {/////no sucede
			e.printStackTrace();
		} catch(java.lang.IllegalArgumentException e) {//no te obligan a controlarla, pero explota
			this.actionStep = new JButton("Step");
		} finally {
			this.actionStep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						controller.step();
					} catch (InstructionExecutionException  e1) {
						JOptionPane.showOptionDialog(null, e1.getMessage(), "",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
								null, new Object[] {"Aceptar"},"");
					} catch (ProgramEnd e1) {
						JOptionPane.showOptionDialog(null, e1.getMessage(), "",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
								null, new Object[] {"Aceptar"},"");
					}catch (InstructionMemoryException e1) {
						JOptionPane.showOptionDialog(null, e1.getMessage(), "",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
								null, new Object[] {"Aceptar"},"");
					}catch (DivByZero e1) {
						JOptionPane.showOptionDialog(null, e1.getMessage(), "",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
								null, new Object[] {"Aceptar"},"");
					}
				}
			});
		}
		Image imgRun;
		try {
			imgRun = ImageIO.read(getClass().getResource("/tp/pr5/mv/ventaner/iconos/run.png"));
			this.actionRun.setIcon(new ImageIcon(imgRun));
		} catch (IOException e) {
			e.printStackTrace();
		} catch(java.lang.IllegalArgumentException e) {//no te obligan a controlarla, pero explota
			this.actionRun = new JButton("Run");
		} finally {
			this.actionRun.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//POST-HEBRA
					worker = new Thread() {
						public void run() {
							actionStep.setEnabled(false);
							actionRun.setEnabled(false);
							actionQuit.setEnabled(false);
							actionPause.setEnabled(true);
							boolean b = true;
							while(b){
								try {
									if(b){
										b = controller.shouldKeepGoing();
										controller.step();
									}
									sleep(5);
								} catch (InterruptedException e) {
									b = false;
								} catch (InstructionExecutionException e) {
									// TODO Auto-generated catch block
									JOptionPane.showOptionDialog(null, e.getMessage(), "",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
											null, new Object[] {"Aceptar"},"");
									b = false;
									worker.interrupt();
									
									actionStep.setEnabled(true);
									actionRun.setEnabled(true);
									actionPause.setEnabled(false);
									actionQuit.setEnabled(true);
									
								} catch (InstructionMemoryException e) {
									// TODO Auto-generated catch block
									JOptionPane.showOptionDialog(null, e.getMessage(), "",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
											null, new Object[] {"Aceptar"},"");
									b = false;
									worker.interrupt();
									actionStep.setEnabled(false);
									actionRun.setEnabled(false);
									actionPause.setEnabled(false);
									actionQuit.setEnabled(true);
								} catch (DivByZero e) {
									// TODO Auto-generated catch block
									JOptionPane.showOptionDialog(null, e.getMessage(), "",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
											null, new Object[] {"Aceptar"},"");
									b = false;
									worker.interrupt();
									actionStep.setEnabled(false);
									actionRun.setEnabled(false);
									actionPause.setEnabled(false);
									actionQuit.setEnabled(true);
								} catch (ProgramEnd e) {
									// TODO Auto-generated catch block
									JOptionPane.showOptionDialog(null, e.getMessage(), "",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
											null, new Object[] {"Aceptar"},"");
									b = false;
									actionStep.setEnabled(false);
									actionRun.setEnabled(false);
									actionPause.setEnabled(false);
									actionQuit.setEnabled(true);
								}
							}
						}
					};
					worker.start();
				}
			});
		}
		
		Image imgPause;
		try {
			imgPause = ImageIO.read(getClass().getResource("/tp/pr5/mv/ventaner/iconos/pause.png"));
			this.actionPause.setIcon(new ImageIcon(imgPause));
		} catch (IOException e) {
			e.printStackTrace();
		} catch(java.lang.IllegalArgumentException e) {//no te obligan a controlarla, pero explota
			this.actionPause = new JButton("Pause");
		} finally {
			this.actionPause.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(worker != null){
						actionStep.setEnabled(true);
						actionQuit.setEnabled(true);
						worker.interrupt();
					}
					actionPause.setEnabled(false);
				}
			});
			this.actionPause.setEnabled(false);
		}

		Image imgQuit;
		try {
			imgQuit = ImageIO.read(getClass().getResource("/tp/pr5/mv/ventaner/iconos/exit.png"));
			this.actionQuit.setIcon(new ImageIcon(imgQuit));
		} catch (IOException e) {
			e.printStackTrace();
		} catch(java.lang.IllegalArgumentException e) {//no te obligan a controlarla, pero explota
			this.actionQuit = new JButton("Quit");
		} finally {
			this.actionQuit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					int seleccion = JOptionPane.showOptionDialog(null, "¿Seguro que desea abandonar la aplicacion?", "",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, new Object[] {"Cancelar", "Aceptar"},   // null para YES, NO y CANCEL
							   "");//????
					if(seleccion == 1){
						System.exit(0);
					}
				}
			});
		}
		
		this.actionStep.setActionCommand("STEP");
		this.actionRun.setActionCommand("RUN");
		this.actionPause.setActionCommand("PAUSE");
		this.actionQuit.setActionCommand("QUIT");
		
		this.setLayout(new FlowLayout());
		this.add(this.actionStep);
		this.add(this.actionRun);
		this.add(this.actionPause);
		this.add(this.actionQuit);
	}

}
