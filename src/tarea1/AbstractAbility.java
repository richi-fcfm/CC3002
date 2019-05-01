package tarea1;

import java.util.Set;

/**
 * Clase abstracta que define las habilidades de un pokemon, hereda a la clase Attack
 * @author Ricardo Cordero
 */
public abstract class AbstractAbility implements IAbility {
	
	//Campos de la clase
	String description;
	Set<IEnergy> cost;
	
	/**
	 * Constructor de la clase abstracta
	 * @param description Descripcion o nombre de la habilidad
	 * @param cost Set de energias que representan el costo de utilizar la habilidad
	 */
	public AbstractAbility(String description, Set<IEnergy> cost){
		this.description = description;
		this.cost = cost;
	}

	/* (non-Javadoc)
	 * @see tarea1.IAbility#getDescription()
	 */
	@Override
	public String getDescription(){
		return description;
	}

	/* (non-Javadoc)
	 * @see tarea1.IAbility#getCost()
	 */
	@Override
	public Set<IEnergy> getCost() {
		return cost;
	}

	/* (non-Javadoc)
	 * @see tarea1.IAbility#isAttack()
	 */
	@Override
	public abstract boolean isAttack();
}
