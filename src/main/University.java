package main;

public class University {
	private String name;
	private double average;
	private double cutoff;
	private int tuition;
	private int classSize;
	private double latitude;
	private double longitude;
	private int uniSize;
	private double residenceCost;
	private int ranking;

	// constructor method University
	public University(String name, double average, double cutoff, int tuition, int classSize, double latitude,
			double longitude, int uniSize, double residenceCost, int ranking) {
		this.name = name;
		this.average = average;
		this.cutoff = cutoff;
		this.tuition = tuition;
		this.classSize = classSize;
		this.latitude = latitude;
		this.longitude = longitude;
		this.uniSize = uniSize;
		this.residenceCost = residenceCost;
		this.ranking = ranking;
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

	public int getUniSize() {
		return uniSize;
	}

	public void setUniSize(int uniSize) {
		this.uniSize = uniSize;
	}

	public double getResidenceCost() {
		return residenceCost;
	}

	public void setResidenceCost(double residenceCost) {
		this.residenceCost = residenceCost;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
