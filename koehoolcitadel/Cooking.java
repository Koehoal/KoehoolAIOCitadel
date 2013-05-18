package koehoolcitadel;

import org.powerbot.core.script.job.state.Node;

public class Cooking extends Node {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void execute() {
		KoehoalCitadel.Status = "Cooking";

	}

}
