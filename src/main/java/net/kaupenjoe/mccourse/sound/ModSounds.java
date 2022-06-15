package net.kaupenjoe.mccourse.sound;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCCourseMod.MOD_ID);

    public static RegistryObject<SoundEvent> DOWSING_ROD_FOUND_ORE
            = registerSoundEvents("dowsing_rod_found_ore");

    public static RegistryObject<SoundEvent> COBALT_LAMP_BREAK = registerSoundEvents("cobalt_lamp_break");
    public static RegistryObject<SoundEvent> COBALT_LAMP_STEP = registerSoundEvents("cobalt_lamp_step");
    public static RegistryObject<SoundEvent> COBALT_LAMP_PLACE = registerSoundEvents("cobalt_lamp_place");
    public static RegistryObject<SoundEvent> COBALT_LAMP_HIT = registerSoundEvents("cobalt_lamp_hit");
    public static RegistryObject<SoundEvent> COBALT_LAMP_FALL = registerSoundEvents("cobalt_lamp_fall");

    public static RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvents("bar_brawl");




    public static final ForgeSoundType COBALT_LAMP_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.COBALT_LAMP_BREAK, ModSounds.COBALT_LAMP_STEP, ModSounds.COBALT_LAMP_PLACE,
            ModSounds.COBALT_LAMP_HIT, ModSounds.COBALT_LAMP_FALL);


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(MCCourseMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

/**
 * 6:07
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * testing here
 *
 * 5:32
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * How to access other sounds explained here
 *
 * 5:28
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * Note this is how you add a sound or call one
 *
 * 5:00
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * code for the dowsing rod sound effect in the DowsingRodItem class explained here
 *
 * 4:44
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * Note you can add multiple entries
 *
 * 4:09
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * Note the name must match in the sounds array
 *
 * also Note the ending of a sound file must be .ogg
 *
 * 3:58
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * In mccourse folder we add a new folder called sounds, then copy over the sounds.json file
 *
 * 3:08
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * Note the naming has to match
 *
 * 2:57
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * code explained
 *
 * 2:43
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * We add the sound file in the mccourse folder, but note we need a json file called sounds.json
 *
 * 1:11
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * more code explained about ModSounds
 *
 * 1:03
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * Note we call the register method for ModSounds in MCCourseMod
 *
 * 0:29
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * code explained here
 *
 * 0:07
 * 4. Intermediate Minecraft Modding Concepts
 * 61. Custom Sounds
 * To create a custom sound,
 *
 * first we need to register them so in mccourse folder we create a folder called sound.
 *
 * Then inside their we create a new class called ModSounds
 */

/**
 * 2:49
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * testing here
 *
 * 2:36
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * add .sound(ModSounds.OBJECT_SOUND_FROM_MODSOUNDS)
 *
 * 2:21
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * Steps to add sound to the block explained here
 *
 * 2:10
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * sounds files are then coppied over to the sounds folder in mccourse's folder
 *
 * 1:42
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * important points here
 *
 * 1:24
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * Note you willl need to copy these sounds into mccourse's sound.json file
 *
 * 0:59
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * you need the sound events and a registry object (all done in ModSounds.java)
 *
 * 0:25
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * code explained here
 *
 * 0:02
 * 4. Intermediate Minecraft Modding Concepts
 * 62. Custom Sounds for Blocks
 * To create a custom sound for blocks,
 *
 * Note a sound type includes five different sounds and represents sound for a particular block.
 * (these include a breaking sound, a stepping sound, placing sound, a hit sound and a full sound)
 */

/**
 * 3:15
 * 4. Intermediate Minecraft Modding Concepts
 * 63. Custom Music Discs
 * testing here
 *
 * 2:53
 * 4. Intermediate Minecraft Modding Concepts
 * 63. Custom Music Discs
 * add the json file for the models item folder
 *
 * 2:20
 * 4. Intermediate Minecraft Modding Concepts
 * 63. Custom Music Discs
 * Add the sound translation to en_us.json
 *
 * 1:26
 * 4. Intermediate Minecraft Modding Concepts
 * 63. Custom Music Discs
 * To create the disk you need to create a new item in the ModItems class
 *
 * 1:18
 * 4. Intermediate Minecraft Modding Concepts
 * 63. Custom Music Discs
 * copy over the sound file to sounds folder under mccourse folder
 *
 * 1:03
 * 4. Intermediate Minecraft Modding Concepts
 * 63. Custom Music Discs
 * make sure it is mono otherwise it will be heard on the entire server
 *
 * 0:42
 * 4. Intermediate Minecraft Modding Concepts
 * 63. Custom Music Discs
 * Add this to the sounds.json file under mccourse folder
 *
 * 0:06
 * 4. Intermediate Minecraft Modding Concepts
 * 63. Custom Music Discs
 * To add a custom music disk,
 *
 * Note this is a normal sound event,
 *
 * this means in ModSounds you need to add a RegistryObject for this
 */