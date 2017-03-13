package com.test;

import com.lego.service.ReportTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/7/17
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class FileTemplateDaoTest {
    @Autowired
    private ReportTemplateService reportTemplateService;

    @Test
    public void testInsert() throws Exception {
        reportTemplateService.createReportTemplateFile(2);
    }
}
