package tarea1;

import java.util.List;

/**
 * Clase que genera los pokemones tipo fuego
 * @author Ricardo Cordero
 */
public class FirePokemon extends AbstractPokemon {

	/**
     * Constructor de la clase
     * @param id Numero de identificacion del pokemon
     * @param hp Puntos de vida
     * @param list Lista de los ataques
     */
	public FirePokemon(int id, int hp, List<IAbility> list) {
		super(id, hp, list);
	}

	/* (non-Javadoc)
	 * @see tarea1.AbstractPokemon#attack(tarea1.IPokemon)
	 */
	@Override
	public void attack(IPokemon objective) {
		objective.receiveFireDamage(this.selectedAttack);
	}
	
	/* (non-Javadoc)
	 * @see tarea1.AbstractPokemon#receiveWaterDamage(tarea1.Attack)
	 */
	@Override
	public void receiveWaterDamage(Attack attack){
		this.hp -= attack.getDamage() * 2;
	}
}
