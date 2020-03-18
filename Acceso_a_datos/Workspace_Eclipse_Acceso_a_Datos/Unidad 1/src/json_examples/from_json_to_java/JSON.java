package json_examples.from_json_to_java;

public class JSON {

	private String type;
	private String timestamp;
	private Upload upload;
	private Server server;
	private Result result;
	private Ping ping;
	private int packetLoss;
	private String isp;
	private Interface interfaz;
	private Download download;
	
	public JSON() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Upload getUpload() {
		return upload;
	}

	public void setUpload(Upload upload) {
		this.upload = upload;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Ping getPing() {
		return ping;
	}

	public void setPing(Ping ping) {
		this.ping = ping;
	}

	public int getPacketLoss() {
		return packetLoss;
	}

	public void setPacketLoss(int packetLoss) {
		this.packetLoss = packetLoss;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public Interface getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(Interface interfaz) {
		this.interfaz = interfaz;
	}

	public Download getDownload() {
		return download;
	}

	public void setDownload(Download download) {
		this.download = download;
	}

	@Override
	public String toString() {
		return "JSON \n\t[type=" + type + ", timestamp=" + timestamp + ", upload=" + upload + ", server=" + server
				+ ", result=" + result + ", ping=" + ping + ", packetLoss=" + packetLoss + ", isp=" + isp
				+ ", interfaz=" + interfaz + ", download=" + download + "]\n\t";
	}
	
	
}
