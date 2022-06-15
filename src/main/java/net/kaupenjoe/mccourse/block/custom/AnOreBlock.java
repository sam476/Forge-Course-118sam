package net.kaupenjoe.mccourse.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class AnOreBlock extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public AnOreBlock(Properties properties){
        super(properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRand) {
        if (pState.getValue(CLICKED)) {
            spawnParticles(pLevel, pPos);
        }

    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        Random pRand = new Random(); // created pRand object to fulfill the animateTick call
        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlock(pPos, pState.setValue(CLICKED, !currentState), 3);
            animateTick(pState, pLevel, pPos, pRand); // had to use animateTick to make particles spawn
        }

        return InteractionResult.SUCCESS;
    }

    private static void spawnParticles(Level pLevel, BlockPos pPos) {
        double d0 = 0.5625D;
        Random random = pLevel.random;

        for(Direction direction : Direction.values()) {
            BlockPos blockpos = pPos.relative(direction);
            if (!pLevel.getBlockState(blockpos).isSolidRender(pLevel, blockpos)) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getStepX() : (double)random.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getStepY() : (double)random.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getStepZ() : (double)random.nextFloat();
                pLevel.addParticle(DustParticleOptions.REDSTONE, (double)pPos.getX() + d1, (double)pPos.getY() + d2, (double)pPos.getZ() + d3, 0.0D, 0.0D, 0.0D);
            }
        }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CLICKED);
    }
}

/**
 * 2:49
 * 4. Intermediate Minecraft Modding Concepts
 * 69. Custom Advancements
 * advancement generator explained here
 *
 * 2:04
 * 4. Intermediate Minecraft Modding Concepts
 * 69. Custom Advancements
 * testing here
 *
 * 0:29
 * 4. Intermediate Minecraft Modding Concepts
 * 69. Custom Advancements
 * code explained
 *
 * 0:06
 * 4. Intermediate Minecraft Modding Concepts
 * 69. Custom Advancements
 * to add custom advancements,
 *
 * add json files data mccourse advancements folder
 */