package com.wsl.wjw.test.initbean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigTest.class);
                System.out.println("#################################");
        context.close();
        
        List<String> tList = new ArrayList<String>();
        tList.add("w1");
        tList.add("w2");
        tList.add("w3");
        
        System.out.println("remove: "+tList.remove(0));
        
        for(int i = 0 ; i <3 ; i++){
        	BigDecimal poundage = BigDecimal.ZERO;
        	System.out.println("poundage="+poundage);
        	if(i == 1){
        		poundage = poundage.add(new BigDecimal(3));
        	}
        	System.out.println("poundage="+poundage);
        }
        
        
    }
}