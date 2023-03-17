package com.company;

import java.io.*;
import java.util.ArrayList;

public class Administration
{
    public static ArrayList<Trainer> extractData(File file)
    {
        ArrayList<Trainer> trainers = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String name, age;
            while ((name = br.readLine()) != null)
            {
                age = br.readLine();
                Trainer trainer = new Trainer();
                trainer.setAge(Integer.parseInt(age));
                trainer.setName(name);

                for(int i = 0; i < 3; ++i)
                {
                    String pokemon = br.readLine();
                    String[] pokemonAndItems = pokemon.split(" ");
                    trainer.addPokemon(PokemonFactory.instance().createPokemon(pokemonAndItems[0]));
                    for (int j = 1; j < pokemonAndItems.length; ++j)
                        trainer.getPokemon().get(i).giveItem(ItemFactory.instance().createItem(pokemonAndItems[j]));
                    trainer.getPokemon().get(i).calculateEffectiveStats();
                }
                trainers.add(trainer);
            }
        }
        catch(FileNotFoundException ex2) { System.out.println("File Not Found"); } // handling exceptions
        catch(IOException ex1) { System.out.println("IO Exception"); }

        return trainers;
    }

    public static void duels(ArrayList<Trainer> trainers, PrintStream out)
    {
        Trainer trainer1 = trainers.get(0), trainer2 = trainers.get(1);
        for(int i = 0 ; i < 3 ; ++i)
        {
            out.println("Duel number " + (i+1) + ": " + trainer1.getPokemon().get(i).getName()
                    + " vs " + trainer2.getPokemon().get(i).getName() + "\n");
            duel(trainer1.getPokemon().get(i), trainer2.getPokemon().get(i), out);
        }

        Pokemon pokemon1 = trainer1.getPokemon().get(0), pokemon2 = trainer2.getPokemon().get(0);

        int maxValue = trainer1.getPokemon().get(0).calculateValue();
        for(int i = 1 ; i < 3; ++i) {
            if(trainer1.getPokemon().get(i).calculateValue() > maxValue)
            {
                maxValue = trainer1.getPokemon().get(i).calculateValue();
                pokemon1 = trainer1.getPokemon().get(i);
            }
            else if(trainer1.getPokemon().get(i).calculateValue() == maxValue)
                if(trainer1.getPokemon().get(i).getName().compareTo(pokemon1.getName()) < 0)
                    pokemon1 = trainer1.getPokemon().get(i);
        }
        maxValue = trainer2.getPokemon().get(0).calculateValue();
        for(int i = 1 ; i < 3; ++i) {
            if(trainer2.getPokemon().get(i).calculateValue() > maxValue)
            {
                maxValue = trainer2.getPokemon().get(i).calculateValue();
                pokemon2 = trainer2.getPokemon().get(i);
            }
            else if(trainer2.getPokemon().get(i).calculateValue() == maxValue)
                if(trainer2.getPokemon().get(i).getName().compareTo(pokemon1.getName()) < 0)
                    pokemon2 = trainer2.getPokemon().get(i);
        }
        out.println("Duel number 4: " + pokemon1.getName() + " vs " + pokemon2.getName() + "\n");
        duel(pokemon1, pokemon2, out);
    }

    public static void duel(Pokemon pokemon1, Pokemon pokemon2, PrintStream out)
    {
        int i = 0;
        boolean pokemon1Died = false, pokemon2Died = false;
        while(!pokemon1Died && !pokemon2Died)
        {
            int event = (int)(Math.random() * 3) + 1;
            switch (event) {
                case 1 -> {
                    out.print("Event number " + (++i) + ", fight with a Neutrel1:\n");
                    Pokemon neutrel1 = PokemonFactory.instance().createPokemon("Neutrel1");
                    Pokemon neutrel2 = PokemonFactory.instance().createPokemon("Neutrel1");
                    neutrel1.calculateEffectiveStats();
                    neutrel2.calculateEffectiveStats();

                    out.println(pokemon1.getName() + "'s fight:\n");

                    while (neutrel1.isAlive() && pokemon1.isAlive())
                        Pokemon.pokemonFightTurn(pokemon1, neutrel1, out);
                    if (pokemon1.isAlive())
                        pokemon1.increaseStats(out);
                    else
                        pokemon1Died = true;
                    pokemon1.resetAbilitiesAndStatus();

                    out.println(pokemon2.getName() + "'s fight:\n");

                    while (neutrel2.isAlive() && pokemon2.isAlive())
                        Pokemon.pokemonFightTurn(pokemon2, neutrel2, out);
                    if (pokemon2.isAlive())
                        pokemon2.increaseStats(out);
                    else
                        pokemon2Died = true;
                    pokemon2.resetAbilitiesAndStatus();
                }
                case 2 -> {
                    out.println("Event number " + (++i) + ", fight with a Neutrel2:\n");
                    Pokemon neutrel1 = PokemonFactory.instance().createPokemon("Neutrel2");
                    Pokemon neutrel2 = PokemonFactory.instance().createPokemon("Neutrel2");
                    neutrel1.calculateEffectiveStats();
                    neutrel2.calculateEffectiveStats();

                    out.println(pokemon1.getName() + "'s fight:\n");

                    while (neutrel1.isAlive() && pokemon1.isAlive())
                        Pokemon.pokemonFightTurn(pokemon1, neutrel1, out);
                    if (pokemon1.isAlive())
                        pokemon1.increaseStats(out);
                    else
                        pokemon1Died = true;
                    pokemon1.resetAbilitiesAndStatus();

                    out.println(pokemon2.getName() + "'s fight:\n");

                    while (neutrel2.isAlive() && pokemon2.isAlive())
                        Pokemon.pokemonFightTurn(pokemon2, neutrel2, out);
                    if(pokemon2.isAlive())
                        pokemon2.increaseStats(out);
                    else
                        pokemon2Died = true;
                    pokemon2.resetAbilitiesAndStatus();
                    }

                case 3 -> {
                    out.println("Event number " + (++i) + ", fight between the trainers:\n");
                    while (pokemon1.isAlive() && pokemon2.isAlive())
                        Pokemon.pokemonFightTurn(pokemon1, pokemon2, out);
                    if (pokemon1.isAlive())
                        pokemon1.increaseStats(out);
                    else
                        pokemon1Died = true;
                    pokemon1.resetAbilitiesAndStatus();

                    if (pokemon2.isAlive())
                        pokemon2.increaseStats(out);
                    else
                        pokemon2Died = true;
                    pokemon2.resetAbilitiesAndStatus();
                }
            }
        }
        if(pokemon1Died && pokemon2Died)
            out.println("DRAW\n");
    }
}
