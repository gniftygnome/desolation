package raltsmc.desolation.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.entity.AshScuttlerEntity;
import raltsmc.desolation.entity.BlackenedEntity;

public final class DesolationEntities {
    public static final EntityType<AshScuttlerEntity> ASH_SCUTTLER = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Desolation.MOD_ID, "ash_scuttler"),
            EntityType.Builder.create(AshScuttlerEntity::new, SpawnGroup.AMBIENT)
                    .dimensions(0.56f,0.32f)
                    .makeFireImmune()
                    .build()
    );

    public static final EntityType<BlackenedEntity> BLACKENED = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Desolation.MOD_ID, "blackened"),
            EntityType.Builder.create(BlackenedEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.75f,2f)
                    .makeFireImmune()
                    .build()
    );

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationEntities() {
        return;
    }

    static void init() {
        FabricDefaultAttributeRegistry.register(ASH_SCUTTLER, AshScuttlerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(BLACKENED, BlackenedEntity.createBlackenedAttributes());

        SpawnRestriction.register(ASH_SCUTTLER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);
        SpawnRestriction.register(BLACKENED, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canMobSpawn);
    }
}
