package GameFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import EnumClass.Direction;
import GameLib.GameScene;
import Global.Global;

/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
@SuppressWarnings("serial")
public class ImoScene extends GameScene implements KeyListener{
	ImoGame game;
	Direction direction;

	public ImoScene() {
		// TODO Auto-generated constructor stub
		game=new ImoGame();
		game.SetBackImg(Global.GetGlobal().GetBkimg());
		this.add(game);
		direction=Global.GetGlobal().GetDirection();
		this.addKeyListener(this);
	}
	@Override
	public void GameStart() {
		// TODO Auto-generated method stub
		if(game.LoadValue())
		{
			game.GameStart();
		}
		else
		{
			
		}
	}

	@Override
	public void GamePause() {
		// TODO Auto-generated method stub
		game.GamePause();
	}

	@Override
	public void GameClose() {
		// TODO Auto-generated method stub
		game.GameClose();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		  int key = e.getKeyCode(); 
		  direction=Global.GetGlobal().GetDirection();
		switch(key)  
		  {  
			  case KeyEvent.VK_DOWN:
			  {
				  System.out.println("front");
				  if(direction!=Direction.front)
				  {
					  Global.GetGlobal().SetDirection(Direction.front);
				  }
				  break; 
			  }
			  case KeyEvent.VK_UP:
			  {
				  System.out.println("back");
				  if(direction!=Direction.back)
				  {
					  Global.GetGlobal().SetDirection(Direction.back);
				  }
				  break; 
			  }
			  case KeyEvent.VK_LEFT:
			  {
				  System.out.println("left");
				  if(direction!=Direction.left)
				  {
					  Global.GetGlobal().SetDirection(Direction.left);
				  }
				  break; 
			  }
			  case KeyEvent.VK_RIGHT:
			  {
				  System.out.println("right");
				  if(direction!=Direction.right)
				  {
					  Global.GetGlobal().SetDirection(Direction.right);
				  }
				  break; 
			  }
		  }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
