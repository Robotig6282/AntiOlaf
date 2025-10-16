package xyz.robotig.antiolaf.mixin;

import xyz.robotig.antiolaf.feature.modules.AntiSnowballModule;
import com.dwarslooper.cactus.client.util.game.ChatUtils;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class AntiSnowballMixin {

    @Inject(method = "onEntitySpawn", at = @At("HEAD"), cancellable = true)
    private void onEntitySpawn(EntitySpawnS2CPacket packet, CallbackInfo ci) {
        AntiSnowballModule module = AntiSnowballModule.getInstance();

        if (module != null && module.shouldBlockSnowballs()) {
            // Check if the entity being spawned is a snowball
            if (packet.getEntityType() == EntityType.SNOWBALL) {
                if (module.shouldShowMessages()) {
                    ChatUtils.infoPrefix("AntiSnowball", "Blocked snowball packet");
                }
                // Cancel the packet processing, preventing the snowball from spawning
                ci.cancel();
            }
        }
    }
}
