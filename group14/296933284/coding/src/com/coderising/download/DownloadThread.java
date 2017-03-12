package com.coderising.download;

import com.coderising.download.api.Connection;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DownloadThread extends Thread {

	private RandomAccessFile randomAccessFile;
	private Connection conn;
	private int startPos;
	private int endPos;
	static int lengths = 0;

	public DownloadThread(Connection conn, RandomAccessFile randomAccessFile,int startPos, int endPos) {
		this.randomAccessFile = randomAccessFile;
		this.conn = conn;
		this.startPos = startPos;
		this.endPos = endPos;
	}

	public void run() {
		try {
			randomAccessFile.seek(startPos);
			byte[] bytes = conn.read(startPos, endPos);
			lengths += bytes.length;
			System.out.println(lengths);
			randomAccessFile.write(bytes, 0, bytes.length);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomAccessFile != null) {
				try {
					randomAccessFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
