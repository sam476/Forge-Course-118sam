package net.kaupenjoe.mccourse.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
// Note in order to create a custom creative tab we first need a class (ModCreativeModeTab in this case)
public class ModCreativeModeTab {
    public static final CreativeModeTab COURSE_TAB = new CreativeModeTab("coursemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.COBALT_INGOT.get());
        } // whatever block you put in here is going to be the display image for the actual tab
        // Note "coursemodtab" is needed for the translation
    };

}
// after creating this class we need to add the tab to the en_us.json file like so:
// "ItemGroup.coursemodtab": "MCCourse Mod"
// We then got to ModItems and ModBlocks or wherever the old tab is and replace CreativeModeTab.TAB_MISC with ModCreativeModeTab.COURSE_TAB

/**
 * Notes on making custom recipes
 *
 * All of the similar recipes and other minecraft assets can be found in client-extra.jar
 *
 * Basic Minecraft Modding Concepts
 * 35. New Recipes
 * Note we use the external library to make recipes that are similar
 *
 * 4:00
 * 2. Basic Minecraft Modding Concepts
 * 35. New Recipes
 * Note you can either use the recipe as a crafting item or the result
 *
 * 3:09
 * 2. Basic Minecraft Modding Concepts
 * 35. New Recipes
 * explanation of parameters here
 *
 * 1:59
 * 2. Basic Minecraft Modding Concepts
 * 35. New Recipes
 * Note you will need to create a json file in order to create the recipe
 *
 * 1:42
 * 2. Basic Minecraft Modding Concepts
 * 35. New Recipes
 * how to create a custom recipe using recipes from external libraries
 *
 * 0:40
 * 2. Basic Minecraft Modding Concepts
 * 35. New Recipes
 * Where to find recipes in external libraries here
 *
 * 0:27
 * 2. Basic Minecraft Modding Concepts
 * 35. New Recipes
 * to start off with new recipes you need three folders: data -> mccourse -> recipes
 */

/**
 * Notes on Making Block Drops with Loot Tables
 *
 * 6:22
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * testing here
 *
 * 5:00
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * Note we define inside the values array of the tool's file what blocks we can mine
 *
 * 4:01
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * copying and pasting the tools for mining explained here for the mineable folder
 *
 * 3:47
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * Note after we made the loot_tables.blocks folder we need to make another separate set of folders: minecraft -> tags -> blocks -> mineable (this defines what our blocks are mined with)
 *
 * For this we go down to the data folder in Gradle net.minecraft.clientextra version data -> minecraft -> tags -> blocks -> mineable (here we can select what can mine your blocks, note you can copy and select all of them)
 *
 * 2:35
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * Loot Table Generator explained here
 *
 * 2:17
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * Loot Table Wiki explained here
 *
 * 1:29
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * explanation of alternatives drop
 *
 * 0:45
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * Note to create Block Drops with Loot Tables we first need two folders: "loot_tables" and "blocks" (in the actual course folder we have one folder that combines these two called "loot_tables.blocks")
 *
 * Also explanation of code here
 *
 * 0:13
 * 2. Basic Minecraft Modding Concepts
 * 36. Block Drops with Loot Tables
 * Note a loot table defines what drops from a block
 */