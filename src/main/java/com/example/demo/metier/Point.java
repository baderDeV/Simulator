package com.example.demo.metier;

public class Point {
	
	private Integer point;
	private boolean inPath;
	private boolean ravitaillement;
	
	
	public Point(Integer point, boolean ravitaillement) {
		super();
		this.point = point;
		this.ravitaillement = ravitaillement;
	}
	
	public Point(Integer point) {
		super();
		this.point = point;
		
	}
	
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public boolean isRavitaillement() {
		return ravitaillement;
	}
	public void setRavitaillement(boolean ravitaillement) {
		this.ravitaillement = ravitaillement;
	}

	public boolean isInPath() {
		return inPath;
	}

	public void setInPath(boolean isInPath) {
		this.inPath = isInPath;
	}
	
	
}
