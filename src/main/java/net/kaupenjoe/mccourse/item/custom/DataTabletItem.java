package net.kaupenjoe.mccourse.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DataTabletItem extends Item {
    public DataTabletItem(Properties pProperties) {
        super(pProperties);
    }

    @Override // right clicking on the item erases all the of the date that is on there
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.getItemInHand(pUsedHand).hasTag()) {
            pPlayer.getItemInHand(pUsedHand).setTag(new CompoundTag());
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override // makes the item glitter like an enchantment
    public boolean isFoil(ItemStack pStack) {
        return pStack.hasTag();
    }

    @Override // checks whether or not a NBT data or a tag is present
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()) {
            String currentOre = pStack.getTag().getString("mccourse.last_ore");
            pTooltipComponents.add(new TextComponent(currentOre));
            String firstOre = pStack.getTag().getString("mccourse.first_ore");
            pTooltipComponents.add(new TextComponent(firstOre));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
/**
 * 8:31
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * fixes explained here
 *
 * 7:45
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * testing here
 *
 * 55. How does NBT Data work?
 * add translation to en_us.json
 *
 * 5:59
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * Additional code added to DowsingRodItem (Setting the tag of the data tablet to MBT data and then inside of here after we found it we add this code)
 *
 * 5:15
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * code explained here
 *
 * 4:53
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * Note we then need to make the registry object for the stack item (DataTabletItem in this case)
 *
 * 4:04
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * Next we need a class InventoryUtil in the util folder.
 *
 * code explained here
 *
 * 1:19
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * Note that we can add NBT data to any different item stack that we want.
 *
 * 1:00
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * Code inside the class explained here
 *
 * 0:53
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * To make an new item stack you go to mccourse -> item -> custom and make a class DataTabletItem.
 *
 * 0:31
 * 4. Intermediate Minecraft Modding Concepts
 * 55. How does NBT Data work?
 * Note item stacks are representations of items inside of your inventory.
 */