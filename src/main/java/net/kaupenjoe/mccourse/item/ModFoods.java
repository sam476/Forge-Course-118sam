package net.kaupenjoe.mccourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
// Note the probability parameter adds a 10% chance of the buff being applied to the user
public class ModFoods {
    public static final FoodProperties TURNIP = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();
}

/**
 * To create a custom food item you need to first add it to the ModItems java file, and add the .food() call to the end,
 *
 * Then create a class called ModFoods in mccourse -> item
 *
 * Note to access the food class to see what the Food class has available to use for your custom food,
 *
 * press shift twice and put foods in the search.
 *
 * From here you go ahead and code out the class.
 *
 * Once you are finished don't forget to add the ModFoods.Allcaps Name of the FoodProperties object back in ModItems java file.
 *
 * After this add a translation for the en_us.json file.
 *
 * Add the json file for the food item in models -> item,
 *
 * Then add the png file for the textures -> item.
 */