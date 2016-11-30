package util;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.*;

/**
 * Created by srikanth on 30/11/16.
 */
public class Reporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
        // iterate over all suites
        for(ISuite suite : list1){
            Map<String, ISuiteResult> results = suite.getResults();
            Set<String> keys = results.keySet();
            //iterate over each result
            for(String key : keys){
                ITestContext context = results.get(key).getTestContext();

                System.out.println("Suite Name: -> "+context.getSuite().getName()+
                "\nTest name "+context.getName()+
                "\nOutput dir "+context.getOutputDirectory()+
                "\nStart date :"+context.getStartDate()+
                "\nEnd date :"+context.getEndDate());

                //Get Map for only failed test cases
                IResultMap resultMap = context.getFailedTests();

                //Get method detail of failed test cases
                Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();

                //Loop one by one in all failed methods
                System.out.println("--------FAILED TEST CASE---------");

                for (ITestNGMethod iTestNGMethod : failedMethods) {
                    //Print failed test cases detail
                    System.out.println("TESTCASE NAME-> "+iTestNGMethod.getMethodName()
                            +" || \tDescription-> "+iTestNGMethod.getDescription()
                            +" || \tPriority-> "+iTestNGMethod.getPriority()
                            +" || \t:Date-> "+new Date(iTestNGMethod.getDate()));
                }

            }
        }


    }
}
