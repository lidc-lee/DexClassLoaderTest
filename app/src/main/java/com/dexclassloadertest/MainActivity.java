package com.dexclassloadertest;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.classloader.interfaces.MainInterface;

import java.io.File;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test(this);
    }

    private void test(Context context) {
        try {
            //jar存放的目录
            File sourceFile = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "output.jar");
            //dex解压后的目录
            File file = context.getDir("dex", 0);
            //把dex加载到虚拟机
            DexClassLoader classLoader = new DexClassLoader(sourceFile.getAbsolutePath(),
                    file.getAbsolutePath(), null, context.getClassLoader());
            Class<?> clazz = classLoader.loadClass("com.classloader.MainIm");
            MainInterface mainIm = (MainInterface) clazz.newInstance();
            Log.e("MainInterface",mainIm.sayHello());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
