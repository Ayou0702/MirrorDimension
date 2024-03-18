package top.prefersmin.mirrordim.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class PMDimensions {

    public static final ResourceKey<Level> CHORD_LEVEL = ResourceKey.create(Registries.DIMENSION, name("chord"));

    private static ResourceLocation name(String name) {
        return new ResourceLocation("prefersmin", name);
    }

}
