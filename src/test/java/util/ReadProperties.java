package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



/**
 * 
 * @author renjy
 */
public class ReadProperties {

	/**
	 * 根据文件名称、属性名获取相应属性值
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 * 
	 */
	public static String getprop(String filename, String folder, String propname) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("./test-classes/"+folder+"/"+filename+".properties"));
		 String str = props.getProperty(propname);
		return str;
		
	}
	
	
	
	
}