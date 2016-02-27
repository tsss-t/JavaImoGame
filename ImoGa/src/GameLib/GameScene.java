package GameLib;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import Global.Global;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
@SuppressWarnings("serial")
public abstract class GameScene extends JFrame implements GameCoreInterface {
	
	
	public GameScene()
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent e) {System.exit(0);}});
		setSize(Global.GetGlobal().GetFrameWidth(),Global.GetGlobal().GetFrameHeight());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
}
