package com.brammie15.coommod.common.blocks;

import com.brammie15.coommod.common.tiles.CumCentrifugeTileEntity;
import com.brammie15.coommod.core.init.TileEntityTileInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CumCentrifuge extends Block {
    public CumCentrifuge(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTileInit.CUM_CENTRIFUGE.get().create();

    }

    @Override
    public ActionResultType use(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult blockRayTraceResult) {

        TileEntity te = world.getBlockEntity(blockPos);

        if(te instanceof CumCentrifugeTileEntity){
            //call rightclick method in the TE ~~doing bc i cant get rightclik in the TE~~
            ((CumCentrifugeTileEntity) te).RightCLick(world,blockPos,playerEntity);
        }

        return super.use(blockState, world, blockPos, playerEntity, hand, blockRayTraceResult);
    }
}
