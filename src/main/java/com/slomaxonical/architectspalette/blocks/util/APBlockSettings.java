package com.slomaxonical.architectspalette.blocks.util;

import com.slomaxonical.architectspalette.blocks.CageLanternBlock;
import com.slomaxonical.architectspalette.blocks.SunstoneBlock;
import com.slomaxonical.architectspalette.blocks.abyssaline.AbyssalineHelper;
import com.slomaxonical.architectspalette.blocks.abyssaline.ChiseledAbyssalineBlock;
import com.slomaxonical.architectspalette.registry.APSounds;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.BooleanProperty;

public class APBlockSettings {

	public static final BooleanProperty CHARGED = BooleanProperty.of("charged");

	public static final FabricBlockSettings ABYSSALINE = FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
			.strength(25.0F, 600.0F)
			.emissiveLighting(AbyssalineHelper::needsPostProcessing)
			.postProcess(AbyssalineHelper::needsPostProcessing)
			.allowsSpawning(AbyssalineHelper::allowsMobSpawning);

	public static final FabricBlockSettings CHISELED_ABYSSALINE = FabricBlockSettings.copyOf(Blocks.OBSIDIAN)
			.strength(25.0F, 600.0F)
			.emissiveLighting(AbyssalineHelper::needsPostProcessing)
			.postProcess(AbyssalineHelper::needsPostProcessing)
			.allowsSpawning(AbyssalineHelper::allowsMobSpawning)
			.luminance(ChiseledAbyssalineBlock.getLuminance());

	public static FabricBlockSettings Meat(MapColor color) {
		return FabricBlockSettings.of(Material.GOURD, color).strength(1.0F).sounds(BlockSoundGroup.CORAL);
	}

	public static final FabricBlockSettings FLINT = FabricBlockSettings.of(Material.STONE, MapColor.GRAY).strength(3.0F, 16.0F).requiresTool();
	public static final FabricBlockSettings LIMESTONE = FabricBlockSettings.copyOf(Blocks.STONE);
	public static final FabricBlockSettings SUNMETAL = FabricBlockSettings.of(Material.METAL, MapColor.BROWN).strength(2.0F, 8.0F).sounds(BlockSoundGroup.NETHERITE).requiresTool();
	 // Should be less slippery?
	public static final FabricBlockSettings BUILDING_ICE = FabricBlockSettings.copyOf(Blocks.PACKED_ICE).slipperiness(0.8F);
	 // As Prismarine
	public static final FabricBlockSettings OLIVESTONE = FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_GREEN).strength(1.5F, 6.0F).requiresTool();
	 // As Nether Bricks
	public static final FabricBlockSettings ALGAL_BRICK = FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_CYAN).strength(2.0F, 6.0F).sounds(BlockSoundGroup.NETHER_BRICKS).requiresTool();

	public static final FabricBlockSettings ENTWINE = FabricBlockSettings.of(Material.STONE, MapColor.CYAN).strength(3.0F, 6.0F).sounds(APSounds.APSoundTypes.ENTWINE).requiresTool();
	public static final FabricBlockSettings ENDER_PEARL = FabricBlockSettings.of(Material.STONE, MapColor.CYAN).strength(1.5F).sounds(APSounds.APSoundTypes.ENDER_PEARL);
	public static final FabricBlockSettings PLATING = FabricBlockSettings.of(Material.METAL, MapColor.STONE_GRAY).strength(4.0F, 10.0F).sounds(BlockSoundGroup.NETHERITE).requiresTool();

	public static final FabricBlockSettings MOLTEN_BRICK = FabricBlockSettings.of(Material.STONE, MapColor.DARK_RED)
			.requiresTool()
			.strength(2.0F, 6.0F)
			.luminance((state) -> 3)
			.postProcess((a, b, c) -> true)
			.emissiveLighting((a, b, c) -> true);

	public static final FabricBlockSettings CAGE_LANTERN = FabricBlockSettings.of(Material.METAL)
			.requiresTool()
			.emissiveLighting((state, reader, pos) -> state.get(CageLanternBlock.LIT))
			.postProcess((state, reader, pos) -> state.get(CageLanternBlock.LIT))
			.strength(3.5f)
			.sounds(BlockSoundGroup.LANTERN)
			.nonOpaque();

	public static final FabricBlockSettings ACACIA_TOTEM = FabricBlockSettings.of(Material.WOOD, MapColor.ORANGE)
			.strength(2.0F)
			.sounds(BlockSoundGroup.WOOD);

	// This makes a new property each time so that setting the door to not solid doesn't interfere.
	public static FabricBlockSettings TwistedWood() {
		return FabricBlockSettings.of(Material.WOOD, MapColor.PURPLE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);
	}
	public static FabricBlockSettings TwistedWood(boolean redstoneComponent) {
		FabricBlockSettings p = TwistedWood();
		if (redstoneComponent) {
			return p.noCollision().strength(0.5f);
		}
		return p;
	}
	public static final FabricBlockSettings SUNSTONE = FabricBlockSettings.copyOf(Blocks.BASALT)
//			.solidBlock(SunstoneBlock::isSolid).dynamicBounds()
			.luminance(SunstoneBlock::lightValue);

}