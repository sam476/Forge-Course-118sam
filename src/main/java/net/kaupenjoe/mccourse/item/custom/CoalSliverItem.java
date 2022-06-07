package net.kaupenjoe.mccourse.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;
// To add a new custom fuel, we need to add it to the Item -> custom folder,
// Then we need to add it to the ModItems java file,
// Then add a json file for this in models -> item,
// add a translation for this in en_us.json,
// then add a png file for this in textures -> item
// Note you will always have to make a new custom class when you make a new custom fuel
public class CoalSliverItem extends Item {
    public CoalSliverItem(Properties pProperties) {
        super(pProperties);
    }

    @Override  // gets the time the item takes to burn (this value is returned)
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 400;
    }
}
