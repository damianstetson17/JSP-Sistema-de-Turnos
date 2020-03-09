package errores;

public class NotificarError extends Exception {

	/**
	 * 
     * @param mensaje
	 */
	private static final long serialVersionUID = -8452776403143587365L;

	public NotificarError(String mensaje) {
		super(mensaje);
	}
}
