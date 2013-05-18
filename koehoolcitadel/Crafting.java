package koehoolcitadel;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class Crafting extends Node {
	
	private final int[] LOOM_IDS = {15737, 15736, 15735, 15734, 15340, 15339, 15338, 15335, 14662,
			14478, 14477, 14435, 15174, 15057, 15056, 15055, 15684, 15685,
			15691, 15692, 15693, 14335, 14337, 14340, 14341 };

	@Override
	public boolean activate() {

		return KoehoalCitadel.Task == "Crafting";
	}

	@Override
	public void execute() {
		KoehoalCitadel.Status = "Crafting";

		SceneObject loom = SceneEntities.getNearest(LOOM_IDS);
		
		if(loom != null){
			
			if(loom.isOnScreen()){
				
				if(!Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1){
					Timer a = new Timer(2000);
					loom.interact("Weave");
					a.reset();
					
					while(a.isRunning() && !Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1){
						Task.sleep(400);
					}
					
					}
				
			}else if(!loom.isOnScreen()){
				Camera.turnTo(loom);
				Task.sleep(250, 400);
				if(!loom.isOnScreen()){
					Walking.walk(loom);
				}
				
			}
			
		}else if(loom == null){
			Task.sleep(100);
		}

		

	}

}
