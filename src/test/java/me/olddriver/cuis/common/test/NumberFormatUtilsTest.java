package me.olddriver.cuis.common.test;

import me.olddriver.cuis.common.NumberFormatUtils;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-04 16:24
 * Description: NumberFormatUtils 测试类
 */
public class NumberFormatUtilsTest {

    @Test
    public void t() {

        String s = NumberFormatUtils.formatDecimalWithZero(new BigDecimal(35.8), 2);
        Assert.assertEquals("35.80", s);

        s = NumberFormatUtils.formatDecimal(33.338, 2);
        Assert.assertEquals("33.34", s);

        s = NumberFormatUtils.formatDecimal("33.3", 2);
        Assert.assertEquals("33.3", s);

        s = NumberFormatUtils.formatDecimalWithZero(33.3F);
        Assert.assertEquals("33.30", s);

        s = NumberFormatUtils.formatDecimalWithZero("33.3222", 3);
        Assert.assertEquals("33.322", s);

        Assert.assertEquals(6, NumberFormatUtils.sizeOfInt(111111));

        double d = NumberFormatUtils.formatDecimal(33.321, 2, RoundingMode.DOWN);
        Assert.assertTrue(33.32 == d);

        d = NumberFormatUtils.formatDecimal("33.321", 2, RoundingMode.DOWN);
        Assert.assertTrue(33.32 == d);
    }

}
