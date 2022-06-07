package net.kaupenjoe.mccourse.util;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
        //this does nothing but can referenced, and everything inside this tag can be evaluated in some way or to add stuff to the tag
        public static final TagKey<Block> DOWSING_ROD_VALUABLES =
                tag("dowsing_rod_valuables");
        public static final TagKey<Block> PAXEL_MINEABLE =
                tag("mineable/paxel");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MCCourseMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }


    public static class Items {
        public static final TagKey<Item> COBALT_INGOTS = forgeTag("ingots/cobalt");
        public static final TagKey<Item> COBALT_NUGGETS = forgeTag("nuggets/cobalt");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(MCCourseMod.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
/**
 * 6:58
 * 2. Basic Minecraft Modding Concepts
 * 42. All about Tags
 * testing here
 *
 * 6:03
 * 2. Basic Minecraft Modding Concepts
 * 42. All about Tags
 * The reason you add this is because if I have a recipe in which I use the cobalt ingot, maybe I would want or other mods that add cobalt as well to be used as well.
 *
 * Note using the forge folder name we replace "item" with "tag": "forge:ingots/cobalt" (this is done in the colbalt_block_from_ingots.json from data -> mccourse -> recipes folder)
 *
 * Also Note anything that is added to this tag can be used to craft this recipe. This is also useful when you have big mod packs. these are two main reasons to add tags.
 *
 *
 *
 *
 *
 *
 *
 * 3:59
 * 2. Basic Minecraft Modding Concepts
 * 42. All about Tags
 * Inside the isValuableBlock method in the item you created in the mccourse -> block -> item -> custom folder: you make an edit like this for example:
 *
 *  return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey
 *
 * (block).get()).is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
 *
 * Note the json file you created earlier has a values array that can be expanded infinitely,
 *
 * then you will make some distinctions between in the objects in Items and the optional tag in Blocks (you will add something like this in Items:
 *
 * public static final TagKey<Item> COBALT_INGOTS = forgeTag("ingots/cobalt");
 * public static final TagKey<Item> COBALT_NUGGETS = forgeTag("nuggets/cobalt");
 * )
 *
 * From here you create a series of folders in the data folder: forge -> tags -> items -> ingots,
 *
 * and then inside the ingots folder you add the json file for example like cobalt.json for cobalt ingot.
 *
 *
 *
 * 3:05
 * 2. Basic Minecraft Modding Concepts
 * 42. All about Tags
 * After adding in the code for your ModTags.java file,
 *
 * you can later go down to the mccourse folder under the data folder, and create a
 *
 * folder called tags,
 *
 * from here you will make a json file for the tag reference you made in the ModTags class,
 *
 *
 *
 * 0:59
 * 2. Basic Minecraft Modding Concepts
 * 42. All about Tags
 * options for Tag class here
 *
 * 0:22
 * 2. Basic Minecraft Modding Concepts
 * 42. All about Tags
 * Note Tags are used for the mineable tags.
 *
 * First thing you need is the util (to help with compatibility)
 *
 * You create this by right clicking on the mccourse -> new package and then add .util,
 *
 * inside this package you will make a class "ModTags"
 */