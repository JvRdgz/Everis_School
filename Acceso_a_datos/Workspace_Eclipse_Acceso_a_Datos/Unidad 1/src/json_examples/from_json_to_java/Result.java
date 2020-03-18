package json_examples.from_json_to_java;

public class Result {

	private String id;
	private String url;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Result \n\t[id=" + id + ", url=" + url + "]\n\t";
	}
	
	
}
