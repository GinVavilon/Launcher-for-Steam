package com.github.ginvavilon.steamlauncher.parser;

import java.io.IOException;

public interface VdfParselable  extends VdfStates{
	void parse (VdfParser parser) throws IOException, ParserException;
}
