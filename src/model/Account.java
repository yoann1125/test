package model;

public class Account {
	
	private String name;
	private AppStore store;
	private String[] namesOfDownloadedApps;
	private int nda;
	private App[] objectsOfDownloadedApps;
	private int oda;
	private final int MAX = 50;
	private String status = "";
	
	public Account(String name, AppStore store) {
		this.name = name;
		this.store = store;
		this.namesOfDownloadedApps = new String[MAX];
		this.objectsOfDownloadedApps = new App[MAX];
		this.nda = 0;
		this.oda = 0;
		this.status = "An account linked to the " + this.store.getBranch() + " store is created for " + this.name + ".";
		
	}
	
	public String[] getNamesOfDownloadedApps() {
		String[] s = new String[this.nda];
		for (int i = 0; i < this.nda; i++) {
			s[i] = this.namesOfDownloadedApps[i];
		}
		return s;
	}

	public App[] getObjectsOfDownloadedApps() {
		App[] a = new App[this.oda];
		for (int i = 0; i < this.oda; i++) {
			a[i] = this.objectsOfDownloadedApps[i];
		}
		return a;
	}

    public void uninstall(String s) {
    	boolean exist = false;
    	int index = 0;
    	for (int i = 0; i < this.nda; i++) {
    		if (this.namesOfDownloadedApps[i].equals(s) == true) {
    			index = i;
    			exist = true;
    			break;
    		}
    	}
    	if (exist == false) {
    		this.status = "Error: " + s + " has not been downloaded for " + this.name + ".";
    	}
    	else {
    		for (int i = index; i < this.nda - 1; i++) {
    			this.namesOfDownloadedApps[i] = this.namesOfDownloadedApps[i + 1];
    		}
    		this.nda--;
    		for (int i = index; i < this.oda - 1; i++) {
    			this.objectsOfDownloadedApps[i] = this.objectsOfDownloadedApps[i + 1];
    		}
    		this.oda--;
    		this.status = s + " is successfully uninstalled for " + this.name + ".";
    	}
    }
    
    public void submitRating(String s, int n) {
    	boolean exist = false;
    	for (int i = 0; i < this.nda; i++) {
    		if (this.namesOfDownloadedApps[i].equals(s) == true) {
    			exist = true;
    			break;
    		}
    	}
    	if (exist == false) {
    		this.status = "Error: " + s + " is not a downloaded app for " + this.name + ".";
    	}
    	else {
    		this.status = "Rating score " + n + " of " + this.name + " is successfully submitted for " + s + ".";
    		this.store.getApp(s).submitRating(n);
    	}
    }
    
    public void switchStore(AppStore a) {
    	this.store = a;	
    	this.status = "Account for " + this.name + " is now linked to the " + this.store.getBranch() + " store.";
    }
    
    public void download(String s) {
    	boolean exist = false;
    	for (int i = 0; i < this.nda; i++) {
    		if (this.namesOfDownloadedApps[i].equals(s) == true) {
    			exist = true;
    			break;
    		}
    	}
    	if (exist == true) {
    		this.status = "Error: " + s + " has already been downloaded for " + this.name + ".";
    	}
    	else {
    		this.namesOfDownloadedApps[this.nda] = s;
        	this.nda++;
        	this.objectsOfDownloadedApps[this.oda] = this.store.getApp(s);
        	this.oda++;
        	this.status = s + " is successfully downloaded for " + this.name + ".";
    	}
    }

	public String toString() {
		return this.status;
	}
	
	

}
