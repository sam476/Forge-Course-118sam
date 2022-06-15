package net.kaupenjoe.mccourse.screen;

import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.entity.CobaltBlasterBlockEntity;
import net.kaupenjoe.mccourse.screen.slot.ModFuelSlot;
import net.kaupenjoe.mccourse.screen.slot.ModResultSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class CobaltBlasterMenu extends AbstractContainerMenu {
    private final CobaltBlasterBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public CobaltBlasterMenu(int windowId, Inventory inv, FriendlyByteBuf extraData) {
        this(windowId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public CobaltBlasterMenu(int windowId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.COBALT_BLASTER_MENU.get(), windowId);
        checkContainerSize(inv, 4);
        blockEntity = ((CobaltBlasterBlockEntity) entity);
        this.level = inv.player.level;
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new ModFuelSlot(handler, 0, 18, 50));
            this.addSlot(new SlotItemHandler(handler, 1, 66, 16));
            this.addSlot(new SlotItemHandler(handler, 2, 66, 50));
            this.addSlot(new ModResultSlot(handler, 3, 114, 33));
        });

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public boolean hasFuel() {
        return data.get(2) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressArrowSize = 26; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledFuelProgress() {
        int fuelProgress = this.data.get(2);
        int maxFuelProgress = this.data.get(3);
        int fuelProgressSize = 14;

        return maxFuelProgress != 0 ? (int)(((float)fuelProgress / (float)maxFuelProgress) * fuelProgressSize) : 0;
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 4;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.COBALT_BLASTER.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
}
/**
 * 25:38
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * testing here
 *
 * 24:58
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * Important for the client set up method here (added to the MCCourseMod class)
 *
 * 23:32
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * the screen of colbalt explained
 *
 * 22:34
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * fitting the menu (also note the png file was copied over to the textures gui folder)
 *
 * 22:03
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * call the eventBus in MCCourseMod
 *
 * 20:33
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * more code explained
 *
 * 20:02
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * slot classes explained
 *
 * 17:26
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * code explained here
 *
 * 16:43
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * we copy over two slot classes, the fuel slot and the result slot
 *
 * 16:32
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * Inside screen we create a folder called slot
 *
 * 16:31
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * and another class ModMenuTypes
 *
 * 16:11
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * in mccourse folder we create the following folders: screen and inside of screen we create two classes, the screen and the menu.
 *
 * 15:33
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * hardcoded recipe here (not recommended practice)
 *
 * 11:35
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * important point here
 *
 * 7:39
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * more code explained here
 *
 * 6:39
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * method defined here
 *
 * 5:41
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * code explained
 *
 * 5:27
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * call the eventBus register method in MCCourseMod class
 *
 * 4:09
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * we make a class called entity in mccourse folder,
 *
 * and we create two classes for it.
 *
 * 0:31
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * theory explained here
 *
 * 0:10
 * 5. Advanced Minecraft Modding Concepts
 * 75. Custom Block Entity
 * Note Block Entities are blocks that have a particular functionality associated with it.
 */

/**
 * 22:01
 * 5. Advanced Minecraft Modding Concepts
 * 76. Creating custom Recipe Types
 * testing here
 *
 * 21:15
 * 5. Advanced Minecraft Modding Concepts
 * 76. Creating custom Recipe Types
 * copy over the recipe to mccourse's recipes folder
 *
 * 7:19
 * 5. Advanced Minecraft Modding Concepts
 * 76. Creating custom Recipe Types
 * more code added and explained
 *
 * 7:01
 * 5. Advanced Minecraft Modding Concepts
 * 76. Creating custom Recipe Types
 * register method added via MCCourseMod
 *
 * 1:13
 * 5. Advanced Minecraft Modding Concepts
 * 76. Creating custom Recipe Types
 * code explained
 *
 * 0:51
 * 5. Advanced Minecraft Modding Concepts
 * 76. Creating custom Recipe Types
 * copy over the recipe classes
 *
 * 0:38
 * 5. Advanced Minecraft Modding Concepts
 * 76. Creating custom Recipe Types
 * mccourse package we create a new package (Recipe)
 */