package ru.goatchaos.mixin;

import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.GoatEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GoatEntityModel.class)
public abstract class GoatEntityModelMixin {
    @Shadow @Final protected ModelPart head;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void goatChaos$addThirdHorn(ModelPart root, CallbackInfo ci) {
        ModelPart left = head.getChild("left_horn");
        ModelPart third = new ModelPart(new ArrayList<>(((ModelPartAccessor) (Object) left).goatChaos$getCuboids()), new HashMap<>());
        third.copyTransform(left);
        third.setPivot(0.0F, left.pivotY, left.pivotZ);
        third.roll = 0.0F;
        ((ModelPartAccessor) (Object) head).goatChaos$getChildren().put("middle_horn", third);
    }
}
