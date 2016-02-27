package GameSprite;

import java.awt.Graphics;

import java.awt.Point;
import java.awt.Rectangle;

import Global.Global;
import Sprite.LoopAction;
import Sprite.Sprite;
import Sprite.SpriteSheet;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public class TreeSprite extends Sprite
{
	Rectangle spriteSheetRect;
	public TreeSprite(Point coordinate, SpriteSheet spriteSheet,
			Rectangle decisionRect) {
		super(coordinate, spriteSheet, decisionRect);
		
		spriteSheetRect= Global.GetGlobal().GetTreeImgRect();
		spriteSheetRect.x=coordinate.x;
		spriteSheetRect.y=coordinate.y;
		// TODO Auto-generated constructor stub
		LoopAction NoAction=new LoopAction("no", Global.GetGlobal().GetTreeImg(), spriteSheetRect,0, 11);
		super.spriteSheet.AddAction(NoAction);
		super.spriteSheet.SetAction("no");
		super.decisionRect.x=coordinate.x+(Global.GetGlobal().GetTreeImgRect().width-decisionRect.width)/2;
		super.decisionRect.y=coordinate.y+(Global.GetGlobal().GetTreeImgRect().height-decisionRect.height)/2;
		
	}
	public Rectangle getDecisionRect()
	{
		return super.decisionRect;
	}
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		super.Update();
		super.decisionRect.x=coordinate.x+(Global.GetGlobal().GetTreeImgRect().width-decisionRect.width)/2;
		super.decisionRect.y=coordinate.y+(Global.GetGlobal().GetTreeImgRect().height-decisionRect.height)/2;
	}
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		super.Draw(g);
//		g.drawRect(decisionRect.x,decisionRect.y,decisionRect. width, decisionRect.height);
	}
}
