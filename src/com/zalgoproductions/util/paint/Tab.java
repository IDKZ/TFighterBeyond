package com.zalgoproductions.util.paint;

import com.zalgoproductions.resources.Fonts;
import com.zalgoproductions.resources.Images;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Tab {
	private final String title;
	private final int x;
	private final int y;
	private final int size;

	public Tab(String s, int size, int x, int y) {
		title = s;
		this.size = size;
		this.x = x;
		this.y = y;      		
	}
	
	public void draw(Graphics graphics) {
		graphics.setFont(Fonts.BATMAN_FONT.deriveFont(Font.PLAIN, size));
		graphics.setColor(Color.ORANGE);

		Rectangle2D titleBounds = graphics.getFontMetrics().getStringBounds(title, graphics);

		graphics.drawImage(Images.TAB_IMG, x, y, null);
		
		double halfWidthOfTitle = titleBounds.getWidth() / 2;
		double halfHeightOfTitle = titleBounds.getHeight() / 2;

		Point centerPointOfImage = new Point(Images.TAB_IMG.getWidth() / 2, Images.TAB_IMG.getHeight() / 2);

		Point drawRelImage = new Point(centerPointOfImage.x - (int)halfWidthOfTitle, centerPointOfImage.y + (int)halfHeightOfTitle);

		Point drawStrAbs = new Point(drawRelImage.x + x, drawRelImage.y + y);
		
		graphics.drawString(title, drawStrAbs.x, drawStrAbs.y);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, Images.TAB_IMG.getWidth(), Images.TAB_IMG.getHeight());
	}
}
