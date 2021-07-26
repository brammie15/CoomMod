package com.brammie15.coommod.core.init;

import com.brammie15.coommod.CumMod;
import com.brammie15.coommod.common.blocks.CumCentrifuge;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CumMod.MOD_ID);

    public static final RegistryObject<CumCentrifuge> CUM_CENTRIFUGE = BLOCKS.register("cum_centrifuge", () -> new CumCentrifuge(AbstractBlock.Properties.of(Material.METAL)));

    public static final RegistryObject<Block> CUM_BLOCK = BLOCKS.register("cum_block", () -> new Block(AbstractBlock.Properties.of(Material.WATER, MaterialColor.COLOR_BLACK).instabreak()));
}
