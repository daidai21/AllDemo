package com.example;

import cn.hutool.system.HostInfo;
import cn.hutool.system.JavaInfo;
import cn.hutool.system.JavaRuntimeInfo;
import cn.hutool.system.JavaSpecInfo;
import cn.hutool.system.JvmInfo;
import cn.hutool.system.JvmSpecInfo;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.UserInfo;
import cn.hutool.system.oshi.CpuInfo;

public class SystemExample {
    public static void main(String[] args) {
        // system
        System.out.println(new HostInfo());
        System.out.println(new JavaInfo());
        System.out.println(new JavaRuntimeInfo());
        System.out.println(new JavaSpecInfo());
        System.out.println(new JvmInfo());
        System.out.println(new JvmSpecInfo());
        System.out.println(new OsInfo());
        System.out.println(new UserInfo());

        System.out.println("ClassLoadingMXBean: " + SystemUtil.getClassLoadingMXBean());
        System.out.println("CompilationMXBean: " + SystemUtil.getCompilationMXBean());
        System.out.println("CurrentPID: " + SystemUtil.getCurrentPID());
        System.out.println("FreeMemory: " + SystemUtil.getFreeMemory());
        System.out.println("GarbageCollectorMXBeans: " + SystemUtil.getGarbageCollectorMXBeans());
        System.out.println("MaxMemory: " + SystemUtil.getMaxMemory());
        System.out.println("TotalMemory: " + SystemUtil.getTotalMemory());
        System.out.println("TotalThreadCount: " + SystemUtil.getTotalThreadCount());

        // oshi lib
        System.out.println(new CpuInfo());
    }
}
