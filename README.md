# DexClassLoaderTest

### 动态类转载器DexClassLoader

 **ClassLoader**--类加载器，它的作用就是动态的装载Class文件。
 
 与import的区别：
 使用import关键字引用的类有2个条件：
 1.类文件必须在地
 2.编译时必须有这个类文件，否则编译不通过
 如果要让序运行的时候动态调用，使用import是不符合， 所以我们需要使用classloader
 对于android来说，DexClassLoader--就是用标准的java编译出class文件，再把class打包成dex文件，这种使得各种函数表等得到了优化。
 即dex文件是一种经过android打包工具优化的Class文件。

**流程**
1.创建工程，导出jar包
2.进入DOS，定位到android sdk下的built_tool下，输入dx.bat --dex  --output=output.jar C:\Users\AA\Desktop\settings.jar
3.把输出的output.jar push 到手机上
