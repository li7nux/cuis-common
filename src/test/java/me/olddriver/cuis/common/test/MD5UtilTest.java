package me.olddriver.cuis.common.test;

import me.olddriver.cuis.common.MD5Util;
import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-03 15:08
 * Description: MD5 工具类测试类
 */
public class MD5UtilTest {

    @Test
    public void encryptTest() throws NoSuchAlgorithmException {
        Assert.assertEquals(MD5Util.encrypt("12345").toUpperCase(), "827CCB0EEA8A706C4C34A16891F84E7B");
    }

}
