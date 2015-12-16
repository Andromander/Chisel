package team.chisel.api.block;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;

/**
 * Represents data about a specific variation
 */
public class VariationData {

    /**
     * The Name of this variation
     */
    public String name;

    /**
     * The carving group of this variation
     */
    @Nullable
    public String group;

    /**
     * The Recipe for this variation, if null it cant be crafted TODO Crafting stuff, maybe custom data class 3x3 of unique identifiers or ore dictionary names
     */
    public ChiselRecipe recipe;

    /**
     * The Itemstack that is smelted into this variation, if null it cant be smelted
     */
    public ItemStack smeltedFrom;

    /**
     * Gets the amount of this block produced through smelting
     */
    public int amountSmelted;

    /**
     * The Light value provided by this block
     */
    public int light;

    /**
     * The Block hardness
     */
    public float hardness;

    /**
     * Whether this block can be used to construct a beacon base
     */
    public boolean beaconBase;

    /**
     * The Index of this variation in the blocks total variations
     */
    public int index;

    public VariationData(String name, @Nullable String group, ChiselRecipe recipe, ItemStack smeltedFrom, int amountSmelted, int light, float hardness, boolean beaconBase, int index) {
        this.name = name;
        this.group = group;
        this.recipe = recipe;
        this.smeltedFrom = smeltedFrom;
        this.amountSmelted = amountSmelted;
        this.light = light;
        this.hardness = hardness;
        this.beaconBase = beaconBase;
    }
}