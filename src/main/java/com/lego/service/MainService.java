package com.lego.service;

import com.lego.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/7/17
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MainService {
    @Autowired
    UserDao userDao;
    @Autowired
    ReportTemplateDao reportTemplateDao;
    @Autowired
    ReportSimulationDao reportSimulationDao;
    @Autowired
    ReportDao reportDao;
    @Autowired
    GroupDao groupDao;
    @Autowired
    FileTemplateDao reportTemplateFilesDao;
    @Autowired
    FileSimulationDao fileSimulationDao;
    @Autowired
    FileDao fileDao;
}
