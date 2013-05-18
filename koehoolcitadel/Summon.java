package koehoolcitadel;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class Summon extends Node {

	private final int[] OBELISK = {20511,20585};
	
	SceneObject obelisk = SceneEntities.getNearest(OBELISK);
	
	@Override
	public boolean activate() {
		obelisk = SceneEntities.getNearest(OBELISK);
		return obelisk != null && KoehoalCitadel.Task.contentEquals("Summoning");
	}

	@Override
	public void execute() {
		obelisk = SceneEntities.getNearest(OBELISK);
		KoehoalCitadel.Status = "Summoning";
		
		if(obelisk != null){
			if(obelisk.isOnScreen()){
				if(!Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1){
					obelisk.interact("Summon");
					Task.sleep(750, 1250);
				}else if(Players.getLocal().isMoving() || Players.getLocal().getAnimation() != -1){
					Task.sleep(400);
				}
				
			}else if(!obelisk.isOnScreen()){
				Camera.turnTo(obelisk);
				Task.sleep(250, 400);
				if(!obelisk.isOnScreen()){
				Walking.walk(obelisk);
				}
			}
			
		}else if(obelisk == null){
			Task.sleep(100);
			
		}

	}

}
