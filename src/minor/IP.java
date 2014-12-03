package minor;

import java.net.InetAddress;
import java.net.UnknownHostException;
 
public class IP {
 
	public String getIP() {
 
	  
          InetAddress ip;
          String str="";
        
	  try {
                
		ip = InetAddress.getLocalHost();
		//System.out.println("Current IP address : " + ip.getHostAddress());
                //String ip_addr = ip.getHostAddress();
                //System.out.println(ip_addr);
                str = ip.getHostAddress();
 
	  } catch (UnknownHostException e) {
 
		e.printStackTrace();
 
	  }
          return str;
 
	}
       
 
}