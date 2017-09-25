# hashcodetest
这个例子说明了为什么覆盖equals方法时需要覆盖hashCode方法

## 什么是hashCode方法？
- hashCode方法返回对象的哈希码值
- 在应用程序的执行期间，只要对象的equals方法的比较操作所用到的信息没有改变，那么对于这同一个对象调用多次，hashCode方法都必须返回同一个整数
- hashcode主要用于查找的快捷性，如Hashtable、HashMap等，hashcode是用来在散列存储结构中确定对象的存储地址的

## hashcode相等与对象相等之间的关系？
- 如果两个对象相等，那么两个对象的hashcode也必须相等
- 如果两个对象的hashcode相等，并不一定表示两个对象就相同，也就是不一定适合equals方法，只能够说明这两个对象在散列表存储结构中，存放在同一个篮子里

## 为什么覆盖equals方法时总要覆盖hashCode方法？
这主要是因为如果在覆盖equals方法时不覆盖hashCode方法，那么相等的对象的hashcode值可能会不一样。

## 如何在覆盖equals方法时覆盖hashCode方法？
只需要覆盖hashCode方法，返回一个适当的hashcode即可。

## 如何设置一个好的散列函数？
- 为对象计算int类型的散列码c:
  - 对于boolean类型，计算(f?1:0)
  - 对于byte,char,short,int类型，则计算(int)f
  - 对于long类型，计算(int)(f^(f>>>32))
  - 对于float类型，计算Float.floatToIntBits(f)
  - 对于Double类型，计算Double.doubleToLongBits(f)，然后再按照long类型处理
  - 对于对象引用，并且该类的equals方法通过递归地调用equals的方式来比较这个域，则同样为这个域递归地调用hashcode
  - 对于数组，则把每一个元素当作单独的域来处理。
-  将获取到的c合并：result = 31 * reuslt + c;
- 返回result

## 说明
本文转自[覆盖equals时总要覆盖hashCode](http://www.jianshu.com/p/40ee40f155aa)
