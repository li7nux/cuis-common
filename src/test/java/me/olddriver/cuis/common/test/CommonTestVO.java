package me.olddriver.cuis.common.test;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-03 16:12
 * Description: 测试对象
 */
public class CommonTestVO {

    private String id;
    private String name;

    public CommonTestVO() {
    }

    public CommonTestVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
