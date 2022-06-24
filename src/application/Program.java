package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n;
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("How many taxpayers will you enter? ");
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Enter the data of the "+(i+1)+"st contributor:");
			System.out.print("Annual income with salary: $ ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Annual income with service provision: $ ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Annual income with capital gain: $ ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Medical expenses: $ ");
			double medicalExpenses = sc.nextDouble();
			System.out.print("Educational expenses: $ ");
			double educationalExpenses = sc.nextDouble();
			list.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, medicalExpenses, educationalExpenses));
		}
		
		int count = 0;
		System.out.println();
		for (TaxPayer taxPayer : list) {
			count++;
			System.out.println("Summary of the "+count+"st contributor:");
			System.out.println(taxPayer);
		}
		
		sc.close();
	}

}
