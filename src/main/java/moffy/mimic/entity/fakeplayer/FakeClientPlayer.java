package moffy.mimic.entity.fakeplayer;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;

public class FakeClientPlayer extends AbstractClientPlayer {
    public FakeClientPlayer(ClientLevel pClientLevel, GameProfile pGameProfile) {
        super(pClientLevel, pGameProfile);
    }
}
