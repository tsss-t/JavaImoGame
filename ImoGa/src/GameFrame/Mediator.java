package GameFrame;

import java.awt.Rectangle;
import java.util.List;

import GameSprite.AppleSprite;
import GameSprite.ImobodySprite;
import GameSprite.ImoheadSprite;
import GameSprite.Imomusi;
import GameSprite.ImotailSprite;
import GameSprite.TreeSprite;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public class Mediator {
	Imomusi imomusi;
	ImoheadSprite head;
	List<ImobodySprite> body;
	List<TreeSprite> trees;
	ImotailSprite tail;
	AppleSprite apple;
	public Mediator(Imomusi imomusi,List<TreeSprite> trees,AppleSprite apple){
		this.imomusi=imomusi;
		head=imomusi.GetHead();
		body=imomusi.GetBody();
		tail=imomusi.GetTail();
		this.trees=trees;
		this.apple=apple;
	}
	public boolean checkBody()
	{
		for(int i=1;i<body.size();i++)
		{
			if(head.getDecisionRect().intersects(body.get(i).getDecisionRect()))
			{
				System.out.println("boom!");
				return true;
			}
		}
		if(head.getDecisionRect().intersects(tail.getDecisionRect()))
		{
			System.out.println("boom!");
			return true;
		}
		return false;
	} 
	public boolean checkTree()
	{
		for(TreeSprite t : trees)
		{
			if(head.getDecisionRect().intersects(t.getDecisionRect()))
			{
				System.out.println("boom!");
				return true;
			}
		}
		return false;
	}
	public void checkApple()
	{
		if(this.apple.getDecisionRect().intersects(head.getDecisionRect()))
		{
			imomusi.GrowUp();
			while(CheckAppleSet())
			{
				
			}
			System.out.println("eat apple!");
		}
		else
		{
			
		}
	}
	public boolean CheckAppleSet()
	{
		Rectangle nextRect= apple.ReSet();
		if(head.getDecisionRect().intersects(nextRect))
		{
			return true;
		}
		for(ImobodySprite b :body)
		{
			if(b.getDecisionRect().intersects(nextRect))
			{
				return true;
			}
		}
		if(tail.getDecisionRect().intersects(nextRect))
		{
			return true;
		}
		for(TreeSprite t : trees)
		{
			if(t.getDecisionRect().intersects(nextRect))
			{
				return true;
			}
		}

		
		return false;
	}
}
