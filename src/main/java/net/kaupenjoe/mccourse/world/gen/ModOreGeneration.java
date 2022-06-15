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

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModPlacedFeatures.COBALT_ORE_PLACED);
    }
}
/**
 * 6:40
 * 6. World Generation
 * 82. Custom Ore Generation
 * testing here,
 *
 * also note play around with the vanilla code if you can
 *
 * 4:57
 * 6. World Generation
 * 82. Custom Ore Generation
 * ModOreGeneration class explained here
 *
 * 3:09
 * 6. World Generation
 * 82. Custom Ore Generation
 * add the feature to ModPlacedFeatures class
 *
 * 0:30
 * 6. World Generation
 * 82. Custom Ore Generation
 * to create a custom ore generation once again create the feature and its object in ModConfiguredFeature class
 */