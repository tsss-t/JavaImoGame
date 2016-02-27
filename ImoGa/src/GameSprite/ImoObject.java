package GameSprite;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import EnumClass.Direction;
import Global.Global;
import Sprite.Sprite;
import Sprite.SpriteSheet;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public abstract class ImoObject extends Sprite {
	protected Direction direction;
	Rectangle spriteSheetRect;

	public ImoObject(Point coordinate, SpriteSheet spriteSheet,
			Rectangle decisionRect) {
		super(coordinate, spriteSheet, decisionRect);
		direction=Direction.no;
		spriteSheetRect= Global.GetGlobal().GetimoImgRect();
		spriteSheetRect.x=coordinate.x;
		spriteSheetRect.y=coordinate.y;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		super.Update();
		switch (direction) {
			case back:
			{
				spriteSheet.SetAction("back");
				super.coordinate.y-=Global.GetGlobal().GetSpeed()-1;
				break;
			}
			case front:
			{
				spriteSheet.SetAction("front");
				super.coordinate.y+=Global.GetGlobal().GetSpeed()-1;
				break;
			}
			case right:
			{
				spriteSheet.SetAction("right");
				super.coordinate.x+=Global.GetGlobal().GetSpeed();
				break;
			}
			case left:
			{
				spriteSheet.SetAction("left");
				super.coordinate.x-=Global.GetGlobal().GetSpeed();
				break;
			}
			case no:
			{
				
			}
		}
		super.decisionRect.x=coordinate.x+(Global.GetGlobal().GetimoImgRect().width-decisionRect.width)/2;
		super.decisionRect.y=coordinate.y+(Global.GetGlobal().GetimoImgRect().height-decisionRect.height)/2;
	}
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		super.Draw(g);
//		g.drawRect(decisionRect.x,decisionRect.y,decisionRect. width, decisionRect.height);
	}
	public Rectangle getDecisionRect()
	{
		return super.decisionRect;
	}
	public Direction getDirection()
	{
		return this.direction;
	}
//	public void SetAction(String actionName)
//	{
//		this.SetAction(actionName);
//	}
}
