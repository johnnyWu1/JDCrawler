package com.jonney;


import org.apache.commons.lang3.StringUtils;  
 
/** 
* 
* 
* @author <a href="ls.zhaoxiangyu@gmail.com">zhao</> 
* @date 2015-10-23 
*/  
public class Tools {  
     
   /** 
    * 判断字符窜是否等于null、"","  ","null" 
    *  
    * @param str 
    * @return 
    */  
   public static boolean isEmpty(String str){  
       return StringUtils.isBlank(str)||"null".equals(str);  
   }  
     
   /** 
    * 判断字符窜是否不等于null、"","  ","null" 
    *  
    * @param str 
    * @return 
    */  
   public static boolean notEmpty(String str){  
       return !StringUtils.isBlank(str)&&!"null".equals(str);  
   }  
     
}  