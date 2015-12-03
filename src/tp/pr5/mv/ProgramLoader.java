package tp.pr5.mv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import tp.pr5.mv.exceptions_mv.ASM_Exception;
import tp.pr5.mv.ins.Instruction;


/**
 * Mas apropiado PROGRAM_PARSER
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 *
 */
public class ProgramLoader {

	private ProgramMV pmv;

	public ProgramMV getProgram(){
		return this.pmv;
	}

	public ProgramLoader(boolean checkASM, String mode, String asm)
			throws ASM_Exception, IOException {
		Scanner sc = new Scanner(System.in);
		String linea = "";
		Instruction instr = null;
		this.pmv = new ProgramMV();
		if(mode.equalsIgnoreCase("BATCH")){
			if(checkASM){
				File archivo = null;
				FileReader fr = null;
				BufferedReader br = null;
				try{
					archivo = new File (asm);
					fr = new FileReader (archivo);
					br = new BufferedReader(fr);
					while(br.ready()){
						linea = br.readLine();
						char mander;
						if(!linea.equalsIgnoreCase("")){
							mander = linea.charAt(0);
							if(mander != ';'){
								instr = InstructionParser.parse(linea, mode);
								if(instr != null){
									this.pmv.addInstruction(instr);
								}
								else if(instr == null && !linea.equalsIgnoreCase("END")){
					                System.out.println(Constants.INSTR_FAIL);
					            }
							}
						}
					}
					//MOSTRAR PROGRAMA INTRODUCIDO
					System.out.println(Constants.PROG_INTRO);
					System.out.println(this.pmv);
					fr.close();
					br.close();
				}catch(FileNotFoundException e){
					System.err.println( "Uso incorrecto: Error al acceder al fichero asm " + asm + ". No existe." +
										Constants.LS + "Use -h|--help para mas detalles.");
				}catch(IOException e){
					System.out.println("pim pam pum! esta no te la esperabas!");
					fr.close();
					br.close();
				}
			}
			else{
				System.out.println(" kaboom");
			}
		}
		else if(mode.equalsIgnoreCase("INTERACTIVE") || mode.equalsIgnoreCase("WINDOW")){
			if(!checkASM && mode.equalsIgnoreCase("INTERACTIVE")){////////////////////////////////////////////interactivo sin asm
				System.out.println(Constants.EXE);
				do{
					System.out.print(Constants.PROMT);
					linea = sc.nextLine();
					instr = InstructionParser.parse(linea, mode);
					if(instr != null){
						this.pmv.addInstruction(instr);
					}
					else if(instr == null && !linea.equalsIgnoreCase("END")){
		                System.out.println(Constants.INSTR_FAIL);//se puede equivocar, no termina instruccion, pide nueva
		            }
				}while(!linea.equalsIgnoreCase("END"));
			}
			else if(!checkASM && mode.equalsIgnoreCase("WINDOW")){
				//no WINDOW sin ASM
				JOptionPane.showMessageDialog(null,
						"Error: Modo window sin fichero ASM",
						"Error",//xD
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			else if(checkASM && (mode.equalsIgnoreCase("INTERACTIVE") || mode.equalsIgnoreCase("WINDOW") )){////////////////////////////////////////////////interactivo con asm
				File archivo = null;
				FileReader fr = null;
				BufferedReader br = null;
				try{
					archivo = new File (asm);
					fr = new FileReader (archivo);
					br = new BufferedReader(fr);
					char mander;
					do{
						linea = br.readLine();
						if(!linea.equalsIgnoreCase("")){
							mander = linea.charAt(0);
							if(mander != ';'){
								instr = InstructionParser.parse(linea, mode);
								if(instr != null){
									this.pmv.addInstruction(instr);
								}
								else if(instr == null && !linea.equalsIgnoreCase("END") && !linea.equalsIgnoreCase("")){
					                if(mode.equalsIgnoreCase("INTERACTIVE")){
					                	System.out.println(Constants.INSTR_FAIL);
									}
					                else{
					                	JOptionPane.showMessageDialog(null,
												"ASM Error",//xD
												"Error",
												JOptionPane.ERROR_MESSAGE);
					                	System.exit(1);
					                }
					            }
							}
						}
					}while(br.ready());
					fr.close();
					br.close();
				}catch(FileNotFoundException e){
					if(mode.equalsIgnoreCase("WINDOW")){
						JOptionPane.showMessageDialog(null,
								"Error 404 - ASM not found",//xD
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						System.err.println( "Uso incorrecto: Error al acceder al fichero asm " + asm + ". No existe." +
											Constants.LS + "Use -h|--help para más detalles.");
					}
					System.exit(1);
				}catch(IOException e){//no sucede con ninguna ejecucion, por ahora...
					System.out.println("pim pam pum! esta no te la esperabas!");
					fr.close();
					br.close();
				}
				if(mode.equalsIgnoreCase("INTERACTIVE")){
					//MOSTRAR PROGRAMA INTRODUCIDO
					System.out.println(Constants.PROG_INTRO);
					System.out.println(this.pmv);
				}
			}
		//sc.close();//KABOOOOM!!!! 
		}
	}
}
