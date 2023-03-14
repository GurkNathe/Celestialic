package net.gurknathe.celestialic.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.gurknathe.celestialic.Celestialic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CelestialicItemGroup {
    public static final net.minecraft.item.ItemGroup CELESTIALIC = FabricItemGroupBuilder.build(new Identifier(Celestialic.MOD_ID, "celestialic"),
            () -> new ItemStack(CelestialicItems.HEAVENLY_SCALE));
}
