package koehoolcitadel;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTable;
 
import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Job;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.widget.WidgetCache;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.bot.Context;
import org.powerbot.game.client.Client;
 
@Manifest(authors = { "Koehoal" }, name = "Koehoal Citadel", description = "Koehoal Citadel", version = 0.1)
public class KoehoalCitadel extends ActiveScript implements PaintListener,MessageListener {
	
	public static String Task;
	public static String Resource;
	public static String Status;
	public static boolean Loot;
       
        private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
        private Tree jobContainer = null;
 
        public synchronized final void provide(final Node... jobs) {
                for (final Node job : jobs) {
                        if (!jobsCollection.contains(job)) {
                                jobsCollection.add(job);
                        }
                }
                jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
        }
 
        public synchronized final void revoke(final Node... jobs) {
                for (final Node job : jobs) {
                        if (jobsCollection.contains(job)) {
                                jobsCollection.remove(job);
                        }
                }
                jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
        }
       
        public final void submit(final Job... jobs) {
                for (final Job job : jobs) {
                        getContainer().submit(job);
                }
        }
 
        @Override
        public void onStart() {
        	
        	Loot = false;
        	
        	EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Gui frame = new Gui();
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
        	
        		provide(new Looting());
                provide(new Mining());
                provide(new Woodcutting());
                provide(new Crafting());
                provide(new Summon());
                provide(new Cooking());
                provide(new Firemaking());
                provide(new Smithing());
        }
 
        private Client client = Context.client();
 
        @Override
        public int loop() {
                if (Game.getClientState() != Game.INDEX_MAP_LOADED) {
                        return 1000;
                }
 
                if (client != Context.client()) {
                        WidgetCache.purge();
                        Context.get().getEventManager().addListener(this);
                        client = Context.client();
                }
 
                if (jobContainer != null) {
                        final Node job = jobContainer.state();
                        if (job != null) {
                                jobContainer.set(job);
                                getContainer().submit(job);
                                job.join();
                        }
                }
                return Random.nextInt(10, 25);
        }
        
       

		@Override
		public void onRepaint(Graphics g) {
			g.drawString("Status : \t"+Status, 10, 85);
			g.drawString("Task : \t"+Task, 10, 100);
			g.drawString("Resource : \t"+Resource, 10, 115);
			g.drawString("Loot : \t"+Loot, 10, 130);
		}
		
		public void onStop(){
			System.out.println("Thanks For Using Koehoal Citadel!");
			System.out.println("See you next week!");
		}

		@Override
		public void messageReceived(MessageEvent e) {
			if(e.getMessage().contentEquals("You can't summon any more minions until your next build tick.") ||
					e.getMessage().contentEquals("This skill plot is currently locked.") || 
					e.getMessage().contentEquals("You have reached your resource cap, you will not be able to skill until the next build tick.")){
				stop();
			}
			
		}
 
}