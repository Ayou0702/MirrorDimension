package top.prefersmin.mirrordim;

import com.simibubi.create.content.trains.track.AllPortalTracks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.prefersmin.mirrordim.registry.PMBlocks;
import top.prefersmin.mirrordim.registry.PMPointOfInterests;
import top.prefersmin.mirrordim.world.PortalTracksSupport;

@Mod(MirrorDimension.MODID)
public class MirrorDimension {

    public static final String MODID = "mirrordim";

    // 传送门框架，拿鸡蛋右键激活哦
    public static final Block frameBlock = Blocks.SCULK;

    public MirrorDimension() {

        // 事件总线，你懂的
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // 注册传送门方块
        PMBlocks.BLOCKS.register(bus);

        // 注册POI
        PMPointOfInterests.register(bus);

        // 注册可被列车系统跨越的维度传送门
        // 此处建议使用new ResourceLocation而非直接传入Block，否则可能有意外错误
        AllPortalTracks.registerIntegration(new ResourceLocation(MODID, "chord_portal"), PortalTracksSupport::mirrordim);

    }

}
