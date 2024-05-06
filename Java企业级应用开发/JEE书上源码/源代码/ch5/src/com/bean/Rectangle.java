package com.bean;

public class Rectangle {
	private double length;
	private double width;
	public Rectangle(){        
		length = 20;
		width = 10;
	}  
	public double getLength(){       
		return length;
	}
	public void setLength(double length){        
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double computerArea(){
		return length*width;
	}
	public double computerLength(){
		return (length+width)*2;
	}
}
