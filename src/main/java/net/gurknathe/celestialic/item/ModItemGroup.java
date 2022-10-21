package net.gurknathe.celestialic.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.gurknathe.celestialic.CelestialicMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CELESTIALIC = FabricItemGroupBuilder.build(new Identifier(CelestialicMod.MOD_ID, "celestialic"),
            () -> new ItemStack(ModItems.HEAVENLY_SCALE));
}
