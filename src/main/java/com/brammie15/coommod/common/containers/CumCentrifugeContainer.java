package com.brammie15.coommod.common.containers;

import com.brammie15.coommod.common.tiles.CumCentrifugeTileEntity;
import com.brammie15.coommod.core.init.BlockInit;
import com.brammie15.coommod.core.init.ContainerTypeInit;
import com.brammie15.coommod.core.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CumCentrifugeContainer extends Container {

    static class CumCentrifugeSyncData implements IIntArray {

        private final CumCentrifugeTileEntity te;

        public CumCentrifugeSyncData(final CumCentrifugeTileEntity te) {
            this.te = te;
        }

        @Override
        public int get(final int index) {
            if (index == 0)
                return this.te.getRunningTime();
            return 0;
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public void set(final int index, final int value) {
            if (index == 0) {
                this.te.setRunningTime(value);
            }
        }

    }

    static class FuelSlot extends SlotItemHandler {

        public FuelSlot(final IItemHandler itemHandler, final int index, final int xPosition, final int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(final ItemStack stack) {
            return stack.getItem() == Items.WET_SPONGE;
        }
    }

    private static CumCentrifugeTileEntity tile;

    public static CumCentrifugeContainer getClientContainer(final int id, final PlayerInventory playerInventory) {
        return new CumCentrifugeContainer(id, playerInventory, new ItemStackHandler(5), BlockPos.ZERO, new IntArray(1));
    }

    public static IContainerProvider getServerContainerProvider(final CumCentrifugeTileEntity te,
                                                                final BlockPos activationPos) {
        tile = te;
        return (id, playerInventory, serverPlayer) -> new CumCentrifugeContainer(id, playerInventory, te.getInventory(),
                activationPos, new CumCentrifugeSyncData(te));
    }

    private final IWorldPosCallable callable;

    public final IIntArray data;

    protected CumCentrifugeContainer(final int id, final PlayerInventory playerInventory, final IItemHandler slots,
                                     final BlockPos pos, final IIntArray data) {
        super(ContainerTypeInit.CUM_CENTRIFUGE.get(), id);
        this.callable = IWorldPosCallable.create(playerInventory.player.level, pos);
        this.data = data;

        final int slotSizePlus2 = 18;

        // Cum Centrifuge Inventory
        addSlot(new SlotItemHandler(slots, 0, 36, 17) {
            @Override
            public boolean mayPlace(final ItemStack stack) {
                return stack.getItem() == ItemInit.RAW_CUM.get();
            }
        });
        addSlot(new FuelSlot(slots, 1, 16, 53));
        addSlot(new FuelSlot(slots, 2, 36, 53));
        addSlot(new FuelSlot(slots, 3, 56, 53));
        addSlot(new SlotItemHandler(slots, 4, 129, 35) {
            @Override
            public boolean mayPlace(final ItemStack stack) {
                return false;
            }
        });

        // Main Player Inventory
        final int startX = 8;
        final int startY = 84;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                addSlot(new Slot(playerInventory, 9 + row * 9 + column, startX + column * slotSizePlus2,
                        startY + row * slotSizePlus2));
            }
        }

        // Player Hotbar
        final int hotbarY = 142;
        for (int column = 0; column < 9; ++column) {
            addSlot(new Slot(playerInventory, column, startX + column * slotSizePlus2, hotbarY));
        }

        addDataSlots(data);
    }

    public int getScaledProgress() {
        return tile.getRunningTime() != 0 && CumCentrifugeTileEntity.getMaxRunningTime() != 0
                ? tile.getRunningTime() * 24 / CumCentrifugeTileEntity.getMaxRunningTime()
                : 0;
    }

    public CumCentrifugeTileEntity getTile() {
        return tile;
    }

    @Override
    public ItemStack quickMoveStack(final PlayerEntity player, final int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        final Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            final ItemStack slotStack = slot.getItem();
            returnStack = slotStack.copy();

            final int containerSlots = this.slots.size() - player.inventory.items.size();
            if (index < containerSlots) {
                if (!moveItemStackTo(slotStack, containerSlots, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(slotStack, 0, containerSlots, false))
                return ItemStack.EMPTY;
            if (slotStack.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (slotStack.getCount() == returnStack.getCount())
                return ItemStack.EMPTY;
            slot.onTake(player, slotStack);
        }
        return returnStack;
    }

    @Override
    public boolean stillValid(final PlayerEntity player) {
        return stillValid(this.callable, player, BlockInit.CUM_CENTRIFUGE.get());
    }
}