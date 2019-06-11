package tarea1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class PsychicPokemonTest {
	
	private ThunderboltPokemon pikachu;
    private PsychicPokemon abra;
    private Attack basicAttack;
	
	@Before
	public void setUp() throws Exception {
		basicAttack = new Attack(40,"Basic Attack", new HashSet<IEnergy>());
		pikachu = new ThunderboltPokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)));
		abra = new PsychicPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)));
	}

	@Test
	public void testAttack() {
		assertEquals(100,pikachu.getHp());
        abra.selectAttack(0);
        abra.attack(pikachu);
        assertEquals(60,pikachu.getHp());
	}

	@Test
	public void testReceiveFightDamage() {
		assertEquals(100,abra.getHp());
        abra.receiveFightDamage(basicAttack);
        assertEquals(90,abra.getHp());
	}

	@Test
	public void testReceivePsychicDamage() {
		assertEquals(100,abra.getHp());
        abra.receivePsychicDamage(basicAttack);
        assertEquals(20,abra.getHp());
	}

}
