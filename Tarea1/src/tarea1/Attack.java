package tarea1;

import java.util.Set;

/**
 * Esta clase define los ataques, un tipo particular de habilidad, que puede usar un pokemon para danar a otro y eliminarlo
 * @author Ricardo Cordero
 */
public class Attack extends AbstractAbility {
	
	//Campos de la Clase
	int damage;
	
	/**
	 * Constructor de la clase
	 * @param damage Dano que hace el ataque
	 * @param description Nombre o descripcion del ataque
	 * @param cost Set con cartas de energia que se�alan el costo de energia del ataque
	 */
	public Attack(int damage, String description, Set<IEnergy> cost){
		super(description,cost);
		this.damage = damage;
	}
	
	/**
	 * Getter del campo damage
	 * @return int damage Da�o del ataque
	 */
	public int getDamage(){
		return this.damage;
	}

	/* (non-Javadoc)
	 * @see tarea1.AbstractAbility#isAttack()
	 */
	@Override
	public boolean isAttack() {
		return true;
	}
}
