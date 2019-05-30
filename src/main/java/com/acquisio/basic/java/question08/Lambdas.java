package com.acquisio.basic.java.question08;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

//import java.io.FileOutputStream;
//import java.io.PrintStream;
import java.io.FileWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * QUESTION 09: Lambdas (https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
 * Using JDK8 Lambdas, add the code to transform the input file to apply those rules.
 * 1- Keep lines where the amount is greater than or equals to 50$
 * 2- Add a Taxes column right after the Amount column, which is 15% of the Amount.
 * 3- Add a Total column right after the Taxes column, which is the sum of Amount and Taxes.
 * 4- Remove the ShoppingCartTitle columns.
 * <p>
 * The input file contains those columns
 * User,Amount,ShoppingCartTitle,NbItems
 * <p>
 
 * the output file:
 * User,Amount,Taxes(15% of Amount),Total,NbItems
 
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
 

//ant run-utility-q8 -Dutility=Lambdas  

public class Lambdas {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Lambdas instance = new Lambdas();
        File input = new File(Thread.currentThread().getContextClassLoader().getResource("./carts.csv").toURI());
        File output = new File("./carts_output.csv");
        output.delete();

		if (input.exists()) {
			Files.lines(input.toPath()).forEachOrdered(line -> System.out.println(line));
        }

        instance.convertCarts(input, output);

        if (output.exists()) {
			//System.out.println(output.toPath() + ":");
			Files.lines(output.toPath()).forEachOrdered(line -> System.out.println(line));
        }
    }

    void convertCarts(File input, File output) throws IOException {
        // TODO: Insert your code here.
	
		try (Stream<String> lines = Files.lines(input.toPath())) {
			List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			
			List<List<String>> removedAmountLT50 = values.stream().filter(value -> Float.parseFloat(value.get(1)) >= 50.0).collect(Collectors.toList());

			List<List<String>> addedTaxesAndRemovedShoppingCartTitle = removedAmountLT50.stream().map(value -> Arrays.asList(new String[]{value.get(0), value.get(1), String.valueOf(Float.parseFloat(value.get(1)) * 0.15), value.get(3)})).collect(Collectors.toList());			
			
			List<List<String>> addedTotal = addedTaxesAndRemovedShoppingCartTitle.stream().map(value -> Arrays.asList(new String[]{value.get(0), value.get(1), value.get(2), String.valueOf(Float.parseFloat(value.get(1)) + Float.parseFloat(value.get(2))), value.get(3)})).collect(Collectors.toList());			
			
			//addedTotal.forEach(value -> System.out.println(String.join(",", value.stream().toArray(String[] ::new))));
			
			FileWriter fw = new FileWriter(output);
			addedTotal.forEach(value -> writeToFile(fw, String.join(",", value.stream().toArray(String[] ::new))));
			
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        

		return;
    }
	
	private void writeToFile(FileWriter fw, String str_line) {
        try {
            fw.write(String.format("%s%n", str_line));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
}
