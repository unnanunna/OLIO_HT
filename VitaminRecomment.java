package HT;

import java.io.*;
import java.net.*;
//import org.json.*;

public class VitaminRecomment {
	
	private int vitamins = 0;
	String inputLine, total = "";
	
	/*public String recommenterVitamin(String gender, int age) {
		return lause;
	}*/
	
	public void vitaminAdd() {
		if (vitamins == 0) {
			vitamins += 1;
			System.out.println("Congratulations, you have taken your vitamins today.");
		}
		else if (vitamins == 1) {
			System.out.println("You already had your vitamins today.");
		}
	}
	
	public int getTotalvitamin() {
		return vitamins;
	}
	
	/*public void readData(){
		String json = getData();
		System.out.println("JSON: " + json);
		
		if (json != null) {
			try {
				JSONArray jsonArray = new JSONArray(json);
				for(int i=0; i<jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					System.out.println(jsonObject.getString(name: "description"));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getData() {
		String response = null;
		try {
			URL url = new URL("https://fineli.fi/fineli/api/v1/components/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			InputStream in = new BufferedInputStream(conn.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			response = sb.toString();
			in.close();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}*/

}
