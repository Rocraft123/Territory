package com.Block.BlockEntity;

import com.Block.BlockEntity.BlockEntities.ClaimAnchorBlockEntity;
import com.Block.BlockManager;
import com.rocraft.Territory;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BlockEntityManager {

    public static final BlockEntityType<ClaimAnchorBlockEntity> CLAIM_ANCHOR_ENTITY =
            register("counter", ClaimAnchorBlockEntity::new, BlockManager.CLAIM_ANCHOR_BLOCK);

    private static <T extends BlockEntity> BlockEntityType<T> register(String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {

        Identifier id = Identifier.fromNamespaceAndPath(Territory.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void init() {}
}
