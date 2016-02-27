package GameSprite;

import java.awt.Point;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import EnumClass.Direction;
import Global.Global;
import Sprite.LoopAction;
import Sprite.SpriteSheet;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public class ImobodySprite extends ImoObject {
	private List<Direction> directionpast;
	public ImobodySprite(Point coordinate, SpriteSheet spriteSheet,
			Rectangle decisionRect,boolean type) {
		super(coordinate, spriteSheet, decisionRect);
		// TODO Auto-generated constructor stub
		directionpast=new ArrayList<Direction>();
		for(int i=0;i<Global.GetGlobal().GetCache();i++)
		{
			directionpast.add(Direction.no);
		}
		super.direction=Direction.no;
		Rectangle spriteSheetRect;
		spriteSheetRect= Global.GetGlobal().GetimoImgRect();
		spriteSheetRect.x=coordinate.x;
		spriteSheetRect.y=coordinate.y;
		LoopAction actionFront;
		LoopAction actionBack;
		LoopAction actionRight;
		LoopAction actionLeft;
		if(type)
		{
		 actionFront=new LoopAction("front",Global.GetGlobal().GetImoImg(), spriteSheetRect, 27, 27);
		 actionBack=new LoopAction("back", Global.GetGlobal().GetImoImg(), spriteSheetRect, 27, 27);
		 actionRight=new LoopAction("right", Global.GetGlobal().GetImoImg(), spriteSheetRect, 14, 26);
		 actionLeft=new LoopAction("left", Global.GetGlobal().GetImoImgMirror(), spriteSheetRect, 14, 26,true);
		}
		else
		{
			 actionFront=new LoopAction("front", Global.GetGlobal().GetImoImg(), spriteSheetRect, 41, 41);
			 actionBack=new LoopAction("back", Global.GetGlobal().GetImoImg(), spriteSheetRect, 41, 41);
			 actionRight=new LoopAction("right", Global.GetGlobal().GetImoImg(), spriteSheetRect, 28, 40);
			 actionLeft=new LoopAction("left", Global.GetGlobal().GetImoImgMirror(), spriteSheetRect, 28, 40,true);
		}
		super.spriteSheet.AddAction(actionFront);
		super.spriteSheet.AddAction(actionBack);
		super.spriteSheet.AddAction(actionRight);
		super.spriteSheet.AddAction(actionLeft);
		super.spriteSheet.SetAction("right");
	}
	public void SetWork(Direction direction)
	{
		super.direction=directionpast.get(Global.GetGlobal().GetCache()-1);
		for(int i=Global.GetGlobal().GetCache()-1;i>0;i--)
		{
			this.directionpast.set(i, this.directionpast.get(i-1));
		}
		this.directionpast.set(0, direction);
	}
	public void SetWorkFlow(List<Direction> directionpast,Direction nowDirection)
	{
		this.directionpast=directionpast;
		this.direction=nowDirection;
	}
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		super.Update();	
	}
	public Rectangle getDecisionRect()
	{
		return super.decisionRect;
	}
	public Direction getDirection()
	{
		return this.direction;
	}
	public Point GetCoordinate()
	{
		return new Point(coordinate.x,coordinate.y);
	}
}
