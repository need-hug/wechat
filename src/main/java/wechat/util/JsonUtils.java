package wechat.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** json工具类
 * className: JsonUtils
 * author: peishuai.li
 * dateTime: 2019/5/21 11:14
 * version: 1.0
 */
public class JsonUtils {

    /**
     * obj转成字符串
     * @param object object
     */
    public static String obj2Str(Object object) {
        if (null == object) {
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 字符串转换成对象
     * @param str 字符串
     * @param c 转换后类型
     * @throws IOException
     */
    public static <T> T str2Obj(String str, Class<T> c) {
        if (null == str || "".equals(str)) {
            return null;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(str, c);
        } catch (IOException e) {
            return null;
        }
    }


    /**
     * 根据json字符串返回 className类型的list集合
     * @param json
     * @param className
     * @return
     * @throws IOException
     */
    public static List<?> getListByJson(String json, Class<?> className) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = getCollectionType(objectMapper, ArrayList.class, className);
        List<?> list = objectMapper.readValue(json, javaType);
        return list;
    }

    /**
     * 获取泛型的Collection Type
     * @param collectionClass 泛型的Collection
     * @param elementClasses 元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    private static JavaType getCollectionType(ObjectMapper objectMapper, Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}
