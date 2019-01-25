# JUC包分析[jdk1.8]
## atomic package
    该包下有12个普通类和4个抽象类
    按更新种类分，可以分4种，分别是原子更新基本类型、原子更新数组、原子更新引用、原子更新字段；
    抽象类(*Updater)，它实现了一个私有静态内部类继承该抽象类，并实现了所有的抽象方法，该抽象类同时
    提供了一个静态工厂方法；
    抽象类Striped64是用于改善并发性能的，里面有个Cell数组，当并发竞争时，会把不同现场的值分布到数组上，从而达到
    锁分段的效果，从而改善并发性能
    atomic包下类的原子功能实现，基本都是通过Unsafe类里面的compareAndSwapObject、compareAndSwapInt、compareAndSwapLong
    本地方法实现
        
    基本类型
    AtomicBoolean 
    AtomicInteger 
    AtomicLong
    
    数组
    AtomicIntegerArray
    AtomicLongArray
    
    字段
    AtomicIntegerFieldUpdater 抽象类
    AtomicLongFieldUpdater 抽象类
    
    引用
    AtomicReference
    AtomicReferenceArray
    AtomicMarkableReference Pair模式，比对时，看boolean标记进行比对，消除ABA问题
    AtomicReferenceFieldUpdater 抽象类
    AtomicStampedReference Pair模式，比对时，带上int版本号进行比对，消除ABA问题
    
    改善并发特性抽象类
    Striped64 抽象类
    
    累加器（计算器）
    DoubleAccumulator
    LongAccumulator
    
    DoubleAccumulator/LongAccumulator的特例情况（只做累加）
    DoubleAdder
    LongAdder
    
## locks package
   - 抽象类<br>
   AbstractOwnableSynchronizer
   AbstractQueueLongSynchronizer
   AbstractQueueSynchronizer
   
   - 接口<br>
   Lock 需要注意的是,Lock.lock阻塞过程中不响应中断，Lock.lockInterruptibly在阻塞过程中相应中断
   ReadWriteLock 可以理解为对Lock的一个扩展接口，细分读锁和写锁
   Condition Lock.newConditin出来的调节，相关阻塞队列可以在相应的条件上进行阻塞和唤醒
   
   - 普通类<br>
   LockSupport
   ReentrantLock
   ReentrantReadWriteLock
   StampedLock
   
## 队列 并发集合等

## 并发涉及知识点
- 并发编程下的ABA是什么问题？<br>
  假设有两个线程Thread1和Thread2，Thread1计划更新一个变量v1，Thread1计划把变量v1修改为v2,此时
  Thread2先获得了执行权，也计划更新v1,把v更改为v3,再把v3更改为v1,Thread2执行完成后，Thread1执行,
  Thread1是不知道v1期间是被动过的,并能更新成功，此时就出现了ABA问题
- Unsafe是什么问题？<br>
  是一个本地类，用来操作内存相关操作
  Unsafe类使Java拥有了像C语言的指针一样操作内存空间的能力，同时也会带来指针的问题