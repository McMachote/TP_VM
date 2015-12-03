package tp.pr5.mv;


import tp.pr5.mv.MVC.BatchView;
import tp.pr5.mv.MVC.InteractiveView;
import tp.pr5.mv.MVC.View;
import tp.pr5.mv.MVC.Controllers.*;
import tp.pr5.mv.exceptions_mv.*;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.instrategys.InStrategyLoader;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategyLoader;
import tp.pr5.mv.ventaner.Ventana;

import java.io.EOFException;
import java.io.IOException;

import org.apache.commons.cli.*;

/**
 * Main
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Main {

	public static void main(String[] args) {
		CPU              cpu = new CPU();
		ProgramMV        pmv = null;
		InStrategy       inS = null;
		OutStrategy     outS = null;
		View               v = null;
		
		// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Para parser de org.apache.commons.cli
		CommandLineParser parser = null;
		CommandLine cmdLine      = null;
		// Configurar opciones de validacion de entrada.

		Options options = new Options();
		options.addOption("a", "asm" , true, "--asm <asmfile>");
		options.addOption("h", "help", false, "--help");
		options.addOption("i", "in"  , true, "--in <infile>");
		options.addOption("m", "mode", true, "--mode <mode>");
		options.addOption("o", "out" , true, "--out <outfile>");
		// Opciones que no pueden aparecen simultaneamente
		OptionGroup group = new OptionGroup();
		group.addOption(new Option("batch", "Salida estandar de errores"));
		group.addOption(new Option("interactive", "Salida estandar"));
		group.addOption(new Option("window", "Aplicacion grafica"));
		options.addOptionGroup(group);
		String  asm     = null;
		String  infile  = null;
		String  mode    = "batch";
		String  outfile = null;
		boolean hasASM  = false;
		boolean hasMODE = false;
		boolean hasIN   = false;
		boolean hasOUT  = false;
		boolean hasHelp = true;
		try {
			parser  = new BasicParser();
			cmdLine = parser.parse(options, args);
			hasHelp = cmdLine.hasOption("-h");
			if (hasHelp) {
				System.out.println(Constants.HELP);//err?
			} else {
				hasASM = cmdLine.hasOption("a");
				if (hasASM) {
					asm = cmdLine.getOptionValue("a");
				}
				hasMODE = cmdLine.hasOption("m");
				if (hasMODE) {
					mode = cmdLine.getOptionValue("m");
					if (!mode.equalsIgnoreCase("batch")
							&& !mode.equalsIgnoreCase("interactive")
							&& !mode.equalsIgnoreCase("window")) {
						throw new org.apache.commons.cli.ParseException(
								"Modo incorrecto (parametro -m|--mode)");
					}
				}
				hasIN = cmdLine.hasOption("i");
				if (hasIN) {
					infile = cmdLine.getOptionValue("i");
				}
				hasOUT = cmdLine.hasOption("o");
				if (hasOUT) {
					outfile = cmdLine.getOptionValue("o");
				}
				if (!hasASM && !mode.equalsIgnoreCase("WINDOW")) {
					throw new ASM_Exception();
				}
				InStrategyLoader inSLoader = new InStrategyLoader(infile, mode);
				inS = inSLoader.getStrategy();
				OutStrategyLoader outSLoader = new OutStrategyLoader(outfile, mode);
				outS = outSLoader.getOutStrategy();
				ProgramLoader pld = new ProgramLoader(hasASM, mode, asm);
				pmv = pld.getProgram();
				cpu.loadProgram(pmv);
				cpu.loadStrategys(inS, outS);
				ejecutar(mode, cpu, v);
			}
		} catch (ASM_Exception asme) {
			System.err.println(asme.getMessage());
			System.exit(2);
		} catch (org.apache.commons.cli.ParseException ex) {
			String s = "";
			boolean check = false;
			for(int i = 0; i < args.length; i++){
				s = args[i];
				if(s.equalsIgnoreCase("-h") || s.equalsIgnoreCase("--help")){
					check = true;
					System.out.println(Constants.HELP);
				}
			}
			if(!check){
				System.err.println("Uso incorrecto: " + ex.getMessage()
						+ Constants.LS + "Use -h|--help para mas detalles.");
			}
			System.exit(1);
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}		
		// TE HEND
	}

	private static void ejecutar(String mode, CPU cpu, View v) {
		//IObserver vista = null;
		if (mode.equalsIgnoreCase("INTERACTIVE")) {
			//cntrl = new InteractiveController(cpu);
			v = new InteractiveView(new InteractiveController(cpu));
		} else if (mode.equalsIgnoreCase("BATCH")) {
			//cntrl = new BController(cpu);
			v = new BatchView(new BController(cpu));
		} else if(mode.equalsIgnoreCase("WINDOW")){
			//cntrl = new WController(cpu);
			v = new Ventana(new WController(cpu));
		}
		v.run();
	}

}
