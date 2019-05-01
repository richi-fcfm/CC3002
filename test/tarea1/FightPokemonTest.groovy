package tarea1

import org.junit.Before
import org.junit.Test

class FightPokemonTest extends GroovyTestCase {

    private FirePokemon charmander
    private FightPokemon mankey
    private Attack basicAttack

    @Before
    void setUp() {
        basicAttack = new Attack(40,"Basic Attack", new HashSet<IEnergy>())
        charmander = new FirePokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)))
        mankey = new FightPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)))
    }

    @Test
    void testAttack() {
        assertEquals(100,charmander.getHp())
        mankey.selectAttack(0)
        mankey.attack(charmander)
        assertEquals(60,charmander.getHp())
    }

    @Test
    void testReceivePlantDamage() {
        assertEquals(100,mankey.getHp())
        mankey.receivePlantDamage(basicAttack)
        assertEquals(20,mankey.getHp())
    }

    @Test
    void testReceivePsychicDamage() {
        assertEquals(100,mankey.getHp())
        mankey.receivePsychicDamage(basicAttack)
        assertEquals(20,mankey.getHp())
    }
}
