package com.coderising.download;

import com.coderising.download.api.Connection;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DownloadThread extends Thread {

	Connection conn;
	RandomAccessFile randomAccessFile;
	int startPos;
	int endPos;

	public DownloadThread(Connection conn, RandomAccessFile randomAccessFile, int startPos, int endPos) {
		this.conn = conn;
		this.randomAccessFile = randomAccessFile;
		this.startPos = startPos;
		this.endPos = endPos;
	}
	public void run() {
		try {
			randomAccessFile.seek(startPos);
			byte[] buffer = conn.read(startPos, endPos);
			randomAccessFile.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
