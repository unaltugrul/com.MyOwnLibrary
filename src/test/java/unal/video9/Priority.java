package unal.video9;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 3) //--------------> third
    public void test01(){
        System.out.println("Test 01");
    }

    @Test(priority = -3)  //------------> first
    public void test02(){
        System.out.println("Test 02");
    }
    @Test
    public void test03(){ //------------> second (valuates like 0)
        System.out.println("Test 03");
    }
}
