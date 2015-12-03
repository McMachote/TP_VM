package tp.pr5.mv.comm;

import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.ins.Watch;
import tp.pr5.mv.ins.restSeq.Pop;
import tp.pr5.mv.ins.restSeq.Push;
import tp.pr5.mv.ins.restSeq.Write;

/**
 * Clase que implementa comandos auxiliares para annadir mas funcionalidad a la maquina.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Debug extends CommandInterpreter{

	/**
	 * Instrucciones que se pueden llamar desde este comando
	 */
	private static final Instruction[] tipo ={
		new Pop(), new Push(), new Write(), new Watch()
		//write no protegido para escrituras en posiciones negativas de memoria
	};
	
	private Instruction instr;
	
	/**
	 * Default constructor.
	 */
	public Debug(){
		super();
	}
	
	/**
	 * Constructor parametrizado.
	 * @param instr - Instruccion que ejecutara.
	 */
	public Debug(Instruction instr){
		this.instr = instr;
	}

	/**
	 * Ejecutar.
	 * @throws DivByZero 
	 * @throws InstructionMemoryException 
	 * @throws InstructionExecutionException 
	 */
	public boolean executeCommand() throws InstructionExecutionException, InstructionMemoryException, DivByZero {
		return cpu.step(this.instr);
	}

	/**
	 * Parser.
	 */
	public CommandInterpreter parse(String line){
		CommandInterpreter ci = null;
		boolean stop = false;
		int i = 0;
		Instruction instr = null;
		while (i < tipo.length && !stop){
			instr = tipo[i].parse(line);
			if(instr != null){
				stop = true;
				ci = new Debug(instr);
			}
			else{
				i++;
			}
		}
		return ci;
	}

	/**
	 * Sobreescritura toString().
	 */
	public String toString(){
		return this.instr.toString();
	}

}
