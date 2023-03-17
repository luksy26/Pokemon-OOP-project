package com.company;

public class Ability
{
    private int dmg, cd, secondsLeftOnCd = 0;
    private boolean stun, dodge;

    public void setDmg(int dmg) { this.dmg = dmg; }
    public void setCd(int cd) { this.cd = cd; }
    public void setStun(boolean stun) { this.stun = stun; }
    public void setDodge(boolean dodge) { this.dodge = dodge; }
    public void setSecondsOnCd(int secondsOnCd) { this.secondsLeftOnCd = secondsOnCd; }

    public int getDmg() { return dmg; }
    public int getCd() { return cd; }
    public boolean dodges() { return dodge; }
    public boolean stuns() { return stun; }
    public int getSecondsOnCd() { return secondsLeftOnCd; }
    public void decreaseCd()
    {
        if(secondsLeftOnCd > 0)
        --secondsLeftOnCd;
    }

}
