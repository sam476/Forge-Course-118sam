package net.kaupenjoe.mccourse.painting;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, MCCourseMod.MOD_ID);

    public static final RegistryObject<Motive> PLANT =
            PAINTING_MOTIVES.register("plant", () -> new Motive(16, 16));
    public static final RegistryObject<Motive> WANDERER =
            PAINTING_MOTIVES.register("wanderer", () -> new Motive(16, 32));
    public static final RegistryObject<Motive> SUNSET =
            PAINTING_MOTIVES.register("sunset", () -> new Motive(32, 16));

    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }
}
/**
 * 2:53
 * 4. Intermediate Minecraft Modding Concepts
 * 70. Custom Paintings
 * testing here
 *
 * 2:31
 * 4. Intermediate Minecraft Modding Concepts
 * 70. Custom Paintings
 * About credits here
 *
 * 2:15
 * 4. Intermediate Minecraft Modding Concepts
 * 70. Custom Paintings
 * create a new folder called painting inside the textures folder
 *
 * 1:09
 * 4. Intermediate Minecraft Modding Concepts
 * 70. Custom Paintings
 * more code explained here
 *
 * 1:00
 * 4. Intermediate Minecraft Modding Concepts
 * 70. Custom Paintings
 * add the register method in MCCourseMod class
 *
 * 0:27
 * 4. Intermediate Minecraft Modding Concepts
 * 70. Custom Paintings
 * code explained here
 *
 * 0:04
 * 4. Intermediate Minecraft Modding Concepts
 * 70. Custom Paintings
 * to add custom paintings,
 *
 * we create a new folder in mccourse folder called painting,
 *
 * then we create a class called ModPaintings class.
 */