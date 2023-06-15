package com.qzb.set;

public class TestSet <A> implements CompareTo<Student>{
    A a;

    public void setA(A a) {
        this.a = a;
    }

    public TestSet() {
    }

    public static <B> void TestSetTo(B a) {
        System.out.println("123");
    }

    @Override
    public int compare(Student a, Student b) {
        return 0;
    }

}
