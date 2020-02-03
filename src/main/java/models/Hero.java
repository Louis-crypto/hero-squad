package models;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String superPower;
    private String weakness;
    private int id;
    private static  ArrayList<Hero> listOfHeroes = new ArrayList<>();

    public Hero(String name, int age, String superPower, String weakness){
        this.name = name;
        this.age = age;
        this.superPower = superPower;
        this.weakness = weakness;
        listOfHeroes.add(this);
        this.id = listOfHeroes.size();
    }

}

