package tarea1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class FirePokemonTest {
	
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
		assertEquals(100,mankey.getHp());
        charmander.selectAttack(0);
        charmander.attack(mankey);
        assertEquals(60,mankey.getHp());
	}

	@Test
	public void testReceiveWaterDamage() {
		assertEquals(100,charmander.getHp());
        charmander.receiveWaterDamage(basicAttack);
        assertEquals(20,charmander.getHp());
	}

}
