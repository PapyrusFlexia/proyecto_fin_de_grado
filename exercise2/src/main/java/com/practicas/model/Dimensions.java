package com.practicas.model;

public class Dimensions {

	private int width;
	private int length;
	private int height;

	public Dimensions() {

	}

	public Dimensions(int width, int length, int height) {
		super();
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Dimensions [width=" + width + ", length=" + length + ", height=" + height + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
