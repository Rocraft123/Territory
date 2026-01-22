package com.Block.BlockEntity.BlockEntities;

import com.Block.BlockEntity.BlockEntityManager;
import com.Claim.Claim;
import com.rocraft.Territory;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.NonNull;

import java.util.HashSet;
import java.util.UUID;

public class ClaimAnchorBlockEntity extends BlockEntity {

    private Claim claim;

    public ClaimAnchorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityManager.CLAIM_ANCHOR_ENTITY, pos, state);
    }

    public boolean claimLand(UUID uuid) {
        if (claim != null)
            return false;

        claim = new Claim(uuid, new AABB(getBlockPos()).inflate(10), new HashSet<>());
        return true;
    }

    @Override
    protected void saveAdditional(@NonNull ValueOutput writeView) {
        if (claim != null)
            writeView.store(Territory.MOD_ID + ":claim", Claim.CODEC, claim);

        super.saveAdditional(writeView);
    }

    @Override
    protected void loadAdditional(@NonNull ValueInput valueInput) {
        if (claim != null) return;

        System.out.println("reading claim data...");
        this.claim = valueInput.read(Territory.MOD_ID + ":claim", Claim.CODEC)
                .orElse(null);

        if (claim != null) System.out.println("finished reading claim data: " + claim);
        else System.out.println("finished reading claim data");

        super.loadAdditional(valueInput);
    }
}