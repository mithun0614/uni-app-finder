package main;

public class University {
	private String name;
	private double average;
	private double cutoff;
	private int tuition;
	private int classSize;
	private double latitude;
	private double longitude;

	// constructor method University
	public University(String name, double average, double cutoff, int tuition, int classSize, double latitude,
			double longitude) {
		this.name = name;
		this.average = average;
		this.cutoff = cutoff;
		this.tuition = tuition;
		this.classSize = classSize;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getCutoff() {
		return cutoff;
	}

	public void setCutoff(double cutoff) {
		this.cutoff = cutoff;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}

	public int getClassSize() {
		return classSize;
	}

	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
