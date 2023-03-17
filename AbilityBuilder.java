package com.company;

public class AbilityBuilder
{
    Ability ability = new Ability();

    public Ability build() { return this.ability; }

    public AbilityBuilder withDmg(int dmg)
    {
        this.ability.setDmg(dmg);
        return this;
    }

    public AbilityBuilder withCd(int cd)
    {
        this.ability.setCd(cd);
        return this;
    }

    public AbilityBuilder withStun(boolean stun)
    {
        this.ability.setStun(stun);
        return this;
    }

    public AbilityBuilder withDodge(boolean dodge)
    {
        this.ability.setDodge(dodge);
        return this;
    }
}
