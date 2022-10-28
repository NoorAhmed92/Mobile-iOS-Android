package com.kinship.automation.testcases.web;


import com.kinship.automation.base.WebBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import org.testng.annotations.Test;

public class VerifyWhistleTest extends WebBaseTest {

    @Test
    public void testLocal(){
        System.out.println(FrameworkConfigFactory.getConfig().browser());

        System.out.println(FrameworkConfigFactory.getConfig().remoteType());
    }


}
