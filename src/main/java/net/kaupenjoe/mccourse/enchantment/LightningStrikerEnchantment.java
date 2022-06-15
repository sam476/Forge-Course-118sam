package net.kaupenjoe.mccourse.enchantment;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningStrikerEnchantment extends Enchantment {
    protected LightningStrikerEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(!pAttacker.level.isClientSide()) {
            ServerLevel world = ((ServerLevel) pAttacker.level);
            ServerPlayer player = ((ServerPlayer) pAttacker);
            BlockPos position = pTarget.blockPosition();

            if(pLevel == 1) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, player, position,
                        MobSpawnType.TRIGGERED, true, true);
            }

            if(pLevel == 2) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, player, position,
                        MobSpawnType.TRIGGERED, true, true);

                EntityType.LIGHTNING_BOLT.spawn(world, null, player, position,
                        MobSpawnType.TRIGGERED, true, true);
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
    //determines how many levels there are
    @Override
    public int getMaxLevel() {
        return 2;
    }
}

/**
 * 6:23
 * 3. All about Tools & Armor
 * 53. Custom Enchantment
 * testing here
 *
 * 6:01
 * 3. All about Tools & Armor
 * 53. Custom Enchantment
 * Add the translation file in the en_us.json file
 *
 * 4:53
 * 3. All about Tools & Armor
 * 53. Custom Enchantment
 * Note we need to add an eventbus in the MCCourseMod for the enchantment
 *
 * 4:15
 * 3. All about Tools & Armor
 * 53. Custom Enchantment
 * adding code to Mod Enchantments here
 *
 * 4:00
 * 3. All about Tools & Armor
 * 53. Custom Enchantment
 * tip here
 *
 * 1:07
 * 3. All about Tools & Armor
 * 53. Custom Enchantment
 * where to find all the vanilla enchantments here
 *
 * 0:33
 * 3. All about Tools & Armor
 * 53. Custom Enchantment
 * What to add in these classes explained here.
 *
 * 0:09
 * 3. All about Tools & Armor
 * 53. Custom Enchantment
 * to Create a Custom Enchantment, in the mccourse you create a new folder called enchantment.
 *
 * Create two classes LighteningStrikerEnchantment and ModEnchantment.
 */