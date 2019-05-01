package tarea1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Clase abstracta que permite generar a lo pokemones existentes, hereda a PlantPokemon, FirePokemon, WaterPokemon, ThunderboltPokemon, FightPokemon, PsychicPokemon
 * @author Ricardo Cordero
 */
public abstract class AbstractPokemon implements IPokemon {
	 //Campos de la clase
	int id;
	int hp;
	Map<IEnergy,Integer> energies;
	List<IAbility> abilitiesList;
	Attack selectedAttack;
	
	/**
	 * Constructor de la clase abstracta
	 * @param id Numero identificatorio de un pokemon
	 * @param hp Puntos de vida de un pokemon
	 * @param list Lista con las habilidades de un pokemon, maximo puede tener 4 habilidades
	 */
	public AbstractPokemon(int id, int hp, List<IAbility> list){
		this.id = id;
		this.hp = hp;
		this.abilitiesList = list;
		this.energies = new HashMap<>();
		this.selectedAttack = null;
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#getId()
	 */
	@Override
	public int getId(){
		return this.id;
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#getHp()
	 */
	@Override
	public int getHp(){
		return this.hp;		
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#getEnergies()
	 */
	@Override
	public Map<IEnergy, Integer> getEnergies(){
		return this.energies;
	}
	
	/* (non-Javadoc)
	 * @see tarea1.IPokemon#addEnergy(tarea1.IEnergy)
	 */
	@Override
	public void addEnergy(IEnergy energy){
		if(this.energies.get(energy) != null){
			int amount = this.energies.get(energy);
			this.energies.put(energy, energy.getQuantity() + amount);
		}
		else{
			this.energies.put(energy, energy.getQuantity());
		}
	}
	
	/* (non-Javadoc)
	 * @see tarea1.Card#isPokemon()
	 */
	@Override
	public boolean isPokemon(){
		return true;
	}
	
	/* (non-Javadoc)
	 * @see tarea1.IPokemon#selectAttack(int)
	 */
	@Override
	public boolean selectAttack(int index){
		if (!this.abilitiesList.get(index).isAttack()){
			return false;
		}
		this.selectedAttack = (Attack) this.abilitiesList.get(index);
		Iterator<IEnergy> i = this.selectedAttack.cost.iterator(); 
		while(i.hasNext()){
			IEnergy energy = i.next();
			if (!this.energies.containsKey(energy)){
				this.selectedAttack = null;
				return false;
			}
			if (energy.getQuantity() > this.energies.get(energy)){
				this.selectedAttack = null;
				return false;
			}
		}
		return true;
		
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#attack(tarea1.IPokemon)
	 */
	@Override
	public abstract void attack(IPokemon objective);
	
	/* (non-Javadoc)
	 * @see tarea1.IPokemon#receivePlantDamage(tarea1.Attack)
	 */
	@Override
	public void receivePlantDamage(Attack attack){
		this.hp -= attack.getDamage();
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#receiveFireDamage(tarea1.Attack)
	 */
	@Override
	public void receiveFireDamage(Attack attack){
		this.hp -= attack.getDamage();
	}
	
	/* (non-Javadoc)
	 * @see tarea1.IPokemon#receiveWaterDamage(tarea1.Attack)
	 */
	@Override
	public void receiveWaterDamage(Attack attack){
		this.hp -= attack.getDamage();
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#receiveThunderboltDamage(tarea1.Attack)
	 */
	@Override
	public void receiveThunderboltDamage(Attack attack){
		this.hp -= attack.getDamage();
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#receiveFightDamage(tarea1.Attack)
	 */
	@Override
	public void receiveFightDamage(Attack attack){
		this.hp -= attack.getDamage();
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#receivePsychicDamage(tarea1.Attack)
	 */
	@Override
	public void receivePsychicDamage(Attack attack){
		this.hp -= attack.getDamage();
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#getAbilityList()
	 */
	@Override
	public List<IAbility> getAbilityList() {
		return abilitiesList;
	}

	/* (non-Javadoc)
	 * @see tarea1.IPokemon#getSelectedAttack()
	 */
	@Override
	public Attack getSelectedAttack() {
		return selectedAttack;
	}
}
