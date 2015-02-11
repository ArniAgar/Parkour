/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.lolnet.arns.parkour;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author James
 */
class MyListener implements Listener {

    public MyListener(Main aThis) {
    }

    @EventHandler
    public void onRightClickBlockWithWand(PlayerInteractEvent event) {
        if (event.getPlayer().hasPermission("somerandomPermission.node.here")) {
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && 
                    event.hasBlock() && 
                    event.getPlayer().getItemInHand().getType().equals(Main.wand.getType())) {
                //Do something
            }
        }

    }
}
