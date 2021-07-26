package com.brammie15.coommod;

import com.brammie15.coommod.core.init.BlockInit;
import com.brammie15.coommod.core.init.ItemInit;
import com.brammie15.coommod.core.init.TileEntityTileInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CumMod.MOD_ID)
public class CumMod {
    public static final Logger LOGGER = LogManager.getLogger();
    //mod id
    public static final String MOD_ID = "cum";
    public static final ItemGroup CUM_ITEMGROUP = new CumGroup("cum_group");
    public CumMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        TileEntityTileInit.TILE_ENTITY_TYPES.register(bus);
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    public static final class CumGroup extends ItemGroup{

        public CumGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.RAW_CUM.get().getDefaultInstance();
        }

    }
}


