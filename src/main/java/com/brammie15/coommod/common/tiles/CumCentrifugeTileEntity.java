package com.brammie15.coommod.common.tiles;

import com.brammie15.coommod.common.blocks.CumCentrifuge;
import com.brammie15.coommod.core.init.ItemInit;
import com.brammie15.coommod.core.init.TileEntityTileInit;
import com.brammie15.coommod.core.util.InventoryTile;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.World;

import java.util.Properties;

public class CumCentrifugeTileEntity extends InventoryTile {
    public int BurningTime = 0;

    public CumCentrifugeTileEntity(final TileEntityType<?> tileEntityType) {
        super(tileEntityType,41);
    }

    public CumCentrifugeTileEntity(){
        this(TileEntityTileInit.CUM_CENTRIFUGE.get());
    }

    public static int getMaxRunningTime() {
        return 120;
    }


    public void RightCLick(World world, BlockPos pos, PlayerEntity player){

    }

    public int getRunningTime() {
        return BurningTime;
    }

    public void setRunningTime(int value) {
        BurningTime = value;
    }
}
