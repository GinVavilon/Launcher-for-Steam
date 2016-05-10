package com.github.ginvavilon.steamlauncher;

import java.io.File;

import com.github.ginvavilon.steamlauncher.parser.Screenshot;

public class TestRun1 {

	public static void main(String[] args) {
		File file = new File("/media/Media/Pictures/BnS/Скриншот_160404_000.jpg");
		Screenshot screenshot =  Screenshot.create(file);
		System.out.println(screenshot.toString());
	}

}
