package json_examples.from_json_to_java;


import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		Gson gson = new Gson();
		String json = "{\"type\":\"result\",\"timestamp\":\"2020-03-18T19:21:53Z\",\"ping\":{\"jitter\":9.3469999999999995,\"latency\":7.7069999999999999},\"download\":{\"bandwidth\":14449002,\"bytes\":194201280,\"elapsed\":15012},\"upload\":{\"bandwidth\":11430033,\"bytes\":94956753,\"elapsed\":8430},\"packetLoss\":0,\"isp\":\"Telefonica de Espana\",\"interface\":{\"internalIp\":\"192.168.1.36\",\"name\":\"enp4s0\",\"macAddr\":\"70:4D:7B:28:B0:B1\",\"isVpn\":false,\"externalIp\":\"81.36.188.249\"},\"server\":{\"id\":21349,\"name\":\"ServiHosting Networks\",\"location\":\"Madrid\",\"country\":\"Spain\",\"host\":\"nets-mad01.servihosting.net\",\"port\":8080,\"ip\":\"78.136.107.51\"},\"result\":{\"id\":\"6ef77456-5419-40d8-88ae-08be64cc3ae8\",\"url\":\"https://www.speedtest.net/result/c/6ef77456-5419-40d8-88ae-08be64cc3ae8\"}}";
		json.replace("\"", "'");
		json.replace("\\", "");
		json.replace("interface", "interfaz");		
		
		JSON j = gson.fromJson(json, JSON.class);
		
		System.out.println(j);
	}
}