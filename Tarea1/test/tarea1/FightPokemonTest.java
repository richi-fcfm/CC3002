package tarea1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class FightPokemonTest {
	
	private FirePokemon charmander;
    private FightPokemon mankey;
    private Attack basicAttack;

	@Before
	public void setUp() throws Exception {
		basicAttack = new Attack(40,"Basic Attack", new HashSet<IEnergy>());
		charmander = new FirePokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)));
		mankey = new FightPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)));
	}

	@Test
	public void testAttack() {
		assertEquals(100,charmander.getHp());
        mankey.selectAttack(0);
        mankey.attack(charmander);
        assertEquals(60,charmander.getHp());
	}

	@Test
	public void testReceivePlantDamage() {
		assertEquals(100,mankey.getHp());
        mankey.receivePlantDamage(basicAttack);
        assertEquals(20,mankey.getHp());
	}

	@Test
	public void testReceivePsychicDamage() {
		assertEquals(100,mankey.getHp());
        mankey.receivePsychicDamage(basicAttack);
        assertEquals(20,mankey.getHp());
	}

}
