package net.kaupenjoe.mccourse.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class LevitationSwordItem extends SwordItem {
    public LevitationSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200), pAttacker);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
/**
 * 1:33
 * 3. All about Tools & Armor
 * 49. Weapons that apply effects
 * testing here
 *
 * 1:18
 * 3. All about Tools & Armor
 * 49. Weapons that apply effects
 * Using the class of a weapon with an effect shown here
 *
 * 0:30
 * 3. All about Tools & Armor
 * 49. Weapons that apply effects
 * adding the effect explained here
 *
 * 0:16
 * 3. All about Tools & Armor
 * 49. Weapons that apply effects
 * To create weapons that apply effects, go to mccourse -> item -> custom folder and create a class called LevitationSwordItem for example.
 *
 * to get the effect we want you need to override the hurtEnemy method
 */