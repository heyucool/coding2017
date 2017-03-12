package com.coderising.download.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Scanner;

import com.coderising.download.api.Connection;

public class ConnectionImpl implements Connection {
	private HttpURLConnection httpURLConnection = null;
	private int contentLength = 0;
	private int responsecode = 0;

	public ConnectionImpl(HttpURLConnection urlConnection) {
		this.httpURLConnection = urlConnection;
	}

	public int getResponsecode() {
		try {
			responsecode = httpURLConnection.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return responsecode;
	}

	@Override
	public byte[] read(int startPos, int endPos) throws IOException {

		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Range", "bytes=" + startPos + "-" + endPos);
		httpURLConnection.setConnectTimeout(5000);

		byte[] bytes = null;
		if (getResponsecode() == 206) {

			InputStream inputStream = null;
			ByteArrayOutputStream outputStream = null;

			try {
				inputStream = httpURLConnection.getInputStream();
				outputStream = new ByteArrayOutputStream(endPos - startPos);

				byte[] buffer = new byte[1024];
				int len;
				while ((len = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, len);
				}

				bytes = outputStream.toByteArray();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return bytes;
	}

	@Override
	public int getContentLength() {
		Scanner input = null;
		try {
			input = new Scanner(httpURLConnection.getInputStream());

			while (input.hasNext()) {
				String line = input.nextLine();
				contentLength += line.length();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}

		return contentLength;
	}

	@Override
	public void close() {

	}

}
