package com.brammie15.coommod.core.init;

import com.brammie15.coommod.CumMod;
import com.brammie15.coommod.common.items.CumExtractorItem;
import com.brammie15.coommod.common.items.CumExtractorItemUsed;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CumMod.MOD_ID);

    //raw cum
    public static final RegistryObject<Item> RAW_CUM = ITEMS.register("raw_cum", () -> new Item(new Item.Properties().tab(  CumMod.CUM_ITEMGROUP)));

    //cum extractor
    public static final RegistryObject<CumExtractorItem> CUM_EXTRACTOR = ITEMS.register("cum_extractor", () -> new CumExtractorItem(new Item.Properties().tab(CumMod.CUM_ITEMGROUP).stacksTo(1)));
    //used cum extractor
    public static final RegistryObject<CumExtractorItemUsed> CUM_EXTRACTOR_USED = ITEMS.register("cum_extractor_used", () -> new CumExtractorItemUsed(new Item.Properties().tab(CumMod.CUM_ITEMGROUP).stacksTo(1)));




    //Block Items
    //cum block
    public static final RegistryObject<BlockItem> CUM_BLOCK = ITEMS.register("cum_block", () -> new BlockItem(BlockInit.CUM_BLOCK.get(),new Item.Properties().tab(CumMod.CUM_ITEMGROUP)));
    //cum centrifuge
    public static final RegistryObject<BlockItem> CUM_CENTRIFUGE = ITEMS.register("cum_centrifuge", () -> new BlockItem(BlockInit.CUM_CENTRIFUGE.get(),new Item.Properties().tab(CumMod.CUM_ITEMGROUP)));

}
