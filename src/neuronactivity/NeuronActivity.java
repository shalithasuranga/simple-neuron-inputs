/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronactivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Shalitha Suranga
 */
public class NeuronActivity {
    private static double T = 0;
    private static ArrayList<Double> weights = new ArrayList<Double>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int inputs = 4; // change input size
        System.out.println("Enter threshold value (T) : ");
        Scanner sc = new Scanner(System.in);
        T = sc.nextDouble();
        System.out.println("Enter weights (w1 w2 w3..) " + inputs + " values : ");
        for(int i = 0; i < inputs; i++){
            weights.add(sc.nextDouble());
        }
        displayOutput(inputs);
        System.out.println("");
    }
    
    
    public static void displayOutput(int N){
        
        Neuron neuron = new Neuron(T);
        for(int i = 0; i < Math.pow(2.0, N); i ++){
            String bins = Integer.toBinaryString(i);
            String s = "";
            for (int j = 0; j < N - bins.length() ; j++){
                   s += "0";
            }
            bins = s + bins;
            
             
            for(int k = 0; k < bins.length(); k ++){
                neuron.add(weights.get(k), Character.getNumericValue(bins.charAt(k)));
            }
            NumberFormat nf = new DecimalFormat("#0.00");
            System.out.print("Input : " + bins + " |\t Weights : ");
            for(double ww : weights){
                System.out.print(ww + " ");
            }
            
            System.out.print("\t | Weighted Sum : " + nf.format(neuron.calcWeightedSum()) + "\t | Output is " + neuron.getOutput() + "\n");
            
            neuron.clear();
        }
        
        

    }
    
    
    
}
