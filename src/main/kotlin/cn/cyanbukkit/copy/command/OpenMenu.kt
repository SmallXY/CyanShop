package cn.cyanbukkit.copy.command

import cn.cyanbukkit.copy.CyanShop
import cn.cyanbukkit.copy.menu.MenuListener
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class OpenMenu(
    val sender: CommandSender,
    val p: Player?,
    val menuName: String,
) {


    fun init() {
        if (!CyanShop.allMenu.containsKey(menuName)) {
            sender.sendMessage("§c菜单不存在")
            return
        }
        if (p == null) {
            if (sender is Player) {
                MenuListener.changeMenu(sender, CyanShop.allMenu[menuName]!!)
                return
            } else {
                sender.sendMessage("§c你必须是玩家")
                return
            }
        }
        MenuListener.changeMenu(p, CyanShop.allMenu[menuName]!!)
    }


}