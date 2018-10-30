package com.lx.springmvcdemo.aop;

public class MathCalculator {

	public int div(int i,int j) {
		System.out.println("MathCalculator.div()被调用");
		return i/j;
	}
}
