package tp.pr5.mv.ventaner.restoV.cpuV;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import tp.pr5.mv.MVC.Controllers.WController;
import tp.pr5.mv.MVC.IObservers.MemoryObserver;

public class MemoryStatePanel extends JPanel implements MemoryObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel memoryTable;
	private MemoryControlPanel mcp;
	private String column_names[]= {"DIRECCION", "VALOR"};
	private JTable t;
	private JScrollPane sp;
	private WController cntrl;

	public MemoryStatePanel(WController cntrl){
		this.cntrl = cntrl;
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("Memoria de la maquina"));
		this.memoryTable = new DefaultTableModel(column_names, 0);
		this.t = new JTable(memoryTable){
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		t.getColumnModel().getColumn(0).setCellRenderer(dtcr);
		t.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		this.sp = new JScrollPane(this.t);
		this.mcp = new MemoryControlPanel(this.cntrl);
		this.add(this.sp, BorderLayout.CENTER);
		this.add(this.mcp, BorderLayout.SOUTH);
	}
	
	public void onStore(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if(cntrl.memoryString() != ""){
					memoryTable.getDataVector().removeAllElements();
					String line[] = cntrl.memoryString().split(";");
					for(int i = 0; i < line.length; i++){
						String s[]       = line[i].split(",");
						Integer position = Integer.parseInt(s[0]);
						Integer value    = Integer.parseInt(s[1]);
						Vector<Integer> rowData = new Vector<Integer>();
						rowData.add(position);
						rowData.add(value);
						memoryTable.addRow(rowData);
					}
				}
			}
		});
	}
	
}
