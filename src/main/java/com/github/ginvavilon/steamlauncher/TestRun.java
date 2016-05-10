package com.github.ginvavilon.steamlauncher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import com.github.ginvavilon.steamlauncher.parser.ParserException;
import com.github.ginvavilon.steamlauncher.parser.ScreenshotsConfig;
import com.github.ginvavilon.steamlauncher.parser.VdfParser;
import com.github.ginvavilon.steamlauncher.parser.VdfStates;

public class TestRun {

	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("/home/vbaraznovsky/workspaces/SteamLauncher/screenshots.vdf");
			VdfParser vdfReader = new VdfParser(reader);
			ScreenshotsConfig root = new ScreenshotsConfig();
			root.parse(vdfReader);
			System.out.println(root.toString().replaceAll(",", ",\n"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParserException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
