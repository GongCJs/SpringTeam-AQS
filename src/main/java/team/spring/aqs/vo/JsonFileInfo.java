package team.spring.aqs.vo;

public class JsonFileInfo {
	
	private Integer error =0;//0为成功，1为失败
	private String message;
	private String url;
	public JsonFileInfo(Integer error, String message, String url) {
		super();
		this.error = error;
		this.message = message;
		this.url = url;
	}
	public JsonFileInfo(String url) {
		this.url = url;
	}
	public JsonFileInfo() {
		super();
	}

	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public JsonFileInfo(Integer error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	
	
	
}
