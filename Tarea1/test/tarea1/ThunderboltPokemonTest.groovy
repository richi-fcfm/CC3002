package tarea1

import org.junit.Before
import org.junit.Test

class ThunderboltPokemonTest extends GroovyTestCase {

    private ThunderboltPokemon pikachu
    private FightPokemon mankey
    private Attack basicAttack

    @Before
    void setUp() {
        basicAttack = new Attack(40,"Basic Attack", new HashSet<IEnergy>())
        pikachu = new ThunderboltPokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)))
        mankey = new FightPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)))
    }

    @Test
    void testAttack() {
        assertEquals(100,mankey.getHp())
        pikachu.selectAttack(0)
        pikachu.attack(mankey)
        assertEquals(60,mankey.getHp())
    }

    @Test
    void testReceiveFightDamage() {
        assertEquals(100,pikachu.getHp())
        pikachu.receiveFightDamage(basicAttack)
        assertEquals(20,pikachu.getHp())
    }
}
