package vazkii.quark.content.world.module;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import vazkii.quark.base.block.QuarkBlock;
import vazkii.quark.base.handler.VariantHandler;
import vazkii.quark.base.module.LoadModule;
import vazkii.quark.base.module.ModuleCategory;
import vazkii.quark.base.module.QuarkModule;
import vazkii.quark.base.module.config.Config;
import vazkii.quark.base.module.config.type.DimensionConfig;

@LoadModule(category = ModuleCategory.WORLD)
public class DeepslateModule extends QuarkModule {

    @Config
    public static DimensionConfig dimensions = DimensionConfig.overworld(false);

    public static Block smooth_basalt;

    @Override
    public void construct() {
        AbstractBlock.Properties basaltProps = AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.25F, 4.2F).sound(SoundType.BASALT).setRequiresTool();

        smooth_basalt = VariantHandler.addSlabStairsWall(new QuarkBlock("smooth_basalt", this, ItemGroup.BUILDING_BLOCKS, basaltProps));
    }

}