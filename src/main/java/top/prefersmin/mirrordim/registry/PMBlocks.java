package top.prefersmin.mirrordim.registry;


import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.prefersmin.mirrordim.MirrorDimension;
import top.prefersmin.mirrordim.block.ChordPortalBlock;

public class PMBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MirrorDimension.MODID);

    public static final RegistryObject<Block> CHORD_PORTAL = BLOCKS.register("chord_portal", ChordPortalBlock::new);

}
