package com.company;

import java.util.ArrayList;

public class Trainer
{
    private String name;
    private int age;
    ArrayList <Pokemon> pokemon = new ArrayList<>();
    // plural of pokemon is also pokemon :)

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void addPokemon(Pokemon pokemon) { if(pokemon != null)  this.pokemon.add(pokemon); }


    public ArrayList<Pokemon> getPokemon() { return pokemon; }
    public int getAge() { return age; }
    public String getName() { return name; }
}
