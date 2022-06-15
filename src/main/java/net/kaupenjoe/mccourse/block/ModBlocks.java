package net.kaupenjoe.mccourse.block;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.custom.*;
import net.kaupenjoe.mccourse.item.ModCreativeModeTab;
import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.kaupenjoe.mccourse.world.feature.tree.CherryBlossomTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    /**
     * to create a custom block we need to create a folder called block, then followed by a ModBlocks class,
     * and then a DefferedRegister object and a register method.
     * We then call the register method in the MCCourseMod class (ModBlocks.register(eventBus)).
     *
     * */
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.COURSE_TAB); // this is how you create another block (Note you will need a block.mccourse.name_block": "Cobalt Ore" in the en_us.json file, and a json file in mcccourse -> blockstates, models -> block, models -> item folders similar to the cobalt block one and a png file in the block folder under the textures folder

    public static final RegistryObject<Block> WOLVES_BLOCK = registerBlock("wolves_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB, "tooltip.block.speedy_block");

    public static final RegistryObject<Block> Java_BLOCK = registerBlock("java_block",
            () -> new JavaBlock(BlockBehaviour.Properties.of(Material.EXPLOSIVE)
                    .strength(0f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB, "tooltip.block.java_block");


    public static final RegistryObject<Block> COBALT_STAIRS = registerBlock("cobalt_stairs",
            () -> new StairBlock(() -> ModBlocks.COBALT_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB); // registerBlock method in action
    public static final RegistryObject<Block> COBALT_SLAB = registerBlock("cobalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_BUTTON = registerBlock("cobalt_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops().noCollission()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> COBALT_PRESSURE_PLATE = registerBlock("cobalt_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_FENCE = registerBlock("cobalt_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> COBALT_FENCE_GATE = registerBlock("cobalt_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> COBALT_WALL = registerBlock("cobalt_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_DOOR = registerBlock("cherry_blossom_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_TRAPDOOR = registerBlock("cherry_blossom_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_LAMP = registerBlock("cobalt_lamp",
            () -> new CobaltLampBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops().sound(ModSounds.COBALT_LAMP_SOUNDS)
                    .lightLevel((state) -> state.getValue(CobaltLampBlock.CLICKED) ? 15 : 0)),
            ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> AN_ORE_BLOCK = registerBlock("an_ore_block",
            () -> new AnOreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(ModSounds.COBALT_LAMP_SOUNDS)
                    .lightLevel((state) -> state.getValue(AnOreBlock.CLICKED) ? 7 : 0)),
    ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> TURNIP_CROP = BLOCKS.register("turnip_crop",
            () -> new TurnipCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)
                    .noCollission().noOcclusion()));


    public static final RegistryObject<Block> PINK_ROSE = registerBlock("pink_rose",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 4,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> POTTED_PINK_ROSE = BLOCKS.register("potted_pink_rose",
            () -> new FlowerPotBlock(null, ModBlocks.PINK_ROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));


    public static final RegistryObject<Block> COBALT_BLASTER = registerBlock("cobalt_blaster",
            () -> new CobaltBlasterBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion()),
            ModCreativeModeTab.COURSE_TAB);


    public static final RegistryObject<Block> CHERRY_BLOSSOM_LOG = registerBlock("cherry_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> CHERRY_BLOSSOM_WOOD = registerBlock("cherry_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_CHERRY_BLOSSOM_LOG = registerBlock("stripped_cherry_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_CHERRY_BLOSSOM_WOOD = registerBlock("stripped_cherry_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_PLANKS = registerBlock("cherry_blossom_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);


    public static final RegistryObject<Block> CHERRY_BLOSSOM_SIGN = BLOCKS.register("cherry_blossom_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD), ModWoodTypes.CHERRY_BLOSSOM));

    public static final RegistryObject<Block> CHERRY_BLOSSOM_WALL_SIGN = BLOCKS.register("cherry_blossom_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD), ModWoodTypes.CHERRY_BLOSSOM));


    public static final RegistryObject<Block> CHERRY_BLOSSOM_LEAVES = registerBlock("cherry_blossom_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);


    public static final RegistryObject<Block> CHERRY_BLOSSOM_SAPLING = registerBlock("cherry_blossom_sapling",
            () -> new SaplingBlock(new CherryBlossomTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> WINTER_WINDOW = registerBlock("winter_window",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)), ModCreativeModeTab.COURSE_TAB);



    // both registerBlock and registerBlockItem are helper methods
    // RegistryObject<T> toReturn = BLOCKS.register(name, block); creates the block
    // to see the registerBlock method in action look at the COBALT_BLOCK object
    // from here you'll need a directory called blockstates inside the mccourse folder (this is where you add the json file for the block you want)
    // the block json file will have an object called "variants" followed by a nested object called "model" which points to an underscore json file (cobalt_block in this case)
    // In the models folder -> block folder you will also have a json file for this that includes an object of parent, textures and all (Note the block model determines how the block will look inside the world)
    // In the same models folder -> item folder you will have another json file with an object called parent that points back to json file in the block folder
    // Don't forget to include a "block.mccourse.cobalt_block": "Cobalt Block" in the en_us.json file in the lang folder in blockstates folder
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey); // registers the item associated with this block here
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

/**
 * 6:03
 * 2. Basic Minecraft Modding Concepts
 * 43. Custom Stairs & Slabs
 * testing here
 *
 * 4:50
 * 2. Basic Minecraft Modding Concepts
 * 43. Custom Stairs & Slabs
 * explaination of code here
 *
 * Note the parent is the actual slab or stairs where as the bottom top and side are using the block for textures
 *
 * 4:11
 * 2. Basic Minecraft Modding Concepts
 * 43. Custom Stairs & Slabs
 * After this we add the translation for either or both stairs and slabs into the en_us.json file.
 *
 *
 *
 * 3:23
 * 2. Basic Minecraft Modding Concepts
 * 43. Custom Stairs & Slabs
 * Note here variants. Certain blocks in the world have different properties. Depending on those properties, if the properties facing east, bottom, inner_left then we are going to show a particular model and the y keeps in the rotation in place.
 *
 * 2:15
 * 2. Basic Minecraft Modding Concepts
 * 43. Custom Stairs & Slabs
 * Note you  can always go to the assets inside Gradle:net.minecreaftclientextra 1.18.2 or whatever version to get the code you need for your mods especially for your custom stairs and slabs json files.
 *
 * 0:28
 * 2. Basic Minecraft Modding Concepts
 * 43. Custom Stairs & Slabs
 * To create your custom stars or slabs, you need to go to ModBlocks,
 *
 * then create the registry object for either one (Note that your naming for the stairs object is plural and naming for slabs is singular), also for stairs you have a StairBlock after the new keyword, and for slabs it's SlabBlock,
 *
 * After this you will go to mccourse -> blockstates and add in the json files for your stairs and slabs
 *
 * Note all of these JSON files are available to you in the GitHub repository or as individual gists (do not type this out)
 */

/**
 * 3:32
 * 2. Basic Minecraft Modding Concepts
 * 44. Custom Buttons & Pressure Plates
 * testing here
 *
 * 3:19
 * 2. Basic Minecraft Modding Concepts
 * 44. Custom Buttons & Pressure Plates
 * Then in resources -> assets -> mccourse -> blockstates we add in the json files for the buttons and or pressure plates. Note the button has three different block models while the pressure plate only has two. Your button must have these json files in the models -> block folder: for example,
 *
 * cobalt_button.json, cobalt_button_inventory.json, cobalt_button_pressed.json
 *
 * And for your pressure plate something like this in the same folder: cobalt_pressure_plate.json,
 *
 * cobalt_pressure_plate_down.json.
 *
 * After this you will add only the json file for your button and pressure plate into the item folder below (Note both files point to the block)
 *
 * 0:59
 * 2. Basic Minecraft Modding Concepts
 * 44. Custom Buttons & Pressure Plates
 * To create a custom button we make it a registry object, with a new StoneButtonBlock, followed a .noCollision() extension after after the requires CorrectToolForDrops() .
 *
 * To create a custom pessure plate we make it a registry object, with a new PressurePlateBlock (Note the getSignalStrength method is responsible for the sensitivity).
 *
 * We make these objects in the ModBlocks class.
 *
 * After this we add in the translations for either or both buttons and press plates in the en_us json file.
 */

/**
 * 4:54
 * 2. Basic Minecraft Modding Concepts
 * 45. Custom Fences & Fence Gates & Walls
 * testing here
 *
 * 4:13
 * 2. Basic Minecraft Modding Concepts
 * 45. Custom Fences & Fence Gates & Walls
 * Then we need to add the tags for the fences and walls to work properly.
 *
 * To do this we go to minecraft's blocks folder and add the json files for the fences and walls.
 *
 * 1:31
 * 2. Basic Minecraft Modding Concepts
 * 45. Custom Fences & Fence Gates & Walls
 * explanation of the json files here
 *
 * Note that the fence and wall have a multipart array (here we add different models depending on whether or not something is a neighbor.
 *
 * From here we copy over the json files to the models -> block folder (Note that only the parent is different)
 *
 * Also do this for the item folder below as well in the models folder.
 *
 * 1:02
 * 2. Basic Minecraft Modding Concepts
 * 45. Custom Fences & Fence Gates & Walls
 * To create a custom fence, fence gate and gate wall we need to create their registry objects in the ModBlocks class. Note that after the new keyword for the fence object we add FenceBlock, for the fence gate we add FenceGateBlock , and for the wall object we add WallBlock.
 *
 * Add the translation for these in the en_us.json file.
 *
 * Add the blocks in the resources -> assets -> mccourse -> blockstates folder
 */

/**
 * 2:34
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * testing here
 *
 * 2:24
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * add the png files for textures block folder
 *
 * 2:09
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * add the json file for models item folder
 *
 * 1:50
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * add the json file for models block folder
 *
 * 1:37
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * add the translation in en_us.json
 *
 * 1:31
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * add the json file for blockstates folder
 *
 * 1:24
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * Next we need to call clientSetup for the custom flower
 *
 * 1:03
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * Note you might need no collusion or no collision
 *
 * 0:14
 * 4. Intermediate Minecraft Modding Concepts
 * 59. Custom Flower
 * To create a custom flower
 *
 * we first need to create a registry object in ModBlocks folder.
 */

/**
 * 3:02
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * more about the loot table here
 *
 * 2:46
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * testing here
 *
 * 2:28
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * Note you wont need the texture but add the cutout to MCCourseMod
 *
 * 1:54
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * add the translation in en_us.json
 *
 * 1:50
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * add the json file for models block folder
 *
 * 1:46
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * Add the json file for blockstates
 *
 * 1:08
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * Add the pot to the setup method in MCCourseMod,
 *
 * also code exlpained
 *
 * 0:38
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * Note Blocks.register is used here as well
 *
 * 0:05
 * 4. Intermediate Minecraft Modding Concepts
 * 60. Custom Flower Pots
 * To create a custom flower pot,
 *
 * first create a registry object in ModBlocks
 */

/**
 * 7:48
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * testing here
 *
 * 7:14
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * also add the json for the mccourse, tags, blocks, mineable folder
 *
 * 6:53
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * tags are needed in the minecraft folder , tags, blocks and then copy over the json files
 *
 * 6:38
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * add png files to textures block folder
 *
 * 6:28
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * add the json files to models item folder
 *
 * 6:07
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * add json file to models block folder
 *
 * 5:44
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * add translation to en_us.json
 *
 * 5:20
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * add the json files to mccourse blockstates folder,
 *
 * 1:54
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * create a registry object in the ModBlocks class
 *
 * 0:45
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * code explained
 *
 * 0:32
 * 5. Advanced Minecraft Modding Concepts
 * 77. Custom Wood
 * to create our custom wood, we need a custom block class in mccourse's custom folder
 */

/**
 * 7:33
 * 6. World Generation
 * 79. Creating a Custom Tree
 * testing here
 *
 * 4:17
 * 6. World Generation
 * 79. Creating a Custom Tree
 * add the a new class to the feature folder
 *
 * 3:46
 * 6. World Generation
 * 79. Creating a Custom Tree
 * add the png files to the textures block folder
 *
 * 3:29
 * 6. World Generation
 * 79. Creating a Custom Tree
 * add the json files to the block's item folder
 *
 * 2:58
 * 6. World Generation
 * 79. Creating a Custom Tree
 * add the translation in the en_us.json
 *
 * 2:46
 * 6. World Generation
 * 79. Creating a Custom Tree
 * add the json files to blockstates folder
 *
 * 2:30
 * 6. World Generation
 * 79. Creating a Custom Tree
 * add in the methods in MCCourseMod folder
 *
 * 1:49
 * 6. World Generation
 * 79. Creating a Custom Tree
 * Inside this folder you will create a folder (feature) inside this folder you will create a folder (tree) and then create a class inside that folder
 *
 * 1:28
 * 6. World Generation
 * 79. Creating a Custom Tree
 * create a new package (World) in the mccourse folder
 *
 * 0:35
 * 6. World Generation
 * 79. Creating a Custom Tree
 * these objects are created in the ModBlocks class
 *
 * 0:21
 * 6. World Generation
 * 79. Creating a Custom Tree
 * To create a custom tree Note you will need logs, wood, sapling and leaves.
 *
 * This video adds in the sapling and leaves.
 */