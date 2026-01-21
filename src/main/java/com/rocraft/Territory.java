package com.rocraft;

import com.Block.BlockEntity.BlockEntityManager;
import com.Block.BlockManager;
import net.fabricmc.api.ModInitializer;

public class Territory implements ModInitializer {

    //public static String MOD_ID = "claim_Consequence";
    public static String MOD_ID = "territory";

    @Override
    public void onInitialize() {
        BlockEntityManager.init();
        BlockManager.initialize();
    }
}
