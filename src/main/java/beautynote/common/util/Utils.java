package beautynote.common.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
	public static String makeJsonString(int total, Object data, String sub){
	    	
	    	String rValue = " \"total\":\"%s\", \"rows\":%s, \"footer\":\"%s\" ";
	    	String mainData;
	    	String subData = "";
	    	
	    	Gson gson = new GsonBuilder().serializeNulls().create(); 
	    	mainData = gson.toJson(data);
	    	
	    	if(sub != null){
	    		subData = sub;
	    	}
	    	
	    	rValue = String.format(rValue, total, mainData, subData);
	    	
	    	return rValue;
	    }
	
	public static void sendResultJson(HttpServletResponse response, String sJsonString, String sErrorCode, String sErrorMessage) throws Exception {
	    
	    PrintWriter writer;
	    String returnValue = "{ \"resultCode\":\"%s\", \"result\":\"%s\", %s }";
	    
	    if (sJsonString == null || sJsonString == ""){
	        sJsonString = " \"total\":0, \"rows\":[], \"footer\":[] ";
	    }
	    
	    if (sErrorCode == null){
	        sErrorCode = "9999";
	    }
	    
	    response.setContentType("text/plain; charset=UTF-8");
	    
	    writer = response.getWriter();
	    
	    writer.write(String.format(returnValue, sErrorCode, sErrorMessage, sJsonString));
	    
	    writer.flush();
	    writer.close();
	}
}
