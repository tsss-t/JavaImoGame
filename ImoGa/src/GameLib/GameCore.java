package GameLib;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import EnumClass.GameState;
import Global.Global;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
@SuppressWarnings("serial")
public abstract class GameCore extends JPanel implements Runnable,GameCoreInterface
{
	private GameState gameState;
	private Image backImg;
	public GameCore()
	{
		setDoubleBuffered(true);
		setSize(Global.GetGlobal().GetFrameWidth(),Global.GetGlobal().GetFrameHeight());
		setVisible(true);
	}
	public void SetBackImg(String BkURL)
	{
		this.backImg=Toolkit.getDefaultToolkit().createImage(BkURL);
		this.backImg=new ImageIcon(backImg).getImage();  
	}
	protected boolean LoadValue()
	{
		try{
			gameState=GameState.Standby;
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public void GameStart()
	{
		if(Global.GetGlobal().GetGameState()==GameState.Standby||
				Global.GetGlobal().GetGameState()==GameState.Pause
				)
		{
			this.gameState=GameState.Doing;
			
			run();
		}
	}
	public void GamePause()
	{
		SetGameState(GameState.Pause);
	}
	public void GameClose()
	{
		SetGameState(GameState.Over);
		GameDistroy();
	}
	private void GameDistroy()
	{
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub      
        while (gameState==GameState.Doing)
        {
            try{
                Thread.sleep(Global.GetGlobal().GetGameFPS());
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            }
            synchronized (this)
            {
            	repaint();
            }
        }
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
	    Image ImageBuffer = createImage(this.getWidth(), this.getHeight());   
	        Graphics GraImage = ImageBuffer.getGraphics();  
	        paint(GraImage);      
	        GraImage.dispose();     
	        g.drawImage(ImageBuffer, 0, 0, this);  

	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Update();
		Draw(g);

	}
	protected void Draw(Graphics g)
	{
		if(backImg!=null)
		{
			for(int i=0;i<Global.GetGlobal().GetFrameWidth();i+=backImg.getWidth(null))
			{
				for(int j=0;j<Global.GetGlobal().GetFrameHeight();j+=backImg.getHeight(null))
				{
						g.drawImage(backImg, i, j, backImg.getWidth(null), backImg.getHeight(null), null);
				}
			}
		}
	}
	protected void Update()
	{
	}

	//change game'state
	private boolean SetGameState(GameState gameState)
    {
    	switch(this.gameState)
    	{
    		case Standby:
    		{
    			if(gameState==GameState.Doing)
    			{
    				this.gameState=gameState;
    				return true;
    			}
    			else
    			{
    				return false;
    			}
    		}
    		case Doing:
    		{
    			if(gameState!=GameState.Standby&&gameState!=GameState.Close)
    			{
    				this.gameState=gameState;
    				return true;
    			}
    			else
    			{
    				return false;
    			}
    		}
    		case Pause:
    		{
    			if(gameState!=GameState.Standby)
    			{
    				this.gameState=gameState;
    				return true;
    			}
    			else
    			{
    				return false;
    			}
    		}
    		case Over:
    		{
    			if(gameState==GameState.Close)
    			{
    				this.gameState=gameState;
    				return true;
    			}
    			else
    			{
    				return false;
    			}
    		}
    		case Close :
    		{
    			return false;
    		}
    	}
    	return false;
    	
    }

}
