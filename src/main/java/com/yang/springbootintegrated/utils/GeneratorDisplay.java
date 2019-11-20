package com.yang.springbootintegrated.utils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 逆向工程启动类
 * 
 * @Description:GeneratorDisplay
 * @author:yanglin
 * @time:2018年8月6日 下午10:25:15
 */
public class GeneratorDisplay {

    /**
     * <p>
     * 描述:
     * </p>
     * <p>
     * 创建时间: 2019-11-20 11:20
     * </p>
     * <p>
     * 更新时间: 2019-11-20 11:20
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @throws XMLParserException            XML解析异常
     * @throws IOException                   IO异常
     * @throws InvalidConfigurationException 非法配置异常
     * @throws SQLException                  SQL异常
     * @throws InterruptedException          中断异常
     * 
     * @author yanglin
     */
    public void generator()
            throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // 指定 逆向工程配置文件
        File configFile = new File("src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

    }

    /**
     * <p>
     * 描述: 测试运行方法
     * </p>
     * <p>
     * 创建时间: 2019-11-20 11:17
     * </p>
     * <p>
     * 更新时间: 2019-11-20 11:17
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @param args 运行参数
     * 
     * @author yanglin
     */
    protected static void main(String[] args) {
        try {
            GeneratorDisplay generatorSqlmap = new GeneratorDisplay();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
