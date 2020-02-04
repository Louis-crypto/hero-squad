package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    public Hero myHero(){
        return new Hero("Dracula",70,"speed","sunlight");
    }

    @Test
    public void newHeroGetsCorrectlyInstantiated_true() {
        Hero hero = myHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void getName_canObtainValueOfName_String(){
        Hero hero = myHero();
        assertEquals("Dracula", hero.getName());
        assertEquals(70, hero.getAge());
        assertEquals("speed", hero.getSuperPower());
        assertEquals("sunlight", hero.getWeakness());
    }

    @Test
    public void returnsAllHeroes_2(){
        Hero hero = myHero();
        Hero mySecondHero = new Hero("Ragnar", 40, "sword","water");
        assertEquals(2, Hero.getAll().size());
        assertEquals(2, mySecondHero.getId());
    }


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}