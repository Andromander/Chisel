package team.chisel.api.render;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import team.chisel.Chisel;

/**
 * List of IBlockRenderContext's
 */
public class RenderContextList {

    private Map<IBlockRenderType, IBlockRenderContext> contextMap;

    public RenderContextList(Collection<IBlockRenderType> types, IBlockAccess world, BlockPos pos){
        contextMap = new HashMap<IBlockRenderType, IBlockRenderContext>();
        for (IBlockRenderType type : types){
            IBlockRenderContext ctx = type.getBlockRenderContext(world, pos);
            if (ctx != null) {
                contextMap.put(type, ctx);
            }
        }
    }

    public IBlockRenderContext getRenderContext(IBlockRenderType type){
        try {
            return this.contextMap.get(type);
        } catch (ClassCastException exception){
            Chisel.debug("Contextmap had a bad type context pair");
            throw exception;
        }
    }

    public boolean contains(IBlockRenderType type){
        return getRenderContext(type) != null;
    }

    public RenderContextList(){

    }
}
