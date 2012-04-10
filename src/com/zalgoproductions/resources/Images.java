package com.zalgoproductions.resources;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Images {

	private static final String RUG_DATA = "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\n" +
			"5PH/A+fj3Eb10BauAAAAAElFTkSuQmCC";

	private static final String MENU_DATA = "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\n"+
			"H4/4/wESiYojWpi6vQAAAABJRU5ErkJggg==";
	
	private static final String TAB_DATA = "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\n" +
			"S4TwE/Ed6I5OBbrfAAAAAElFTkSuQmCC";

	public static final BufferedImage RUG_IMG = getImage(RUG_DATA);
	public static final BufferedImage MENU_IMG = getImage(MENU_DATA);
	public static final BufferedImage TAB_IMG = getImage(TAB_DATA);

	private static BufferedImage getImage(String string){
		byte[] imageBytes;
		try {
			imageBytes = new BASE64Decoder().decodeBuffer(string);
			return ImageIO.read(new ByteArrayInputStream(imageBytes));
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		return null;
	}
}
