package com.github.dodii.finalreality.model.character.playablecharacters.common;

import com.github.dodii.finalreality.model.character.ICharacter;
import com.github.dodii.finalreality.model.character.playablecharacters.AbstractPlayerCharacter;
import com.github.dodii.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that represents a thief character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Oportot.
 */
public class ThiefCharacter extends AbstractPlayerCharacter implements ICommonCharacter {

    private static String CUSTOM_PARAMETER = "T";

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param hp             the character's hp.
     * @param def            the character's def.
     * @param turnsQueue     the queue with the characters waiting for their turn
     */
    public ThiefCharacter(@NotNull String name, int hp, int def,
                          @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, hp, def, turnsQueue);
    }

    /**
     * Equips a certain weapon to a character.
     * Checks the weapon's type to follow the
     * rules of the game when equipping by using double dispatch.
     * A thief may only equip swords, knives and bows.
     * All characters can equip null weapons.
     * @param weapon weapon to be equipped.
     */
    @Override
    public void equip(@NotNull IWeapon weapon) {
        weapon.equipToThief(this);
    }

    /**
     * Returns the hashcode of the character.
     * A pair of playable characters have an equivalent hashcode if
     * they share the same name, hp, def, equipped weapon and a custom
     * parameter defined on every subclass.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHP(), getDef(), getEquippedWeapon(),
                CUSTOM_PARAMETER);
    }

    /**
     * Compares two characters.
     * @param o character to compare.
     * @return true if both are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ThiefCharacter)) {
            return false;
        }

        final ThiefCharacter thiefCharacter = (ThiefCharacter) o;
        return getName().equals(thiefCharacter.getName()) &&
                getHP() == thiefCharacter.getHP() &&
                getDef() == thiefCharacter.getDef() &&
                getEquippedWeapon().equals(thiefCharacter.getEquippedWeapon());
    }
}
