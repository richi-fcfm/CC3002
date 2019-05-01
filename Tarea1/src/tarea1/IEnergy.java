package tarea1;

/**
 * Interfaz para implementar los distintos tipos de energias, es implementada por la clase abstracta AbstractEnergy
 * @author Ricardo Cordero
 */
public interface IEnergy extends Card {

	/**
	 * Metodo getter para obtener la cantidad de energias que representa cada carta
	 * @return int Cantidad de energias
	 */
	int getQuantity();
}
