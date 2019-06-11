package tarea1;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import tarea1.Attack;
import tarea1.IEnergy;
import tarea1.PlantEnergy;
import tarea1.WaterEnergy;

public class AttackTest {
	
	private Attack attack;
    private Set<IEnergy> energies;

	@Before
	public void setUp() throws Exception {
		energies = new HashSet<>();
		energies.add(new PlantEnergy(2));
		energies.add(new WaterEnergy(3));
		attack = new Attack(10, "Basic Attack", energies);
	}

	@Test
    public void testGetDamage() {
        assertEquals(10,attack.getDamage());
        assertEquals(2,attack.getCost().size());
    }

    @Test
    public void testIsAttack() {
        assertEquals(true,attack.isAttack());
    }
}


