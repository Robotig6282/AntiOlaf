package xyz.robotig.antiolaf;

import xyz.robotig.antiolaf.feature.modules.AntiSnowballModule;
import com.dwarslooper.cactus.client.addon.v2.ICactusAddon;
import com.dwarslooper.cactus.client.addon.v2.RegistryBus;
import com.dwarslooper.cactus.client.feature.module.Category;
import com.dwarslooper.cactus.client.feature.module.Module;

import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AntiOlafMain implements ICactusAddon {

	public static final Logger LOGGER = LoggerFactory.getLogger("AntiOlaf");

	public static final Category CATEGORY = new Category("AntiOlaf", Items.DIAMOND.getDefaultStack());

	@Override
	public void onInitialize(RegistryBus registryBus) {
		// This is called when the addon is initialized. It provides a RegistryBus
		// which will be used to register new features and content


		registryBus.register(Category.class, ctx -> CATEGORY);
		registryBus.register(Module.class, ctx -> new AntiSnowballModule());

		LOGGER.info("AntiOlaf successfully loaded!");
	}

	@Override
	public void onLoadComplete() {
		// This is called when Cactus is fully done initializing
		// This does not mean the game has completely loaded yet
	}

	@Override
	public void onShutdown() {
		// This is called when the client is shutting down
	}
}