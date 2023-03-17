package com.company;

public class PokemonBuilder
{
    private final Pokemon pokemon = new Pokemon();

    public Pokemon build() { return this.pokemon; }

    public PokemonBuilder withName(String name)
    {
        this.pokemon.setName(name);
        return this;
    }

    public PokemonBuilder withHp(int hp)
    {
        this.pokemon.setHp(hp);
        return this;
    }

    public PokemonBuilder withNormalAttack(int normalAttack)
    {
        this.pokemon.setNormalAttack(normalAttack);
        return this;
    }

    public PokemonBuilder withSpecialAttack(int special_attack)
    {
        this.pokemon.setSpecialAttack(special_attack);
        return this;
    }

    public PokemonBuilder withDef(int def)
    {
        this.pokemon.setDef(def);
        return this;
    }

    public PokemonBuilder withSpecialDef(int specialDef)
    {
        this.pokemon.setSpecialDef(specialDef);
        return this;
    }

    public PokemonBuilder withAbility1(Ability ability1)
    {
        this.pokemon.setAbility1(ability1);
        return this;
    }

    public PokemonBuilder withAbility2(Ability ability2)
    {
        this.pokemon.setAbility2(ability2);
        return this;
    }
}
