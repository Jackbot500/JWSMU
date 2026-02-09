package nonamecrackers2.witherstormmod.api.common.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import nonamecrackers2.witherstormmod.WitherStormMod;
import nonamecrackers2.witherstormmod.api.common.ai.symbiont.SpellType;

public class WitherStormModRegistries {

    // Same name as in the original mod
    public static final ResourceLocation SPELL_TYPES_NAME = WitherStormMod.id("symbiont_spells");

    // Custom registry key for SpellType
    public static final ResourceKey<Registry<SpellType>> SPELL_TYPE_REGISTRY_KEY = ResourceKey
            .createRegistryKey(SPELL_TYPES_NAME);

    // DeferredRegister for SpellType
    public static final DeferredRegister<SpellType> SPELL_TYPES = DeferredRegister.create(SPELL_TYPE_REGISTRY_KEY,
            WitherStormMod.MODID);

    // Called from the main mod class
    public static void register(IEventBus modBus) {
        SPELL_TYPES.register(modBus);
    }
}
