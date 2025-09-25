package moffy.mimic.entity;

import moffy.mimic.entity.fakeplayer.FakePlayerWrapperEntity;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class MimicEntity extends FakePlayerWrapperEntity {
    public MimicEntity(EntityType<? extends MimicEntity> entityType, Level level) {
        super(entityType, level);
    }
}
