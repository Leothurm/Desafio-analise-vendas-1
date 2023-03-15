package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sales;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		System.out.println();
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			List<Sales> list = new ArrayList<>();
			String line = br.readLine();
			
			while(line != null) {
				
			String[] fields = line.split(",");
			
			Integer month = Integer.parseInt(fields[0]);
			Integer years = Integer.parseInt(fields[1]);
			String sales = fields[2];
			Integer items = Integer.parseInt(fields[3]);
			Double total = Double.parseDouble(fields[4]);
			
			list.add(new Sales(month, years, sales, items, total));
			
			
			line = br.readLine();
			}
			
			Comparator<Sales> comp = (x, y) -> x.averagePrice().compareTo(y.averagePrice());
			
			List<Sales> fiveFirstSales = list.stream()
					.filter(p -> p.getYear().equals(2016))
					.sorted(comp.reversed())
					.limit(5)
					.collect(Collectors.toList());
					
					
			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio ");
			fiveFirstSales.forEach(System.out::println);		
			
			Double sum = list.stream()
					.filter(p -> p.getSales().toUpperCase().equals("LOGAN") && (p.getMonth() == 1 || p.getMonth() == 7))
					.map(p -> p.getTotal()).reduce(0.0, (x, y) -> x + y);
			
			System.out.println();
			System.out.println("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = " + String.format("%.2f", sum));
			
			
			
		} catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
		
		
		
		
		
		
		
		
		
	}

}
