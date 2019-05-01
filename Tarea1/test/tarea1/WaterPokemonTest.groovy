package tarea1

import org.junit.Before
import org.junit.Test

class WaterPokemonTest extends GroovyTestCase {

    private ThunderboltPokemon pikachu
    private WaterPokemon squirtle
    private Attack basicAttack

    @Before
    void setUp() {
        basicAttack = new Attack(40,"Basic Attack", new HashSet<IEnergy>())
        pikachu = new ThunderboltPokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)))
        squirtle = new WaterPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)))
    }

    @Test
    void testAttack() {
        assertEquals(100,pikachu.getHp())
        squirtle.selectAttack(0)
        squirtle.attack(pikachu)
        assertEquals(60,pikachu.getHp())
    }

    @Test
    void testReceiveThunderboltDamage() {
        assertEquals(100,squirtle.getHp())
        squirtle.receiveThunderboltDamage(basicAttack)
        assertEquals(20,squirtle.getHp())
    }

    @Test
    void testReceivePlantDamage() {
        assertEquals(100,squirtle.getHp())
        squirtle.receivePlantDamage(basicAttack)
        assertEquals(20,squirtle.getHp())
    }

    @Test
    void testReceiveFightDamage() {
        assertEquals(100,squirtle.getHp())
        squirtle.receiveFightDamage(basicAttack)
        assertEquals(90,squirtle.getHp())
    }
}
