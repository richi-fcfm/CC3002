package tarea1;

import java.util.Set;

/**
 * Interfaz para implementar las distintas habilidades que podrian haber en el juego, implementada por la clase AbstractAbility
 * @author Ricardo Cordero
 */
public interface IAbility {

    /**
     * Metodo getter de la descripcion de la habilidad
     * @return String Descripcion de la habilidad
     */
    String getDescription();

	/**
	 * Metodo que comprueba si un habilidad es un ataque o no
	 * @return true en caso que sea un ataque
	 * 		   false en cualquier otro caso
	 */
	boolean isAttack();

    /**
     * Metodo getter del set de energias que son el costo de la habilidad
     * @return Set<IEnergy> Set de energias del costo
     */
    Set<IEnergy> getCost();
}
