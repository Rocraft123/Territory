package com.Claim;

import com.Utils.Codecs;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.phys.AABB;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Claim {

    private final UUID owner;
    private final AABB area;
    private final Set<UUID> trusted;

    public Claim(UUID owner, AABB area, Set<UUID> trusted) {
        this.owner = owner;
        this.area = area;
        this.trusted = trusted;
    }

    public UUID getOwner() {
        return owner;
    }

    public AABB getArea() {
        return area;
    }

    public Set<UUID> getTrusted() {
        return trusted;
    }

    public boolean addTrusted(UUID uuid) {
        return trusted.add(uuid);
    }

    public boolean removeTrusted(UUID uuid) {
        return trusted.remove(uuid);
    }

    @Override
    public String toString() {
        return "owner:" + owner + " trusted:" + Arrays.toString(trusted.toArray()) + " area:" + area.toString();
    }

    public static final Codec<Claim> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codecs.UUID_CODEC.fieldOf("owner").forGetter(Claim::getOwner),
                    Codecs.AABB_CODEC.fieldOf("area").forGetter(Claim::getArea),
                    Codecs.UUID_CODEC.listOf()
                            .xmap(Set::copyOf, List::copyOf)
                            .fieldOf("trusted")
                            .forGetter(Claim::getTrusted)
            ).apply(instance, Claim::new)
    );
}
