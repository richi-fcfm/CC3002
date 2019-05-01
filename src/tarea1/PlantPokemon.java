package tarea1;

import java.util.List;

/**
 * Clase que genera los pokemones tipo planta
 * @author Ricardo Cordero
 */
public class PlantPokemon extends AbstractPokemon {

	/**
     * Constructor de la clase
     * @param id Numero de identificacion del pokemon
     * @param hp Puntos de vida
     * @param list Lista de los ataques
     */
	public PlantPokemon(int id, int hp, List<IAbility> list){
		super(id,hp,list);
	}
	
	/* (non-Javadoc)
	 * @see tarea1.AbstractPokemon#attack(tarea1.IPokemon)
	 */
	@Override
	public void attack(IPokemon objective){
		objective.receivePlantDamage(this.selectedAttack);
	}
	
	/* (non-Javadoc)
	 * @see tarea1.AbstractPokemon#receiveFireDamage(tarea1.Attack)
	 */
	@Override
	public void receiveFireDamage(Attack attack){
		this.hp -= attack.getDamage() * 2;
	}
	
	/* (non-Javadoc)
	 * @see tarea1.AbstractPokemon#receiveWaterDamage(tarea1.Attack)
	 */
	@Override
	public void receiveWaterDamage(Attack attack){
		this.hp -= attack.getDamage() - 30;
	}
}
