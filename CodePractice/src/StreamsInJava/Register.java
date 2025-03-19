package StreamsInJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Interview
public class Register {
	
	private int id;
	private String shortCode; //AU
	private String originalShortCode; //AU
	private String longCode;
	private String transalation; //Australia
	private String subLanguageCode; //en

	public Register(String shortCode, String transalation) {
		super();
		this.shortCode = shortCode;
		this.transalation = transalation;
	}

	public static void main(String[] args) {
		List<Register> registerList = new ArrayList<>();
		
		registerList.add(new Register("AU", "Australia"));
		registerList.add(new Register("IND", "India"));
		registerList.add(new Register("ENG", "England"));
		
		Map<String, String> registerMap = registerList.stream().collect(Collectors.toMap(reg1 -> reg1.shortCode, reg2 -> reg2.transalation));
		System.out.println("Get the registerMap : " +registerMap);
		
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getShortCode() {
		return shortCode;
	}



	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}



	public String getOriginalShortCode() {
		return originalShortCode;
	}



	public void setOriginalShortCode(String originalShortCode) {
		this.originalShortCode = originalShortCode;
	}



	public String getLongCode() {
		return longCode;
	}



	public void setLongCode(String longCode) {
		this.longCode = longCode;
	}



	public String getTransalation() {
		return transalation;
	}



	public void setTransalation(String transalation) {
		this.transalation = transalation;
	}



	public String getSubLanguageCode() {
		return subLanguageCode;
	}



	public void setSubLanguageCode(String subLanguageCode) {
		this.subLanguageCode = subLanguageCode;
	}
	
	
	

}
