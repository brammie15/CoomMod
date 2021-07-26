package com.brammie15.coommod.core.init;

import com.brammie15.coommod.CumMod;
import com.brammie15.coommod.common.blocks.CumCentrifuge;
import com.brammie15.coommod.common.containers.CumCentrifugeContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeInit {

    public static DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, CumMod.MOD_ID);

    public static final RegistryObject<ContainerType<CumCentrifugeContainer>> CUM_CENTRIFUGE = CONTAINER_TYPES.register("cum_centrifuge", () -> new ContainerType<>(CumCentrifugeContainer::getClientContainer));

}
