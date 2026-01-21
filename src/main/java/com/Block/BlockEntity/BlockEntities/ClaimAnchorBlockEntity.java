package com.Block.BlockEntity.BlockEntities;

import com.Block.BlockEntity.BlockEntityManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.NonNull;

public class ClaimAnchorBlockEntity extends BlockEntity {

    public ClaimAnchorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityManager.CLAIM_ANCHOR_ENTITY, pos, state);
    }

    @Override
    protected void saveAdditional(@NonNull ValueOutput writeView) {
        super.saveAdditional(writeView);
    }

    @Override
    protected void loadAdditional(@NonNull ValueInput valueInput) {
        super.loadAdditional(valueInput);
    }
}