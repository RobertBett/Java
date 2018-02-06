
public interface CalculatorTest {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		calculator.setOperation("+");
		calculator.setOperandOne("10.5");
		calculator.setOperandTwo("5.2");
		calculator.performOperation();
		calculator.getResults();
	}
}
