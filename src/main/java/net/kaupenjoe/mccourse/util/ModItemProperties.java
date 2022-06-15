package net.kaupenjoe.mccourse.util;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), new ResourceLocation(MCCourseMod.MOD_ID, "on"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));

        makeBow(ModItems.COBALT_BOW.get());
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(item, new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        });
    }
}
/**
 * 4:44
 * 4. Intermediate Minecraft Modding Concepts
 * 56. Item Properties
 * testing here
 *
 * 4:20
 * 4. Intermediate Minecraft Modding Concepts
 * 56. Item Properties
 * add the other data tablet png on in textures -> item folder
 *
 * 3:34
 * 4. Intermediate Minecraft Modding Concepts
 * 56. Item Properties
 * code explained here
 *
 * 2:59
 * 4. Intermediate Minecraft Modding Concepts
 * 56. Item Properties
 * Note we use this inside the item model.
 *
 * create a new item model json file with _on.
 *
 *
 *
 * 0:52
 * 4. Intermediate Minecraft Modding Concepts
 * 56. Item Properties
 * code created here
 *
 * 0:43
 * 4. Intermediate Minecraft Modding Concepts
 * 56. Item Properties
 * To create an item property we first need to make class called ModItemProperties in the util folder.
 *
 * 0:26
 * 4. Intermediate Minecraft Modding Concepts
 * 56. Item Properties
 * Note similar to a block state property, and item property enables us to point to a different item, model, space and file if the property changes its value.
 */