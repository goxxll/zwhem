package com.zwhem.util;

import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/** @pdOid e248b575-04b1-488d-9ffa-d50af1f12aac */
public class MyBASE64 {
   /** @pdOid 078a0e89-01cd-49fe-b604-5e6dd8997865 */
   public static final String myKey = "digital";
   
   /** BASE64解密
    * 
    * @param key
    * @return
    * @throws Exception
    * @pdOid 869c4aec-26d6-4ae5-8b0a-9a81d2a6606d */
   public static String decryptBASE64(String key)   {               
         String code="";
   try {
   	code = new String(new BASE64Decoder().decodeBuffer(key));
   } catch (IOException e) {
   	e.printStackTrace();
   }     
         return code.substring(0,code.indexOf(myKey));
     }
   
   /** BASE64加密
    * 
    * @param key
    * @return
    * @throws Exception
    * @pdOid 787b6089-e40e-4c5e-b0bc-0057d7e546d8 */
   public static String encryptBASE64(String key) { 
       return (new BASE64Encoder()).encodeBuffer(key.concat(myKey).getBytes());               
   }
   
   /** @param args
    * @exception Exception
    * @pdOid 650bdba7-57c5-4f65-b7e6-ce11ab1f0fb8 */
   public static void main(String[] args) throws Exception {     
       String data = MyBASE64.encryptBASE64("1234");     
       System.out.println("加密后："+data);     
            
       String dataDecrype= MyBASE64.decryptBASE64(data);     
       System.out.println("解密后："+dataDecrype);     
   }

}