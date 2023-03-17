package com.company;

import java.io.PrintStream;
import java.util.ArrayList;

public class Pokemon
{
    private String name;
    private int hp, normalAttack, specialAttack, def, specialDef, fightsWon;
    private int effectiveHp, effectiveAttack, effectiveSpecialAttack, effectiveDef, effectiveSpecialDef;
    private boolean isStunned = false, isDodging = false;
    private boolean willGetStunned = false;
    private Ability ability1, ability2;
    private final ArrayList<Item>  items = new ArrayList<>();

    public void setName(String name) { this.name = name; }
    public void setHp(int hp) { this.hp = hp; }
    public void setNormalAttack(int normalAttack) { this.normalAttack = normalAttack; }
    public void setSpecialAttack(int specialAttack) { this.specialAttack = specialAttack; }
    public void setDef(int def) { this.def = def; }
    public void setSpecialDef(int specialDef) { this.specialDef = specialDef; }
    public void setAbility1(Ability ability1) { this.ability1 = ability1; }
    public void setAbility2(Ability ability2) { this.ability2 = ability2; }
    public void giveItem(Item item) { if(item != null) items.add(item); }

    public int calculateValue() {
        return effectiveHp + effectiveAttack + effectiveSpecialAttack + effectiveDef + effectiveSpecialDef;
    }

    public void calculateEffectiveStats()
    {
        effectiveHp = hp;
        effectiveAttack = normalAttack;
        effectiveDef = def;
        effectiveSpecialAttack = specialAttack;
        effectiveSpecialDef = specialDef;

        for(Item item: items)
        {
            effectiveHp += item.getBonusHp();
            if(effectiveAttack > 0)
                effectiveAttack += item.getBonusAttack();
            if(effectiveSpecialAttack > 0)
                effectiveSpecialAttack += item.getBonusSpecialAttack();
            effectiveDef += item.getBonusDefense();
            effectiveSpecialDef += item.getBonusSpecialDefense();
        }
    }

    public void setEffectiveHp(int effectiveHp) { this.effectiveHp = effectiveHp; }

    public String getName() { return name; }
    public int getHp() { return effectiveHp; }
    public int getSpecialDef() { return effectiveSpecialDef; }
    public int getDef() { return effectiveDef; }
    public int getSpecialAttack() { return effectiveSpecialAttack; }
    public int getAttack() { return effectiveAttack; }
    public Ability getAbility1() { return ability1; }
    public Ability getAbility2() { return ability2; }

    public void increaseStats(PrintStream out)
    {
        out.println(name + " wins!");
        out.println(name + " gets +1 for all of their base stats: ");
        ++fightsWon;
        effectiveHp = hp + fightsWon;
        for(Item item: items)
            effectiveHp += item.getBonusHp();
        ++effectiveDef;
        out.print("HP: " + effectiveHp);
        if(effectiveAttack > 0)
        {
            ++effectiveAttack;
            out.print(", Attack: " + effectiveAttack);
        }
        if(effectiveSpecialAttack > 0)
        {
            ++effectiveSpecialAttack;
            out.print(", Special Attack: " + effectiveSpecialAttack);
        }
        ++effectiveSpecialDef;
        out.println(", Defense: " + effectiveDef + ", Special Defense: " + effectiveSpecialDef + "\n");

    }

    public boolean isAlive() { return effectiveHp > 0; }
    public boolean isStunned() { return isStunned; }
    public boolean isDodging() { return isDodging; }
    public boolean getWillGetStunned() { return willGetStunned; }

    public void setStunned(boolean stunned) { isStunned = stunned; }
    public void setDodging(boolean dodging) { isDodging = dodging; }
    public void setWillGetStunned(boolean willGetStunned) { this.willGetStunned = willGetStunned; }

    public ArrayList<String> getChoices()
    {
        ArrayList<String> choices = new ArrayList<>();
        if(getAttack() > 0)
            choices.add("Normal Attack");
        if(getSpecialAttack() > 0)
            choices.add("Special Attack");
        if(getAbility1() != null && getAbility1().getSecondsOnCd() == 0)
            choices.add("Ability 1");
        if(getAbility2() != null && getAbility2().getSecondsOnCd() == 0)
            choices.add("Ability 2");

        return choices;
    }

    public String hpAndAbilities(boolean dodged, boolean stunned)
    {
        StringBuilder s = new StringBuilder();
        s.append(name).append(" ").append(effectiveHp).append("HP");
        if(stunned && effectiveHp > 0)
            s.append(" and got stunned for next turn");
        if(dodged)
            s.append(" (dodged)");
        if(ability1 != null && ability1.getSecondsOnCd() > 0 && effectiveHp > 0)
            s.append(", Ability 1 on a ").append(ability1.getSecondsOnCd()).append(" second cooldown");
        if(ability2 != null && ability2.getSecondsOnCd() > 0 && effectiveHp > 0)
            s.append(", Ability 2 on a ").append(ability2.getSecondsOnCd()).append(" second cooldown");
        return s.toString();
    }

    public void resetAbilitiesAndStatus()
    {
        if(ability1 != null)
            ability1.setSecondsOnCd(0);
        if(ability2 != null)
            ability2.setSecondsOnCd(0);
        isStunned = false;
        willGetStunned = false;
        effectiveHp = hp + fightsWon;
        for(Item item: items)
            effectiveHp += item.getBonusHp();
    }

    public static void pokemonFightTurn(Pokemon pokemon1, Pokemon pokemon2, PrintStream out)
    {
        ArrayList<String> choices1 = pokemon1.getChoices();
        ArrayList<String> choices2 = pokemon2.getChoices();
        String choice1 = "is stunned", choice2 = "is stunned";

        pokemon1.setDodging(false);
        pokemon2.setDodging(false);
        pokemon1.setWillGetStunned(false);
        pokemon2.setWillGetStunned(false);


        if(!pokemon1.isStunned()) {
            choice1 = choices1.get((int)(Math.random() * choices1.size()));
        }
        if(!pokemon2.isStunned()) {
            choice2 = choices2.get((int)(Math.random() * choices2.size()));
        }

        out.println(pokemon1.name + " " + choice1 + " | " + pokemon2.name + " " + choice2);

        CommandAttack c1 = new CommandAttack();
        CommandSpecialAttack c2 = new CommandSpecialAttack();
        CommandAbility c3 = new CommandAbility();

        switch (choice1) {
            case "Normal Attack" -> c1.execute(pokemon1, pokemon2, 0);
            case "Special Attack" -> c2.execute(pokemon1, pokemon2,0);
            case "Ability 1" -> c3.execute(pokemon1, pokemon2, 1);
            case "Ability 2" -> c3.execute(pokemon1, pokemon2, 2);
        }

        switch (choice2) {
            case "Normal Attack" -> c1.execute(pokemon2, pokemon1, 0);
            case "Special Attack" -> c2.execute(pokemon2, pokemon1,0);
            case "Ability 1" -> c3.execute(pokemon2, pokemon1, 1);
            case "Ability 2" -> c3.execute(pokemon2, pokemon1, 2);
        }

        if(pokemon1.isDodging())
            switch (choice2) {
                case "Normal Attack" -> c1.cancel(pokemon2, pokemon1, 0);
                case "Special Attack" -> c2.cancel(pokemon2, pokemon1,0);
                case "Ability 1" -> c3.cancel(pokemon2, pokemon1, 1);
                case "Ability 2" -> c3.cancel(pokemon2, pokemon1, 2);
            }

        if(pokemon2.isDodging())
            switch (choice1) {
                case "Normal Attack" -> c1.cancel(pokemon1, pokemon2, 0);
                case "Special Attack" -> c2.cancel(pokemon1, pokemon2,0);
                case "Ability 1" -> c3.cancel(pokemon1, pokemon2, 1);
                case "Ability 2" -> c3.cancel(pokemon1, pokemon2, 2);
            }

        pokemon1.setStunned(pokemon1.getWillGetStunned());
        pokemon2.setStunned(pokemon2.getWillGetStunned());

        if(pokemon1.getHp() < 0) pokemon1.setEffectiveHp(0);
        if(pokemon2.getHp() < 0) pokemon2.setEffectiveHp(0);

        out.println(pokemon1.hpAndAbilities(pokemon1.isDodging, pokemon1.isStunned()));
        out.println(pokemon2.hpAndAbilities(pokemon2.isDodging, pokemon2.isStunned()));
        out.println();

        if(pokemon1.getAbility1() != null) pokemon1.getAbility1().decreaseCd();
        if(pokemon1.getAbility2() != null) pokemon1.getAbility2().decreaseCd();
        if(pokemon2.getAbility1() != null) pokemon2.getAbility1().decreaseCd();
        if(pokemon2.getAbility2() != null) pokemon2.getAbility2().decreaseCd();
    }
}
