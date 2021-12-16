package com.exterro.SampleJenkins;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.util.Scanner;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class JenkinsRun {

	 String a, c, d;

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {
		 String a = null, c = null, d = null;
		try {
			
			String JobName1 = "My_First_Proj";
			String Jobname2 = "test2";
			String url = "http://localhost:8080/job/"+JobName1+"/build?token=111f04203f451774c9df1b23541f60589f";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			URLConnection openConnection = new URL(url).openConnection();
			System.out.println("Job status is " + con.getResponseCode());
			System.out.println("execution ended");
			Thread.sleep(10000);
			
			while (c == null) {
				String inline = "";
				String Url = "http://localhost:8080/job/" + JobName1
						+ "/api/json?tree=builds[number,status,timestamp,id,result]";
				URL url1 = new URL(Url);
				HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
				URLConnection openConnection1 = new URL(Url).openConnection();
				int responsecode = conn.getResponseCode();
				  System.out.println("Build Status After 30 seconds");
				Scanner sc = new Scanner(url1.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
					break;
				}
				
				JSONObject jsonObject = new JSONObject(inline);
				JSONArray s1 = jsonObject.getJSONArray("builds");

				for (int i = 0; i < 1; i++) {
					a = s1.getJSONObject(i).getString("id");
					c = s1.getJSONObject(i).getString("result");
					d = s1.getJSONObject(i).getString("timestamp");
                  
					System.out.println("id :" + a);
					System.out.println("result : " + c);
					System.out.println("timestamp : " + d);
				}
				Thread.sleep(30000);
				 openConnection1 = new URL(Url).openConnection();
			}
            System.out.println("Build Status After Completion of Run");
			System.out.println("id :" + a);
			System.out.println("result : " + c);
			System.out.println("timestamp : " + d);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
