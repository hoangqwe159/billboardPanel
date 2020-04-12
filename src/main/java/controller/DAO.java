/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import model.Billboard;
import model.Schedule;
import model.User;

/**
 *
 * @author Asus
 */
public class DAO {
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private DateFormat hourFormat = new SimpleDateFormat("HH:mm");
    public ArrayList<Billboard> getListBillboard() {
        ArrayList<Billboard> list = new ArrayList<>();
        Billboard b = new Billboard();
                b.setBillboardId(1); 
                b.setUserId(1); 
                b.setMessage("bb no1"); 
                b.setInformation("bb info 1"); 
                b.setBackgroundColor("white 1"); 
                b.setFontColor("black 1"); 
               
                b.setPicture("pic 1");
                
        list.add(b);
        return list;
    }
    
    public ArrayList<Schedule> getListSchedule() {
        Date currentTime = new Date();
        Date previousTime = new Date(currentTime.getTime() - 24*60*1000);
        Date previousTime1 = new Date(currentTime.getTime() - 26*60*1000);
        
        ArrayList<Schedule> list = new ArrayList<>();
        
        
        Schedule s = new Schedule(currentTime);
                s.setScheduleId(1);
                s.setBillboardId(1); 
                s.setTimeLimit(120); 
                s.setNextRun(120); 
                s.setStartTime("10:30 08-04-2020"); 
                
                
        list.add(s);
        
        Schedule s1 = new Schedule(previousTime);
                s1.setScheduleId(2);
                s1.setBillboardId(2); 
                s1.setTimeLimit(60); 
                s1.setNextRun(60 * 2); 
                s1.setStartTime("09:00 08-04-2020");   
                
                
        list.add(s1);
        
        Schedule s2 = new Schedule(previousTime1);
                s2.setScheduleId(3);
                s2.setBillboardId(3); 
                s2.setTimeLimit(80); 
                s2.setNextRun(50 * 2); 
                s2.setStartTime("08:00 08-04-2020");   
                
                
        list.add(s2);
        
        
        
        return list;
    }
    //Sort the list base on updateAt
    //Set startRunAt, endRunAt
    public ArrayList<Schedule> processListSchedule(ArrayList<Schedule> list) {
        Collections.sort(list);
        for(Schedule s: list) {
            s.setRunTime();
            s.setStartRun(s.getRunTime());
            ArrayList<Date> endRun = new ArrayList<>();
            for (int i = 0; i < s.getStartRun().size(); i++) {
                
                endRun.add(new Date(s.getStartRun().get(i).getTime() + s.getTimeLimit() * 60 * 1000));
            }
            s.setEndRun(endRun);
        }
        
        
        
        ArrayList<Date> currentStartRun = new  ArrayList<Date>();
        currentStartRun.addAll(list.get(list.size()-1).getStartRun());
        ArrayList<Date> currentEndRun = new  ArrayList<Date>();
                
        currentEndRun.addAll(list.get(list.size()-1).getEndRun());
        
//        for(int j = 0; j < currentStartRun.size(); j++) {
//            System.out.println(""+ hourFormat.format(currentStartRun.get(j))+ " - "+hourFormat.format(currentEndRun.get(j)) );
//            
//        }
        
        for(int i = list.size() - 1; i > 0; i--){
            ArrayList<Date> previousStartRun = list.get(i-1).getStartRun();
            ArrayList<Date> previousEndRun = list.get(i-1).getEndRun();
            
        
            
            for (int j = 0; j < previousStartRun.size(); j++) {
                for (int k = 0; k < currentStartRun.size(); k++){
                    if (previousStartRun.get(j).getTime() < currentStartRun.get(k).getTime() 
                            && previousEndRun.get(j).getTime() > currentStartRun.get(k).getTime()){
                        previousEndRun.set(j, new Date(currentStartRun.get(k).getTime()));
                    } 
                    else if (previousStartRun.get(j).getTime() < currentStartRun.get(k).getTime() 
                            && previousEndRun.get(j).getTime() >= currentStartRun.get(k).getTime()){
                        previousEndRun.set(j, new Date(currentEndRun.get(k).getTime()));
                    } 
                    
                    
                    
                    else if (previousStartRun.get(j).getTime() <= currentEndRun.get(k).getTime()
                            && previousEndRun.get(j).getTime() > currentEndRun.get(k).getTime()) {
                        previousStartRun.set(j, new Date(currentEndRun.get(k).getTime()));
                        
                    } else if (previousStartRun.get(j).getTime() >= currentStartRun.get(k).getTime()
                            && previousEndRun.get(j).getTime() <= currentEndRun.get(k).getTime()) {
                        previousStartRun.set(j, new Date(1L));
                        previousEndRun.set(j, new Date(1L));
                    }  
                    
                }
            }
            
            for (int j = 0; j < previousStartRun.size(); j++) {
                if(previousStartRun.get(j).equals(new Date(1L))) {
                    previousStartRun.remove(j);
                    previousEndRun.remove(j);
                }
//                for (int k =0; k < currentStartRun.size(); k++){
//                    if(previousStartRun.get(j).equals(currentStartRun.get(k)) 
//                            && previousEndRun.get(j).equals(currentEndRun.get(k))  ) {
//                        previousStartRun.remove(j);
//                        previousEndRun.remove(j);          
//                    }
//                }
            }

            list.get(i-1).setStartRun(previousStartRun);
            list.get(i-1).setEndRun(previousEndRun);
            
            currentStartRun.addAll(previousStartRun);
            currentEndRun.addAll(previousEndRun);
            
            for(int j = 0; j <list.get(list.size() - 1).getStartRun().size()-1; j++) {
            System.out.println(""+ hourFormat.format(list.get(list.size() - 1).getStartRun().get(j))+ " - "+hourFormat.format(list.get(list.size() - 1).getEndRun().get(j)) );
            
        } 
           
        }
        return list;
        
    }

    public ArrayList<User> getListUser() {           
        
        ArrayList<User> list = new ArrayList<>();
        
        
        User u = new User();
        ArrayList<String> permission1 = new  ArrayList<String>();
        permission1.add("CB");
        permission1.add("EB");
        permission1.add("SB");
        permission1.add("EU");               
         
                u.setUsername("hoangqwe159");
                u.setPassword("12345678");
                u.setPermission(permission1);
                
                
        list.add(u);
        return list;
    }
    
    
    
    
}
