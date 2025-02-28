package com.slomaxonical.architectspalette.features;

import com.slomaxonical.architectspalette.registry.APBlocks;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.Lazy;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TwistedTree extends SaplingGenerator {

    public static final Lazy<TreeFeatureConfig> TWISTED_TREE_CONFIG = new Lazy<>(() ->
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(APBlocks.TWISTED_LOG.getDefaultState()),
                    new ForkingTrunkPlacer(5, 2, 2),
                    new SimpleBlockStateProvider(APBlocks.TWISTED_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(APBlocks.TWISTED_SAPLING.getDefaultState()),
                    new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
                    new TwoLayersFeatureSize(1, 0, 2)
            )
                    .ignoreVines()
                    .build()
    );


    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return Feature.TREE.configure(TWISTED_TREE_CONFIG.get());
    }
}
