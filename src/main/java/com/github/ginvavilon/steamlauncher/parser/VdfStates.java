package com.github.ginvavilon.steamlauncher.parser;

public interface VdfStates {

	int START_DOCUMENT = 0;
	int VALUE = 1;
	int START_OBJECT = 2;
	int END_OBJECT = 3;
	int END_DOCUMENT = 4;
	int SPACE_CHARACTER = 5;

}