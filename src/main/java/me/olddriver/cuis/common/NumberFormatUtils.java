package me.olddriver.cuis.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-04 14:24
 * Description: 数字格式化工具类
 */
public class NumberFormatUtils {

    private static final int DEFAULT_SCALE = 2;

    /**
     * 按四舍五入保留指定小数位数，位数不够用 0 补充
     *
     * @param obj   格式化前的小数
     * @param scale 保留小数位数
     * @return 格式化后的小数
     */
    public static String formatDecimalWithZero(Object obj, int scale) {
        return String.format("%." + scale + "f", obj);
    }

    /**
     * 按四舍五入保留指定小数位数，位数不够用0补充
     *
     * @param input 格式化前的小数
     * @param scale 保留小数位数
     * @return 格式化后的小数
     */
    public static String formatDecimalWithZero(double input, int scale) {
        StringBuilder pattern = new StringBuilder("0.");
        for (int i = 0; i < scale; i++) {
            pattern.append("0");
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        return df.format(input);
    }

    /**
     * 按四舍五入保留指定小数位数，位数不够用0补充
     *
     * @param input 格式化前的小数
     * @param scale 保留小数位数
     * @return 格式化后的小数
     */
    public static String formatDecimalWithZero(float input, int scale) {
        BigDecimal b = new BigDecimal(Float.toString(input));
        return formatDecimalWithZero(b.doubleValue(), scale);
    }

    /**
     * 按四舍五入保留指定 2 位小数，位数不够用 0 补充
     *
     * @param input 格式化前的小数
     * @return 格式化后的小数
     */
    public static String formatDecimalWithZero(float input) {
        return formatDecimalWithZero(input, DEFAULT_SCALE);
    }

    /**
     * 按四舍五入保留指定小数位数，位数不够用 0 补充
     *
     * @param input 格式化前的小数 String 形式
     * @param scale 保留小数位数
     * @return 格式化后的小数
     */
    public static String formatDecimalWithZero(String input, int scale) {
        return formatDecimalWithZero(Double.valueOf(input), scale);
    }

    /**
     * 按四舍五入保留指定小数位数，不补 0
     *
     * @param input 格式化前的小数
     * @param scale 保留小数位数
     * @return 格式化后的小数
     */
    public static String formatDecimal(double input, int scale) {
        StringBuilder pattern = new StringBuilder("#.");
        for (int i = 0; i < scale; i++) {
            pattern.append("#");
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        return df.format(input);
    }

    /**
     * 按四舍五入保留指定小数位数，不补 0
     *
     * @param input 格式化前的小数
     * @param scale 保留小数位数
     * @return 格式化后的小数
     */
    public static String formatDecimal(String input, int scale) {
        return formatDecimal(Double.valueOf(input), scale);
    }

    /**
     * 按指定舍入模式保留指定小数位数
     *
     * @param input        格式化前的小数
     * @param scale        保留小数位数
     * @param roundingMode 舍入模式
     *                     RoundingMode.UP          始终进一
     *                     RoundingMode.DOWN        直接舍弃
     *                     RoundingMode.CEILING     正进负舍
     *                     RoundingMode.FLOOR       正舍负进
     *                     RoundingMode.HALF_UP     四舍五入
     *                     RoundingMode.HALF_DOWN   五舍六进
     *                     RoundingMode.HALF_EVEN   银行家舍入法
     *                     RoundingMode.UNNECESSARY 抛出异常
     * @return 格式化后的小数
     */
    public static double formatDecimal(double input, int scale, RoundingMode roundingMode) {
        BigDecimal bd = new BigDecimal(input).setScale(scale, roundingMode);
        return bd.doubleValue();
    }

    /**
     * 按指定舍入模式保留指定小数位数
     *
     * @param input        格式化前的小数
     * @param scale        保留小数位数
     * @param roundingMode 舍入模式
     *                     RoundingMode.UP          始终进一
     *                     RoundingMode.DOWN        直接舍弃
     *                     RoundingMode.CEILING     正进负舍
     *                     RoundingMode.FLOOR       正舍负进
     *                     RoundingMode.HALF_UP     四舍五入
     *                     RoundingMode.HALF_DOWN   五舍六进
     *                     RoundingMode.HALF_EVEN   银行家舍入法
     *                     RoundingMode.UNNECESSARY 抛出异常
     * @return 格式化后的小数
     */
    public static double formatDecimal(String input, int scale, RoundingMode roundingMode) {
        BigDecimal bd = new BigDecimal(Double.valueOf(input)).setScale(scale, roundingMode);
        return bd.doubleValue();
    }

    private final static int[] SIZE_TABLE = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    public static int sizeOfInt(int x) {
        for (int i = 0; ; i++) {
            if (x <= SIZE_TABLE[i]) {
                return i + 1;
            }
        }
    }

}
