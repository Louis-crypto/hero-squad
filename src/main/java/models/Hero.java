package models;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String superPower;
    private String weakness;

    public Hero(String name, int age, String superPower, String weakness){
        this.name = name;
        this.age = age;
        this.superPower = superPower;
        this.weakness = weakness;
    }
}

