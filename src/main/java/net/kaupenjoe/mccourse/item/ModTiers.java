package net.kaupenjoe.mccourse.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier COBALT = new ForgeTier(1, 1500, 1f,
            3f, 10, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.COBALT_INGOT.get()));
}
/**
 * 5:17
 * 3. All about Tools & Armor
 * 47. Creating a new Tool Set
 * adjusting speed parameter and where to find tiers explained here
 *
 * 4:37
 * 3. All about Tools & Armor
 * 47. Creating a new Tool Set
 * testing here
 *
 * 2:47
 * 3. All about Tools & Armor
 * 47. Creating a new Tool Set
 * Next we go to ModItems class and add the tool registry objects. Each item has a their item after new: sword is SwordItem, pickaxe is PickaxeItem, shovel is ShovelItem, axe is AxeItem and hoe is HoeItem. Note that these tools have parameters for type, attackdamage, and attackspeed.
 *
 * Add the translations to en_us.json for these tools.
 *
 * Copy over the json files for these tools to models's item folder. Note the parent must have /handled so the item is displayed as 3D in third person view.
 *
 * Copy over the textures in textures's item folder.
 *
 * 1:01
 * 3. All about Tools & Armor
 * 47. Creating a new Tool Set
 * code inside ModTiers explained here
 *
 * 0:17
 * 3. All about Tools & Armor
 * 47. Creating a new Tool Set
 * to create a new tool set you first need a new class called ModTiers in the mccourse -> item folder.
 */