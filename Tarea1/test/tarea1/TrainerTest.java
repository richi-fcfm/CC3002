package tarea1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TrainerTest {
	
	private Trainer trainer1;
    private Trainer trainer2;
    private ThunderboltPokemon pikachu;
    private FirePokemon charmander;
    private PlantPokemon bulbasaur;
    private WaterPokemon squirtle;
    private FightPokemon mankey;
    private PsychicPokemon abra;
    private Attack basicAttack;
    private List<Card> hand1;
    private List<Card> hand2;
    private Set<IEnergy> energies;

    @Before
    public void setUp() {
        energies = new HashSet<>();
        energies.add(new PsychicEnergy(1));
        energies.add(new FightEnergy(1));
        basicAttack = new Attack(40,"Basic Attack", energies);
        pikachu = new ThunderboltPokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)));
        charmander = new FirePokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)));
        bulbasaur = new PlantPokemon(3,100,new ArrayList<>(Arrays.asList(basicAttack)));
        squirtle = new WaterPokemon(1,100,new ArrayList<>(Arrays.asList(basicAttack)));
        mankey = new FightPokemon(2,100,new ArrayList<>(Arrays.asList(basicAttack)));
        abra = new PsychicPokemon(3,100,new ArrayList<>(Arrays.asList(basicAttack)));
        hand1 = new ArrayList<>(Arrays.asList(new FireEnergy(2),new ThunderboltEnergy(1),bulbasaur,charmander,pikachu,squirtle,mankey,abra));
        hand2 = new ArrayList<>(Arrays.asList(new PsychicEnergy(1),new FightEnergy(1)));
        trainer1 = new Trainer(pikachu,hand1);
        trainer2 = new Trainer(charmander,hand2);
    }

    @Test
    public void testGetHand() {
        assertEquals(8,trainer1.getHand().size());
        assertEquals(hand2, trainer2.getHand());
        trainer1.selectCardFromHand(0);
        assertEquals(7,trainer1.getHand().size());
    }

    @Test
    public void testGetBench() {
        assertEquals(true,trainer1.getBench().isEmpty());
        trainer1.selectCardFromHand(2);
        trainer1.playCard();
        assertEquals(1,trainer1.getBench().size());
        assertEquals(bulbasaur,trainer1.getBench().peek());
    }

    @Test
    public void testGetActivePokemon() {
        assertEquals(1,trainer1.getActivePokemon().getId());
        trainer1.selectCardFromHand(2);
        trainer1.playCard();
        trainer2.selectCardFromHand(0);
        trainer2.playCard();
        trainer2.selectCardFromHand(0);
        trainer2.playCard();
        assertEquals(2,trainer2.getActivePokemon().getEnergies().size());
        trainer2.attack(trainer1,0);
        trainer2.attack(trainer1,0);
        trainer2.attack(trainer1,0);
        assertEquals(3,trainer1.getActivePokemon().getId());
    }

    @Test
    public void testGetSelectedCard() {
        assertEquals(null,trainer1.getSelectedCard());
        trainer1.selectCardFromHand(0);
        assertEquals(new FireEnergy(2),trainer1.getSelectedCard());
        trainer1.selectCardFromHand(1);
    }

    @Test
    public void testSelectCardFromHand() {
        assertEquals(8,trainer1.getHand().size());
        trainer1.selectCardFromHand(2);
        assertEquals(true,trainer1.getSelectedCard().isPokemon());
        trainer1.selectCardFromHand(0);
        assertEquals(7,trainer1.getHand().size());
        assertEquals(false,trainer1.getSelectedCard().isPokemon());
    }

    @Test
    public void testPlayCard() {
        assertEquals(false,trainer1.playCard());
        assertEquals(true,trainer1.getActivePokemon().getEnergies().isEmpty());
        trainer1.selectCardFromHand(0);
        assertEquals(true,trainer1.playCard());
        assertEquals(true,trainer1.getActivePokemon().getEnergies().containsKey(new FireEnergy(2)));
        trainer1.selectCardFromHand(1);
        assertEquals(true,trainer1.playCard());
        assertEquals(1,trainer1.getBench().size());
        trainer1.selectCardFromHand(1);
        trainer1.playCard();
        trainer1.selectCardFromHand(1);
        trainer1.playCard();
        trainer1.selectCardFromHand(1);
        trainer1.playCard();
        trainer1.selectCardFromHand(1);
        trainer1.playCard();
        assertEquals(5,trainer1.getBench().size());
        trainer1.selectCardFromHand(1);
        assertEquals(false,trainer1.playCard());
    }

    @Test
    public void testAttack() {
        assertEquals(100,trainer1.getActivePokemon().getHp());
        assertEquals(1,trainer2.getActivePokemon().getAbilityList().size());
        trainer2.selectCardFromHand(0);
        trainer2.playCard();
        trainer2.selectCardFromHand(0);
        trainer2.playCard();
        trainer2.attack(trainer1,0);
        assertEquals("Basic Attack",trainer2.getActivePokemon().getSelectedAttack().getDescription());
        assertEquals(2,trainer2.getActivePokemon().getSelectedAttack().getCost().size());
        assertEquals(60,trainer1.getActivePokemon().getHp());
    }
}
