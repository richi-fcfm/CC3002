package tarea1;

import java.util.List;

/**
 * Clase que genera los pokemones tipo psiquico
 * @author Ricardo Cordero
 */
public class PsychicPokemon extends AbstractPokemon {

	/**
     * Constructor de la clase
     * @param id Numero de identificacion del pokemon
     * @param hp Puntos de vida
     * @param list Lista de los ataques
     */
    public PsychicPokemon(int id, int hp, List<IAbility> list) {
        super(id, hp, list);
    }

    /* (non-Javadoc)
     * @see tarea1.AbstractPokemon#attack(tarea1.IPokemon)
     */
    @Override
    public void attack(IPokemon objective) {
        objective.receivePsychicDamage(this.selectedAttack);
    }

    /* (non-Javadoc)
     * @see tarea1.AbstractPokemon#receiveFightDamage(tarea1.Attack)
     */
    @Override
    public void receiveFightDamage(Attack attack) {
        this.hp -= attack.getDamage() - 30;
    }

    /* (non-Javadoc)
     * @see tarea1.AbstractPokemon#receivePsychicDamage(tarea1.Attack)
     */
    @Override
    public void receivePsychicDamage(Attack attack) {
        this.hp -= attack.getDamage() * 2;
    }
}
