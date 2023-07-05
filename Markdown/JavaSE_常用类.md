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
- String 内存分析
  - 直接拼接：不会在堆里开创空间，栈中的变量名直接存储方法区里字符串常量池里的字符串常量地址。
  - 使用new关键字创建String 对象时会在堆里开辟一个String 类型的对象空间，其中它的Value属性指向字符串常量池中的字符串。
  - <img src="C:\Users\qzb20\IdeaProjects\JAVALearning\Markdown\Figure\字符串拼接.png" style="zoom:50%;" />
  - <img src="C:\Users\qzb20\IdeaProjects\JAVALearning\Markdown\Figure\内存空间.png" style="zoom: 33%;" />
  - 
  - 有变量参与的字符串拼接：在编译时不知道a的具体值，因此无法进行字符串优化，实际上会调用`StringBuilder()`方法
```java
class Test(){
    String a = "123";  
    String s = a + "456";
}
```
- StringBuilder类
  - `public final class StringBuilder`，表示不可以被继承；**空构造器**实际上是对底层value数组初始化，长度为16
  - 其父类为：`abstract class AbstractStringBuilder`成员变量： ` char[] value; int count`;