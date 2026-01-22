package com.Utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.UUID;

public class Codecs {

    public static final Codec<UUID> UUID_CODEC = Codec.STRING.xmap(UUID::fromString, UUID::toString);

    public static final Codec<AABB> AABB_CODEC = Codec.DOUBLE.listOf().comapFlatMap(
            list -> list.size() == 6
                    ? DataResult.success(new AABB(
                    list.getFirst(), list.get(1), list.get(2),
                    list.get(3), list.get(4), list.get(5)))
                    : DataResult.error(() -> "Expected 6 doubles for AABB"),
            aabb -> List.of(
                    aabb.minX, aabb.minY, aabb.minZ,
                    aabb.maxX, aabb.maxY, aabb.maxZ)
    );

}
