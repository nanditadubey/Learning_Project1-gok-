package com.gojek.testcases;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gojek.comparator.JsonComparator;
import com.gojek.constants.ConfigConstants;
import com.gojek.datareader.DataReader;
import com.gojek.utils.RestUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;

/**
 * Created by nandita.dubey on 09/05/20.
 */
public class ComparatorTest {


    public static ArrayList listOne;
    public static ArrayList listTwo;
   public static  ObjectMapper mapper ;
    @BeforeClass
    public static void setup() {
         mapper = new ObjectMapper();
        DataReader dr = new DataReader();
         listOne = dr.Read(0,ConfigConstants.File1);
        listTwo = dr.Read(0,ConfigConstants.File2);

       Assert.assertEquals(listOne.size(),listTwo.size());

    }

    @Test
    public static void objectandNumericTest()
    {

        try {
            for(int i=1;i<listOne.size();i++){
             String urlOne=listOne.get(i).toString();
             String urlTwo=listTwo.get(i).toString();
             String rsOne= RestUtils.getCall( urlOne,HttpStatus.SC_OK).asString();
             String rsTwo= RestUtils.getCall( urlTwo,HttpStatus.SC_OK).asString();
                JsonNode actualObj1 = mapper.readTree(rsOne);
                JsonNode actualObj2 = mapper.readTree(rsTwo);
                JsonComparator jsCompare= new JsonComparator();
                int resposne=jsCompare.compare(actualObj1,actualObj2);
               if(resposne==0){
                   System.out.println(urlOne +" "+ "equals" +" "+urlTwo);
               }else{
                   System.out.println(urlOne +" "+ "Not equals" +" "+urlTwo);
               }
            }


        }
        catch (Exception e){
e.printStackTrace();
        }

    }





}


