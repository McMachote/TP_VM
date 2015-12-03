package tp.pr5.mv;

/**
 * Atomic element of Memory that contains value and position
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class MemoryCell {
	
	private int contenido;
	private int posicion;
	
	/**
	 * Constructor parametrizado
	 * @param contenido - Dato a almacenar
	 * @param posicion - "posicion" de memoria en la que se insertara...
	 * 					 En realidad solo determina el orden de los elementos de la memoria
	 */
	public MemoryCell(int contenido, int posicion){
		this.posicion = posicion;
		this.contenido = contenido;
	}
		
	/**
	 * Getter.
	 * Se utiliza en el comparator<MemoryCell> de Memory
	 * @return contenido
	 */
	public int getContenido(){
		return this.contenido;
	}
	
	/**
	 * Getter.
	 * @return posicion
	 */
	public int getPos(){
		return this.posicion;
	}
	
	/**
	 * Redefinition of equals() necesary for contains and other similar
	 * methods which uses this implementation.
	 * No utilizare el contains() en memoria
	 * @return true only if position and conten are both similar
	 * @see also Memory.buscaPosInsert()
	 */
	public boolean equals(MemoryCell mc){
		return this.contenido == mc.getContenido() && this.posicion == mc.getPos();
	}
	
}