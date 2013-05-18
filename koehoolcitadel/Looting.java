package koehoolcitadel;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.GroundItem;

public class Looting extends Node {

	GroundItem ort = GroundItems.getNearest(24909);
	
	@Override
	public boolean activate() {
		ort = GroundItems.getNearest(24909);
		return ort != null && KoehoalCitadel.Loot == true;
	}

	@Override
	public void execute() {
		KoehoalCitadel.Status = "Looting";
		
		ort = GroundItems.getNearest(24909 );
		
		if(ort != null){
			if(ort.isOnScreen()){
				if(!Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1){
					ort.interact("Take");
					Task.sleep(750, 1250);
				}else if(Players.getLocal().isMoving() || Players.getLocal().getAnimation() != -1){
					Task.sleep(400);
				}
			}else if(!ort.isOnScreen()){
				Camera.turnTo(ort);
				Task.sleep(250, 400);
				if(Walking.walk(ort));
				
			}
		}
		
		

	}

}
