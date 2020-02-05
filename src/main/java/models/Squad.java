package models;

import java.util.ArrayList;

public class Squad {
    private String squadName;
    private String cause;
    private boolean hasMaxMembers;
    private int squadId;
    private static ArrayList<Squad> listOfSquads = new ArrayList<>();

    public Squad(String squadName, String cause){
        this.squadName = squadName;
        this.cause =cause;
        this.hasMaxMembers = false;
        listOfSquads.add(this);
        this.squadId = listOfSquads.size();
    }
}
