# 包装类
- 以 Integer 类为例。 自动装箱与自动拆箱：可以直接将int值赋给Integer类型，或者直接将Integer类型的值赋给int,实现自动装箱与自动拆箱。其实底层依然是依靠valueOf 和 intValue方法实现的。

# String 类的常用方法
- equals方法与compareTo 方法
```java
public final class String {
    public int compareTo(String anotherString) {
        int len1 = value.length; //与字符串数组不同，value数组中不会再最后一个位置上加空字符
        int len2 = anotherString.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }
}
```