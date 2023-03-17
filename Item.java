package com.company;

public class Item
{
    private int bonusHp, bonusAttack, bonusSpecialAttack, bonusDefense, bonusSpecialDefense;

    public void setBonusHp(int bonusHp) { this.bonusHp = bonusHp; }
    public void setBonusAttack(int bonusAttack) { this.bonusAttack = bonusAttack; }
    public void setBonusSpecialAttack(int bonusSpecialAttack) { this.bonusSpecialAttack = bonusSpecialAttack; }
    public void setBonusDefense(int bonusDefense) { this.bonusDefense = bonusDefense; }
    public void setBonusSpecialDefense(int bonusSpecialDefense) { this.bonusSpecialDefense = bonusSpecialDefense; }

    public int getBonusHp() { return bonusHp; }
    public int getBonusSpecialDefense() { return bonusSpecialDefense; }
    public int getBonusDefense() { return bonusDefense; }
    public int getBonusSpecialAttack() { return bonusSpecialAttack; }
    public int getBonusAttack() { return bonusAttack; }
}
