package me.olddriver.cuis.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2017-12-29 16:44
 * Description: 基于 Jackson 的 Json 转换工具类
 */
public class JsonUtils {

    private static final ObjectMapper OM = new ObjectMapper();

    static {
        // 反序列化忽略未知属性. 禁用遇到未知属性抛出异常
        OM.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 低层级配置
        OM.enable(JsonParser.Feature.ALLOW_COMMENTS);
        // 允许属性名称没有引号
        OM.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        // 允许单引号
        OM.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        // 对于空的对象转json的时候不抛出错误
        OM.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 解析器支持解析结束符
        OM.enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
        // 禁止转成 timestamps 形式
        OM.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 所有日期格式都统一为固定格式
        OM.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 将对象转化为 List 泛型对象
     *
     * @param obj   待转换的对象
     * @param clazz 目标泛型对象类型
     * @return 转换后的 List 对象
     */
    public static <T> List<T> toList(Object obj, Class<T> clazz) {
        try {
            JavaType javaType = OM.getTypeFactory().constructParametricType(List.class, clazz);

            if (obj instanceof String) {
                return OM.readValue((String) obj, javaType);
            } else if (obj instanceof JsonNode) {
                return OM.readValue(obj.toString(), javaType);
            } else {
                return OM.readValue(OM.writeValueAsString(obj), javaType);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 转成对象
     *
     * @param obj   待转换的对象
     * @param clazz 目标对象
     * @return 转换后的对象
     */
    public static <E> E toObject(Object obj, Class<E> clazz) {
        try {
            if (obj instanceof String) {
                if (clazz == String.class) {
                    return (E) obj;
                } else {
                    return OM.readValue((String) obj, clazz);
                }
            } else if (obj instanceof JsonNode) {
                return OM.readValue(obj.toString(), clazz);
            } else {
                return OM.readValue(OM.writeValueAsString(obj), clazz);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Java 对象转成 Json 字符串
     *
     * @param obj Java对象
     * @return Json字符串
     * @throws RuntimeException
     */
    public static String toJsonString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else {
            try {
                return OM.writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Java 对象转成 JsonNode
     *
     * @param obj Java对象
     * @return JsonNode
     * @throws RuntimeException
     */
    public static JsonNode toJson(Object obj) {
        if (obj instanceof String) {
            try {
                return OM.readTree((String) obj);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return OM.valueToTree(obj);
        }
    }

}
