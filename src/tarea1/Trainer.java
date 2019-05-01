package tarea1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Clase que define a los entrenadores pokemon, los que pueden enfrentarse entre ellos
 * @author Ricardo
 */
public class Trainer {

	//Campos de la clase
	IPokemon active;
	Queue<IPokemon> bench;
	List<Card> hand;
	Card selectedCard;
	
	/**
	 * Constructor de la clase
	 * @param active Pokemon inicial y activo del entrenador
	 * @param list Lista de cartas en la mano del entrenador
	 */
	public Trainer(IPokemon active,List<Card> list){
		this.active = active;
		this.bench = new LinkedList<IPokemon>();
		this.hand = list;
		this.selectedCard = null;
	}
	
	/**
	 * Getter de la mano del entrenador
	 * @return List<Card> Mano del entrenador
	 */
	public List<Card> getHand(){
		return this.hand;
	}
	
	/**
	 * Getter de la banca de pokemones del entrenador
	 * @return Queue<IPokemon> Banca de pokemones
	 */
	public Queue<IPokemon> getBench(){
		return this.bench;
	}
	
	/**
	 * Getter del pokemon activo en el campo del etrenador
	 * @return IPokemon Pokemon activo
	 */
	public IPokemon getActivePokemon(){
		return this.active;
	}
	
	/**
	 * Getter de la carta seleccionada de la mano para ser la proxima en jugar 
	 * @return Card Carta seleccionada
	 */
	public Card getSelectedCard(){
		return this.selectedCard;
	}
	
	/**
	 * Metodo permite seleccionar una carta de la mano, segun el indice de su posicion en la lista de la mano
	 * @param index Indice de posicion en la lista
	 */
	public void selectCardFromHand(int index){
		if(this.selectedCard != null){
			Card temporal = this.selectedCard;
			this.selectedCard = hand.get(index);
			this.hand.remove(index);
			this.hand.add(temporal);
		}
		else{
			this.selectedCard = hand.get(index);
			this.hand.remove(index);
		}
	}
	
	/**
	 * Permite jugar la ultima carta seleccionada por el entrenador
	 * @return true si es que se pudo jugar la carta
	 * 		   false en caso de que no se pueda jugar por estar llena la banca
	 */
	public boolean playCard(){
		if (this.selectedCard == null){
			return false;
		}
		if(!this.selectedCard.isPokemon()){
			this.active.addEnergy((IEnergy) this.selectedCard);
			this.selectedCard = null;
			return true;
		}
		if (this.selectedCard.isPokemon() && this.bench.size() < 5){
			this.bench.add((IPokemon) this.selectedCard);
			this.selectedCard = null;
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que permite a un entrenador atacar con su pokemon activo al pokemon activo del entrenador rival
	 * @param enemy Entrenador rival
	 * @param index Indice del ataque en la lista de ataques del pokemon activo
	 */
	public void attack(Trainer enemy, int index){
		this.active.selectAttack(index);
		this.active.attack(enemy.active);
		if (enemy.active.getHp() <= 0){
			enemy.active = enemy.bench.poll();
		}
	}
}
