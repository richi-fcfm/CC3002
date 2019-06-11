package tarea1

import org.junit.Before
import org.junit.Test

class PsychicPokemonTest extends GroovyTestCase {

    private ThunderboltPokemon pikachu
    private PsychicPokemon abra
    private Attack basicAttack

    @Before
    void setUp() {
        basicAttack = new Attack(40,"Basic Attack", new HashSet<IEnergy>())
        pikachu = new ThunderboltPokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)))
        abra = new PsychicPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)))
    }

    @Test
    void testAttack() {
        assertEquals(100,pikachu.getHp())
        abra.selectAttack(0)
        abra.attack(pikachu)
        assertEquals(60,pikachu.getHp())
    }

    @Test
    void testReceiveFightDamage() {
        assertEquals(100,abra.getHp())
        abra.receiveFightDamage(basicAttack)
        assertEquals(90,abra.getHp())
    }

    @Test
    void testReceivePsychicDamage() {
        assertEquals(100,abra.getHp())
        abra.receivePsychicDamage(basicAttack)
        assertEquals(20,abra.getHp())
    }
}
