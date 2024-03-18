package top.prefersmin.mirrordim.registry;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import top.prefersmin.mirrordim.MirrorDimension;

import java.util.Set;
import java.util.function.Supplier;

public class PMPointOfInterests {

    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, MirrorDimension.MODID);

    public static final Supplier<PoiType> CHORD_PORTAL = POI.register("chord_portal", () -> new PoiType(getBlockStates(PMBlocks.CHORD_PORTAL.get()), 0, 1));

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }

    private static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
    }

}