package com.github.ginvavilon.steamlauncher.parser;

import java.io.IOException;
import java.io.Reader;

public class VdfParser implements VdfStates {

	private static final char CHAR_START_OBJECT = '{';
	private static final char CHAR_END_OBJECT = '}';

	private static final char CHAR_START_STRING = '"';
	private static final char CHAR_END_STRING = '"';

	private static final int NONE = -1;
	Reader mReader;

	int mState = NONE;
	private String mString;
	private int mChar;

	public VdfParser(Reader mReader) {
		super();
		this.mReader = mReader;
	}

	public int nextElement() throws IOException {
		int type;
		while ((type = next()) == SPACE_CHARACTER) {
		}
		return type;
	}

	public int next() throws IOException {
		mState = doNext();
		return mState;
	}

	private int doNext() throws IOException {
		mString = null;
		mChar = 0;
		if (mState == NONE) {
			return START_DOCUMENT;
		}
		if (!mReader.ready()) {
			return END_DOCUMENT;
		}
		int c = extracted();
		switch (c) {
		case CHAR_START_STRING:
			mString = readString();
			return VALUE;
		case CHAR_START_OBJECT:
			return START_OBJECT;
		case CHAR_END_OBJECT:
			return END_OBJECT;
		default:
			mChar = c;
			return SPACE_CHARACTER;
		}
	}

	private String readString() throws IOException {
		StringBuilder builder = new StringBuilder();

		while (mReader.ready()) {
			int c = extracted();
			if (c == CHAR_END_STRING) {
				return builder.toString();
			}
			builder.append((char) c);
		}
		return null;
	}

	private int extracted() throws IOException {
		return mReader.read();
	}

	public int getState() {
		return mState;
	}

	public String getString() {
		return mString;
	}

	public int getInteger() {
		return Integer.parseInt(mString);
	}

	public long getLong() {
		return Long.parseLong(mString);
	}

	public int getChar() {
		return mChar;
	}

}
