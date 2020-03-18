package json_examples.from_json_to_java;

public class Server {

	private int port;
	private String name;
	private String location;
	private String ip;
	private int id;
	private String host;
	private String country;

	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Server \n\t[port=" + port + ", name=" + name + ", location=" + location + ", ip=" + ip + ", id=" + id
				+ ", host=" + host + ", country=" + country + "]\n\t";
	}
}
