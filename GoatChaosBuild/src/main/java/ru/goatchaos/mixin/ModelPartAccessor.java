package ru.goatchaos.mixin;

import java.util.List;
import java.util.Map;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.client.model.ModelPart;

@Mixin(ModelPart.class)
public interface ModelPartAccessor {
    @Accessor("children") Map<String, ModelPart> goatChaos$getChildren();
    @Accessor("cuboids") List<ModelPart.Cuboid> goatChaos$getCuboids();
}
