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

public class ModTreeGeneration {
    public static void generateTrees(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.PLAINS)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.CHERRY_BLOSSOM_PLACED);
        }
    }
}

/**
 * 10:00
 * 6. World Generation
 * 80. Custom Tree Generation
 * testing here
 *
 * 8:26
 * 6. World Generation
 * 80. Custom Tree Generation
 * create a class (ModWorldEvents) in the world folder
 *
 * 6:58
 * 6. World Generation
 * 80. Custom Tree Generation
 * create a class in the new folder (ModTreeGeneration)
 *
 * 6:47
 * 6. World Generation
 * 80. Custom Tree Generation
 * create a folder called (gen) in the world folder
 *
 * 4:48
 * 6. World Generation
 * 80. Custom Tree Generation
 * create a class (ModPlacedFeatures) in the feature folder
 *
 * 3:18
 * 6. World Generation
 * 80. Custom Tree Generation
 * code in depth explained here
 *
 * 0:18
 * 6. World Generation
 * 80. Custom Tree Generation
 * To create a custom tree generation we need to go back to our ModConfiguredFeature and add our new feature
 */