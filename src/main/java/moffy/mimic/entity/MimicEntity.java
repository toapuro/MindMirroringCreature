package moffy.mimic.entity;

import moffy.mimic.entity.fakeplayer.FakePlayerWrapperEntity;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class MimicEntity extends FakePlayerWrapperEntity {

    private static final EntityDataAccessor<Optional<UUID>> DATA_ATTACHED_PLAYER = SynchedEntityData.defineId(MimicEntity.class, EntityDataSerializers.OPTIONAL_UUID);

    @Nullable
    private ServerPlayer attachedPlayer = null;

    public MimicEntity(EntityType<? extends MimicEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ATTACHED_PLAYER, attachedPlayer == null ? Optional.empty() : Optional.of(attachedPlayer.getUUID()));
    }

    @SuppressWarnings("OptionalIsPresent")
    @Nullable
    public Player getAttachedPlayer() {
        Optional<UUID> uuid = this.entityData.get(DATA_ATTACHED_PLAYER);
        if(uuid.isPresent()) {
            return level().getPlayerByUUID(uuid.get());
        }

        return null;
    }

    public void setAttachedPlayer(@Nullable Player player) {
        entityData.set(DATA_ATTACHED_PLAYER, player == null ? Optional.empty() : Optional.of(player.getUUID()));
    }

    @Override
    public void die(@NotNull DamageSource pDamageSource) {
        if(fakePlayer == null) return;
        super.die(pDamageSource);
    }

    @Override
    public void tick() {
        super.tick();

        if(level().isClientSide) {
            return;
        }

        ServerPlayer nearest = level().getNearestEntity(ServerPlayer.class, TargetingConditions.forNonCombat(), this, getX(), getY(), getZ(), AABB.ofSize(
                this.position(), 20, 20, 20
        ));

        if(nearest != attachedPlayer) {
            this.setAttachedPlayer(nearest);
            this.attachedPlayer = nearest;
        }
    }
}
