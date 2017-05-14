/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package normalfilecounter;

/**
 *
 * @author DELL
 */
import java.math.BigInteger;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;



public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file=null;
        File outFile=null;
        Scanner read=null;
        PrintWriter printWriter=null;
        try
        {
         file = new File("I:\\Documents\\Malware\\DataSets\\" +
                    "ISOT_Botnet_DataSet_2010\\ISOT_Botnet_DataSet_2010\\smtpResultTest.txt");
           outFile = new File("I:\\Documents\\Malware\\DataSets\\" +
                    "ISOT_Botnet_DataSet_2010\\ISOT_Botnet_DataSet_2010\\smtpNormalCounter.txt");
          printWriter = new PrintWriter(outFile);

        HashMap<Integer,Integer>frequencycount=new HashMap<Integer, Integer>();

         read = new Scanner(file);

     //   read.useDelimiter(",");

        while (read.hasNextByte()) {
            byte hex1 = read.nextByte();
            byte hex2 = read.nextByte();
            byte hex3 = read.nextByte();
            byte hex4 = read.nextByte();

          /*    String x=read.next();
              int n=x.length();
              String truncx=x.substring(n-2, n);
              int tempx=Integer.parseInt(truncx,16);
              char c=(char)tempx;*/

             /* int n1=hex1.length();
              int n2=hex2.length();
              int n3=hex3.length();
              int n4=hex4.length();

              String truncHex1=hex1.substring(n1-2,n1);
               String truncHex2=hex2.substring(n2-2,n2);
                String truncHex3=hex3.substring(n3-2,n3);
                 String truncHex4=hex4.substring(n4-2,n4);

                 int truncHex1Int=Integer.parseInt(truncHex1,16);
                 int truncHex2Int=Integer.parseInt(truncHex2,16);
                 int truncHex3Int=Integer.parseInt(truncHex3,16);
                 int truncHex4Int=Integer.parseInt(truncHex4,16);

                 char hex1char=(char)truncHex1Int;
                 char hex2char=(char)truncHex2Int;
                 char hex3char=(char)truncHex3Int;
                 char hex4char=(char)truncHex4Int;*/

                 byte[] byteArray=new byte[4];

                 byteArray[0]=(byte)hex1;
                 byteArray[1]=(byte)hex2;
                 byteArray[2]=(byte)hex3;
                 byteArray[3]=(byte)hex4;

            Integer tempInteger=new BigInteger(byteArray).intValue();
           if(frequencycount.containsKey(tempInteger))
           {
             frequencycount.put(tempInteger, frequencycount.get(tempInteger)+1);
           }
           else
           {
             frequencycount.put(tempInteger,1);
           }

//            char c=read.next().charAt(0);
      //      char[] c=i.toCharArray();

        //    byte[] bi=i.getBytes();
         //  int parsedResult = (int) Long.parseLong(hex, 16);
        //     BigInteger i = new BigInteger(hex,16);
        //    System.out.println(i.intValue());
       //     int x=Integer.parseInt(hex);
   //         byte[] hexByte=hex.getBytes();

     //       System.out.println((char)tempx);
        }
       /*   while (read.hasNextInt()) {
           int x=read.nextInt(16);
           char c=(char)x;


        }*/

       /*for (int tempKey:frequencycount.keySet())
       {
         int tempKey=frequencycount.get(tempKey);
       }*/

        for(int tempKey:frequencycount.keySet())
        {
          int tempValue=frequencycount.get(tempKey);
          printWriter.println(tempKey+"     "+tempValue);
        }
        printWriter.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());

        }

          finally
        {
            try
            {
                read.close();
                printWriter.close();

            }
            catch (Exception ex)
            {
               // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }

}

