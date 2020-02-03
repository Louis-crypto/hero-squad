package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    public Hero myHero(){
        return new Hero("Dracula",21,"speed","sunlight");
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
        assertEquals(21, hero.getAge());
        assertEquals("speed", hero.getSuperpower());
        assertEquals("sun", hero.getWeakness());
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}