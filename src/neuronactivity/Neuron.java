/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronactivity;

import java.util.ArrayList;

/**
 *
 * @author Shalitha Suranga
 */
public class Neuron {
    private ArrayList<Double> weights = new ArrayList<Double>();
    private ArrayList<Double> values = new ArrayList<Double>();
    private double threshold;
    private double weightedSum = 0;

    
    public Neuron(double threshold) {
        this.threshold = threshold;
        System.out.println("Neuron created with threshold " + this.threshold);
    }
    

    public void add(double w,double x){
        this.weights.add(w);
        this.values.add(x);
    }
    
    
    public int getOutput(){
        return this.weightedSum > this.threshold ? 1 : 0;
        
    }
    
    public double calcWeightedSum(){
        
        for(int i = 0; i < weights.size(); i++){
            this.weightedSum += this.weights.get(i) * this.values.get(i);
        }
        return this.weightedSum;
    }
    
    public void clear(){
        this.values = new ArrayList<Double>();
        this.weights = new ArrayList<Double>();
        this.weightedSum = 0;
        
    }
}
