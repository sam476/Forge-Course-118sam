package net.kaupenjoe.mccourse.block.custom;

import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

public class TurnipCropBlock extends BeetrootBlock {
    public TurnipCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.TURNIP_SEEDS.get();
    }
}

/**
 * 9:23
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * testing here
 *
 * 8:10
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Add the json file for mccourse -> loot_tables -> blocks.
 *
 * also code explained here
 *
 * 7:39
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * beetroots file was used here
 *
 * 7:07
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Add the json files for the models item folder
 *
 * 6:48
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Add the json files to models block folder
 *
 * 6:30
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Add the json file for blockstates file
 *
 * 5:43
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Add translation in en_us.json
 *
 * 5:38
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Add the Rendering for the Crop in MCCourseMod
 *
 * 4:32
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * code explained
 *
 * 4:25
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Also create the item as a RegistryObject in ModItems
 *
 * 3:42
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * This is because we do not want a block item associated with this particular crop here
 *
 * 3:46
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Note you will need Blocks.register instead of registerBlock
 *
 * 3:27
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * code explained here
 *
 * 3:18
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * After Overriding then create a registry object in ModBlocks
 *
 * 1:16
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * code explained here
 *
 * 1:12
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * Note you will need to override the getBaseSeedId()
 *
 * 0:07
 * 4. Intermediate Minecraft Modding Concepts
 * 57. Custom Crops
 * To create a Custom Crop,
 *
 * create a class in mccourse -> block -> custom,
 */