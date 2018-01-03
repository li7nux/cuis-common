package me.olddriver.cuis.common.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import me.olddriver.cuis.common.JsonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-03 15:12
 * Description: JsonUtils 测试类
 */
public class JsonUtilsTest {

    @Test
    public void toJsonTest() {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode sourceJson = objectMapper.createObjectNode().put("id", "123").put("name", "name123");

        CommonTestVO vo = new CommonTestVO("123", "name123");
        JsonNode distJson = JsonUtils.toJson(vo);

        Assert.assertEquals(sourceJson, distJson);
    }

    @Test
    public void toObjectTest() {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode sourceJson = objectMapper.createObjectNode().put("id", "123").put("name", "name123");
        CommonTestVO sourceVO = JsonUtils.toObject(sourceJson, CommonTestVO.class);

        CommonTestVO vo = new CommonTestVO("123", "name123");

        Assert.assertEquals(vo.getId(), sourceVO.getId());
        Assert.assertEquals(vo.getName(), sourceVO.getName());
    }

    @Test
    public void toJsonStringTest() {

        String sourceString = "{\"id\":\"123\",\"name\":\"name123\"}";

        CommonTestVO vo = new CommonTestVO("123", "name123");

        Assert.assertEquals(sourceString, JsonUtils.toJsonString(vo));

    }

    @Test
    public void toListTest() {

        String sourceString = "[{\"id\":\"123\",\"name\":\"name123\"}]";

        List<CommonTestVO> voList = JsonUtils.toList(sourceString, CommonTestVO.class);
        CommonTestVO vo = voList.get(0);

        Assert.assertEquals("name123", vo.getName());
        Assert.assertEquals("123", vo.getId());

    }

}