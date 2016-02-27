package GameSprite;

import java.awt.Point;
import java.awt.Rectangle;

import EnumClass.Direction;
import Global.Global;
import Sprite.LoopAction;
import Sprite.SpriteSheet;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public class ImoheadSprite extends ImoObject 
{
	public ImoheadSprite(Point coordinate, SpriteSheet spriteSheet,
			Rectangle decisionRect) {
		super(coordinate, spriteSheet, decisionRect);
		// TODO Auto-generated constructor stub
		LoopAction actionFront=new LoopAction("front", Global.GetGlobal().GetImoImg(), spriteSheetRect, 55, 55);
		LoopAction actionBack=new LoopAction("back", Global.GetGlobal().GetImoImg(), spriteSheetRect, 56, 56);
		LoopAction actionRight=new LoopAction("right", Global.GetGlobal().GetImoImg(), spriteSheetRect, 42, 54);
		LoopAction actionLeft=new LoopAction("left", Global.GetGlobal().GetImoImgMirror(), spriteSheetRect, 42, 54,true);
		super.spriteSheet.AddAction(actionFront);
		super.spriteSheet.AddAction(actionBack);
		super.spriteSheet.AddAction(actionRight);
		super.spriteSheet.AddAction(actionLeft);
		super.spriteSheet.SetAction("right");
		this.direction=Direction.right;
	}
	

	@Override
	public void Update() {
		// TODO Auto-generated method stub

		super.Update();
		direction=Global.GetGlobal().GetDirection();
	}
	public Point GetCoordinate()
	{
		return new Point(coordinate.x,coordinate.y);
	}
}
