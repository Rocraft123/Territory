package com.Claim;

import net.minecraft.world.phys.AABB;

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
        return super.toString();
    }
}
