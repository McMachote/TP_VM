package tp.pr5.mv.comm;

/**
 * Clase que se encarga de generar los comandos.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class CommandParser {

	/**
	 * Default constructor
	 */
	public CommandParser(){}
	
	/**
	 * Array de clases por defecto para comparar en el parseo
	 */
	private static final CommandInterpreter[] commands = {
		new Run(), new Quit(), new Step(), new Steps(), new Debug()
	};
	
	/**
	 * Procesa el string de entrada y o bien devuelve un objeto de la clase CommandInterpreter o null
	 * en caso de que la linea de entrada no se corresponda con ningun comando.
	 * @param line - String de entrada
	 * @return CommandInterpreter - Comando a ejecutar
	 */
	public static CommandInterpreter parseCommand (String line) {
		CommandInterpreter ci = null;
		boolean stop = false;
		int i = 0;
		while (i < commands.length && !stop){
			ci = commands[i].parse(line);
			if (ci != null)
				stop = true;
			else
				i++;
		}
		return ci;
	}
	
}
