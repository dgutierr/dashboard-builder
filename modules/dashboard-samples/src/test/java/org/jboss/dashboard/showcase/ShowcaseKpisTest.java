/**
 * Copyright (C) 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.dashboard.showcase;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.dashboard.commons.cdi.CDIBeanLocator;
import org.jboss.dashboard.dataset.DataSet;
import org.jboss.dashboard.profiler.CodeBlockTrace;
import org.jboss.dashboard.test.*;
import org.jboss.dashboard.Application;
import org.jboss.dashboard.DataDisplayerServices;
import org.jboss.dashboard.export.ImportManager;
import org.jboss.dashboard.export.ImportResults;
import org.jboss.dashboard.kpi.KPI;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;

import java.io.File;
import java.io.FileInputStream;

import javax.enterprise.inject.spi.BeanManager;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.jboss.dashboard.dataset.Assertions.*;

@RunWith(Arquillian.class)
public class ShowcaseKpisTest {

    @Deployment
    public static Archive<?> createTestArchive()  {
        return ShrinkWrapHelper.createJavaArchive()
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    protected BeanManager beanManager;

    protected File rootDir;
    protected File webAppDir;
    protected ImportResults context;

    public KPI getKPIByCode(String kpiCode) {
        return context.getKPIByCode(kpiCode);
    }

    public void assertKPIValues(KPI kpi, String[][] values) throws Exception {
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, values, 0);
        }
    }

    @Before
    public void setUp() throws Exception {
        CDIBeanLocator.beanManager = beanManager;
        CodeBlockTrace.RUNTIME_CONTRAINTS_ENABLED = false;

        rootDir = MavenProjectHelper.getModuleDir("dashboard-samples");
        webAppDir = new File(rootDir, "src/main/webapp");
        Application.lookup().setBaseAppDirectory(webAppDir.getAbsolutePath());

        File kpisFile = new File(webAppDir, "WEB-INF/etc/appdata/initialData/showcaseKPIs.xml");
        FileInputStream is = new FileInputStream(kpisFile);

        ImportManager importManager = DataDisplayerServices.lookup().getImportManager();
        context = importManager.parse(is);
    }

    @Test
    public void testNumberOfProviders() throws Exception {
        assertThat(context.getDataProviders().size()).isEqualTo(2);
    }

    @Test
    public void testNumberOfKPIs() throws Exception {
        assertThat(context.getKPIs().size()).isEqualTo(23);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // The tests method below have been auto-generated by the ShowcaseKPITestsGenerator class.
    //
    // IMPORTANT NOTE:
    // If any of the Showcase dashboard KPIs change then it will necessary to generate these tests
    // methods again to avoid a test failure.

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_64061223773274641() throws Exception {
        KPI kpi = getKPIByCode("kpi_64061223773274641");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"1","Barcelona","Engineering","Roxie Foraker","12/11/12 12:00 AM","120.35"},
                    {"2","Barcelona","Engineering","Roxie Foraker","12/1/12 12:00 AM","1,100.1"},
                    {"3","Barcelona","Engineering","Roxie Foraker","11/1/12 12:00 AM","900.1"},
                    {"4","Barcelona","Services","Jamie Gilbeau","10/12/12 12:00 AM","340.34"},
                    {"5","Barcelona","Services","Jamie Gilbeau","09/15/12 12:00 AM","300"},
                    {"6","Barcelona","Services","Jamie Gilbeau","08/17/12 12:00 AM","152.25"},
                    {"7","Madrid","Services","Roxie Foraker","07/1/12 12:00 AM","800.8"},
                    {"8","Madrid","Services","Roxie Foraker","06/1/12 12:00 AM","911.11"},
                    {"9","Madrid","Sales","Nita Marling","05/11/12 12:00 AM","75.75"},
                    {"10","Madrid","Sales","Nita Marling","03/11/12 12:00 AM","100"},
                    {"11","Madrid","Sales","Nita Marling","03/16/12 12:00 AM","220.8"},
                    {"12","Madrid","Sales","Nita Marling","03/2/12 12:00 AM","344.9"},
                    {"13","Brno","Support","Darryl Innes","02/9/12 12:00 AM","567.89"},
                    {"14","Brno","Support","Darryl Innes","01/13/12 12:00 AM","400.4"},
                    {"15","Brno","Support","Darryl Innes","01/11/12 12:00 AM","1,001.9"},
                    {"16","Brno","Engineering","Julio Burdge","11/2/11 12:00 AM","200.2"},
                    {"17","Brno","Engineering","Julio Burdge","09/1/11 12:00 AM","159.01"},
                    {"18","Brno","Engineering","Julio Burdge","08/22/11 12:00 AM","300"},
                    {"19","Brno","Engineering","Julio Burdge","07/23/11 12:00 AM","800.24"},
                    {"20","Brno","Sales","Neva Hunger","06/11/11 12:00 AM","995.3"},
                    {"21","Brno","Sales","Neva Hunger","06/11/11 12:00 AM","234.3"},
                    {"22","Westford","Engineering","Kathrine Janas","05/17/11 12:00 AM","233.49"},
                    {"23","Westford","Engineering","Kathrine Janas","04/12/11 12:00 AM","1.1"},
                    {"24","Westford","Engineering","Kathrine Janas","03/13/11 12:00 AM","1.402"},
                    {"25","Westford","Engineering","Kathrine Janas","02/13/11 12:00 AM","490.1"},
                    {"26","Westford","Engineering","Kathrine Janas","02/9/11 12:00 AM","600.34"},
                    {"27","Westford","Sales","Jerri Preble","12/23/10 12:00 AM","899.03"},
                    {"28","Westford","Sales","Jerri Preble","11/30/10 12:00 AM","343.45"},
                    {"29","Westford","Management","Donald M. Stanton","10/29/10 12:00 AM","983.03"},
                    {"30","Westford","Management","Donald M. Stanton","10/11/10 12:00 AM","43.03"},
                    {"31","Raleigh","Management","Hannah B. Mackey","09/1/10 12:00 AM","234.34"},
                    {"32","Raleigh","Management","Hannah B. Mackey","07/2/10 12:00 AM","543.45"},
                    {"33","Raleigh","Management","Hannah B. Mackey","06/2/10 12:00 AM","193.45"},
                    {"34","Raleigh","Management","Loretta R. Havens","05/3/10 12:00 AM","992.2"},
                    {"35","Raleigh","Management","Loretta R. Havens","04/23/10 12:00 AM","494.4"},
                    {"36","Raleigh","Engineering","Tony L. Crawford","02/18/10 12:00 AM","233.09"},
                    {"37","Raleigh","Engineering","Tony L. Crawford","02/22/10 12:00 AM","293.49"},
                    {"38","Raleigh","Engineering","Tony L. Crawford","12/23/09 12:00 AM","401.4"},
                    {"39","Raleigh","Engineering","Tony L. Crawford","07/19/09 12:00 AM","209.55"},
                    {"40","Raleigh","Support","Eileen L. Pereira","06/12/09 12:00 AM","300.01"},
                    {"41","Raleigh","Support","Eileen L. Pereira","06/13/09 12:00 AM","450.6"},
                    {"42","Raleigh","Support","Eileen L. Pereira","06/14/09 12:00 AM","320.9"},
                    {"43","Raleigh","Support","Eileen L. Pereira","06/15/09 12:00 AM","303.9"},
                    {"44","London","Engineering","Alan P. Adamson","06/12/09 12:00 AM","404.3"},
                    {"45","London","Engineering","Alan P. Adamson","05/12/09 12:00 AM","868.45"},
                    {"46","London","Engineering","Alan P. Adamson","05/13/09 12:00 AM","333.45"},
                    {"47","London","Management","Patricia J. Behr","04/14/09 12:00 AM","565.56"},
                    {"48","London","Management","Patricia J. Behr","03/2/09 12:00 AM","345.45"},
                    {"49","London","Management","Patricia J. Behr","02/3/09 12:00 AM","700.66"},
                    {"50","London","Management","Patricia J. Behr","01/4/09 12:00 AM","921.9"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_64011223773089901() throws Exception {
        KPI kpi = getKPIByCode("kpi_64011223773089901");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"January 2009","921.9"},
                    {"February 2009","700.66"},
                    {"March 2009","345.45"},
                    {"April 2009","565.56"},
                    {"May 2009","1,201.9"},
                    {"June 2009","1,779.71"},
                    {"July 2009","209.55"},
                    {"August 2009","0"},
                    {"September 2009","0"},
                    {"October 2009","0"},
                    {"November 2009","0"},
                    {"December 2009","401.4"},
                    {"January 2010","0"},
                    {"February 2010","526.58"},
                    {"March 2010","0"},
                    {"April 2010","494.4"},
                    {"May 2010","992.2"},
                    {"June 2010","193.45"},
                    {"July 2010","543.45"},
                    {"August 2010","0"},
                    {"September 2010","234.34"},
                    {"October 2010","1,026.06"},
                    {"November 2010","343.45"},
                    {"December 2010","899.03"},
                    {"January 2011","0"},
                    {"February 2011","1,090.44"},
                    {"March 2011","1.402"},
                    {"April 2011","1.1"},
                    {"May 2011","233.49"},
                    {"June 2011","1,229.6"},
                    {"July 2011","800.24"},
                    {"August 2011","300"},
                    {"September 2011","159.01"},
                    {"October 2011","0"},
                    {"November 2011","200.2"},
                    {"December 2011","0"},
                    {"January 2012","1,402.3"},
                    {"February 2012","567.89"},
                    {"March 2012","665.7"},
                    {"April 2012","0"},
                    {"May 2012","75.75"},
                    {"June 2012","911.11"},
                    {"July 2012","800.8"},
                    {"August 2012","152.25"},
                    {"September 2012","300"},
                    {"October 2012","340.34"},
                    {"November 2012","900.1"},
                    {"December 2012","1,220.45"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30301353506280659() throws Exception {
        KPI kpi = getKPIByCode("kpi_30301353506280659");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Apr 2010","42,485,847.012"},
                    {"Jul 2010","51,622,861.461"},
                    {"Oct 2010","59,985,255.528"},
                    {"Jan 2011","48,658,783.972"},
                    {"Apr 2011","52,079,924.319"},
                    {"Jul 2011","55,270,895.043"},
                    {"Oct 2011","44,231,566.894"},
                    {"Jan 2012","49,108,590.261"},
                    {"Apr 2012","51,437,088.287"},
                    {"Jul 2012","43,640,397.533"},
                    {"Oct 2012","43,540,520.762"},
                    {"Jan 2013","57,330,014.521"},
                    {"Apr 2013","48,398,318.716"},
                    {"Jul 2013","45,819,149.797"},
                    {"Oct 2013","44,942,957.051"},
                    {"Jan 2014","56,941,978.584"},
                    {"Apr 2014","48,064,010.139"},
                    {"Jul 2014","50,072,135.677"},
                    {"Oct 2014","49,529,848.74"},
                    {"Jan 2015","46,840,850.458"},
                    {"Apr 2015","12,525,643.728"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30361353506582145() throws Exception {
        KPI kpi = getKPIByCode("kpi_30361353506582145");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"WIN","2,467,342.049"},
                    {"VERBAL COMMITMENT","2,704,337.45"},
                    {"STANDBY","2,692,343.835"},
                    {"SHORT LISTED","2,720,890.442"},
                    {"QUALIFIED","2,614,849.549"},
                    {"LOST","2,614,342.545"},
                    {"DEMO","2,336,241.648"},
                    {"CONTACTED","2,454,224.894"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30651353683614640() throws Exception {
        KPI kpi = getKPIByCode("kpi_30651353683614640");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Darryl Innes","2,669,089.546"},
                    {"Nita Marling","2,342,011.583"},
                    {"Roxie Foraker","2,659,589.977"},
                    {"Neva Hunger","2,485,446.724"},
                    {"Jamie Gilbeau","2,617,395.494"},
                    {"Jerri Preble","2,521,398.184"},
                    {"Kathrine Janas","2,435,833.788"},
                    {"Julio Burdge","2,873,807.116"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30331353506453066() throws Exception {
        KPI kpi = getKPIByCode("kpi_30331353506453066");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Roxie Foraker","2,659,589.977"},
                    {"Nita Marling","2,342,011.583"},
                    {"Neva Hunger","2,485,446.724"},
                    {"Kathrine Janas","2,435,833.788"},
                    {"Julio Burdge","2,873,807.116"},
                    {"Jerri Preble","2,521,398.184"},
                    {"Jamie Gilbeau","2,617,395.494"},
                    {"Darryl Innes","2,669,089.546"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30831353686700387() throws Exception {
        KPI kpi = getKPIByCode("kpi_30831353686700387");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"PRODUCT 8","4,114,026.669"},
                    {"PRODUCT 6","2,079,768.984"},
                    {"PRODUCT 1","1,987,832.383"},
                    {"PRODUCT 3","1,925,443.347"},
                    {"PRODUCT 4","1,857,255.82"},
                    {"PRODUCT 10","1,854,040.865"},
                    {"PRODUCT 7","1,824,624.363"},
                    {"PRODUCT 11","1,758,737.539"},
                    {"PRODUCT 2","1,614,398.311"},
                    {"PRODUCT 5","1,588,444.131"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30391353506887646() throws Exception {
        KPI kpi = getKPIByCode("kpi_30391353506887646");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"PRODUCT 8","4,114,026.669"},
                    {"PRODUCT 6","2,079,768.984"},
                    {"PRODUCT 1","1,987,832.383"},
                    {"PRODUCT 3","1,925,443.347"},
                    {"PRODUCT 4","1,857,255.82"},
                    {"PRODUCT 10","1,854,040.865"},
                    {"PRODUCT 7","1,824,624.363"},
                    {"PRODUCT 11","1,758,737.539"},
                    {"PRODUCT 2","1,614,398.311"},
                    {"PRODUCT 5","1,588,444.131"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30801353685378049() throws Exception {
        KPI kpi = getKPIByCode("kpi_30801353685378049");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Company 3","330"},
                    {"Company 6","185"},
                    {"Company 8","172"},
                    {"Company 2","180"},
                    {"Company 7","190"},
                    {"Company 9","184"},
                    {"Company 4","188"},
                    {"Company 5","181"},
                    {"Company 1","190"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30281353675541472() throws Exception {
        KPI kpi = getKPIByCode("kpi_30281353675541472");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Poland","1,011,402.476"},
                    {"Norway","1,007,179.203"},
                    {"Australia","961,801.729"},
                    {"Brazil","950,466.685"},
                    {"Saudi Arabia","918,329.541"},
                    {"Indonesia","906,457.066"},
                    {"Japan","905,540.505"},
                    {"Spain","903,722.52"},
                    {"Canada","878,924.004"},
                    {"United Kingdom","859,565.719"},
                    {"United States","847,462.911"},
                    {"Sweden","845,247.182"},
                    {"Mexico","828,073.852"},
                    {"Belgium","827,838.829"},
                    {"Netherlands","826,297.502"},
                    {"China","823,189.266"},
                    {"Germany","811,042.786"},
                    {"Switzerland","809,276.535"},
                    {"Italy","808,096.313"},
                    {"Turkey","801,689.898"},
                    {"India","788,623.434"},
                    {"South Korea","784,776.095"},
                    {"France","767,410.705"},
                    {"Russia","732,157.656"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_21591363786594721() throws Exception {
        KPI kpi = getKPIByCode("kpi_21591363786594721");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"VERBAL COMMITMENT","2,704,337.45"},
                    {"LOST","2,614,342.545"},
                    {"STANDBY","2,692,343.835"},
                    {"QUALIFIED","2,614,849.549"},
                    {"CONTACTED","2,454,224.894"},
                    {"WIN","2,467,342.049"},
                    {"SHORT LISTED","2,720,890.442"},
                    {"DEMO","2,336,241.648"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30861353687605533() throws Exception {
        KPI kpi = getKPIByCode("kpi_30861353687605533");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"0","2,057,056.508"},
                    {"10","2,375,578.04"},
                    {"20","2,008,834.675"},
                    {"30","2,176,257.697"},
                    {"40","2,207,890.542"},
                    {"50","2,091,138.732"},
                    {"60","1,820,731.107"},
                    {"70","2,066,648.416"},
                    {"80","1,842,871.528"},
                    {"90","1,957,565.167"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_63931223772633377() throws Exception {
        KPI kpi = getKPIByCode("kpi_63931223772633377");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Engineering","7,650.162"},
                    {"Management","6,017.47"},
                    {"Support","3,345.6"},
                    {"Sales","3,213.53"},
                    {"Services","2,504.5"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_63901223772516707() throws Exception {
        KPI kpi = getKPIByCode("kpi_63901223772516707");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Barcelona","2,913.14"},
                    {"Madrid","2,453.36"},
                    {"Brno","4,659.24"},
                    {"Westford","3,594.972"},
                    {"Raleigh","4,970.78"},
                    {"London","4,139.77"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30461354643057084() throws Exception {
        KPI kpi = getKPIByCode("kpi_30461354643057084");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Roxie Foraker","3,832.46"},
                    {"Patricia J. Behr","2,533.57"},
                    {"Darryl Innes","1,970.19"},
                    {"Alan P. Adamson","1,606.2"},
                    {"Loretta R. Havens","1,486.6"},
                    {"Julio Burdge","1,459.45"},
                    {"Eileen L. Pereira","1,375.41"},
                    {"Kathrine Janas","1,326.432"},
                    {"Jerri Preble","1,242.48"},
                    {"Neva Hunger","1,229.6"},
                    {"Tony L. Crawford","1,137.53"},
                    {"Donald M. Stanton","1,026.06"},
                    {"Hannah B. Mackey","971.24"},
                    {"Jamie Gilbeau","792.59"},
                    {"Nita Marling","741.45"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30441353507392054() throws Exception {
        KPI kpi = getKPIByCode("kpi_30441353507392054");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"2010","2,906,030.224"},
                    {"2011","4,122,965.423"},
                    {"2012","4,075,631.39"},
                    {"2013","4,095,320.587"},
                    {"2014","4,197,797.742"},
                    {"2015","1,206,827.046"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30101353505177974() throws Exception {
        KPI kpi = getKPIByCode("kpi_30101353505177974");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"United States","74"},
                    {"United Kingdom","77"},
                    {"Turkey","67"},
                    {"Switzerland","71"},
                    {"Sweden","73"},
                    {"Spain","80"},
                    {"South Korea","69"},
                    {"Saudi Arabia","83"},
                    {"Russia","67"},
                    {"Poland","88"},
                    {"Australia, China, Netherlands, Canada, Mexico, Japan, Germany, Italy, France, Norway, India, Belgium, Indonesia, Brazil","1,051"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30041353504912610() throws Exception {
        KPI kpi = getKPIByCode("kpi_30041353504912610");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"Julio Burdge","2,873,807.116"},
                    {"Darryl Innes","2,669,089.546"},
                    {"Roxie Foraker","2,659,589.977"},
                    {"Jamie Gilbeau","2,617,395.494"},
                    {"Jerri Preble","2,521,398.184"},
                    {"Neva Hunger","2,485,446.724"},
                    {"Kathrine Janas","2,435,833.788"},
                    {"Nita Marling","2,342,011.583"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30011353503663716() throws Exception {
        KPI kpi = getKPIByCode("kpi_30011353503663716");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"WIN","2,467,342.049"},
                    {"VERBAL COMMITMENT","2,704,337.45"},
                    {"STANDBY","2,692,343.835"},
                    {"SHORT LISTED","2,720,890.442"},
                    {"QUALIFIED","2,614,849.549"},
                    {"LOST","2,614,342.545"},
                    {"DEMO","2,336,241.648"},
                    {"CONTACTED","2,454,224.894"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30251353675275870() throws Exception {
        KPI kpi = getKPIByCode("kpi_30251353675275870");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"EARLY","7,524,909.475"},
                    {"STANDBY","6,654,928.048"},
                    {"ADVANCED","6,424,734.889"}}, 0);
        }
    }

    @Test // Auto-generated by KPITestMethodGenerator
    public void test_kpi_30621353683547916() throws Exception {
        KPI kpi = getKPIByCode("kpi_30621353683547916");
        DataSet dataSet = KPIHelper.getDataSet(kpi);
        if  (dataSet != null) {
            assertDataSetValues(dataSet, new String[][] {
                    {"April 2010","126,866.671"},
                    {"May 2010","352,234.947"},
                    {"June 2010","349,034.448"},
                    {"July 2010","376,779.234"},
                    {"August 2010","341,209.097"},
                    {"September 2010","317,595.285"},
                    {"October 2010","369,454.783"},
                    {"November 2010","326,903.462"},
                    {"December 2010","345,952.297"},
                    {"January 2011","348,570.135"},
                    {"February 2011","332,314.024"},
                    {"March 2011","284,034.893"},
                    {"April 2011","361,406.875"},
                    {"May 2011","396,205.688"},
                    {"June 2011","309,378.078"},
                    {"July 2011","322,607.235"},
                    {"August 2011","461,746.201"},
                    {"September 2011","300,624.94"},
                    {"October 2011","398,914.587"},
                    {"November 2011","293,237.494"},
                    {"December 2011","313,925.273"},
                    {"January 2012","422,129.357"},
                    {"February 2012","240,392.074"},
                    {"March 2012","368,414.401"},
                    {"April 2012","336,818.744"},
                    {"May 2012","301,270.713"},
                    {"June 2012","418,759.822"},
                    {"July 2012","332,081.983"},
                    {"August 2012","378,888.15"},
                    {"September 2012","402,316.63"},
                    {"October 2012","237,092.592"},
                    {"November 2012","336,182.565"},
                    {"December 2012","301,284.359"},
                    {"January 2013","397,168.056"},
                    {"February 2013","275,754.693"},
                    {"March 2013","487,646.289"},
                    {"April 2013","230,331.631"},
                    {"May 2013","377,866.493"},
                    {"June 2013","291,110.385"},
                    {"July 2013","361,629.658"},
                    {"August 2013","374,968.674"},
                    {"September 2013","349,077.354"},
                    {"October 2013","267,205.063"},
                    {"November 2013","433,072.572"},
                    {"December 2013","249,489.719"},
                    {"January 2014","427,978.692"},
                    {"February 2014","360,425.82"},
                    {"March 2014","320,944.61"},
                    {"April 2014","321,963.865"},
                    {"May 2014","313,164.115"},
                    {"June 2014","435,288.952"},
                    {"July 2014","295,268.088"},
                    {"August 2014","419,251.194"},
                    {"September 2014","286,614.442"},
                    {"October 2014","333,842.023"},
                    {"November 2014","328,271.065"},
                    {"December 2014","354,784.876"},
                    {"January 2015","332,981.786"},
                    {"February 2015","292,202.732"},
                    {"March 2015","358,183.052"},
                    {"April 2015","200,266.615"},
                    {"May 2015","23,192.861"}}, 0);
        }
    }
}