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

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}