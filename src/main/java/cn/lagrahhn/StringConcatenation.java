package cn.lagrahhn;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 字符串拼接示例
 */
public class StringConcatenation {
    public static void main(String[] args) {
        String[] values = {"https", "://", "www.", "wdbyte", ".com", null};
        System.out.println("字符串数组" + Arrays.toString(values));
        String result = "";
        for (String value : values) {
            result += value;
        }
        System.out.println("方式一：使用+=的方式进行拼接字符串，但是null会被拼接下来\n结果：" + result);
        result = "";
        result = String.join("", values);
        System.out.println("方式二：使用String.join('',values)进行拼接，问题仍然存在\n结果是：" + result);
        result = "";
        for (String value : values) {
            result = result + (value == null ? "" : value);
        }
        System.out.println("方式三：使用for循环进行拼接，null不会被拼接，但是涉及字符串拼接仍然不好\n结果是：" + result);
        result = "";
        for (String value : values) {
            result = result.concat(nullToString(value));
        }
        System.out.println("方式四：使用concat进行拼接，null不会被拼接\n结果是：" + result);
        result = "";
        StringBuilder builder = new StringBuilder();
        for (String value : values) {
            builder = builder.append(nullToString(value));
        }
        System.out.println("方式五：使用StringBuilder拼接：\n结果为" + builder);
        StringJoiner joiner = new StringJoiner("");
        for (String value : values) {
            joiner = joiner.add(nullToString(value));
        }
        System.out.println("方式六：使用StringJoiner拼接：\n结果为" + joiner);
        result = Arrays.stream(values)
                .filter(Objects::nonNull)
                .collect(Collectors.joining());
        System.out.println("方式七：使用stream流filter后进行拼接：\n结果为" + result);
    }

    public static String nullToString(String value) {
        return value == null ? "" : value;
    }

}
