package json_examples.from_json_to_java;

public class Ping {

	private double jitter;
	private double latency;
	
	public Ping() {
	}

	public double getJitter() {
		return jitter;
	}

	public void setJitter(double jitter) {
		this.jitter = jitter;
	}

	public double getLatency() {
		return latency;
	}

	public void setLatency(double latency) {
		this.latency = latency;
	}

	@Override
	public String toString() {
		return "Ping \n\t[jitter=" + jitter + ", latency=" + latency + "]\n\t";
	}
	
	
}
