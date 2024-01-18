package net.dyna.skyward.block;

import net.dyna.skyward.Skyward;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SKYSTONE = registerBlock("skystone", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block COBBLED_SKYSTONE = registerBlock("cobbled_skystone", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Skyward.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Skyward.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Skyward.LOGGER.info("Registering ModBlocks for " + Skyward.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addItemsToNaturalGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlocksGroup);
    }

    private static void addItemsToNaturalGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.SKYSTONE);
    }

    private static void addItemsToBuildingBlocksGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.SKYSTONE);
        entries.add(ModBlocks.COBBLED_SKYSTONE);
    }
}
