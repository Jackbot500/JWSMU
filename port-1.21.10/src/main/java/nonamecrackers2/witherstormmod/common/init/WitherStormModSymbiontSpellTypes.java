package nonamecrackers2.witherstormmod.common.init;

import java.util.Optional;

import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.RegistryObject;
import nonamecrackers2.witherstormmod.api.common.ai.symbiont.SpellType;
import nonamecrackers2.witherstormmod.api.common.registry.WitherStormModRegistries;
import nonamecrackers2.witherstormmod.common.entity.WitheredSymbiontEntity;
import nonamecrackers2.witherstormmod.common.entity.ai.symbiont.*;
import nonamecrackers2.witherstormmod.common.util.DragonFireballAccessor;

public class WitherStormModSymbiontSpellTypes {

        public static final RegistryObject<SpellType> EMPTY = WitherStormModRegistries.SPELL_TYPES.register(
                        "empty",
                        () -> new SpellType(EmptySpell::new, 0, Optional.empty(), false));

        public static final RegistryObject<SpellType> EVOKER_FANGS = WitherStormModRegistries.SPELL_TYPES.register(
                        "evoker_fangs",
                        () -> new SpellType(EvokerFangsSpell::new, 20, Optional.empty()));

        public static final RegistryObject<SpellType> SHULKER_BULLETS = WitherStormModRegistries.SPELL_TYPES.register(
                        "shulker_bullets",
                        () -> new SpellType(ShulkerBulletsSpell::new, 80, Optional.empty()));

        public static final RegistryObject<SpellType> ARROWS = WitherStormModRegistries.SPELL_TYPES.register(
                        "arrows",
                        () -> new SpellType(ArrowsSpell::new, 120, Optional.empty()));

        public static final RegistryObject<SpellType> SMASH = WitherStormModRegistries.SPELL_TYPES.register(
                        "smash",
                        () -> new SpellType(SmashSpell::new, 40, Optional.empty()));

        // Reconstructed from context: FireballSpell needs a ProjectileFactory and
        // count.
        // This version uses a simple LargeFireball factory as a faithful approximation.
        public static final RegistryObject<SpellType> FIRE_BALLS = WitherStormModRegistries.SPELL_TYPES.register(
                        "fire_balls",
                        () -> new SpellType(
                                        (WitheredSymbiontEntity symbiont, SpellType type) -> new FireballSpell(
                                                        symbiont,
                                                        type,
                                                        FireballSpellFactories.largeFireball(),
                                                        8 // guessed count; we can tweak once behavior is tested
                                        ),
                                        160,
                                        Optional.empty()));

        public static final RegistryObject<SpellType> WITHER_SKULLS = WitherStormModRegistries.SPELL_TYPES.register(
                        "wither_skulls",
                        () -> new SpellType(WitherSkullsSpell::new, 220, Optional.empty()));

        public static final RegistryObject<SpellType> PULL = WitherStormModRegistries.SPELL_TYPES.register(
                        "pull",
                        () -> new SpellType(
                                        PullSpell::new,
                                        240,
                                        Optional.of(WitherStormModSoundEvents.WITHERED_SYMBIONT_PULL),
                                        false));

        public static final RegistryObject<SpellType> THROWING = WitherStormModRegistries.SPELL_TYPES.register(
                        "throwing",
                        () -> new SpellType(ThrowingSpell::new, 240, Optional.empty()));

        public static final RegistryObject<SpellType> BOMBING = WitherStormModRegistries.SPELL_TYPES.register(
                        "bombing",
                        () -> new SpellType(BombingSpell::new, 60, Optional.empty()));

        public static final RegistryObject<SpellType> PULSE = WitherStormModRegistries.SPELL_TYPES.register(
                        "pulse",
                        () -> new SpellType(PulseSpell::new, 160, Optional.empty(), true, 6.0D, 2.0D));

        // Helper to keep the Fireball factory logic tidy
        public static final class FireballSpellFactories {
                public static FireballSpell.ProjectileFactory largeFireball() {
                        return (Level level, LivingEntity owner, double x, double y, double z) -> {
                                // You can swap this to DragonFireball + DragonFireballAccessor if needed later
                                return new LargeFireball(level, owner, x, y, z, 2);
                        };
                }
        }
}
