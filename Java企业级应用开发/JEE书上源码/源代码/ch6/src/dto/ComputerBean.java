package dto;

public class ComputerBean {
	double numberOne;
	double numberTwo;
	String operator;
	double result;
	public double getNumberOne() {
		return numberOne;
	}
	public void setNumberOne(double numberOne) {
		this.numberOne = numberOne;
	}
	public double getNumberTwo() {
		return numberTwo;
	}
	public void setNumberTwo(double numberTwo) {
		this.numberTwo = numberTwo;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public double getResult() {
		if("+".equals(operator)) {
			result = numberOne + numberTwo;
		}else if("-".equals(operator)) {
			result = numberOne - numberTwo;
		}else if("*".equals(operator)) {
			result = numberOne * numberTwo;
		}else {
			result = numberOne / numberTwo;
		}
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
}
