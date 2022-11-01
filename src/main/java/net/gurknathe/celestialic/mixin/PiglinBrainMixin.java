package net.gurknathe.celestialic.mixin;

import net.gurknathe.celestialic.CelestialicMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;

@Mixin(PiglinBrain.class)
public abstract class PiglinBrainMixin {
    @Inject(method = "wearsGoldArmor(Lnet/minecraft/entity/LivingEntity;)Z", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private static void wearsGoldArmorInject(LivingEntity entity, CallbackInfoReturnable<Boolean> cir, Iterable<ItemStack> iterable, Iterator iterator, ItemStack stack, Item item) {
        if (stack.isIn(CelestialicMod.PIGLIN_SAFE_ARMOR)) cir.setReturnValue(true);
    }
}
