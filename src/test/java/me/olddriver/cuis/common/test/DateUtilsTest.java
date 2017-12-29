package me.olddriver.cuis.common.test;

import me.olddriver.cuis.common.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2017-12-29 15:12
 * Description: DateUtils 测试类
 */
public class DateUtilsTest {

    private static final String CURR_DATE_STR = "201712291512";

    @Test
    public void createDateTest() {
        Date date = DateUtils.createDate(2017, 12, 29, 15, 30, 0);
        Assert.assertNotNull(date);
    }

    @Test
    public void parseDateTest() {
        Date date = DateUtils.createDate(2017, 12, 29, 15, 30, 0);
        Date parsedDate = DateUtils.parseDate("20171229153000", DateUtils.sf);
        Assert.assertEquals(date, parsedDate);
    }

    @Test
    public void formatDateTest() {
        Date date = DateUtils.createDate(2017, 12, 29, 15, 30, 0);
        String dateStr = DateUtils.formatDate(date, DateUtils.sf);
        Assert.assertEquals(dateStr, "20171229153000");

        dateStr = DateUtils.formatDate(date.getTime(), DateUtils.sf);
        Assert.assertEquals(dateStr, "20171229153000");

    }

    @Test
    public void addDayTest() {
        String afterAdd = DateUtils.formatDate(
                DateUtils.addDays(
                        DateUtils.parseDate(CURR_DATE_STR, DateUtils.mf), -1), DateUtils.df);
        Assert.assertEquals(afterAdd, "20171228");
    }

    @Test
    public void addMonthTest() {
        String afterAdd = DateUtils.formatDate(
                DateUtils.addMonths(
                        DateUtils.parseDate(CURR_DATE_STR, DateUtils.mf), -1), DateUtils.Mf);
        Assert.assertEquals(afterAdd, "201711");
    }

    @Test
    public void t(){
        DateUtils.formatDate(new Date(), DateUtils.sf);
        DateUtils.parseDate("20171229", DateUtils.df);
    }

}
