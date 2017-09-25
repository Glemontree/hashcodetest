package com.glemontree.hashcodetest;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
    private int areaCode = 0;
    private int prefix = 0;
    private int lineNumber = 0;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof PhoneNumber))
            return false;
        //必须满足如下条件，才能说明为同一个对象
        PhoneNumber pn = (PhoneNumber) obj;
        return pn.areaCode == areaCode && pn.prefix == prefix && pn.lineNumber == lineNumber;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>();
        PhoneNumber p1 = new PhoneNumber(707, 867, 5309);
        PhoneNumber p2 = new PhoneNumber(707, 867, 5309);
        map.put(p1, "Jerry");
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p2.equals(p1): " + p2.equals(p1));

        System.out.println("get p1 from hashmap: " + map.get(p1));
        System.out.println("get p2 from hashmap: " + map.get(p2));

        System.out.println("p1's hashcode: " + p1.hashCode());
        System.out.println("p2's hashcode: " + p2.hashCode());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }
}
