/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocesslab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author tmiller
 */
public class OrderProcessLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        System.out.println("Start processing orders.");
       try(BufferedReader br = new BufferedReader(new FileReader("Orders.txt"))) 
        {
        
            final double TAX_RATE = 0.02;
            final double SHIPPING_RATE = 0.05;
        
            try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("OrdersProcessed.txt"))))
            {
                
                
                Path p = Paths.get("/Users/tmiller/Dropbox/orderProcessLab/OrdersProcessed.txt");
                boolean path_exists = Files.exists(p);
                
                if(path_exists = false)
                {
                    Files.createFile(p);
                }
                
                br.readLine();
            
                String inputLine = br.readLine();
            
                while(inputLine != null)
                {
                 
                    String[] seperated = inputLine.split("\\|");
                 
                    String order = seperated[0];
                    String partNum = seperated[1];
                    double price = Double.valueOf(seperated[2]);
                    int quan = Integer.parseInt(seperated[3]);
                    double tax = (TAX_RATE * quan * price);
                    double ship = (SHIPPING_RATE * quan * price);
                    double total = quan * price + tax + ship;
                 
                    writer.println("Order ID: " + order);
                    writer.println("Part Num: " + partNum);
                    writer.println("Price: " + price);
                    writer.println("Quantity: " + quan);
                    writer.println("Tax: " + tax);
                    writer.println("Shipping: " + ship);
                    writer.println("Total: " + total);
                    writer.println("   ");
                    inputLine = br.readLine();
                }
            
            }
            catch(Exception e)
            {
            
            }
        }
       System.out.println("Finished processing orders.");
    }   
}
