package tp.pr5.mv.MVC;

import tp.pr5.mv.MVC.Controllers.InteractiveController;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;

public class InteractiveView implements View {

	private InteractiveController cntrl;

	public InteractiveView(InteractiveController cntrl) {
		this.cntrl = cntrl;
		this.cntrl.addObs(this);
	}

	@Override
	public void run() {
		try {
			this.cntrl.run();
		} catch (InstructionExecutionException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (InstructionMemoryException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (DivByZero e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		this.cntrl.quit();
	}

	@Override
	public void showStatus(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

	@Override
	public void onClear() {
		// TODO Auto-generated method stub

	}

}
