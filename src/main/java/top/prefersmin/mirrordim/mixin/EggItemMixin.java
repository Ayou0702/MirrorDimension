package top.prefersmin.mirrordim.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import top.prefersmin.mirrordim.block.ChordPortalBlock;
import top.prefersmin.mirrordim.registry.PMBlocks;
import top.prefersmin.mirrordim.registry.PMDimensions;

import java.util.Objects;

@Mixin(EggItem.class)
public class EggItemMixin extends Item {

    public EggItemMixin(Properties pProperties) {
        super(pProperties);
    }

    // 使用鸡蛋右键玻璃即可点亮传送门
    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() != null) {
            if (context.getPlayer().level().dimension() == PMDimensions.CHORD_LEVEL || context.getPlayer().level().dimension() == Level.OVERWORLD) {
                for (Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if (((ChordPortalBlock) PMBlocks.CHORD_PORTAL.get()).trySpawnPortal(context, framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast"))), SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    } else {
                        return InteractionResult.FAIL;
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }

}
