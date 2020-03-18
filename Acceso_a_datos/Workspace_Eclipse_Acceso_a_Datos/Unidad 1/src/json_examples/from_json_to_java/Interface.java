package json_examples.from_json_to_java;

public class Interface {

	private String name;
	private String macAddr;
	private boolean isVpn;
	private String internalIp;
	private String externalIp;
	public Interface() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMacAddr() {
		return macAddr;
	}
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}
	public boolean isVpn() {
		return isVpn;
	}
	public void setVpn(boolean isVpn) {
		this.isVpn = isVpn;
	}
	public String getInternalIp() {
		return internalIp;
	}
	public void setInternalIp(String internalIp) {
		this.internalIp = internalIp;
	}
	public String getExternalIp() {
		return externalIp;
	}
	public void setExternalIp(String externalIp) {
		this.externalIp = externalIp;
	}
	@Override
	public String toString() {
		return "Interface \n\t[name=" + name + ", macAddr=" + macAddr + ", isVpn=" + isVpn + ", internalIp=" + internalIp
				+ ", externalIp=" + externalIp + "]\n\t";
	}
	
	
}
