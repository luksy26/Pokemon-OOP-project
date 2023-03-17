package com.company;

public class PokemonFactory
{
    private static PokemonFactory uniqueInstance = null;

    private PokemonFactory() {}

    public static PokemonFactory instance()
    {
        if(uniqueInstance == null)
            uniqueInstance = new PokemonFactory();
        return uniqueInstance;
    }

    public Pokemon createPokemon(String name)
    {
        return switch (name) {
            case "Pikachu" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(35)
                    .withSpecialAttack(4)
                    .withDef(2)
                    .withSpecialDef(3)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(6)
                            .withCd(4)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(4)
                            .withStun(true)
                            .withDodge(true)
                            .withCd(5)
                            .build())
                    .build();
            case "Bulbasaur" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(42)
                    .withSpecialAttack(5)
                    .withDef(3)
                    .withSpecialDef(1)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(6)
                            .withCd(4)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(5)
                            .withCd(3)
                            .build())
                    .build();
            case "Charmander" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(50)
                    .withNormalAttack(4)
                    .withDef(3)
                    .withSpecialDef(2)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(4)
                            .withStun(true)
                            .withCd(4)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(7)
                            .withCd(6)
                            .build())
                    .build();
            case "Squirtle" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(60)
                    .withSpecialAttack(3)
                    .withDef(5)
                    .withSpecialDef(5)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(4)
                            .withCd(3)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(2)
                            .withStun(true)
                            .withCd(2)
                            .build())
                    .build();
            case "Snorlax" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(62)
                    .withNormalAttack(3)
                    .withDef(6)
                    .withSpecialDef(4)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(4)
                            .withStun(true)
                            .withCd(5)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(0)
                            .withDodge(true)
                            .withCd(5)
                            .build())
                    .build();
            case "Vulpix" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(36)
                    .withNormalAttack(5)
                    .withDef(2)
                    .withSpecialDef(4)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(8)
                            .withStun(true)
                            .withCd(6)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(2)
                            .withDodge(true)
                            .withCd(7)
                            .build())
                    .build();
            case "Eevee" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(39)
                    .withSpecialAttack(4)
                    .withDef(3)
                    .withSpecialDef(3)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(5)
                            .withCd(3)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(3)
                            .withStun(true)
                            .withCd(3)
                            .build())
                    .build();
            case "Jigglypuff" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(34)
                    .withNormalAttack(4)
                    .withDef(2)
                    .withSpecialDef(3)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(4)
                            .withStun(true)
                            .withCd(4)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(3)
                            .withStun(true)
                            .withCd(4)
                            .build())
                    .build();
            case "Meowth" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(41)
                    .withNormalAttack(3)
                    .withDef(4)
                    .withSpecialDef(2)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(5)
                            .withDodge(true)
                            .withCd(4)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(1)
                            .withDodge(true)
                            .withCd(3)
                            .build())
                    .build();
            case "Psyduck" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(43)
                    .withNormalAttack(3)
                    .withDef(3)
                    .withSpecialDef(3)
                    .withAbility1(new AbilityBuilder()
                            .withDmg(2)
                            .withCd(4)
                            .build())
                    .withAbility2(new AbilityBuilder()
                            .withDmg(2)
                            .withStun(true)
                            .withCd(5)
                            .build())
                    .build();
            case "Neutrel1" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(10)
                    .withNormalAttack(3)
                    .withDef(1)
                    .withSpecialDef(1)
                    .build();
            case "Neutrel2" -> new PokemonBuilder()
                    .withName(name)
                    .withHp(20)
                    .withNormalAttack(4)
                    .withDef(1)
                    .withSpecialDef(1)
                    .build();
            default -> null;
        };
    }
}
