package tarea1;

/**
 * Clase abstracta que permite implementar las energias, hereda a PlantEnergy, FireEnregy, WaterEnergy, ThunderboltEnregy, FightEnergy, PsychicEnergy
 * @author Ricardo Cordero
 */
public abstract class AbstractEnergy implements IEnergy {

	//Campos de la clase
	int quantity;

	/**
	 * Constructor de la clase abstracta
	 * @param quantity Cantidad de energias que tiene la carta generada
	 */
	public AbstractEnergy(int quantity) {
		this.quantity = quantity;
	}

    /* (non-Javadoc)
     * @see tarea1.IEnergy#getQuantity()
     */
    @Override
    public int getQuantity() {
        return this.quantity;
    }
    
    /* (non-Javadoc)
     * @see tarea1.Card#isPokemon()
     */
    @Override
	public boolean isPokemon(){
		return false;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o.getClass() == this.getClass();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return 0;
    }
}
