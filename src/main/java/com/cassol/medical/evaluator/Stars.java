package com.cassol.medical.evaluator;

public enum Stars {
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5);
	
	private Integer number;

	private Stars(Integer number){
		this.number = number;
		
	}

	public Integer number() {
		return this.number;
	}

}
