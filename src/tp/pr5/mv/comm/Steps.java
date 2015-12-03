package tp.pr5.mv.comm;

import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;

/**
 * Hace lo mismo que la clase Step, pero n veces
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Steps extends Step {

	private int n;
	
	/**
	 * Constructor por defecto necesario para crear array de CommandInterpreter en CommandParser
	 */
	public Steps(){
		super();
	}
	
	/**
	 * Constructor parametrizado.
	 * @param int n - numero de veces que se ejecutara step
	 */
	public Steps(int n){
		super();
		this.n = n;
	}
	
	/**
	 * Sobreescritura metodo toString().
	 */
	@Override
	public String toString(){
		return "STEPS";
	}

	/**
	 * Ejecutar steps n es lo mismo que ejecutar step n veces.
	 * @throws DivByZero 
	 * @throws InstructionMemoryException 
	 * @throws InstructionExecutionException 
	 */
	@Override
	public boolean executeCommand() throws InstructionExecutionException, InstructionMemoryException, DivByZero {
		boolean check = true;
		int i = 0;
		Step paso = new Step();
		while(i < this.n && check){// && !cpu.isHalted()){
			check = paso.executeCommand();
			i++;
		}
		return check;
	}

	/**
	 * Parser.
	 */
	public CommandInterpreter parse(String line){
		CommandInterpreter ci = null;
		String[] ld = line.split(" ");
		if(ld.length == 2 && ld[0].equalsIgnoreCase("STEP")){
			try{
				int a = Integer.parseInt(ld[1]);
				if(a > 0){
					ci = new Steps(a);
			}
			}catch(NumberFormatException nfe){}
		}
		return ci;
	}
	
}
