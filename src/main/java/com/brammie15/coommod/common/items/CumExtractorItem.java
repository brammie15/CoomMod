package com.brammie15.coommod.common.items;

import com.brammie15.coommod.core.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CumExtractorItem extends Item {
    public CumExtractorItem(Properties properties) {
        super(properties);
    }
    public boolean HasBeenUsed = false;
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {


        if(!world.isClientSide()){
            //give raw cum
            playerEntity.addItem(new ItemStack(ItemInit.RAW_CUM.get(), 1));
            //prob not the best way to do this cuz cant always be sure if hand item is cum extractor? i guess
            playerEntity.setItemInHand(hand, new ItemStack(ItemInit.CUM_EXTRACTOR_USED.get(),1));
        }


        return super.use(world, playerEntity, hand);
    }
}
