package team.chisel.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import team.chisel.client.render.RenderAutoChisel;
import team.chisel.common.init.ChiselTileEntities;

@EventBusSubscriber(value = Dist.CLIENT, bus = Bus.MOD)
public class ClientProxy {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ClientRegistry.bindTileEntityRenderer(ChiselTileEntities.AUTO_CHISEL_TE.get(), RenderAutoChisel::new);

// TODO       MinecraftForge.EVENT_BUS.register(new DebugHandler());

// TODO       OffsetProviderRegistry.INSTANCE.registerProvider((world, pos) -> ChunkData.getOffsetForChunk(world, pos).getOffset());        
    }

    public static World getClientWorld() {
        return DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> Minecraft.getInstance().world);
    }
    
    public static PlayerEntity getClientPlayer() {
        return DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> Minecraft.getInstance().player);
    }
}
