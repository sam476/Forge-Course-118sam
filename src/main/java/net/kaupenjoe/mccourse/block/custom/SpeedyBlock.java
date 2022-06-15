package net.kaupenjoe.mccourse.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;
// To create an Advanced Block we first need the "custom" folder and then the block class (SpeedyBlock in this case)
// Note we have to make a registry object for this block in ModBlocks,
// then crate a block json for this in mccourse -> blockstates folder,
// then create a block json for this in models -> block folder ( the name to the right in the code points to a texture),
// then create a block json for this in models -> item folder,
// then finally add a block png for the textures -> item folder.

public class SpeedyBlock extends Block {
    public SpeedyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRandom) {
        float chance = 0.35f;

        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
        }

        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
        }

        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
        }

        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
        }
    }

    @Override // functionality for the speedyBlock
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(!pLevel.isClientSide()) {  // Note the ! is important because without it we're checking off on the client side (we want to be on the server)
            if(pEntity instanceof LivingEntity) {
                LivingEntity entity = ((LivingEntity) pEntity);
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}

/**
 * 1:56
 * 4. Intermediate Minecraft Modding Concepts
 * 68. Spawning Particles
 * testing and other details here
 *
 * 0:23
 * 4. Intermediate Minecraft Modding Concepts
 * 68. Spawning Particles
 * code explained here
 *
 * 0:04
 * 4. Intermediate Minecraft Modding Concepts
 * 68. Spawning Particles
 * to spawn particles,
 *
 * create a method in SpeedBlock class called animateTick,
 */
