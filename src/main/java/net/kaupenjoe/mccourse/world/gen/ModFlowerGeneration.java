package net.kaupenjoe.mccourse.world.gen;

import net.kaupenjoe.mccourse.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModFlowerGeneration {
    public static void generateFlowers(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.PLAINS)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.PINK_ROSE_PLACED);
        }
    }
}

/**
 * 4:14
 * 6. World Generation
 * 81. Custom Flower Generation
 * try out other examples if you can
 *
 * 3:21
 * 6. World Generation
 * 81. Custom Flower Generation
 * create a class for gen folder
 *
 * 2:37
 * 6. World Generation
 * 81. Custom Flower Generation
 * add another feature ModPlacedFeatures class
 *
 * 0:13
 * 6. World Generation
 * 81. Custom Flower Generation
 * to create flower generation you first need to create the feature inside ModConfiguredFeature class
 */