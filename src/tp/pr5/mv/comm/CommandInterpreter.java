package tp.pr5.mv.comm;

import tp.pr5.mv.CPU;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;

/**
 * Clase abstracta que representa los distintos comandos que podemos ejecutar sobre la maquina virtual.
 * De esta clase heredaran las subclases Run, Step, Steps y Quit que implementan, respectivamente,
 * los comandos con el mismo nombre.
 * Las clases Steps y Run heredan de la clase Step.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public abstract class CommandInterpreter {

	protected static CPU cpu;
	
	/**
	 * Para inicializar el valor del atributo cpu una vez que la CPU dispone del programa a ejecutar.
	 */
	public static void configureCommandInterpreter(CPU cpu){
		CommandInterpreter.cpu = cpu;
	}
	
	/**
	 * Implementaran sus distintas subclases de acuerdo con el comando que se desee ejecutar.
	 * @return true - solo si se ha ejecutado con exito
	 * @throws DivByZero 
	 * @throws InstructionMemoryException 
	 * @throws InstructionExecutionException 
	 */
	public abstract boolean executeCommand() throws InstructionExecutionException, InstructionMemoryException, DivByZero;
	
	/**
	 * Parser.
	 * @param line - String que contendra o no un comando para ejecutar.
	 * @return CommandInterpreter o null si line no se corresponde con la sintaxis de ningun comando.
	 */
	public abstract CommandInterpreter parse(String line);

	/**
	 * Obligara a redefinir el metodo toString en las distintas subclases.
	 */
	public abstract String toString();
	
}
