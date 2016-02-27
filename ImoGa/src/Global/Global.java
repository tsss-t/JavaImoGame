package Global;

import java.awt.Rectangle;

import EnumClass.Direction;
import EnumClass.GameState;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public class Global {
	
    private static Global global=null;
	GameState gameState;
	int GameFps;
	int gameFrameWidth;
	int gameFrameHeigth;
	int speed;
	Direction direction;
	Rectangle ImodecisionRect;
	String imoImg;
	String imoImgMirror;
	String treeImg;
	String Bkimg;
	String appleImg;
	Rectangle imoImgRect;
	Rectangle treeImgRect;
	Rectangle appleImgRect;
	public int cache;
	private Global()
	{
		gameFrameWidth=800;
		gameFrameHeigth=480;
		gameState=GameState.Standby;
		GameFps=50;
		speed=3;
		direction=Direction.right;
		imoImg="img/3.png";
		imoImgMirror="img/1mirror.png";
		Bkimg="img/bk.png";
		treeImg="img/tree.png";
		appleImg="img/apple.png";
		ImodecisionRect=new Rectangle(0,0,30,20);
		treeImgRect=new Rectangle(0,0,50,77);
		imoImgRect=new Rectangle(0,0,52,60);
		appleImgRect=new Rectangle(0,0,32,32);
		
		cache=13;
	}

    public static Global GetGlobal()
    {
        if (global==null)
        {
            global=new Global();
        }
        return global;
    }
    public void SetSpeed(int speed)
    {
    	this.speed=speed;
    }
    public int GetSpeed()
    {
    	return this.speed;
    }
    public int GetGameFPS()
    {
    	return GameFps;
    }
    public GameState GetGameState()
    {
    	return gameState;
    }
    public void SetFrameSize(int height,int width)
    {
    	this.gameFrameHeigth=height;
    	this.gameFrameWidth=width;
    }
    public int GetFrameHeight()
    {
    	return this.gameFrameHeigth;
    }
    public int GetFrameWidth()
    {
    	return this.gameFrameWidth;
    }
    public void SetDirection(Direction direction)
    {
    	this.direction=direction;
    }
    public Direction GetDirection()
    {
    	return direction;
    }
    public Rectangle GetImodecisionRect()
    {
		return new Rectangle(  ImodecisionRect.x,ImodecisionRect.y,ImodecisionRect.width, ImodecisionRect.height);
    }
	public String GetImoImg()
	{
		return imoImg;
	}
	public String GetImoImgMirror()
	{
		return imoImgMirror;
	}
	public String GetTreeImg()
	{
		return treeImg;
	}
	public Rectangle GetTreeImgRect()
	{
		return new Rectangle(  treeImgRect.x,treeImgRect.y,treeImgRect.width, treeImgRect.height);
	}
	public Rectangle GetimoImgRect()
	{
		return new Rectangle(  imoImgRect.x,imoImgRect.y,imoImgRect.width, imoImgRect.height);
	}
	public int GetCache()
	{
		return cache;
	}
	public String GetBkimg()
	{
		return Bkimg;
	}
	public String GetAppleImg()
	{
		return appleImg;
	}
	public Rectangle GetAppleImgRect()
	{
		return appleImgRect;
	}
    //state change:Standby,Doing,Pause,Over,Close 
    public boolean SetGameState(GameState gameState)
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
