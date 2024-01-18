package net.dyna.skyward.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.dyna.skyward.block.ModBlocks;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> SKYSTONE_SMELTABLES = List.of(ModBlocks.COBBLED_SKYSTONE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, SKYSTONE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SKYSTONE, 0.1f, 200, "skystone");
    }
}
