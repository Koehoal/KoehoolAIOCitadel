package koehoolcitadel;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class Woodcutting extends Node {

	 private final int[] ROOT_ID = { 17301, 17318, 17319, 17326, 17327, 17328,
	            17858, 17861, 17931, 17971, 17907, 17913, 17920, 17995, 17998,
	            18328, 18331, 18406, 18496, 18503, 18662, 18856, 18859, 18874,
	            18883, 18901, 18907, 18920, 18921, 19974 };
	
	 SceneObject root = SceneEntities.getNearest(ROOT_ID);
	 
	@Override
	public boolean activate() {
		root = SceneEntities.getNearest(ROOT_ID);
		
		return KoehoalCitadel.Task.contentEquals("WoodCutting");
		
	}

	@Override
	public void execute() {
		root = SceneEntities.getNearest(ROOT_ID);
		KoehoalCitadel.Status = "WoodCutting";
	
		if(root != null){
			if(root.isOnScreen()){
				if(!Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1){
					KoehoalCitadel.Status = "Chopping Root";
				root.interact("Chop");
				Task.sleep(750, 1250);
				}
				
			}else if(!root.isOnScreen()){
				Camera.turnTo(root);
				Task.sleep(250, 400);
				if(!root.isOnScreen()){
					Walking.walk(root);
				}
			}
			
		}else if(root == null){
			Task.sleep(100);
		}
		
	}

}
