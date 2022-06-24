package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
	
	public Double getSalaryIncome() {
		return salaryIncome;
	}
	public Double getServicesIncome() {
		return servicesIncome;
	}
	public Double getCapitalIncome() {
		return capitalIncome;
	}
	public Double getHealthSpending() {
		return healthSpending;
	}
	public Double getEducationSpending() {
		return educationSpending;
	}
	
	public Double salaryTax() {
		double monthlyIncome = salaryIncome / 12.0;
		if(monthlyIncome < 3000.00) {
			return 0.0;
		} 
		else if(monthlyIncome < 5000.00) {
			return salaryIncome * 0.1;
		} else {
			return salaryIncome * 0.2;
		}
	}
	
	public Double servicesTax() {
		return servicesIncome * 0.15;
	}
	
	public Double capitalTax() {
		return capitalIncome * 0.2;
	}
	
	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public Double taxRebate() {
		double maxRebate = grossTax() * 0.3;
		double totalSpending = healthSpending + educationSpending;
		if (totalSpending > maxRebate) {
			return maxRebate;
		} else {
			return totalSpending;
		}
	}
	
	public Double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		return "Total gross tax: $ " + String.format("%.2f%n", grossTax())
			 + "Rebate: $ " + String.format("%.2f%n", taxRebate())
			 + "Tax due: $ " + String.format("%.2f%n", netTax());
	}

}
