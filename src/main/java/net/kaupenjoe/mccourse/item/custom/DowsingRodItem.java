package net.kaupenjoe.mccourse.item.custom;

import io.netty.channel.epoll.EpollTcpInfo;
import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.kaupenjoe.mccourse.util.InventoryUtil;
import net.kaupenjoe.mccourse.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }
    //Note an advanced item like a normal item must be coppied as a registryobject in ModItems (Note that you must use "new" after the arrow () ->)
    // Note you will need to add this item to the en_us.json file as well
    // Note you will need to add the item json file to the item under models folder -> item
    // Note you will finally need to add the item png file to the textures folder ->  item
    @Override  // this method gets the coordinates of the block below the one the player interacts with
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;


            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();
                Block firstBlock = pContext.getLevel().getBlockState(positionClicked.atY(1)).getBlock();


                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;

                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
                        addNbtToDataTablet(player, positionClicked.below(i), blockBelow);
                    }

                    pContext.getLevel().playSound(player, positionClicked, ModSounds.DOWSING_ROD_FOUND_ORE.get(),
                            SoundSource.BLOCKS, 1f, 1f);

                    break;
                }

                if(isValuableBlock(blockBelow) && i == 1) {
                    outputValuableCoordinates(positionClicked.atY(1), player, firstBlock);
                    player.sendMessage(new TextComponent("first block found!"),
                            player.getUUID());

                    if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
                        addNbtToDataTablet2(player, positionClicked.atY(1), firstBlock);
                    }


                    pContext.getLevel().playSound(player, positionClicked, ModSounds.DOWSING_ROD_FOUND_ORE.get(),
                            SoundSource.BLOCKS, 1f, 1f);
                }
            }

            if(!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.mccourse.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }
        // allows for the durabillity on the item to change or get damaged (add or substract one durabillity each time the item is used)
        // Also notice we added durability in the ModItems java file
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void addNbtToDataTablet(Player player, BlockPos pos, Block blockFound) {
        ItemStack dataTablet =
                player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("mccourse.last_ore", "Found " + blockFound.asItem().getRegistryName().toString() + " at (" +
                pos.getX() + ", "+ pos.getY() + ", "+ pos.getZ() + ")");
        dataTablet.setTag(nbtData);
    }
    private void addNbtToDataTablet2(Player player, BlockPos pos, Block blockFound) {
        ItemStack dataTablet =
                player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("mccourse.first_ore", "Found first block " + blockFound.asItem().getRegistryName().toString() + " at (" +
                pos.getX() + ", "+ pos.getY() + ", "+ pos.getZ() + ")");
        dataTablet.setTag(nbtData);
    }

    /**
     * 4:49
     * 2. Basic Minecraft Modding Concepts
     * 41. Custom Tooltips
     * Note you can add the functionality of holding shift to the tooltip.
     *
     * 2:57
     * 2. Basic Minecraft Modding Concepts
     * 41. Custom Tooltips
     * This is how you add custom tooltips for blocks,
     *
     * we need to create two overridden methods, one for registerBlock and one for registerBlockItem, both will have a new String paramenter called tooltipKey.
     *
     * Follow this marker for more details.
     *
     * Note you will need to add the tooltipkey at the end of COURSE_TAB in the block in ModBlocks class file (something like "tooltip.block.speedy_block");
     *
     * Note after this you will add this tooltip to the en_us.json file  along with it's message.
     *
     *
     *
     *
     *
     * 0:13
     * 2. Basic Minecraft Modding Concepts
     * 41. Custom Tooltips
     * Note custom tools are that what you see when you hover over a particular item.
     *
     * Note that in order to create a custom tooltip you will need a custom class for this, but also know we can add this to not only an Item class but also a Block class.
     *
     * To start creating a custom tooltip we add the appendHoverText method to the class where we want it. The keys are required as parameters for TranslatableComponent.
     *
     * Add this to the en_us.json
     *
     * This is how you do it for items
     * @param pStack
     * @param pLevel
     * @param pTooltipComponents
     * @param pIsAdvanced
     */
    @Override //this displays the text when the item is hovered in the inventory
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.mccourse.dowsing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.mccourse.dowsing_rod.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) {
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
    }
}
