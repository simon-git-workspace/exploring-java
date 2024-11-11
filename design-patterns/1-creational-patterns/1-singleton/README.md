# Singleton
1. Eager Initialization
2. Lazy Initialization
3. Enhanced Lazy Initialization with Synchronization
4. BillPugh
5. Break Singleton using Reflection API  

## Eager Initialization vs Static Block Initialization
| Feature              | Eager Initialization                               | Static Block Initialization                        |
|----------------------|----------------------------------------------------|----------------------------------------------------|
| **Exception Handling** | Not possible                                    | Possible in static block                           |
| **Memory Efficiency** | Can be inefficient if unused                     | Can be inefficient if unused                       |

## Lazy Initialization vs BillPugh
**Key Takeaway**
- The Bill Pugh Singleton approach is generally considered more robust because it combines lazy initialization with thread safety without requiring synchronization. This makes it more efficient and is often the recommended way to implement singletons in Java.

### Lazy Initialization
**Thread-Safe Version**
- Slows down performance due to the overhead of synchronization.

### BillPugh (Inbuilt lazy+thread safe)
The inner class isn’t loaded until it’s referenced, which creates the instance in a thread-safe and lazy manner without needing synchronization.

**Thread Safety**
- Thread-safe without synchronization, because class loading is handled by the JVM and is guaranteed to be thread-safe.

### Comparison

| Feature              | Lazy Singleton Initialization                    | Bill Pugh Singleton Implementation               |
|----------------------|--------------------------------------------------|--------------------------------------------------|
| **Instance Creation**| Created when `getInstance()` is called           | Created when `getInstance()` is called           |
| **Thread Safety**    | Not thread-safe (without additional sync)        | Thread-safe due to JVM’s class loading           |
| **Memory Efficiency**| Memory-efficient (created only if needed)        | Memory-efficient (created only if needed)        |
| **Performance**      | Can be slow if synchronization is added for safety| Efficient (no synchronization overhead)          |
| **Use Case**         | Suitable for simple, non-threaded environments   | Suitable for high-performance, thread-safe singletons |