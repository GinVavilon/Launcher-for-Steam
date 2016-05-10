package com.github.ginvavilon.steamlauncher.parser;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ScreenshotsConfig implements VdfParselable {

	private VdfMap mNames = new VdfMap();
	private Map<String, SteamApplication> mApps = new TreeMap<>();

	@Override
	public void parse(VdfParser parser) throws IOException, ParserException {
		int type;
		do {
			type = parser.nextElement();
			switch (type) {
			case VdfStates.VALUE:
				if (!"Screenshots".equalsIgnoreCase(parser.getString())) {
					throw new ParserException("No Screenshots");
				}
				break;
			default:
				break;
			}

		} while ((type != VdfStates.END_DOCUMENT) && (type != START_OBJECT));

		do {
			type = parser.nextElement();
			switch (type) {
			case VdfStates.VALUE: {
				String key = parser.getString();
				if ("shortcutnames".equalsIgnoreCase(key)) {
					mNames.parse(parser);
				} else if (key.matches("\\d+")) {
					SteamApplication application = new SteamApplication();
					application.parse(parser);
					mApps.put(key, application);
				}

				break;
			}
			default:
				break;
			}

		} while (type != VdfStates.END_DOCUMENT);

	}

	@Override
	public String toString() {
		return "ScreenShots [mNames=" + mNames + ", mApps=" + mApps + "]";
	}

	
	
}
