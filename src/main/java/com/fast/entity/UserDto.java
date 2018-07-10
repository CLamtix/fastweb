package com.fast.entity;

public class UserDto {
	
	private String name;
	private int age;
	private double avalibleFunds;//可用
	private double frozenFunds;//冻结
	private double earlyDayFunds;//期初余额
	private double lastDayFunds;//期末余额
	
	

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", age=" + age + ", avalibleFunds=" + avalibleFunds + ", frozenFunds="
				+ frozenFunds + ", earlyDayFunds=" + earlyDayFunds + ", lastDayFunds=" + lastDayFunds + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getAvalibleFunds() {
		return avalibleFunds;
	}
	public void setAvalibleFunds(double avalibleFunds) {
		this.avalibleFunds = avalibleFunds;
	}
	public double getFrozenFunds() {
		return frozenFunds;
	}
	public void setFrozenFunds(double frozenFunds) {
		this.frozenFunds = frozenFunds;
	}
	public double getEarlyDayFunds() {
		return earlyDayFunds;
	}
	public void setEarlyDayFunds(double earlyDayFunds) {
		this.earlyDayFunds = earlyDayFunds;
	}
	public double getLastDayFunds() {
		return lastDayFunds;
	}
	public void setLastDayFunds(double lastDayFunds) {
		this.lastDayFunds = lastDayFunds;
	}
	
}
