package net.kaupenjoe.mccourse.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(pWorldPosition, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.SIGN_BLOCK_ENTITIES.get();
    }
}

/**
 * 6:24
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * testing here
 *
 * 6:13
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * create a folder for minecraft entity folder (signs folder)
 *
 * 5:38
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * add the png file to textures item folder
 *
 * 5:24
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * add the json file to the models item folder
 *
 * 5:10
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * add the json file for the models block folder
 *
 * 4:56
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * add json files for the blockstates folder, and add translation in en_us.json
 *
 * 4:28
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * method added in MCCourseMod class
 *
 * 3:36
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * code added in ModItems class
 *
 * 1:54
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * create the registry object in ModBlocks class
 *
 * 0:26
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * code explained
 *
 * 0:18
 * 5. Advanced Minecraft Modding Concepts
 * 78. Custom Sign
 * to create a custom sign we first need to create a class inside the entity folder
 */