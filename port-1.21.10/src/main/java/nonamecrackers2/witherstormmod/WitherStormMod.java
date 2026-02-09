package nonamecrackers2.witherstormmod;

import net.minecraftforge.eventbus.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nonamecrackers2.witherstormmod.api.common.registry.WitherStormModRegistries;

@Mod(WitherStormMod.MODID)
public class WitherStormMod {

	public static final String MODID = "witherstormmod";

	public WitherStormMod() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register custom registries (SpellType)
		WitherStormModRegistries.register(modBus);

		// Register everything else (blocks, items, entities, sounds, etc.)
		// WitherStormModBlocks.register(modBus);
		// WitherStormModItems.register(modBus);
		// WitherStormModEntities.register(modBus);
		// WitherStormModSoundEvents.register(modBus);
	}
}
