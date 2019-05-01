package tarea1

import org.junit.Before
import org.junit.Test

class FirePokemonTest extends GroovyTestCase {

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
        assertEquals(100,mankey.getHp())
        charmander.selectAttack(0)
        charmander.attack(mankey)
        assertEquals(60,mankey.getHp())
    }

    @Test
    void testReceiveWaterDamage() {
        assertEquals(100,charmander.getHp())
        charmander.receiveWaterDamage(basicAttack)
        assertEquals(20,charmander.getHp())
    }
}
