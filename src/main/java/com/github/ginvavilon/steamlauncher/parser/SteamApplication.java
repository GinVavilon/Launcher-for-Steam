package com.github.ginvavilon.steamlauncher.parser;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SteamApplication implements VdfParselable{

	Map<String, VdfParselable> mList=new TreeMap<>();
	
	@Override
	public void parse(VdfParser parser) throws IOException, ParserException {
		int type;
		while( (type=parser.nextElement())!=END_OBJECT){
			switch (type) {
			case VALUE:
				String key = parser.getString();
				VdfParselable map = new Screenshot();
				map.parse(parser);
				mList.put(key, map);
				break;

			default:
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "SteamApplication [mList=" + mList + "]";
	}
	
	

}
