package com.bean;

public class Triangle {
	double sideA = -1, sideB = -1, sideC = -1, area = -1, length = -1;
	boolean triangle;

	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	public double getArea() {
		double p = (sideA + sideB + sideC) / 2.0;
		if (triangle)
			area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public boolean isTriangle() {
		if (sideA < sideB + sideC && sideB < sideA + sideC
				&& sideC < sideA + sideB)
			triangle = true;
		else
			triangle = false;
		return triangle;
	}

	public void setTriangle(boolean triangle) {
		this.triangle = triangle;
	}

	public double getLength() {
		length = sideA + sideB + sideC;
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

}
