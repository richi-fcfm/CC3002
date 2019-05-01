package tarea1;

import java.util.List;
import java.util.Map;

/**
 * Interfaz para implemntar los tipos de pokemon que existen, implementada por la clase abstracta AbstractPokemon
 * @author Ricardo Cordero
 */
public interface IPokemon extends Card {

	/**
	 * Metodo getter del numero de identidad del pokemon
	 * @return int Numero identificatorio
	 */
	int getId();
	
	/**
	 * Metodo getter de los puntos de vida del pokemon
	 * @return int Puntos de vida del pokemon
	 */
	int getHp();

    /**
     * Metodo getter de la cantidad de cada tipo de energia que se ha a�adido al pokemon
     * @return Map Mapa con energias y sus cantidades
     */
    Map<IEnergy, Integer> getEnergies();

    /**
     * Metodo para anadir una energia nueva al pokemon
     * @param energy Carta de energia a anadir
     */
    void addEnergy(IEnergy energy);
	
	/**
	 * Metodo para seleccionar una ataque de lista de habilidades del pokemon
	 * @param index Indice del ataque en la lista
	 * @return true si el ataque pudo ser seleccionado
	 * 		   false en cualquier otro caso
	 */
	boolean selectAttack(int index);
	
	/**
	 * Metodo para que el pokemon ataque a otro pokemon con su ataque selecionado
	 * @param objective Pokemon objetivo
	 */
	void attack(IPokemon objective);
	
	/**
	 * Metodo para que el pokemon reciba dano del ataque de un pokemon tipo planta
	 * @param attack Ataque que recibio el pokemon
	 */
	void receivePlantDamage(Attack attack);
	
	/**
	 * Metodo para que el pokemon reciba dano del ataque de un pokemon tipo fuego
	 * @param attack Ataque que recibio el pokemon
	 */
	void receiveFireDamage(Attack attack);
	
	/**
	 * Metodo para que el pokemon reciba dano del ataque de un pokemon tipo agua
	 * @param attack Ataque que recibio el pokemon
	 */
	void receiveWaterDamage(Attack attack);
	
	/**
	 * Metodo para que el pokemon reciba dano del ataque de un pokemon tipo rayo
	 * @param attack Ataque que recibio el pokemon
	 */
	void receiveThunderboltDamage(Attack attack);
	
	/**
	 * Metodo para que el pokemon reciba dano del ataque de un pokemon tipo lucha
	 * @param attack Ataque que recibio el pokemon
	 */
	void receiveFightDamage(Attack attack);
	
	/**
	 * Metodo para que el pokemon reciba dano del ataque de un pokemon tipo psiquico
	 * @param attack Ataque que recibio el pokemon
	 */
	void receivePsychicDamage(Attack attack);

	/**
	 * Metodo getter de la lista de habilidades del pokemon
	 * @return List<IAbility> Lista con las habilidades del pokemon, maximo 4 habilidades
	 */
	List<IAbility> getAbilityList();

	/**
	 * Metodo getter del ataque actualmente seleccionado del pokemon
	 * @return Attack Ataque selecionado
	 */
	Attack getSelectedAttack();
}
