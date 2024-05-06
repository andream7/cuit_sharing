package com.bean;

public class NewRectangle {
	double length;
	double width;
	double rectangleArea;
	double rectangleLength;
	public NewRectangle() {
		length = 20;
		width = 10;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getRectangleArea() {
		return length * width;
	}
	public double getRectangleLength() {
		return 2 * (width + length);
	}
}
