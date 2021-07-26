package com.brammie15.coommod.core.init;

import com.brammie15.coommod.CumMod;
import com.brammie15.coommod.common.tiles.CumCentrifugeTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTileInit {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CumMod.MOD_ID);

    //cum centrifuge TE
    public static final RegistryObject<TileEntityType<CumCentrifugeTileEntity>> CUM_CENTRIFUGE = TILE_ENTITY_TYPES.register("cum_centrifuge", () -> TileEntityType.Builder.of(CumCentrifugeTileEntity::new, BlockInit.CUM_CENTRIFUGE.get()).build(null));

}
