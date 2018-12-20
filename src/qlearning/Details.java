/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qlearning;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Details 
{
    static int Agent=3;
    static ArrayList input[]=new ArrayList[Agent];
    static int State=10;
    static int StateGoal=0;
    
    static int Xmax=10; // Max. no of customer in queue
    static int Imax=20; // Max. no of Stock in shop
    
    static int startPrice[]={8,5,10};
    static int endPrice[]={14,9,13};
    
    static ArrayList priceList[]=new ArrayList[Agent];
    
    static ArrayList states[]=new ArrayList[Agent];
    static ArrayList action[]=new ArrayList[Agent];
    static ArrayList reward[]=new ArrayList[Agent];
    
    //static ArrayList prob[]=new ArrayList[Agent];
    
    static double R[][];
    static double Q[][];
    static double Qtar[][];
   
    static double gamma=0.5; 
    static double mu=0.2;
}
