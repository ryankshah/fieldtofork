package com.ryankshah.fieldtofork.block.silkworm_habitat;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ryankshah.fieldtofork.registry.BlockEntityRegistry;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import com.ryankshah.fieldtofork.registry.RecipeRegistry;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SilkwormHabitatBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible
{
    protected static final int SLOT_INPUT = 0;
    protected static final int SLOT_FUEL = 1;
    protected static final int SLOT_RESULT = 2;
    public static final int DATA_LIT_TIME = 0;
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    public static final int DATA_LIT_DURATION = 1;
    public static final int DATA_COOKING_PROGRESS = 2;
    public static final int DATA_COOKING_TOTAL_TIME = 3;
    public static final int NUM_DATA_VALUES = 4;
    public static final int BURN_TIME_STANDARD = 200;
    public static final int BURN_COOL_SPEED = 2;
    protected NonNullList<ItemStack> items;
    int producingTime;
    int producingDuration;
    int producingProgress;
    int producingTotalTime;
    @Nullable
    private static volatile Map<Item, Integer> fuelCache;
    protected final ContainerData dataAccess;
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed;
    private final RecipeManager.CachedCheck<SingleRecipeInput, ? extends AbstractCookingRecipe> quickCheck;

    public SilkwormHabitatBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.SILKWORM_HABITAT.get(), pPos, pBlockState);
        this.items = NonNullList.withSize(3, ItemStack.EMPTY);
        this.dataAccess = new ContainerData() {
            public int get(int p_58431_) {
                switch (p_58431_) {
                    case 0:
                        return SilkwormHabitatBlockEntity.this.producingTime;
                    case 1:
                        return SilkwormHabitatBlockEntity.this.producingDuration;
                    case 2:
                        return SilkwormHabitatBlockEntity.this.producingProgress;
                    case 3:
                        return SilkwormHabitatBlockEntity.this.producingTotalTime;
                    default:
                        return 0;
                }
            }

            public void set(int p_58433_, int p_58434_) {
                switch (p_58433_) {
                    case 0:
                        SilkwormHabitatBlockEntity.this.producingTime = p_58434_;
                        break;
                    case 1:
                        SilkwormHabitatBlockEntity.this.producingDuration = p_58434_;
                        break;
                    case 2:
                        SilkwormHabitatBlockEntity.this.producingProgress = p_58434_;
                        break;
                    case 3:
                        SilkwormHabitatBlockEntity.this.producingTotalTime = p_58434_;
                }

            }

            public int getCount() {
                return 4;
            }
        };
        this.recipesUsed = new Object2IntOpenHashMap();
        this.quickCheck = RecipeManager.createCheck(RecipeRegistry.SILKWORM_HABITAT.get());
    }

    public static void invalidateCache() {
        fuelCache = null;
    }

    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = fuelCache;
        if (map != null) {
            return map;
        } else {
            Map<Item, Integer> map1 = Maps.newLinkedHashMap();
            add(map1, (ItemLike) ItemRegistry.SILKWORM_EGGS.get(), 20000);
            fuelCache = map1;
            return map1;
        }
    }

    public static Item getLeaves() {
        return BlockRegistry.MULBERRY_LEAVES.get().asItem();
    }

    private static boolean isNeverAFurnaceFuel(Item pItem) {
        return pItem.builtInRegistryHolder().is(ItemTags.NON_FLAMMABLE_WOOD);
    }

    private static void add(Map<Item, Integer> pMap, TagKey<Item> pItemTag, int pBurnTime) {
        Iterator var3 = BuiltInRegistries.ITEM.getTagOrEmpty(pItemTag).iterator();

        while(var3.hasNext()) {
            Holder<Item> holder = (Holder)var3.next();
            if (!isNeverAFurnaceFuel((Item)holder.value())) {
                pMap.put((Item)holder.value(), pBurnTime);
            }
        }

    }

    private static void add(Map<Item, Integer> pMap, ItemLike pItem, int pBurnTime) {
        Item item = pItem.asItem();
        if (isNeverAFurnaceFuel(item)) {
            if (SharedConstants.IS_RUNNING_IN_IDE) {
                throw (IllegalStateException) Util.pauseInIde(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item.getName((ItemStack)null).getString() + " a furnace fuel. That will not work!"));
            }
        } else {
            pMap.put(item, pBurnTime);
        }

    }

    private boolean isLit() {
        return this.producingTime > 0;
    }

    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
        this.producingTime = pTag.getShort("BurnTime");
        this.producingProgress = pTag.getShort("CookTime");
        this.producingTotalTime = pTag.getShort("CookTimeTotal");
        this.producingDuration = this.getBurnDuration((ItemStack)this.items.get(1));
        CompoundTag compoundtag = pTag.getCompound("RecipesUsed");
        Iterator var4 = compoundtag.getAllKeys().iterator();

        while(var4.hasNext()) {
            String s = (String)var4.next();
            this.recipesUsed.put(ResourceLocation.parse(s), compoundtag.getInt(s));
        }

    }

    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        pTag.putShort("BurnTime", (short)this.producingTime);
        pTag.putShort("CookTime", (short)this.producingProgress);
        pTag.putShort("CookTimeTotal", (short)this.producingTotalTime);
        ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
        CompoundTag compoundtag = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> {
            compoundtag.putInt(p_187449_.toString(), p_187450_);
        });
        pTag.put("RecipesUsed", compoundtag);
    }

    @Override
    protected Component getDefaultName() {
        return SilkwormHabitat.CONTAINER_TITLE;
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, SilkwormHabitatBlockEntity pBlockEntity) {
        boolean flag = pBlockEntity.isLit();
        boolean flag1 = false;
        if (pBlockEntity.isLit()) {
            --pBlockEntity.producingTime;
        }

        ItemStack itemstack = (ItemStack)pBlockEntity.items.get(1);
        ItemStack itemstack1 = (ItemStack)pBlockEntity.items.get(0);
        boolean flag2 = !itemstack1.isEmpty();
        boolean flag3 = !itemstack.isEmpty();
        if (pBlockEntity.isLit() || flag3 && flag2) {
            RecipeHolder recipeholder;
            if (flag2) {
                recipeholder = (RecipeHolder)pBlockEntity.quickCheck.getRecipeFor(new SingleRecipeInput(itemstack1), pLevel).orElse((RecipeHolder)null);
            } else {
                recipeholder = null;
            }

            int i = pBlockEntity.getMaxStackSize();
            if (!pBlockEntity.isLit() && canBurn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                pBlockEntity.producingTime = pBlockEntity.getBurnDuration(itemstack);
                pBlockEntity.producingDuration = pBlockEntity.producingTime;
                if (pBlockEntity.isLit()) {
                    flag1 = true;
                    if (flag3) {
                        Item item = itemstack.getItem();
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            Item item1 = item.getCraftingRemainingItem();
                            pBlockEntity.items.set(1, item1 == null ? ItemStack.EMPTY : new ItemStack(item1));
                        }
                    }
                }
            }

            if (pBlockEntity.isLit() && canBurn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                ++pBlockEntity.producingProgress;
                if (pBlockEntity.producingProgress == pBlockEntity.producingTotalTime) {
                    pBlockEntity.producingProgress = 0;
                    pBlockEntity.producingTotalTime = getTotalCookTime(pLevel, pBlockEntity);
                    if (burn(pLevel.registryAccess(), recipeholder, pBlockEntity.items, i)) {
                        pBlockEntity.setRecipeUsed(recipeholder);
                    }

                    flag1 = true;
                }
            } else {
                pBlockEntity.producingProgress = 0;
            }
        } else if (!pBlockEntity.isLit() && pBlockEntity.producingProgress > 0) {
            pBlockEntity.producingProgress = Mth.clamp(pBlockEntity.producingProgress - 2, 0, pBlockEntity.producingTotalTime);
        }

        if (flag != pBlockEntity.isLit()) {
            flag1 = true;
            pState = (BlockState)pState.setValue(SilkwormHabitat.PRODUCING, pBlockEntity.isLit());
            pLevel.setBlock(pPos, pState, 3);
        }

        if (flag1) {
            setChanged(pLevel, pPos, pState);
        }

    }

    private static boolean canBurn(RegistryAccess pRegistryAccess, @Nullable RecipeHolder<?> pRecipe, NonNullList<ItemStack> pInventory, int pMaxStackSize) {
        if (!((ItemStack)pInventory.get(0)).isEmpty() && pRecipe != null) {
            ItemStack itemstack = pRecipe.value().getResultItem(pRegistryAccess);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = (ItemStack)pInventory.get(2);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItemSameComponents(itemstack1, itemstack)) {
                    return false;
                } else {
                    return itemstack1.getCount() < pMaxStackSize && itemstack1.getCount() < itemstack1.getMaxStackSize() ? true : itemstack1.getCount() < itemstack.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }

    private static boolean burn(RegistryAccess pRegistryAccess, @Nullable RecipeHolder<?> pRecipe, NonNullList<ItemStack> pInventory, int pMaxStackSize) {
        if (pRecipe != null && canBurn(pRegistryAccess, pRecipe, pInventory, pMaxStackSize)) {
            ItemStack itemstack = (ItemStack)pInventory.get(0);
            ItemStack itemstack1 = pRecipe.value().getResultItem(pRegistryAccess);
            ItemStack itemstack2 = (ItemStack)pInventory.get(2);
            if (itemstack2.isEmpty()) {
                pInventory.set(2, itemstack1.copy());
            } else if (ItemStack.isSameItemSameComponents(itemstack2, itemstack1)) {
                itemstack2.grow(1);
            }

            if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !((ItemStack)pInventory.get(1)).isEmpty() && ((ItemStack)pInventory.get(1)).is(Items.BUCKET)) {
                pInventory.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            itemstack.shrink(1);
            return true;
        } else {
            return false;
        }
    }

    protected int getBurnDuration(ItemStack pFuel) {
        if (pFuel.isEmpty()) {
            return 0;
        } else {
            Item item = pFuel.getItem();
            return (Integer)getFuel().getOrDefault(item, 0);
        }
    }

    private static int getTotalCookTime(Level pLevel, SilkwormHabitatBlockEntity pBlockEntity) {
        SingleRecipeInput singlerecipeinput = new SingleRecipeInput(pBlockEntity.getItem(0));
        return (Integer)pBlockEntity.quickCheck.getRecipeFor(singlerecipeinput, pLevel).map((p_300840_) -> {
            return ((AbstractCookingRecipe)p_300840_.value()).getCookingTime();
        }).orElse(200);
    }

    public static boolean isFuel(ItemStack pStack) {
        return getFuel().containsKey(pStack.getItem());
    }

    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return pSide == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack);
    }

    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        return pDirection == Direction.DOWN && pIndex == 1 ? pStack.is(Items.WATER_BUCKET) || pStack.is(Items.BUCKET) : true;
    }

    public int getContainerSize() {
        return this.items.size();
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(NonNullList<ItemStack> pItems) {
        this.items = pItems;
    }

    public void setItem(int pIndex, ItemStack pStack) {
        ItemStack itemstack = (ItemStack)this.items.get(pIndex);
        boolean flag = !pStack.isEmpty() && ItemStack.isSameItemSameComponents(itemstack, pStack);
        this.items.set(pIndex, pStack);
        pStack.limitSize(this.getMaxStackSize(pStack));
        if (pIndex == 0 && !flag) {
            this.producingTotalTime = getTotalCookTime(this.level, this);
            this.producingProgress = 0;
            this.setChanged();
        }

    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return null;
    }

    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        if (pIndex == 2) {
            return false;
        } else if (pIndex != 1) {
            return true;
        } else {
            ItemStack itemstack = (ItemStack)this.items.get(1);
            return isFuel(pStack) || pStack.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
        }
    }

    public void setRecipeUsed(@Nullable RecipeHolder<?> pRecipe) {
        if (pRecipe != null) {
            ResourceLocation resourcelocation = pRecipe.id();
            this.recipesUsed.addTo(resourcelocation, 1);
        }

    }

    @Nullable
    public RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    public void awardUsedRecipes(Player pPlayer, List<ItemStack> pItems) {
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
        List<RecipeHolder<?>> list = this.getRecipesToAwardAndPopExperience(pPlayer.serverLevel(), pPlayer.position());
        pPlayer.awardRecipes(list);
        Iterator var3 = list.iterator();

        while(var3.hasNext()) {
            RecipeHolder<?> recipeholder = (RecipeHolder)var3.next();
            if (recipeholder != null) {
                pPlayer.triggerRecipeCrafted(recipeholder, this.items);
            }
        }

        this.recipesUsed.clear();
    }

    public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pPopVec) {
        List<RecipeHolder<?>> list = Lists.newArrayList();
        ObjectIterator var4 = this.recipesUsed.object2IntEntrySet().iterator();

        while(var4.hasNext()) {
            Object2IntMap.Entry<ResourceLocation> entry = (Object2IntMap.Entry)var4.next();
            pLevel.getRecipeManager().byKey((ResourceLocation)entry.getKey()).ifPresent((p_300839_) -> {
                list.add(p_300839_);
                createExperience(pLevel, pPopVec, entry.getIntValue(), ((AbstractCookingRecipe)p_300839_.value()).getExperience());
            });
        }

        return list;
    }

    private static void createExperience(ServerLevel pLevel, Vec3 pPopVec, int pRecipeIndex, float pExperience) {
        int i = Mth.floor((float)pRecipeIndex * pExperience);
        float f = Mth.frac((float)pRecipeIndex * pExperience);
        if (f != 0.0F && Math.random() < (double)f) {
            ++i;
        }

        ExperienceOrb.award(pLevel, pPopVec, i);
    }

    public void fillStackedContents(StackedContents pHelper) {
        Iterator var2 = this.items.iterator();

        while(var2.hasNext()) {
            ItemStack itemstack = (ItemStack)var2.next();
            pHelper.accountStack(itemstack);
        }

    }
}