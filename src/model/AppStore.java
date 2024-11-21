package model;

public class AppStore {
	
	private String branch;
	private App app;
	private App[] availableApps;
	private String[] stableApps;
	private int noa;
	
	public AppStore(String branch, int maxApp) {
		this.branch = branch;
		this.availableApps = new App[maxApp];
		this.stableApps = new String[maxApp];
		this.noa = 0;
	}

	public String getBranch() {
		return branch;
	}

	public App getApp(String s) {
		for (int i = 0; i < this.noa; i++) {
			if (this.availableApps[i].getName().equals(s)) {
				this.app = this.availableApps[i];
				break;
			}
			else {
				this.app = null;
			}
		}
		return app;
	}

	public String[] getStableApps(int n) {
		String[] stable;
		int count = 0;
		for (int i = 0; i < this.noa; i++) {
			if (this.availableApps[i].getUpdateHistory().length >= n) {
				this.stableApps[count] = this.availableApps[i].getName() + " (" + this.availableApps[i].getUpdateHistory().length
						+ " versions; Current Version: " + this.availableApps[i].getUpdateHistory()[this.availableApps[i].getUpdateHistory().length - 1].toString()
						+ ")";
				count++;
			}
		}
		stable = new String[count];
		for (int i = 0; i < count; i++) {
			stable[i] = this.stableApps[i];
		}
		return stable;
	}
	
	public void addApp(App a) {
		this.availableApps[this.noa] = a;
		this.noa++;
	}
	
	

}
