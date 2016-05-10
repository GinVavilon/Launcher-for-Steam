package com.github.ginvavilon.steamlauncher.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VdfMap implements VdfParselable {
	Map<String, String> mMap = new HashMap<>();

	public VdfMap() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parse(VdfParser parser) throws IOException, ParserException {
		int type;
		while ((type = parser.nextElement()) != END_OBJECT) {
			switch (type) {
			case VALUE:
				String key = parser.getString();
				while (parser.nextElement()==SPACE_CHARACTER);
				String value = parser.getString();
				mMap.put(key, value);
				break;

			default:
				break;
			}
		}

	}

	@Override
	public String toString() {
		return "VdfMap [mMap=" + mMap + "]";
	}

}
