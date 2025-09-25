package moffy.mimic.entity.fakeplayer;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
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
import java.util.Map;
import java.util.UUID;

public class FakePlayerWrapperEntity extends LivingEntity {
    protected FakePlayer fakePlayer;

    protected FakePlayerWrapperEntity(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

        if(!pLevel.isClientSide && pLevel instanceof ServerLevel serverLevel) {
            fakePlayer = FakePlayerFactory.get(serverLevel, new GameProfile(UUID.randomUUID(), "mimic_fake_player"));
        }
    }

    @Override
    public @NotNull Iterable<ItemStack> getArmorSlots() {
        return fakePlayer.getArmorSlots();
    }

    @Override
    public @NotNull ItemStack getItemBySlot(@NotNull EquipmentSlot pSlot) {
        return fakePlayer.getItemBySlot(pSlot);
    }

    @Override
    public void setItemSlot(@NotNull EquipmentSlot pSlot, @NotNull ItemStack pStack) {
    }

    @Override
    public @NotNull HumanoidArm getMainArm() {
        return fakePlayer.getMainArm();
    }

    @Override
    public @NotNull Collection<MobEffectInstance> getActiveEffects() {
        return fakePlayer.getActiveEffects();
    }

    @Override
    public @NotNull Map<MobEffect, MobEffectInstance> getActiveEffectsMap() {
        return fakePlayer.getActiveEffectsMap();
    }

    @Override
    public @Nullable MobEffectInstance getEffect(@NotNull MobEffect pEffect) {
        return fakePlayer.getEffect(pEffect);
    }

    @Override
    public boolean hasEffect(@NotNull MobEffect pEffect) {
        return fakePlayer.hasEffect(pEffect);
    }

    @Override
    public boolean canBeAffected(@NotNull MobEffectInstance pEffectInstance) {
        return fakePlayer.canBeAffected(pEffectInstance);
    }

    @Override
    public float getHealth() {
        return fakePlayer.getHealth();
    }

    @Override
    public @Nullable DamageSource getLastDamageSource() {
        return fakePlayer.getLastDamageSource();
    }

    @Override
    public @Nullable AttributeInstance getAttribute(@NotNull Attribute pAttribute) {
        return fakePlayer.getAttribute(pAttribute);
    }

    @Override
    public double getAttributeValue(@NotNull Holder<Attribute> pAttribute) {
        return fakePlayer.getAttributeValue(pAttribute);
    }

    @Override
    public double getAttributeValue(@NotNull Attribute pAttribute) {
        return fakePlayer.getAttributeValue(pAttribute);
    }

    @Override
    public double getAttributeBaseValue(@NotNull Holder<Attribute> pAttribute) {
        return fakePlayer.getAttributeBaseValue(pAttribute);
    }

    @Override
    public double getAttributeBaseValue(@NotNull Attribute pAttribute) {
        return fakePlayer.getAttributeBaseValue(pAttribute);
    }

    @Override
    public @NotNull AttributeMap getAttributes() {
        return fakePlayer.getAttributes();
    }

    @Override
    public @NotNull ItemStack getMainHandItem() {
        return fakePlayer.getMainHandItem();
    }

    @Override
    public @NotNull ItemStack getOffhandItem() {
        return fakePlayer.getOffhandItem();
    }

    @Override
    public int getArmorValue() {
        return fakePlayer.getArmorValue();
    }

    @Override
    public @NotNull SoundEvent getEatingSound(@NotNull ItemStack pStack) {
        return fakePlayer.getEatingSound(pStack);
    }

    @Override
    public @NotNull ItemStack getItemInHand(@NotNull InteractionHand pHand) {
        return fakePlayer.getItemInHand(pHand);
    }

    @Override
    public float getViewYRot(float pPartialTicks) {
        return fakePlayer.getViewYRot(pPartialTicks);
    }

    @Override
    public float getAttackAnim(float pPartialTick) {
        return fakePlayer.getAttackAnim(pPartialTick);
    }

    @Override
    public float getViewXRot(float pPartialTicks) {
        return fakePlayer.getViewXRot(pPartialTicks);
    }

    @Override
    public float getYHeadRot() {
        return fakePlayer.getYHeadRot();
    }

    @Override
    public @NotNull Vec2 getRotationVector() {
        return fakePlayer.getRotationVector();
    }

    @Override
    public float getVisualRotationYInDegrees() {
        return fakePlayer.getVisualRotationYInDegrees();
    }

    @Override
    public float getYRot() {
        return fakePlayer.getYRot();
    }

    @Override
    public float getXRot() {
        return fakePlayer.getXRot();
    }
}
