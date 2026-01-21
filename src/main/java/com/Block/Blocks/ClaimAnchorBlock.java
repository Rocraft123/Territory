package com.Block.Blocks;

import com.Block.BlockEntity.BlockEntities.ClaimAnchorBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class ClaimAnchorBlock extends BaseEntityBlock {

    public ClaimAnchorBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected @NonNull MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(ClaimAnchorBlock::new);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NonNull BlockPos pos, @NonNull BlockState state) {
        return new ClaimAnchorBlockEntity(pos, state);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState blockState, @NonNull Level level, @NonNull BlockPos blockPos,
                                                        @NonNull Player player, @NonNull BlockHitResult blockHitResult) {
        if (!(level.getBlockEntity(blockPos) instanceof ClaimAnchorBlockEntity))
            return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);

        player.displayClientMessage(Component.literal("you used the block"), false);
        return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
    }
}
