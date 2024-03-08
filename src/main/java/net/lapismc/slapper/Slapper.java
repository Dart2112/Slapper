package net.lapismc.slapper;

import net.lapismc.lapiscore.LapisCorePlugin;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public final class Slapper extends LapisCorePlugin {

    @Override
    public void onEnable() {
        new SlapperCommand(this);
        new Permission("slapper.slap", PermissionDefault.OP);
        super.onEnable();
    }

}
