package tarea1

import org.junit.Before
import org.junit.Test

class AttackTest extends GroovyTestCase {

    private Attack attack
    private Set<IEnergy> energies

    @Before
    void setUp() {
        energies = new HashSet<>()
        energies.add(new PlantEnergy(2))
        energies.add(new WaterEnergy(3))
        attack = new Attack(10, "Basic Attack", energies)
    }

    @Test
    void testGetDamage() {
        assertEquals(10,attack.getDamage())
        assertEquals(2,attack.getCost().size())
    }

    @Test
    void testIsAttack() {
        assertEquals(true,attack.isAttack())
    }
}
