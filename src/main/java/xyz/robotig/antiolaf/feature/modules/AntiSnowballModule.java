package xyz.robotig.antiolaf.feature.modules;

import xyz.robotig.antiolaf.AntiOlafMain;
import com.dwarslooper.cactus.client.feature.module.Module;
import com.dwarslooper.cactus.client.systems.config.settings.group.SettingGroup;
import com.dwarslooper.cactus.client.systems.config.settings.impl.BooleanSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.Setting;
import com.dwarslooper.cactus.client.util.game.ChatUtils;

public class AntiSnowballModule extends Module {

    private static AntiSnowballModule INSTANCE;

    private final SettingGroup mainGroup = settings.buildGroup("main");
    public final Setting<Boolean> blockSpawnPackets = mainGroup.add(new BooleanSetting("blockSpawnPackets", true));
    public final Setting<Boolean> showBlockedMessages = mainGroup.add(new BooleanSetting("showBlockedMessages", false));

    public AntiSnowballModule() {
        super("antiSnowball", AntiOlafMain.CATEGORY, new Options());
        INSTANCE = this;
    }

    public static AntiSnowballModule getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        ChatUtils.infoPrefix("AntiSnowball", "Snowball packet blocking enabled");
    }

    @Override
    public void onDisable() {
        ChatUtils.infoPrefix("AntiSnowball", "Snowball packet blocking disabled");
    }

    public boolean shouldBlockSnowballs() {
        return active() && blockSpawnPackets.get();
    }

    public boolean shouldShowMessages() {
        return showBlockedMessages.get();
    }
}
