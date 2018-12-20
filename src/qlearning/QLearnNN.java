/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qlearning;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author admin
 */
public class QLearnNN 
{
    Details dt=new Details();
    
    QLearnNN()
    {
        
    }
    
    public void learning()
    {
        try
        {
            DecimalFormat df=new DecimalFormat("#.###");
            dt.Q=new double[dt.Agent][dt.State];
            dt.Qtar=new double[dt.Agent][dt.State];
            double we[][]=new double[dt.Agent][dt.State];
            // Initialize Q 
            for(int i=0;i<dt.Agent;i++)
            {
                for(int j=0;j<dt.State;j++)
                {                
                    dt.Q[i][j]=0;   
                    dt.Qtar[i][j]=0;
                }
            } 
            
            Random rn=new Random();
            // Initialize Weight
             for(int i=0;i<dt.Agent;i++)
            {
                for(int j=0;j<dt.State;j++)
                {                
                    we[i][j]=rn.nextDouble();            
                }
            } 
            int iter=50;
            for(int it=0;it<iter;it++)
            {
                double output[]=new double[dt.Agent];
                for(int i=0;i<dt.Agent;i++)
                {
                    ArrayList act=dt.action[i];                    
                    double sm=0;
                    for(int j=0;j<act.size();j++)
                    {
                        String g1=act.get(j).toString();
                        dt.Q[i][j]=(Double.parseDouble(g1)*we[i][j]);
                        sm=sm+(Double.parseDouble(g1)*we[i][j]); 
                    }                
                    output[i]=sm/act.size();
                   // System.out.println("== "+output[i]);
                }
                
              /*  for(int i=0;i<dt.Agent;i++)
                {
                     ArrayList act=dt.action[i];
                    for(int j=0;j<dt.State;j++)
                    {
                         String g1=act.get(j).toString();
                        we[i][j]=we[i][j]+dt.mu*(output[i]-dt.Q[i][j]);//*Double.parseDouble(g1);
                    }
                }*/
            }
            double maxQ[]=new double[dt.Agent];
            for(int i=0;i<dt.Agent;i++)
            {
                double max1=0;
                for(int j=0;j<dt.State;j++)
                {
                    max1=Math.max(max1, dt.Q[i][j]);
                }
                maxQ[i]=max1;
            }
            System.out.println("Q  -------");
            for(int i=0;i<dt.Agent;i++)
            {
                for(int j=0;j<dt.State;j++)
                {
                    System.out.print(df.format(dt.Q[i][j])+" ");
                }
                System.out.println();
            }
            
            System.out.println("Q Target -------");
            
            for(int i=0;i<dt.Agent;i++)
            {
                for(int j=0;j<dt.State;j++)
                {
                    double e3=dt.Q[i][j]+dt.gamma*maxQ[i];
                    dt.Qtar[i][j]=Double.parseDouble(df.format(e3));
                    System.out.print((df.format(e3))+" ");
                }
                System.out.println();
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
