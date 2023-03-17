package com.company;

public class ItemBuilder
{
    Item item = new Item();

    public Item build() { return this.item; }

    public ItemBuilder withBonusHp(int bonusHp)
    {
        this.item.setBonusHp(bonusHp);
        return this;
    }

    public ItemBuilder withBonusAttack(int bonusAttack)
    {
        this.item.setBonusAttack(bonusAttack);
        return this;
    }

    public ItemBuilder withBonusSpecialAttack(int bonusSpecialAttack)
    {
        this.item.setBonusSpecialAttack(bonusSpecialAttack);
        return this;
    }

    public ItemBuilder withBonusDefense(int bonusDefense)
    {
        this.item.setBonusDefense(bonusDefense);
        return this;
    }

    public ItemBuilder withBonusSpecialDefense(int bonusSpecialDefense)
    {
        this.item.setBonusSpecialDefense(bonusSpecialDefense);
        return this;
    }
}
