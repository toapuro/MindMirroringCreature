package moffy.mimic.entity.fakeplayer;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FakePlayerWrapperEntity extends LivingEntity {
    @Nullable
    protected FakePlayer fakePlayer;

    protected FakePlayerWrapperEntity(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

        if(!pLevel.isClientSide && pLevel instanceof ServerLevel serverLevel) {
            fakePlayer = FakePlayerFactory.get(serverLevel, new GameProfile(UUID.randomUUID(), "mimic_fake_player"));
        }
    }

    @Override
    public @NotNull Iterable<ItemStack> getArmorSlots() {
        if(fakePlayer == null) return List.of();
        return fakePlayer.getArmorSlots();
    }

    @Override
    public @NotNull ItemStack getItemBySlot(@NotNull EquipmentSlot pSlot) {
        if(fakePlayer == null) return ItemStack.EMPTY;
        return fakePlayer.getItemBySlot(pSlot);
    }

    @Override
    public void setItemSlot(@NotNull EquipmentSlot pSlot, @NotNull ItemStack pStack) {
    }

    @Override
    public @NotNull HumanoidArm getMainArm() {
        if(fakePlayer == null) return HumanoidArm.RIGHT;
        return fakePlayer.getMainArm();
    }

    @Override
    public @NotNull Collection<MobEffectInstance> getActiveEffects() {
        if(fakePlayer == null) return List.of();
        return fakePlayer.getActiveEffects();
    }

    @Override
    public @NotNull Map<MobEffect, MobEffectInstance> getActiveEffectsMap() {
        if(fakePlayer == null) return Map.of();
        return fakePlayer.getActiveEffectsMap();
    }

    @Override
    public @Nullable MobEffectInstance getEffect(@NotNull MobEffect pEffect) {
        if(fakePlayer == null) return null;
        return fakePlayer.getEffect(pEffect);
    }

    @Override
    public boolean hasEffect(@NotNull MobEffect pEffect) {
        if(fakePlayer == null) return false;
        return fakePlayer.hasEffect(pEffect);
    }

    @Override
    public boolean canBeAffected(@NotNull MobEffectInstance pEffectInstance) {
        if(fakePlayer == null) return false;
        return fakePlayer.canBeAffected(pEffectInstance);
    }

    @Override
    public float getHealth() {
        if(fakePlayer == null) return 20;
        return fakePlayer.getHealth();
    }

    @Override
    public @Nullable DamageSource getLastDamageSource() {
        if(fakePlayer == null) return null;
        return fakePlayer.getLastDamageSource();
    }

    @Override
    public @Nullable AttributeInstance getAttribute(@NotNull Attribute pAttribute) {
        if(fakePlayer == null) return null;
        return fakePlayer.getAttribute(pAttribute);
    }

    @Override
    public double getAttributeValue(@NotNull Holder<Attribute> pAttribute) {
        if(fakePlayer == null) return 0;
        return fakePlayer.getAttributeValue(pAttribute);
    }

    @Override
    public double getAttributeValue(@NotNull Attribute pAttribute) {
        if(fakePlayer == null) return 0;
        return fakePlayer.getAttributeValue(pAttribute);
    }

    @Override
    public double getAttributeBaseValue(@NotNull Holder<Attribute> pAttribute) {
        if(fakePlayer == null) return 0;
        return fakePlayer.getAttributeBaseValue(pAttribute);
    }

    @Override
    public double getAttributeBaseValue(@NotNull Attribute pAttribute) {
        if(fakePlayer == null) return 0;
        return fakePlayer.getAttributeBaseValue(pAttribute);
    }

    @Override
    public @NotNull AttributeMap getAttributes() {
        if(fakePlayer == null) return super.getAttributes();
        return fakePlayer.getAttributes();
    }

    @Override
    public @NotNull ItemStack getMainHandItem() {
        if(fakePlayer == null) return ItemStack.EMPTY;
        return fakePlayer.getMainHandItem();
    }

    @Override
    public @NotNull ItemStack getOffhandItem() {
        if(fakePlayer == null) return ItemStack.EMPTY;
        return fakePlayer.getOffhandItem();
    }

    @Override
    public int getArmorValue() {
        if(fakePlayer == null) return 0;
        return fakePlayer.getArmorValue();
    }

    @Override
    public @NotNull ItemStack getItemInHand(@NotNull InteractionHand pHand) {
        if(fakePlayer == null) return ItemStack.EMPTY;
        return fakePlayer.getItemInHand(pHand);
    }

    @Override
    public float getViewYRot(float pPartialTicks) {
        if(fakePlayer == null) return super.getViewYRot(pPartialTicks);
        return fakePlayer.getViewYRot(pPartialTicks);
    }

    @Override
    public float getAttackAnim(float pPartialTick) {
        if(fakePlayer == null) return super.getAttackAnim(pPartialTick);
        return fakePlayer.getAttackAnim(pPartialTick);
    }

    @Override
    public float getViewXRot(float pPartialTicks) {
        if(fakePlayer == null) return super.getViewXRot(pPartialTicks);
        return fakePlayer.getViewXRot(pPartialTicks);
    }

    @Override
    public float getYHeadRot() {
        if(fakePlayer == null) return super.getYHeadRot();
        return fakePlayer.getYHeadRot();
    }

    @Override
    public @NotNull Vec2 getRotationVector() {
        if(fakePlayer == null) return super.getRotationVector();
        return fakePlayer.getRotationVector();
    }

    @Override
    public float getVisualRotationYInDegrees() {
        if(fakePlayer == null) return super.getVisualRotationYInDegrees();
        return fakePlayer.getVisualRotationYInDegrees();
    }

    @Override
    public float getYRot() {
        if(fakePlayer == null) return super.getYRot();
        return fakePlayer.getYRot();
    }

    @Override
    public float getXRot() {
        if(fakePlayer == null) return super.getXRot();
        return fakePlayer.getXRot();
    }
}
