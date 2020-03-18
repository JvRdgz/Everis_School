package json_examples.from_json_to_java;

public class Upload {

	private int bandwidth;
	private int bytes;
	private int elapsed;

	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	public long getBytes() {
		return bytes;
	}

	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	public long getElapsed() {
		return elapsed;
	}

	public void setElapsed(int elapsed) {
		this.elapsed = elapsed;
	}

	@Override
	public String toString() {
		return "Upload \n\t[bandwidth=" + bandwidth + ", bytes=" + bytes + ", elapsed=" + elapsed + "]\n\t";
	}

}
