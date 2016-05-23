package Service;

import java.awt.Image;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class Weather {
	// static String lon = "126.98";
	static String lon;
	// static String lat = "37.57";
	static String lat;

	public String weather;
	public String description;
	public Double temp;
	public String name;
	public int when;
	public Image image;

	public Weather(String lon, String lat, int when) {
		this.lon = lon;
		this.lat = lat;
		this.when = when;

		switch (when) {
		case 0:
			currentWeather();
			break;
		}
	}

	public void currentWeather() {
		URL url;

		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon
					+ "&appid=a03848aabb7cb876cdac4a2710af8f78");
			//System.out.println(url);
			InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream());

			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) JSONValue.parseWithException(isr);
			weather = ((JSONObject) ((JSONArray) object.get("weather")).get(0)).get("main").toString();
			String iconUrl = "http://openweathermap.org/img/w/"
					+ ((JSONObject) ((JSONArray) object.get("weather")).get(0)).get("icon").toString() + ".png";
			image = ImageIO.read(new URL(iconUrl));
			description = ((JSONObject) ((JSONArray) object.get("weather")).get(0)).get("description").toString();

			JSONObject mainArray = (JSONObject) object.get("main");

			temp = Double.parseDouble(mainArray.get("temp").toString()) - 273.15;

			name = object.get("name").toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString() {
		String ans;
		ans = String.format("현재 %s의 날씨\n  온도:%.2f도\n  날씨:%s", name, temp, description);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new Weather("126.98", "37.57", 0).toString());
	}
}