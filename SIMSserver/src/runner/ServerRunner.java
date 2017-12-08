package SIMSserver.src.runner;

import SIMSserver.src.rmi.RemoteHelper;

public class ServerRunner {
	
	public ServerRunner(){
		new RemoteHelper();
	}
	
	public static void main(String[] args) {
		new ServerRunner();
	}
}
