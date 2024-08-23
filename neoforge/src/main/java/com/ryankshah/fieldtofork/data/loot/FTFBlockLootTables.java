package com.ryankshah.fieldtofork.data.loot;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.block.crop.TwoHighCropBlock;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import com.ryankshah.fieldtofork.registry.ItemRegistry;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FTFBlockLootTables extends BlockLootSubProvider
{
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    public FTFBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(BlockRegistry.VILLAGER_SCARECROW_BLOCK.get());
        dropSelf(BlockRegistry.CHURN.get());
        dropSelf(BlockRegistry.SILKWORM_HABITAT.get());
        dropSelf(BlockRegistry.SPINNING_WHEEL.get());

        dropSelf(BlockRegistry.IRIS_FLOWER.get());
        dropSelf(BlockRegistry.CROCUS_VERNUS.get());
        dropSelf(BlockRegistry.CROCUS_FLAVUS.get());
        dropSelf(BlockRegistry.DAFFODIL.get());
        dropSelf(BlockRegistry.BELLFLOWER.get());
        dropSelf(BlockRegistry.GERANIUM.get());
        dropSelf(BlockRegistry.WHITE_ROSE.get());
        dropSelf(BlockRegistry.MARIGOLD.get());
        dropSelf(BlockRegistry.THISTLE.get());
        dropSelf(BlockRegistry.CHRYSANTHEMUM.get());

        dropSelf(BlockRegistry.PALM_SAPLING.get());
        dropSelf(BlockRegistry.PALM_LOG.get());
        add(BlockRegistry.PALM_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.PALM_LEAVES.get(),
                BlockRegistry.PALM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.COCONUT.get()));
        dropSelf(BlockRegistry.DENSE_PALM_LEAVES.get());
        dropSelf(BlockRegistry.PALM_TRAPDOOR.get());
        dropSelf(BlockRegistry.PALM_PLANKS.get());
        add(BlockRegistry.PALM_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.PALM_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.PALM_STAIRS.get());
        dropSelf(BlockRegistry.PALM_FENCE.get());
        dropSelf(BlockRegistry.PALM_FENCE_GATE.get());
        dropSelf(BlockRegistry.PALM_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.PALM_BUTTON.get());
        dropSelf(BlockRegistry.PALM_SIGN.get());
        dropOther(BlockRegistry.PALM_WALL_SIGN.get(), BlockRegistry.PALM_SIGN.get());
        dropSelf(BlockRegistry.PALM_HANGING_SIGN.get());
        dropOther(BlockRegistry.PALM_WALL_HANGING_SIGN.get(), BlockRegistry.PALM_HANGING_SIGN.get());

        dropSelf(BlockRegistry.MULBERRY_SAPLING.get());
        dropSelf(BlockRegistry.MULBERRY_LOG.get());
        add(BlockRegistry.MULBERRY_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.MULBERRY_LEAVES.get(),
                BlockRegistry.MULBERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.MULBERRY.get()));
        dropSelf(BlockRegistry.MULBERRY_TRAPDOOR.get());
        dropSelf(BlockRegistry.MULBERRY_PLANKS.get());
        add(BlockRegistry.MULBERRY_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.MULBERRY_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.MULBERRY_STAIRS.get());
        dropSelf(BlockRegistry.MULBERRY_FENCE.get());
        dropSelf(BlockRegistry.MULBERRY_FENCE_GATE.get());
        dropSelf(BlockRegistry.MULBERRY_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.MULBERRY_BUTTON.get());
        dropSelf(BlockRegistry.MULBERRY_SIGN.get());
        dropOther(BlockRegistry.MULBERRY_WALL_SIGN.get(), BlockRegistry.MULBERRY_SIGN.get());
        dropSelf(BlockRegistry.MULBERRY_HANGING_SIGN.get());
        dropOther(BlockRegistry.MULBERRY_WALL_HANGING_SIGN.get(), BlockRegistry.MULBERRY_HANGING_SIGN.get());

        dropSelf(BlockRegistry.BANANA_SAPLING.get());
        dropSelf(BlockRegistry.BANANA_TREE_LOG.get());
        dropSelf(BlockRegistry.BANANA_TREE_PLANKS.get());
        add(BlockRegistry.BANANA_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.BANANA_LEAVES.get(),
                BlockRegistry.BANANA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.BANANA_SINGLE.get()));
        dropSelf(BlockRegistry.BANANA_TRAPDOOR.get());
        add(BlockRegistry.BANANA_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.BANANA_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.BANANA_STAIRS.get());
        dropSelf(BlockRegistry.BANANA_FENCE.get());
        dropSelf(BlockRegistry.BANANA_FENCE_GATE.get());
        dropSelf(BlockRegistry.BANANA_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.BANANA_BUTTON.get());
        dropSelf(BlockRegistry.BANANA_SIGN.get());
        dropOther(BlockRegistry.BANANA_WALL_SIGN.get(), BlockRegistry.BANANA_SIGN.get());
        dropSelf(BlockRegistry.BANANA_HANGING_SIGN.get());
        dropOther(BlockRegistry.BANANA_WALL_HANGING_SIGN.get(), BlockRegistry.BANANA_HANGING_SIGN.get());

        dropSelf(BlockRegistry.DRAGONFRUIT_SAPLING.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_TREE_LOG.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get());
        add(BlockRegistry.DRAGONFRUIT_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.DRAGONFRUIT_LEAVES.get(),
                BlockRegistry.DRAGONFRUIT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.DRAGONFRUIT.get()));
        dropSelf(BlockRegistry.DRAGONFRUIT_TRAPDOOR.get());
        add(BlockRegistry.DRAGONFRUIT_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.DRAGONFRUIT_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.DRAGONFRUIT_STAIRS.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_FENCE.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_FENCE_GATE.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_BUTTON.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_SIGN.get());
        dropOther(BlockRegistry.DRAGONFRUIT_WALL_SIGN.get(), BlockRegistry.DRAGONFRUIT_SIGN.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get());
        dropOther(BlockRegistry.DRAGONFRUIT_WALL_HANGING_SIGN.get(), BlockRegistry.DRAGONFRUIT_HANGING_SIGN.get());

        dropSelf(BlockRegistry.LYCHEE_SAPLING.get());
        dropSelf(BlockRegistry.LYCHEE_TREE_LOG.get());
        dropSelf(BlockRegistry.LYCHEE_TREE_PLANKS.get());
        add(BlockRegistry.LYCHEE_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.LYCHEE_LEAVES.get(),
                BlockRegistry.LYCHEE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.LYCHEE.get()));
        dropSelf(BlockRegistry.LYCHEE_TRAPDOOR.get());
        add(BlockRegistry.LYCHEE_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.LYCHEE_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.LYCHEE_STAIRS.get());
        dropSelf(BlockRegistry.LYCHEE_FENCE.get());
        dropSelf(BlockRegistry.LYCHEE_FENCE_GATE.get());
        dropSelf(BlockRegistry.LYCHEE_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.LYCHEE_BUTTON.get());
        dropSelf(BlockRegistry.LYCHEE_SIGN.get());
        dropOther(BlockRegistry.LYCHEE_WALL_SIGN.get(), BlockRegistry.LYCHEE_SIGN.get());
        dropSelf(BlockRegistry.LYCHEE_HANGING_SIGN.get());
        dropOther(BlockRegistry.LYCHEE_WALL_HANGING_SIGN.get(), BlockRegistry.LYCHEE_HANGING_SIGN.get());

        dropSelf(BlockRegistry.MANGO_LOG.get());
        dropSelf(BlockRegistry.MANGO_PLANKS.get());
        dropSelf(BlockRegistry.MANGO_SAPLING.get());
        add(BlockRegistry.MANGO_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.MANGO_LEAVES.get(),
                BlockRegistry.MANGO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.MANGO.get()));
        dropSelf(BlockRegistry.MANGO_TRAPDOOR.get());
        add(BlockRegistry.MANGO_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.MANGO_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.MANGO_STAIRS.get());
        dropSelf(BlockRegistry.MANGO_FENCE.get());
        dropSelf(BlockRegistry.MANGO_FENCE_GATE.get());
        dropSelf(BlockRegistry.MANGO_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.MANGO_BUTTON.get());
        dropSelf(BlockRegistry.MANGO_SIGN.get());
        dropOther(BlockRegistry.MANGO_WALL_SIGN.get(), BlockRegistry.MANGO_SIGN.get());
        dropSelf(BlockRegistry.MANGO_HANGING_SIGN.get());
        dropOther(BlockRegistry.MANGO_WALL_HANGING_SIGN.get(), BlockRegistry.MANGO_HANGING_SIGN.get());

        dropSelf(BlockRegistry.ORANGE_SAPLING.get());
        dropSelf(BlockRegistry.ORANGE_LOG.get());
        dropSelf(BlockRegistry.ORANGE_PLANKS.get());
        add(BlockRegistry.ORANGE_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.ORANGE_LEAVES.get(),
                BlockRegistry.ORANGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.ORANGE.get()));
        dropSelf(BlockRegistry.ORANGE_TRAPDOOR.get());
        add(BlockRegistry.ORANGE_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.ORANGE_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.ORANGE_STAIRS.get());
        dropSelf(BlockRegistry.ORANGE_FENCE.get());
        dropSelf(BlockRegistry.ORANGE_FENCE_GATE.get());
        dropSelf(BlockRegistry.ORANGE_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.ORANGE_BUTTON.get());
        dropSelf(BlockRegistry.ORANGE_SIGN.get());
        dropOther(BlockRegistry.ORANGE_WALL_SIGN.get(), BlockRegistry.ORANGE_SIGN.get());
        dropSelf(BlockRegistry.ORANGE_HANGING_SIGN.get());
        dropOther(BlockRegistry.ORANGE_WALL_HANGING_SIGN.get(), BlockRegistry.ORANGE_HANGING_SIGN.get());

        dropSelf(BlockRegistry.PEAR_SAPLING.get());
        dropSelf(BlockRegistry.PEAR_LOG.get());
        dropSelf(BlockRegistry.PEAR_PLANKS.get());
        add(BlockRegistry.PEAR_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.PEAR_LEAVES.get(),
                BlockRegistry.PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.PEAR.get()));
        dropSelf(BlockRegistry.PEAR_TRAPDOOR.get());
        add(BlockRegistry.PEAR_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.PEAR_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.PEAR_STAIRS.get());
        dropSelf(BlockRegistry.PEAR_FENCE.get());
        dropSelf(BlockRegistry.PEAR_FENCE_GATE.get());
        dropSelf(BlockRegistry.PEAR_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.PEAR_BUTTON.get());
        dropSelf(BlockRegistry.PEAR_SIGN.get());
        dropOther(BlockRegistry.PEAR_WALL_SIGN.get(), BlockRegistry.PEAR_SIGN.get());
        dropSelf(BlockRegistry.PEAR_HANGING_SIGN.get());
        dropOther(BlockRegistry.PEAR_WALL_HANGING_SIGN.get(), BlockRegistry.PEAR_HANGING_SIGN.get());

        dropSelf(BlockRegistry.POMEGRANATE_SAPLING.get());
        dropSelf(BlockRegistry.POMEGRANATE_LOG.get());
        dropSelf(BlockRegistry.POMEGRANATE_PLANKS.get());
        add(BlockRegistry.POMEGRANATE_LEAVES.get(), createAgeingLeavesDrops(BlockRegistry.POMEGRANATE_LEAVES.get(),
                BlockRegistry.POMEGRANATE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES, ItemRegistry.POMEGRANATE.get()));
        dropSelf(BlockRegistry.POMEGRANATE_TRAPDOOR.get());
        add(BlockRegistry.POMEGRANATE_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.POMEGRANATE_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.POMEGRANATE_STAIRS.get());
        dropSelf(BlockRegistry.POMEGRANATE_FENCE.get());
        dropSelf(BlockRegistry.POMEGRANATE_FENCE_GATE.get());
        dropSelf(BlockRegistry.POMEGRANATE_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.POMEGRANATE_BUTTON.get());
        dropSelf(BlockRegistry.POMEGRANATE_SIGN.get());
        dropOther(BlockRegistry.POMEGRANATE_WALL_SIGN.get(), BlockRegistry.POMEGRANATE_SIGN.get());
        dropSelf(BlockRegistry.POMEGRANATE_HANGING_SIGN.get());
        dropOther(BlockRegistry.POMEGRANATE_WALL_HANGING_SIGN.get(), BlockRegistry.POMEGRANATE_HANGING_SIGN.get());

        LootItemCondition.Builder grapeConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.GRAPE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.GRAPE_CROP.get(), createTwoHighCropDrops(BlockRegistry.GRAPE_CROP.get(), ItemRegistry.GREEN_GRAPES.get(), ItemRegistry.GRAPE_SEEDS.get(), grapeConditionBuilder)
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.5f, 1.0F)).add(LootItem.lootTableItem(ItemRegistry.PURPLE_GRAPES.get()))));

        LootItemCondition.Builder sweetPotatoConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.SWEET_POTATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.SWEET_POTATO_CROP.get(), createCropDrops(BlockRegistry.SWEET_POTATO_CROP.get(), ItemRegistry.SWEET_POTATO.get(), ItemRegistry.SWEET_POTATO_SLIPS.get(), sweetPotatoConditionBuilder));

        LootItemCondition.Builder radishConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.RADISH_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.RADISH_CROP.get(), createCropDrops(BlockRegistry.RADISH_CROP.get(), ItemRegistry.RADISH.get(), ItemRegistry.RADISH_SEEDS.get(), radishConditionBuilder));

        LootItemCondition.Builder chilliConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.CHILLI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.CHILLI_CROP.get(), createCropDrops(BlockRegistry.CHILLI_CROP.get(), ItemRegistry.CHILLI.get(), ItemRegistry.CHILLI_SEEDS.get(), chilliConditionBuilder));

        LootItemCondition.Builder asparagusConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.ASPARAGUS_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.ASPARAGUS_CROP.get(), createCropDrops(BlockRegistry.ASPARAGUS_CROP.get(), ItemRegistry.ASPARAGUS.get(), ItemRegistry.ASPARAGUS_CROWNS.get(), asparagusConditionBuilder));

        LootItemCondition.Builder leekConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.LEEK_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.LEEK_CROP.get(), createCropDrops(BlockRegistry.LEEK_CROP.get(), ItemRegistry.LEEK.get(), ItemRegistry.LEEK_SEEDS.get(), leekConditionBuilder));

        LootItemCondition.Builder eggplantConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.EGGPLANT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.EGGPLANT_CROP.get(), createCropDrops(BlockRegistry.EGGPLANT_CROP.get(), ItemRegistry.EGGPLANT.get(), ItemRegistry.EGGPLANT_SEEDS.get(), eggplantConditionBuilder));

        LootItemCondition.Builder bellPepperConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.BELL_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.BELL_PEPPER_CROP.get(), createCropDrops(BlockRegistry.BELL_PEPPER_CROP.get(), ItemRegistry.RED_PEPPER.get(), ItemRegistry.BELL_PEPPER_SEEDS.get(), bellPepperConditionBuilder)
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.5f, 1.0F)).add(LootItem.lootTableItem(ItemRegistry.YELLOW_PEPPER.get()))));

        LootItemCondition.Builder zucchiniConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.ZUCCHINI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.ZUCCHINI_CROP.get(), createCropDrops(BlockRegistry.ZUCCHINI_CROP.get(), ItemRegistry.ZUCCHINI.get(), ItemRegistry.ZUCCHINI_SEEDS.get(), zucchiniConditionBuilder));

        LootItemCondition.Builder passionfruitConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.PASSIONFRUIT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.PASSIONFRUIT_CROP.get(), createCropDrops(BlockRegistry.PASSIONFRUIT_CROP.get(), ItemRegistry.PASSIONFRUIT.get(), ItemRegistry.PASSIONFRUIT_SEEDS.get(), passionfruitConditionBuilder));

        LootItemCondition.Builder tomatoConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.TOMATO_CROP.get(), createCropDrops(BlockRegistry.TOMATO_CROP.get(), ItemRegistry.TOMATO.get(), ItemRegistry.TOMATO_SEEDS.get(), tomatoConditionBuilder));

        LootItemCondition.Builder garlicConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.GARLIC_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.GARLIC_CROP.get(), createCropDrops(BlockRegistry.GARLIC_CROP.get(), ItemRegistry.GARLIC.get(), ItemRegistry.GARLIC.get(), garlicConditionBuilder));

        LootItemCondition.Builder strawberryConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.STRAWBERRY_CROP.get(), createCropDrops(BlockRegistry.STRAWBERRY_CROP.get(), ItemRegistry.STRAWBERRY.get(), ItemRegistry.STRAWBERRY_SEEDS.get(), strawberryConditionBuilder));

        LootItemCondition.Builder durumWheatConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.DURUM_WHEAT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.DURUM_WHEAT_CROP.get(), createCropDrops(BlockRegistry.DURUM_WHEAT_CROP.get(), ItemRegistry.DURUM_WHEAT.get(), ItemRegistry.DURUM_WHEAT_SEEDS.get(), durumWheatConditionBuilder));

        LootItemCondition.Builder gingerConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.GINGER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.GINGER_CROP.get(), createCropDrops(BlockRegistry.GINGER_CROP.get(), ItemRegistry.GINGER.get(), ItemRegistry.GINGER_ROOT_SLIP.get(), gingerConditionBuilder));

        LootItemCondition.Builder riceConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.RICE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.RICE_CROP.get(), createCropDrops(BlockRegistry.RICE_CROP.get(), ItemRegistry.SHEAF_OF_RICE.get(), ItemRegistry.SHEAF_OF_RICE.get(), riceConditionBuilder));

        LootItemCondition.Builder pineappleConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.PINEAPPLE_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.PINEAPPLE_BLOCK.get(), createCropDrops(BlockRegistry.PINEAPPLE_BLOCK.get(), ItemRegistry.PINEAPPLE.get(), ItemRegistry.PINEAPPLE_SEEDS.get(), pineappleConditionBuilder)
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.125f, 1.0F)).add(LootItem.lootTableItem(ItemRegistry.GOLDEN_PINEAPPLE.get()))));

        LootItemCondition.Builder cabbageConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.CABBAGE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(BlockRegistry.CABBAGE_CROP.get(), createCropDrops(BlockRegistry.CABBAGE_CROP.get(), ItemRegistry.CABBAGE.get(), ItemRegistry.CABBAGE_SEEDS.get(), cabbageConditionBuilder));

    }

    protected LootTable.Builder createAgeingLeavesDrops(Block pBlock, Block pSaplingBlock, float[] pChances, Item drop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createLeavesDrops(pBlock, pSaplingBlock, pChances)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(pBlock, LootItem.lootTableItem(drop))).when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), new float[]{0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F}))));
    }

    protected LootTable.Builder createTwoHighCropDrops(TwoHighCropBlock pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        LootPoolEntryContainer.Builder builder = LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition).otherwise(LootItem.lootTableItem(pSeedsItem)); //.withPool(LootPool.lootPool().when(pDropGrownCropCondition).add(LootItem.lootTableItem(pSeedsItem).apply(ApplyBonusCount.addBonusBinomialDistributionCount(registrylookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3)))));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder)
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pCropBlock).setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))
                            .when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
                                    .setBlock(BlockPredicate.Builder.block().of(new Block[]{pCropBlock})
                                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))),
                                                new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder)
                                                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pCropBlock)
                                                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)))
                                                                .when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
                                                                        .setBlock(BlockPredicate.Builder.block().of(new Block[]{pCropBlock})
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))),
                                                                                    new BlockPos(0, -1, 0))));
    }

    private LootItemCondition.Builder hasShearsOrSilkTouch() {
        return HAS_SHEARS.or(this.hasSilkTouch());
    }

    private LootItemCondition.Builder doesNotHaveShearsOrSilkTouch() {
        return this.hasShearsOrSilkTouch().invert();
    }

    @Override
    public @NotNull Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(Constants.MOD_ID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}