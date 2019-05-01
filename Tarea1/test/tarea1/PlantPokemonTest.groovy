package tarea1

import org.junit.Before
import org.junit.Test

class PlantPokemonTest extends GroovyTestCase {

    private ThunderboltPokemon pikachu
    private PlantPokemon bulbasaur
    private Attack basicAttack

    @Before
    void setUp() {
        basicAttack = new Attack(40,"Basic Attack", new HashSet<IEnergy>())
        pikachu = new ThunderboltPokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)))
        bulbasaur = new PlantPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)))
    }

    @Test
    void testAttack() {
        assertEquals(100,pikachu.getHp())
        bulbasaur.selectAttack(0)
        bulbasaur.attack(pikachu)
        assertEquals(60,pikachu.getHp())
    }

    @Test
    void testReceiveFireDamage() {
        assertEquals(100,bulbasaur.getHp())
        bulbasaur.receiveFireDamage(basicAttack)
        assertEquals(20,bulbasaur.getHp())
    }

    @Test
    void testReceiveWaterDamage() {
        assertEquals(100,bulbasaur.getHp())
        bulbasaur.receiveWaterDamage(basicAttack)
        assertEquals(90,bulbasaur.getHp())
    }
}
