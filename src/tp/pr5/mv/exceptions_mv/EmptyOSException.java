package tp.pr5.mv.exceptions_mv;

public class EmptyOSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyOSException(){
		super("Pila vacia");
	}

}
