package com.github.ginvavilon.steamlauncher.parser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;

public class Screenshot implements VdfParselable {

	String filename;
	String thumbnail;
	int imported;
	int width;
	int height;
	String gameid;
	long creation;
	String caption;
	int Permissions;
	String hscreenshot;

	public Screenshot() {
	}

	public static Screenshot create(File file) {
		Screenshot screenshot = new Screenshot();
		try {
			BufferedImage image = ImageIO.read(file);
			screenshot.imported = 1;
			screenshot.filename = file.getCanonicalPath();
			screenshot.height = image.getHeight();
			screenshot.width = image.getWidth();
			screenshot.Permissions = 2;
			screenshot.creation = Files.getLastModifiedTime(file.toPath()).toMillis();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshot;

	}

	@Override
	public void parse(VdfParser parser) throws IOException, ParserException {
		int type;
		do {
			type = parser.nextElement();
			switch (type) {
			case VALUE:
				String key = parser.getString();
				parseField(parser, key);
				break;

			default:
				break;
			}
		} while (type != END_OBJECT);
	}

	private void parseField(VdfParser parser, String key) throws IOException {
		parser.nextElement();
		switch (key.toLowerCase()) {
		case "filename":
			filename = parser.getString();
			break;
		case "thumbnail":
			thumbnail = parser.getString();
			break;
		case "imported":
			imported = parser.getInteger();
			break;
		case "width":
			width = parser.getInteger();
			break;
		case "height":
			height = parser.getInteger();
			break;
		case "creation":
			creation = parser.getLong();
			break;
		case "permissions":
			Permissions = parser.getInteger();
			break;
		case "gameid":
			gameid = parser.getString();
			break;
		case "caption":
			caption = parser.getString();
			break;
		case "hscreenshot":
			hscreenshot = parser.getString();
			break;

		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Screenshot [filename=" + filename + ", thumbnail=" + thumbnail + ", imported=" + imported + ", width="
				+ width + ", height=" + height + ", gameid=" + gameid + ", creation=" + creation + ", caption="
				+ caption + ", Permissions=" + Permissions + ", hscreenshot=" + hscreenshot + "]";
	}

}
