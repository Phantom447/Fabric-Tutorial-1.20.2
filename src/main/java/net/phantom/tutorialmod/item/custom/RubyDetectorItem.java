package net.phantom.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.phantom.tutorialmod.block.ModBlocks;

public class RubyDetectorItem extends Item {
    public RubyDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundRuby = false;

            for(int i=0; i<=positionClicked.getY()+64; i++){
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if (isRuby(state)){
                    outputCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundRuby = true;
                    break;
                }
            }
            if (!foundRuby){
                player.sendMessage(Text.literal("No ruby ores found :("), false);
            }
        }
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputCoordinates(BlockPos pos, PlayerEntity player, Block block){
        player.sendMessage((Text.literal("Found "+block.asItem().getName().getString()+" at "+"("+pos.getX()+", "+pos.getY()+", "+pos.getZ()+")")), false);
    }

    private boolean isRuby(BlockState state){
       return state.isOf(ModBlocks.RUBY_ORE) || state.isOf(ModBlocks.DEEPSLATE_RUBY_ORE) || state.isOf(ModBlocks.NETHER_RUBY_ORE) || state.isOf(ModBlocks.END_RUBY_ORE);
    }
}
