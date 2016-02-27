package Sprite;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */

public class SpriteSheet {

	SpriteSheetAction nowAction;
	List<SpriteSheetAction> listAction;
	/*sprite pic
	 * width: in the pic,one small pic's width
	 * height: in the pic,one small pic's height
	 */
	public SpriteSheet()
	{
		listAction=new ArrayList<SpriteSheetAction>();
	}
	public SpriteSheet(SpriteSheetAction action)
	{
		listAction=new ArrayList<SpriteSheetAction>();
		this.nowAction=action;
		this.listAction.add(action);
	}
	

	public void SetAction(String actionName)
	{
		for (SpriteSheetAction spriteSheetAction : listAction) {
			if(spriteSheetAction.actionName==actionName)
			{
				this.nowAction=spriteSheetAction;
			}
		}
	}
	public void AddAction(SpriteSheetAction action)
	{
		listAction.add(action);
		if(nowAction!=null)
		{
			nowAction=action;
		}
	}
	public void Update(Point coordinate)
	{	
		if(nowAction!=null)
		{
			nowAction.Update(coordinate);
		}
	}
	public void Draw(Graphics g)
	{		
		if(nowAction!=null)
		{
			nowAction.Draw(g);
		}
	}
}
