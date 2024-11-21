package model;

public class App {
	
	private String name;
	private String whatIsNew;
	private Log[] updateHistory ;
    private Log versionInfo;
    private String ratingReport;
    private final int MAX_UPDATE = 20;
    private int nou;
    private int[] ratings;
    private int nor;
    private double average;
    
    public App (String name, int maxRating) {
    	this.name = name;
    	this.ratings = new int[maxRating];
    	this.whatIsNew = "n/a";
    	this.updateHistory = new Log[MAX_UPDATE];
    	this.nou = 0;
    	this.ratingReport = "No ratings submitted so far!";
    	this.nor = 0;
    	this.average = 0.0;
    }

	public String getName() {
		return name;
	}

	public String getWhatIsNew() {
		return whatIsNew;
	}

	public Log[] getUpdateHistory() {
		Log[] update = new Log[this.nou];
		for(int i = 0; i < this.nou; i++) {
			update[i] = this.updateHistory[i];
		}
		return update;
	}

	public Log getVersionInfo(String s) {
		for (int i = 0; i < this.nou; i++) {
			if (this.updateHistory[i].getVersion().equals(s)) {
				this.versionInfo = this.updateHistory[i];
				break;
			}
			else {
				this.versionInfo = null;
			}
		}
		return versionInfo;
	}

	public String getRatingReport() {
		if (this.nor >= 1) {
			double total = 0.0;
			this.average = 0.0;
			int one = 0;
			int two = 0;
			int three = 0;
			int four = 0;
			int five = 0;
			for (int i = 0; i < this.nor; i++) {
				total += this.ratings[i];
				if (this.ratings[i] == 1) {
					one++;
				}
				if (this.ratings[i] == 2) {
					two++;
				}
				if (this.ratings[i] == 3) {
					three++;
				}
				if (this.ratings[i] == 4) {
					four++;
				}
				if (this.ratings[i] == 5) { 
					five++;
				}
			}
			average = total/this.nor;
			this.ratingReport = "Average of " + this.nor + " ratings: " + String.format("%.1f", average) + " (Score 5: " + five + ", Score 4: " + four 
					            + ", Score 3: " + three  + ", Score 2: " + two  + ", Score 1: " + one + ")";
		}
		return ratingReport;
	}
	
	public void releaseUpdate(String s) {
		Log update = new Log(s);
		this.updateHistory[this.nou] = update;
		this.whatIsNew = update.toString();
		this.nou++;
	}
	
	public void submitRating(int n) {
		this.ratings[this.nor] = n;
		this.nor++;
	}
	
	public String toString() {
		String s = "";
		if (this.nor == 0 && this.nou == 0) {
			s += this.name + " (Current Version: " + this.whatIsNew + "; Average Rating: n/a)";
		}
		else {
			s += this.name + " (Current Version: " + this.updateHistory[this.nou - 1].toString() + "; Average Rating: " + String.format("%.1f", this.average) + ")";
		}
		
		return s;
	}
    
    
    
}   
