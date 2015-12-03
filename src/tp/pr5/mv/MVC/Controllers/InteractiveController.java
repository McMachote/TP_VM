package tp.pr5.mv.MVC.Controllers;

import java.util.Scanner;

import tp.pr5.mv.CPU;
import tp.pr5.mv.Constants;
import tp.pr5.mv.MVC.View;
import tp.pr5.mv.comm.CommandInterpreter;
import tp.pr5.mv.comm.CommandParser;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;

public class InteractiveController implements Controller {

	private CommandInterpreter ci;
	private CPU cpu;
	
	public InteractiveController(CPU cpu) {
		this.cpu = cpu;
		this.ci = null;
		//CommandInterpreter.configureCommandInterpreter(cpu);
	}

	public void run() throws InstructionExecutionException, InstructionMemoryException, DivByZero{
		CommandInterpreter.configureCommandInterpreter(this.cpu);
		Scanner sc_aux = new Scanner(System.in);
		String linea = "";
		do {
			System.out.print("> ");
			linea = sc_aux.nextLine();
			ci = CommandParser.parseCommand(linea);
			if (ci != null) {//kk
				ci.executeCommand();
			} else {
				System.out.println(Constants.DONT_UNDERSTOOD_COMMAND);
			}
		} while (!linea.equalsIgnoreCase("QUIT") && !cpu.isHalted());
		sc_aux.close();
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	public void addObs(View v) {
		this.cpu.addObs(v);
	}

}
