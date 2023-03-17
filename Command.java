package com.company;

public abstract class Command
{
    public abstract void execute(Pokemon pokemon1, Pokemon pokemon2, int index);
    public abstract void cancel(Pokemon pokemon1, Pokemon pokemon2, int index);
}

class CommandAttack extends Command
{
    public void execute(Pokemon pokemon1, Pokemon pokemon2, int index) {
        pokemon2.setEffectiveHp(pokemon2.getHp() - Integer.max(0, pokemon1.getAttack() - pokemon2.getDef()));
    }
    public void cancel(Pokemon pokemon1, Pokemon pokemon2, int index) {
        pokemon2.setEffectiveHp(pokemon2.getHp() + Integer.max(0, pokemon1.getAttack() - pokemon2.getDef()));
    }
}

class CommandSpecialAttack extends Command
{
    public void execute(Pokemon pokemon1, Pokemon pokemon2,int index) {
        pokemon2.setEffectiveHp(pokemon2.getHp() - Integer.max(0,pokemon1.getSpecialAttack() -
                pokemon2.getSpecialDef()));
    }
    public void cancel(Pokemon pokemon1, Pokemon pokemon2,int index) {
        pokemon2.setEffectiveHp(pokemon2.getHp() + Integer.max(0, pokemon1.getSpecialAttack() -
                pokemon2.getSpecialDef()));
    }
}

class CommandAbility extends Command
{
    public void execute(Pokemon pokemon1, Pokemon pokemon2, int index)
    {
        Ability ability;
        if(index == 1)
            ability = pokemon1.getAbility1();
        else
            ability  = pokemon1.getAbility2();
        pokemon2.setEffectiveHp(pokemon2.getHp() - ability.getDmg());
        ability.setSecondsOnCd(ability.getCd());
        pokemon2.setWillGetStunned(ability.stuns());
        pokemon1.setDodging(ability.dodges());
    }

    public void cancel(Pokemon pokemon1, Pokemon pokemon2, int index)
    {
        Ability ability;
        if(index == 1)
            ability = pokemon1.getAbility1();
        else
            ability  = pokemon1.getAbility2();
        pokemon2.setEffectiveHp(pokemon2.getHp() + ability.getDmg());
        pokemon2.setWillGetStunned(false);
    }
}
