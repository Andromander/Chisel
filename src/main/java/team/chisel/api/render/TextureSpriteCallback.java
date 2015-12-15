package team.chisel.api.render;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

/**
 * Callback when textures are stitched
 */
public class TextureSpriteCallback {

    private ResourceLocation location;

    private TextureAtlasSprite sprite;

    public TextureSpriteCallback(ResourceLocation loc){
        this.location = loc;
    }

    public void stitch(TextureMap map){
        this.sprite = map.registerSprite(location);
    }

    public TextureAtlasSprite getSprite(){
        return this.sprite;
    }
}
