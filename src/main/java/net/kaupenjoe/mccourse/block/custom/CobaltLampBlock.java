package net.kaupenjoe.mccourse.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class CobaltLampBlock extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked"); // Note this is how you create a customblockstate property

    public CobaltLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false)); // Note this sets the object light to be false by default
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlock(pPos, pState.setValue(CLICKED, !currentState), 3);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CLICKED);
    }
}

/**
 * 12:40
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * testing here
 *
 * 12:24
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * Add the png file for textures's block folder
 *
 * 11:57
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * Add the json file for the mccourse -> models -> block folder
 *
 * 11:35
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * Add the json file to mccourse blockstates
 *
 * 11:16
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * Add translation to en_us.json
 *
 * 10:09
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * Note you will need to add the block as a block registry object in ModBlocks class.
 *
 * Also note the .lightlevel uses a ternary operator to illuminate light from the object (15 here is max)
 *
 * 8:44
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * Always include the ! before pLevel.isClientSide()
 *
 * 7:27
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * Note if you have multiple block state properties you can add them with a ,
 *
 * 3:32
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * Changing Block states explained here
 *
 * 2:00
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * More about Blockstates Properties here
 *
 * 0:27
 * 4. Intermediate Minecraft Modding Concepts
 * 54. BlockState Properties
 * theory of blocks vs blockstates explained here
 */