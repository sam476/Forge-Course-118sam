package net.kaupenjoe.mccourse.item.custom;

import net.kaupenjoe.mccourse.util.ModTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;

public class PaxelItem extends DiggerItem implements Vanishable {
    public PaxelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.PAXEL_MINEABLE, pProperties);
    }
}
/**
 * 4:18
 * 3. All about Tools & Armor
 * 48. Making a Multi-Tool (Paxel)
 * testing here
 *
 * 4:02
 * 3. All about Tools & Armor
 * 48. Making a Multi-Tool (Paxel)
 * Add the translation to en_us.json file.
 *
 * Add the json file to the models's item folder.
 *
 * Then add the texture to textures's item folder.
 *
 *
 *
 * 3:10
 * 3. All about Tools & Armor
 * 48. Making a Multi-Tool (Paxel)
 * Note that the paxel item has no right click functionality, unless you go to the item using the paxel item and override the useOn function.
 *
 * 2:36
 * 3. All about Tools & Armor
 * 48. Making a Multi-Tool (Paxel)
 * To create the actual Paxil item, go back to ModItems.java and create a registry object, don't forget to include PaxelItem after the "new" keyword.
 *
 *
 *
 * 0:53
 * 3. All about Tools & Armor
 * 48. Making a Multi-Tool (Paxel)
 * Go to the ModTags class and add the PAXEL-MINEABLE tag.
 *
 * Add this tag to the super constructor as a parameter.
 *
 * After this go to mccourse -> tags -> blocks folder and add a new directory called mineable,
 *
 * inside there create a file called paxel.json,
 *
 * From here we use the same structure as the dowsing_rod_valuables.json except we replace the values inside the values array with the tools we want ( we do this by referencing the tags but note we can add other tags here as well )
 *
 *
 *
 *
 *
 *
 *
 * 0:19
 * 3. All about Tools & Armor
 * 48. Making a Multi-Tool (Paxel)
 * how to create the PaxelItem class explained here
 *
 * 0:13
 * 3. All about Tools & Armor
 * 48. Making a Multi-Tool (Paxel)
 * To create a mutli-tool to minecraft we need to create a class called PaxelItem in the mccourse -> Item -> custom folder.
 */