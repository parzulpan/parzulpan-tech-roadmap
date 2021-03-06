# Java 虚拟机

对 Java 虚拟机 (Java Virtual Machine) 的一些深入学习以及笔记总结。

## 脑图

[源文件](Java-VirtualMachine.xmind)

[脑图](Java-VirtualMachine.png)

## 1.基本原理

### Java 代码是怎么运行的

#### 为什么 Java 要在虚拟机里运行？

在虚拟机运行主要有两点：

* **一次编写，到处运行**
  * JVM 可以由硬件实现，但是更为常见是在各个现有平台(Windows x64、Linux aarch64)上提供软件实现；
  * 因为这样一旦一个程序被转换为 Java 字节码，那么它便可以在不同平台上的虚拟机实现里运行。
* **包含一个托管环境**
  * 这个托管环境提供了内存管理、垃圾回收、编译时动态校验等功能；
  * 可以免于我们书写这些与业务逻辑无关的代码。

#### JVM 是具体如何运行 Java 字节码的？

JVM **内存结构** 分为 线程共享的 方法区、堆 以及 线程私有的 Java 方法栈、本地方法栈、PC 寄存器。如下图：

![JVM-JMM](https://cdn.jsdelivr.net/gh/parzulpan/static@master//img/JavaJMM_202205222014988.png)

具体的**加载顺序**为：

* 加载 Java 编辑成的 class 文件到虚拟机，加载好后放在方法区；
* 执行时需要将字节码翻译成机器码，分为 解释执行 和 即时编译 JIT 两种；
* 在运行过程中，每当调用进入一个 Java 方法，JVM 就会在当前线程的 Java 方法栈中生成一个栈帧，用于存放局部变量以及字节码的操作数。这个栈帧的大小是提前计算好的，而且 JVM 不要求栈帧在内存空间里连续分布；
* 当退出当前执行的方法时，不管是正常返回还是异常返回，JVN 均会弹出当前线程的当前栈帧，并将其舍弃。

具体的**编译过程**为：

* 在 HotSpot 里面，含有两种编译形式：
  * 第一种是解释执行，即逐条将字节码翻译成机器码并执行；
  * 第二种是即时编译 JIT，即将一个方法中包含的所有字节码编译成机器码后再执行；
  * 第一种优势在于无需等待编译，而第二种优势在于实际运行速度更快。HotSpot 默认采用混合模式，综合了解释执行和即时编译的优点，它会先解释执行字节码，然后将其中反复执行的热点代码以方法为单位进行即时编译。具体流程如下图：

![Java-CompilationProcess](https://cdn.jsdelivr.net/gh/parzulpan/static@master//img/Java-CompilationProcess_202205222028705.png)

#### JVM 的运行效率究竟是怎么样的？

理论上讲，即时编译后的 Java 程序的执行效率，是可能超过 C++ 程序的，这是因为与静态编译相比，即时编译拥有程序的运行时信息，并且能够根据这个信息做出相应的优化。

比如说，我们知道虚方法是用来实现面向对象多态性的，对于一个虚方法调用，尽管它有很多个目标方法，但在实际运行过程中它可能只调用其中的一个。这个信息便可以被即时编译器所利用，来规避虚方法调用的开销，从而达到比静态编译的 C++ 程序更好的性能。

为了满足不同用户场景的需要，HotSpot 内置了多个即时编译器：C1、C2 和 Graal。Graal 是 Java10 正式引入的实现性的即时编译器。之所以引入多个即时编译器，是为了在编译时间和生成代码的执行效率之间进行取舍。

C1 又叫做 Client 编译器，面向的是对启动性能有要求的客户端 GUI 程序，采用的优化手段相对简单，因此编译时间较短。

C2 又叫做 Server 编译器，面向的是对峰值性能有要求的服务端程序，采用的优化手段相对复杂，因此编译时间较长，但同时生成代码的执行效率较高。

从 Java7 开始，HotSpot 默认采用**分层编译**的方式：热点方法首先会被 C1 编译，而后热点方法中的热点会进一步被 C2 编译。为了不干扰应用的正常运行，HotSpot 的即时编译器是放在额外的编译线程中进行的。HotSpot 会根据 CPU 的数量设置编译线程的数目，并且按照 1:2 的比例配置给 C1 和 C2 编译器。

在计算资源充足的情况下，**字节码的解释执行和即时编译可以同时进行，编译完成后的机器码会在下次调用该方法时启用，以替换原本的解释执行**。

#### 问题和总结？

Q：JIT 程序重启之后需要再来一遍吗？

A：程序关闭后，即时编译的结果就没了，因此需要再来一遍。

---

Q：JVM 是如何区分热点代码和非热点代码的？

A：是使用“热点探测”技术统计的， HotSpot VM 使用的是基于计数器的热点探测，具体可参考[文章](https://mp.weixin.qq.com/s/GO2fAeGgaB2jIC02gWp5Aw)。

### Java 的基本类型

### JVM 是如何加载 Java 类的

### JVM 是如何执行方法调用的

### JVM 是如何处理异常的

### JVM 是如何实现反射的

### JVM 是如何实现 invoked dynamic 的

### Java 对象的内存布局

### JVM 垃圾回收

## 2.高效实现

## 3.代码优化

## 4.性能调优

## 5. 黑科技

## 6.面试总结

## 参考

* [书籍 深入理解 Java 虚拟机（第3版）](https://book.douban.com/subject/34907497/)
* [专栏 深入拆解 Java 虚拟机](https://time.geekbang.org/column/intro/100010301)
