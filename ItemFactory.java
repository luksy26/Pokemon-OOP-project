package com.company;

public class ItemFactory
{
    private static ItemFactory uniqueInstance = null;

    private ItemFactory() {}

    public static ItemFactory instance()
    {
        if(uniqueInstance == null)
            uniqueInstance = new ItemFactory();
        return uniqueInstance;
    }

    public Item createItem(String name)
    {
        return switch(name) {
            case "Shield" -> new ItemBuilder()
                    .withBonusDefense(2)
                    .withBonusSpecialDefense(2)
                    .build();
            case "Vest" -> new ItemBuilder()
                    .withBonusHp(10)
                    .build();
            case "SmallSword" -> new ItemBuilder()
                    .withBonusAttack(3)
                    .build();
            case "Wand" -> new ItemBuilder()
                    .withBonusSpecialAttack(3)
                    .build();
            case "Vitamins" -> new ItemBuilder()
                    .withBonusHp(2)
                    .withBonusAttack(2)
                    .withBonusSpecialAttack(2)
                    .build();
            case "ChristmasTree" -> new ItemBuilder()
                    .withBonusAttack(3)
                    .withBonusDefense(1)
                    .build();
            case "Cloak" -> new ItemBuilder()
                    .withBonusSpecialDefense(3)
                    .build();
            default -> null;
        };
    }
}
