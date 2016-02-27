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
public class ImotailSprite extends ImoObject {
	private List<Direction> directionpast;
	protected Direction direction;
	public  ImotailSprite(Point coordinate, SpriteSheet spriteSheet,
			Rectangle decisionRect) {
		super(coordinate, spriteSheet, decisionRect);
		// TODO Auto-generated constructor stub

		Reset();
		LoopAction actionFront=new LoopAction("front", Global.GetGlobal().GetImoImg(), spriteSheetRect, 13, 13);
		LoopAction actionBack=new LoopAction("back", Global.GetGlobal().GetImoImg(), spriteSheetRect, 13, 13);
		LoopAction actionRight=new LoopAction("right", Global.GetGlobal().GetImoImg(), spriteSheetRect, 0, 12);
		LoopAction actionLeft=new LoopAction("left", Global.GetGlobal().GetImoImgMirror(), spriteSheetRect, 0, 12,true);
		super.spriteSheet.AddAction(actionFront);
		super.spriteSheet.AddAction(actionBack);
		super.spriteSheet.AddAction(actionRight);
		super.spriteSheet.AddAction(actionLeft);
		super.spriteSheet.SetAction("right");
	}
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		super.Update();
		
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
	public Point GetCoordinate()
	{
		return super.coordinate;
	}
	public List<Direction> GetWorkFlow()
	{
		return directionpast;
	}
	public Direction GetDirection()
	{
		return direction;
	}
	public void Reset()
	{
		directionpast=new ArrayList<Direction>();
		for(int i=0;i<Global.GetGlobal().GetCache();i++)
		{
			directionpast.add(Direction.no);
		}
		direction=Direction.no;
	}
}
