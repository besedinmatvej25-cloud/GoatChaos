package ru.goatchaos.mixin;

import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GoatEntity.class)
public abstract class GoatEntityMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void goatChaos$superJump(CallbackInfo ci) {
        GoatEntity goat = (GoatEntity) (Object) this;
        World world = goat.getWorld();
        if (!world.isClient && goat.age > 0 && goat.age % 200 == 0) {
            Vec3d velocity = goat.getVelocity();
            goat.setVelocity(velocity.x, 2.0, velocity.z);
            goat.velocityModified = true;
        }
    }
}
