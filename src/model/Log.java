package model;

public class Log {
	
	private String version;
	private int numberOfFixes;
	private String fixes = "[";
	
	public Log(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public int getNumberOfFixes() {
		return numberOfFixes;
	}

	public String getFixes() {
		return this.fixes + "]";
	}

	public void setFixes(String fixes) {
		this.fixes = fixes;
	}
	
	public void addFix(String fixes) {
		this.numberOfFixes++;
		if (this.numberOfFixes == 0 || this.numberOfFixes == 1) {
			this.fixes += fixes;
		}
		else {
			this.fixes += ", " + fixes;
		}	
	}
	
	public String toString() {
		String s = "";
		s += "Version " + this.version + " contains " + this.numberOfFixes + " fixes " + this.fixes + "]";
		return s;
	}
	
	

}
