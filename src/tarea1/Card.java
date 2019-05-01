package tarea1;

/**
 * Interfaz para implementar los distintos tipos de cartas, hereda a las interfaces IEnergy, IPokemon
 * @author Ricardo Cordero
 */
public interface Card {

	/**
	 * Este metodo permite saber si una carta es pokemon o energia
	 * @return true si es un pokemon
	 * 		   false en cualquier otro caso
	 */
	boolean isPokemon();

}
