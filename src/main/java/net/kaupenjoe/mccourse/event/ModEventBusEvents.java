package net.kaupenjoe.mccourse.event;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.entity.ModEntityTypes;
import net.kaupenjoe.mccourse.entity.client.armor.CobaltArmorRenderer;
import net.kaupenjoe.mccourse.entity.custom.RaccoonEntity;
import net.kaupenjoe.mccourse.entity.custom.TigerEntity;
import net.kaupenjoe.mccourse.event.loot.DowsingRodInIglooAdditionModifier;
import net.kaupenjoe.mccourse.event.loot.TurnipSeedsFromGrassAdditionModifier;
import net.kaupenjoe.mccourse.item.custom.CobaltArmorItem;
import net.kaupenjoe.mccourse.recipe.CobaltBlasterRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new TurnipSeedsFromGrassAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(MCCourseMod.MOD_ID,"turnip_seeds_from_grass")),
                new DowsingRodInIglooAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(MCCourseMod.MOD_ID,"dowsing_rod_in_igloo"))
        );
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
        event.put(ModEntityTypes.TIGER.get(), TigerEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, CobaltBlasterRecipe.Type.ID, CobaltBlasterRecipe.Type.INSTANCE);
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(CobaltArmorItem.class, new CobaltArmorRenderer());
    }
}

/**
 * 9:01
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * testing here, plus important point at the end.
 *
 * 8:40
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * other resources for loot modifiers for forge
 *
 * 6:46
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * in data mccourse folder we create a folder called loot_modifiers and we copy over the json files.
 *
 * 6:09
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * in data folder and forge folder we create a folder called loot_modifiers
 *
 * and copy over a json file called global_loot_modifiers.json
 *
 * 4:58
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * code explained
 *
 * 4:46
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * You will need another class in the event folder called ModeventBusEvents.
 *
 * 1:43
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * code explained
 *
 * 1:37
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * Note only difference between both files is the do apply method
 *
 * 1:05
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * modifiers added here in the folder explained
 *
 * 0:08
 * 4. Intermediate Minecraft Modding Concepts
 * 71. Global Loot Modifiers
 * Note a global loot modifier is a way for us to change the loot tables of for example vanilla loot tables, add stuff to it or even subtract stuff from it. Be careful not to subtract too much as it may break the mod's compatibility.
 *
 * In the event folder create a folder called loot.
 */