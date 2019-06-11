package tarea1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class PlantPokemonTest {
	
	private ThunderboltPokemon pikachu;
    private PlantPokemon bulbasaur;
    private Attack basicAttack;

	@Before
	public void setUp() throws Exception {
		basicAttack = new Attack(40,"Basic Attack", new HashSet<IEnergy>());
		pikachu = new ThunderboltPokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)));
		bulbasaur = new PlantPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)));
	}

	@Test
	public void testAttack() {
		assertEquals(100,pikachu.getHp());
        bulbasaur.selectAttack(0);
        bulbasaur.attack(pikachu);
        assertEquals(60,pikachu.getHp());
	}

	@Test
	public void testReceiveFireDamage() {
		assertEquals(100,bulbasaur.getHp());
        bulbasaur.receiveFireDamage(basicAttack);
        assertEquals(20,bulbasaur.getHp());
	}

	@Test
	public void testReceiveWaterDamage() {
		assertEquals(100,bulbasaur.getHp());
        bulbasaur.receiveWaterDamage(basicAttack);
        assertEquals(90,bulbasaur.getHp());
	}

}
