package net.kaupenjoe.mccourse.item;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.entity.ModEntityTypes;
import net.kaupenjoe.mccourse.entity.custom.ModBoatEntity;
import net.kaupenjoe.mccourse.fluid.ModFluids;
import net.kaupenjoe.mccourse.item.custom.*;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Note everytime we create a DeferredRegister we need a register method
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID); // first thing needed for items

    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB))); // public static final RegistryObject adds the item (but will not have functionality from this line)
    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB))); // Note (new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB) is also a builder tab where can use a . to access other stuff to change the item
    // Note in order to make the items work you will need a folder called assets created in the resources folder
    // Inside this assets folder you will create a directory exactly named as the mod class (mccourse in this case) this has to be your model.
    // Inside the mccourse directory we make two directories called lang and the other called textures
    // Still in the models directory we make a directory called block and another called item (we then drag these to the textures folder)
    // Inside the lang folder we create a file called en_us.json
    // follow video 32 at 9:02 for what to put inside this file
    // Still in this file the structure follows like so, you have first the Unlocalized name and after the : the localized name. Note make sure the folder names and the name of the file are correct
    // inside the item folder we create the colbalt_ingot.json
    // in this json file we have the parent which determines how the texture is displayed in your hand and also in 3D (generated means the texture extrude a little bit so it has a 3D look)
    // we have textures followed by layer0 and what follows this is the definition of the directory where the texture is located (the png must be copied over to the item folder in textures for this to be found)
    // All the textures is distributed by nanotech detailed in the Credits.txt file
    public static final RegistryObject<Item> RAW_COBALT = ITEMS.register("raw_cobalt",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB))); // this is how you create another item but Note you will need a json file in models -> item and a png file in textures -> item (also add a pointer inside en_us.json)

    public static final RegistryObject<Item> WOLVES = ITEMS.register("wolves",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).durability(16)));

    public static final RegistryObject<Item> COAL_SLIVER = ITEMS.register("coal_sliver",
            () -> new CoalSliverItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> TURNIP = ITEMS.register("turnip",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).food(ModFoods.TURNIP)));

    public static final RegistryObject<Item> COBALT_SWORD = ITEMS.register("cobalt_sword",
            () -> new LevitationSwordItem(ModTiers.COBALT, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe",
            () -> new PickaxeItem(ModTiers.COBALT, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel",
            () -> new ShovelItem(ModTiers.COBALT, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> COBALT_AXE = ITEMS.register("cobalt_axe",
            () -> new AxeItem(ModTiers.COBALT, 4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> COBALT_HOE = ITEMS.register("cobalt_hoe",
            () -> new HoeItem(ModTiers.COBALT, 0, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_PAXEL = ITEMS.register("cobalt_paxel",
            () -> new PaxelItem(ModTiers.COBALT, 0, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_HELMET = ITEMS.register("cobalt_helmet",
            () -> new CobaltArmorItem(ModArmorMaterials.COBALT, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> COBALT_CHESTPLATE = ITEMS.register("cobalt_chestplate",
            () -> new CobaltArmorItem(ModArmorMaterials.COBALT, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> COBALT_LEGGINGS = ITEMS.register("cobalt_leggings",
            () -> new CobaltArmorItem(ModArmorMaterials.COBALT, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> COBALT_BOOTS = ITEMS.register("cobalt_boots",
            () -> new CobaltArmorItem(ModArmorMaterials.COBALT, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_HORSE_ARMOR = ITEMS.register("cobalt_horse_armor",
            () -> new HorseArmorItem(12, "cobalt",
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));


    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));


    public static final RegistryObject<Item> TURNIP_SEEDS = ITEMS.register("turnip_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TURNIP_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> BAR_BRAWL_RECORD = ITEMS.register("bar_brawl_music_disc",
            () -> new RecordItem(4, ModSounds.BAR_BRAWL,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));

    public static final RegistryObject<Item> COBALT_STAFF = ITEMS.register("cobalt_staff",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));


    public static final RegistryObject<Item> COBALT_BOW = ITEMS.register("cobalt_bow",
            () -> new BowItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).durability(500)));


    public static final RegistryObject<Item> HONEY_BUCKET = ITEMS.register("honey_bucket",
            () -> new BucketItem(ModFluids.HONEY_FLUID,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).durability(500)));


    public static final RegistryObject<Item> CHERRY_BLOSSOM_SIGN_ITEM = ITEMS.register("cherry_blossom_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(16),
                    ModBlocks.CHERRY_BLOSSOM_SIGN.get(), ModBlocks.CHERRY_BLOSSOM_WALL_SIGN.get()));


    public static final RegistryObject<Item> MAGIC_DUST = ITEMS.register("magic_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));


    public static final RegistryObject<ForgeSpawnEggItem> RACCOON_SPAWN_EGG = ITEMS.register("raccoon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.RACCOON,0x948e8d, 0x3b3635,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> TIGER_SPAWN_EGG = ITEMS.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TIGER,0xfcb603, 0x242321,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));


    public static final RegistryObject<Item> CHERRY_BLOSSOM_BOAT = ITEMS.register("cherry_blossom_boat",
            () -> new ModBoatItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB), ModBoatEntity.Type.CHERRY_BLOSSOM));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

/**
 * 7:21
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * testing here
 *
 * 6:58
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * where to find other textures here
 *
 * 6:16
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * important points here
 *
 * 5:50
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * The next step is to get the 3D armor. To do this you need to go to resources -> assets -> mccourse -> textures and create a new directory called armor. Then in this folder copy over the pngs.
 *
 *
 *
 * 4:03
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * After those steps go to ModItems.java and add in the armor set as a registry object, followed by the new ArmorItem. Note you will have to individually add the set pieces themselves as separate items here.
 *
 * Go to en_us.json and add in the translations.
 *
 * Add in the json files for the models -> item folder.
 *
 * Add in the png files for the textures's item folder.
 *
 * 3:29
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * important here for when you want to add another armor material
 *
 * 2:54
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * Note try to play with the numbers until you get what you want
 *
 * 0:33
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * steps of implementation explained here
 *
 * 0:30
 * 3. All about Tools & Armor
 * 50. Creating a new Armor Set
 * To create a new Armor set, go to mccourse -> item -> custom folder and create a class for it like ModArmorMaterials
 */

/**
 * 2:36
 * 3. All about Tools & Armor
 * 52. Custom Horse Armor
 * testing here
 *
 * 0:15
 * 3. All about Tools & Armor
 * 52. Custom Horse Armor
 * To create Custom Horse Armor, go to ModItems and create a registry object for it, add new HorseArmorItem, you will add two parameters one for the protection as an int and the texture of the armor.
 *
 * Add the translation in en_us.json
 *
 * Copy the ingot for the horse amor json file in mccourse -> models -> item.
 *
 * Add the png file for the horse amor in the textures -> item folder.
 *
 * To add the 3D texture you need to go to assets folder under resources and create a folder called minecraft and then create a folder called textures inside, then inside of that folder create the following series of folders: entity -> horse -> armor.
 *
 * Inside this armor folder add the png of the horse armor.
 */

/**
 * 3:11
 * 4. Intermediate Minecraft Modding Concepts
 * 66. Custom Bows
 * testing here
 *
 * 2:51
 * 4. Intermediate Minecraft Modding Concepts
 * 66. Custom Bows
 * Add png files to textures item folder
 *
 * 1:59
 * 4. Intermediate Minecraft Modding Concepts
 * 66. Custom Bows
 * add the json files to the models item folder
 *
 * 1:46
 * 4. Intermediate Minecraft Modding Concepts
 * 66. Custom Bows
 * add translation in en_us.json
 *
 * 1:18
 * 4. Intermediate Minecraft Modding Concepts
 * 66. Custom Bows
 * from ItemProperties class
 *
 * 0:39
 * 4. Intermediate Minecraft Modding Concepts
 * 66. Custom Bows
 * Add the properties in the ModItemProperties class
 *
 * 0:12
 * 4. Intermediate Minecraft Modding Concepts
 * 66. Custom Bows
 * to create a custom bow,
 *
 * first create a registry object for the ModItems class
 */