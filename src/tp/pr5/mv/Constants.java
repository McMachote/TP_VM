package tp.pr5.mv;

/**
 * Contiene los mensajes a mostrar por pantalla
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Constants {
	
	public static final String LS = System.lineSeparator();
	public static final String EXE = "Instruccion a ejecutar: ";
	public static final String EXE_FAIL = "Imposible hacer: ";
	public static final String CURRENT_EXE = "Comienza la ejecucion de ";
	public static final String STATE = "El estado de la maquina tras ejecutar la instruccion es: ";
	public static final String INSTR_FAIL = "Error: Instruccion incorrecta";
	public static final String INST_EXE_FAIL = "Error ejecutando ";
	
	public static final String MACHINE_STATUS = "El estado de la maquina tras ejecutar la instruccion es:";
	public static final String PROGR_INI = "Introduce el programa fuente";
	public static final String PROG_INTRO = "El programa introducido es:";
	public static final String PROMT = "> ";
	public static final String DONT_UNDERSTOOD_COMMAND = "No lo endiendo";
	
	public static final String HELP = "usage: tp.pr3.mv.Main [-a <asmfile>] [-h] [-i <infile>] [-m <mode>] [-o <outfile>]" + LS + 
			"-a,--asm <asmfile>" + "   " + "Fichero con el codigo en ASM del programa a ejecutar. Obligatorio en modo batch." + LS +
			"-h,--help" + "   " + "Muestra esta ayuda" + LS +
			"-i,--in <infile>" + "   " + "Entrada del programa de la maquina-p." + LS +
			"-m,--mode <mode>" + "   " + "Modo de funcionamiento (batch | interactive | window). Por defecto, batch." + LS +
			"-o,--out <outfile>" + "   " + "Fichero donde se guarda la salida del programa de la maquina-p.";
	
}
