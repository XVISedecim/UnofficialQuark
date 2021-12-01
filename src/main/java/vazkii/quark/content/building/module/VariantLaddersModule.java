package vazkii.quark.content.building.module;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import vazkii.quark.base.handler.FuelHandler;
import vazkii.quark.base.handler.ItemOverrideHandler;
import vazkii.quark.base.handler.MiscUtil;
import vazkii.quark.base.module.LoadModule;
import vazkii.quark.base.module.ModuleCategory;
import vazkii.quark.base.module.QuarkModule;
import vazkii.quark.base.module.config.Config;
import vazkii.quark.content.building.block.VariantLadderBlock;

@LoadModule(category = ModuleCategory.BUILDING)
public class VariantLaddersModule extends QuarkModule {

	@Config public static boolean changeNames = true;

	public static List<Block> variantLadders = new LinkedList<>();

	public static boolean moduleEnabled;

	@Override
	public void construct() {
		for(String type : MiscUtil.OVERWORLD_VARIANT_WOOD_TYPES)
			variantLadders.add(new VariantLadderBlock(type, this, true));
		for(String type : MiscUtil.NETHER_WOOD_TYPES)
			variantLadders.add(new VariantLadderBlock(type, this, false));
	}
	
	/**
	 * TODO 1.18: merge Iron Ladder with other ladders
	 * 
	 * 	@Override
		public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
			Direction facing = state.get(FACING);
			boolean solid = facing.getAxis() != Axis.Y && worldIn.getBlockState(pos.offset(facing.getOpposite())).isSolidSide(worldIn, pos.offset(facing.getOpposite()), facing);
			BlockState topState = worldIn.getBlockState(pos.up());
			return solid || (topState.getBlock() == this && (facing.getAxis() == Axis.Y || topState.get(FACING) == facing));
		}
	 */

	@Override
	public void loadComplete() {
		variantLadders.forEach(FuelHandler::addWood);
	}

	@Override
	public void configChanged() {
		moduleEnabled = this.enabled;
		ItemOverrideHandler.changeBlockLocalizationKey(Blocks.LADDER, "block.quark.oak_ladder", changeNames && enabled);
	}

	public static boolean isTrapdoorLadder(boolean defaultValue, IWorldReader world, BlockPos pos) {
		if(defaultValue || !moduleEnabled)
			return defaultValue;

		BlockState curr = world.getBlockState(pos);
		if(curr.getProperties().contains(TrapDoorBlock.OPEN) && curr.get(TrapDoorBlock.OPEN)) {
			BlockState down = world.getBlockState(pos.down());
			if(down.getBlock() instanceof LadderBlock)
				return down.get(LadderBlock.FACING) == curr.get(TrapDoorBlock.HORIZONTAL_FACING);
		}

		return false;
	}

}
