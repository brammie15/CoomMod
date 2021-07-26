package com.brammie15.coommod.common.items;

import com.brammie15.coommod.core.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CumExtractorItemUsed extends Item {
    public CumExtractorItemUsed(Properties properties) {
        super(properties);
    }
    public boolean HasBeenUsed = false;
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {


        if(!world.isClientSide()){
            //show message when its rightclicked ( am gonna replace with chat message thing prob)
            playerEntity.displayClientMessage(new TranslationTextComponent("Item.Dirty.cum_extractor"),false);
        }


        return super.use(world, playerEntity, hand);
    }
}
