package com.mahii.flavoursdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author i_m_mahii, mahi05
 */
class CallService extends AsyncTask<Void, String, String> {

	private OnServiceCall OnServiceCall;
	private String urlStr;
	private String method = "";

	interface OnServiceCall {
		void onServiceCall(String response);
	}

	CallService(Context context, String urlStr, String method, OnServiceCall OnServiceCall) {
		this.urlStr = urlStr;
		this.OnServiceCall = OnServiceCall;
		this.method = method;
	}

	@SuppressLint("InflateParams")
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected String doInBackground(Void... params) {
		return getData(method);
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		OnServiceCall.onServiceCall(result);
	}

	private String getData(String mehtod) {
		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod(mehtod);
			conn.setDoInput(true);
			conn.connect();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
            StringBuilder response = new StringBuilder();
			while ((output = br.readLine()) != null) {
                response.append(output);
			}

			conn.disconnect();
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
