package Samples;


import java.io.FilePermission;
import java.io.IOException;
import java.net.ServerSocket;
import java.security.acl.Permission;

/**
 * Created by User on 17.10.2016.
 */
public class SampleSecurity extends Thread {
	public static void main(String[] args) {
//		System.out.println(SampleSecurity.class.getProtectionDomain().getCodeSource());
//		FilePermission p =  new FilePermission("temp/*", "read");
//		SecurityManager security = System.getSecurityManager();
//		if (security != null)
//			security.checkPermission(p);
		SecurityManager t1= new SecurityManager();
//		t1.checkAccess(this);
		System.setSecurityManager(t1);
		try {
			new ServerSocket(124);
		} catch (IOException e) {
			System.out.println("Could not listen on port: 124");
			System.exit(-1);
		}
		System.out.println("Listening OK.");
	}

	public void run() {
		System.out.println("HelloWorld!");

	}

}
