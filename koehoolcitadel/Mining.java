package koehoolcitadel;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class Mining extends Node {
	
	private final int MINING_EMOTE = 6051;
	
	 private final int[] STONE_IDs = { 20754, 20981, 20982, 20983, 21500, 21501,
	            21517, 21518, 21556, 21558, 21560, 21643, 21656, 21673, 21672,
	            24619, 24906, 24910, 24917, 24962, 24965, 24977, 24978, 24983,
	            28007, 28008, 28009, 28016, 28017, 28018, 28019, 28020, 28021,
	            28022, 28023, 28028, 28029, 28030, 28031, 28032, 28033, 28034,
	            28035, 28036, 28037, 28038, 28039, 28043, 28044, 28045, 28048,
	            28049, 28050, 28051, 28052, 28053, 28085, 28086, 28087, 28088,
	            28089, 28090, 28091, 28092, 28093, 48125, 48130, 48210, 48211,
	            48283, 48326, 48332, 48334, 48336, 48338, 48401, 48402, 48403,
	            48417, 48422, 48491, 48500, 48501, 48508, 48511, 48512, 48517 };
	    private final int[] ORE_IDs = { 25031, 25032, 25049, 25050, 25051, 25052,
	            25053, 25054, 28054, 28055, 28056, 28057, 28058, 28061, 28062,
	            28063, 28064, 28065, 28066, 28068, 28069, 28070, 48570, 48571,
	            48574, 48576, 48600, 48606, 48609, 48622, 48709, 48710, 48712,
	            48718, 48727, 48736 };
	    private final int[] P_ORE_IDs = { 25057, 25058, 25059, 25060, 25061, 25062,
	            25063, 25064, 28074, 28075, 28076, 28077, 28078, 28079, 28080,
	            28082, 28083, 28084, 48737, 48751, 48780, 48795, 48887, 48952,
	            48970, 48973, 48976, 48982 };
	    
	    SceneObject stone = SceneEntities.getNearest(STONE_IDs);
	    SceneObject ore = SceneEntities.getNearest(ORE_IDs);
	    SceneObject pOre = SceneEntities.getNearest(P_ORE_IDs);

	@Override
	public boolean activate() {

		return KoehoalCitadel.Task == "Mining";
	}

	@Override
	public void execute() {
		KoehoalCitadel.Status = "Mining";
		
		if(KoehoalCitadel.Resource == "Stone"){
			Mine(STONE_IDs);
			
		}else if(KoehoalCitadel.Resource == "Ore"){
			Mine(ORE_IDs);
			
		}else if(KoehoalCitadel.Resource == "Precious Ore"){
			Mine(P_ORE_IDs);
			
		}

	}
	
	
	private void Mine(int[] OTM){
		
		SceneObject otm = SceneEntities.getNearest(OTM);
		Timer a = new Timer(3000);
		if(otm != null){
			
			if(Players.getLocal().getAnimation() == 6051){
				while(Players.getLocal().getAnimation() == 6051){
				Task.sleep(4000);
				}
			}
			if(otm.isOnScreen()){
			if(!Players.getLocal().isMoving() && Players.getLocal().getAnimation() == -1 ){
				otm.interact("Mine");
				Task.sleep(250, 400);
				a.reset();
				while(Players.getLocal().isMoving() && Players.getLocal().getAnimation() != -1 &&a.isRunning()){
					if(Players.getLocal().getAnimation() == MINING_EMOTE){
						while(Players.getLocal().getAnimation() == MINING_EMOTE){
						a.reset();
						Task.sleep(250, 400);
						}
					}
					Task.sleep(400);
				}
			}
			}else if(!otm.isOnScreen()){
				Camera.turnTo(otm);
				Task.sleep(250,400);
				if(!otm.isOnScreen()){
				Walking.walk(otm);
				}
				
			}
			
		}else if(otm == null){
			Task.sleep(100, 200);
		}
		
		
	}

}
