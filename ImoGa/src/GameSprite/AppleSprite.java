package GameSprite;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import Global.Global;
import Sprite.LoopAction;
import Sprite.Sprite;
import Sprite.SpriteSheet;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public class AppleSprite extends Sprite {
	Random r=new Random(2);
	Random r2=new Random(3);
	Rectangle spriteSheetRect;
	public AppleSprite(Point coordinate, SpriteSheet spriteSheet,
			Rectangle decisionRect) {
		super(coordinate, spriteSheet, decisionRect);
		// TODO Auto-generated constructor stub
		spriteSheetRect= Global.GetGlobal().GetAppleImgRect();
		spriteSheetRect.x=coordinate.x;
		spriteSheetRect.y=coordinate.y;
		// TODO Auto-generated constructor stub
		LoopAction NoAction=new LoopAction("no", Global.GetGlobal().GetAppleImg(), spriteSheetRect,0, 0);
		super.spriteSheet.AddAction(NoAction);
		super.spriteSheet.SetAction("no");
		super.decisionRect.x=coordinate.x+(Global.GetGlobal().GetAppleImgRect().width-decisionRect.width)/2;
		super.decisionRect.y=coordinate.y+(Global.GetGlobal().GetAppleImgRect().height-decisionRect.height)/2;
	}
	public Rectangle getDecisionRect()
	{
		return super.decisionRect;
	}
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		super.Draw(g);
//		g.drawRect(decisionRect.x,decisionRect.y,decisionRect. width, decisionRect.height);
	}
	public Rectangle ReSet()
	{
		coordinate.x=r.nextInt(Global.GetGlobal().GetFrameWidth()-Global.GetGlobal().GetTreeImgRect().width*2)+Global.GetGlobal().GetTreeImgRect().width;
		coordinate.y=r2.nextInt(Global.GetGlobal().GetFrameHeight()-Global.GetGlobal().GetTreeImgRect().height*2)+Global.GetGlobal().GetTreeImgRect().height;
		System.out.println(String.valueOf(coordinate.x));
		System.out.println(String.valueOf(coordinate.y));
		return new Rectangle(coordinate.x,coordinate.y,super.decisionRect.width,super.decisionRect.height);
	}
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		r.nextInt(Global.GetGlobal().GetFrameWidth()-Global.GetGlobal().GetTreeImgRect().width*2);
		r2.nextInt(Global.GetGlobal().GetFrameHeight()-Global.GetGlobal().GetTreeImgRect().height*2);
		super.Update();
	}
}
