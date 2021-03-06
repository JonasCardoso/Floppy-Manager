/*
 * Copyright (C) 2015-2016 Willi Ye <williye97@gmail.com>
 *
 * This file is part of Kernel Adiutor.
 *
 * Kernel Adiutor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kernel Adiutor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Kernel Adiutor.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.grarak.kerneladiutor.utils.kernel.misc;

import android.content.Context;

import com.grarak.kerneladiutor.fragments.ApplyOnBootFragment;
import com.grarak.kerneladiutor.utils.Utils;
import com.grarak.kerneladiutor.utils.root.Control;
import com.grarak.kerneladiutor.utils.root.RootUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by willi on 29.06.16.
 */
public class Misc {

    private static Misc sInstance;

    public static Misc getInstance() {
        if (sInstance == null) {
            sInstance = new Misc();
        }
        return sInstance;
    }

    private static final String BLOCK_TUNER = "/sys/kernel/block_tuner/block_tuner_enabled";
    private static final String DYNAMIC_FSYNC = "/sys/kernel/dyn_fsync/Dyn_fsync_active";
    private static final String GENTLE_FAIR_SLEEPERS = "/sys/kernel/sched/gentle_fair_sleepers";
    private static final String ARCH_POWER = "/sys/kernel/sched/arch_power";
	private static final String FP_WAKE = "/sys/devices/soc/soc:fpc_fpc1020/enable_wakeup";	
    private static final String FP_BOOST = "/sys/kernel/fp_boost/enabled";	
    private static final String SELINUX = "/sys/fs/selinux/enforce";
	private static final String UC_BALANCED = "/sys/module/cpufreq/parameters/enable_underclock_balanced";
    private static final String UC_BATTERY = "/sys/module/cpufreq/parameters/enable_underclock_battery";
    private static final String TCP_AVAILABLE_CONGESTIONS = "/proc/sys/net/ipv4/tcp_available_congestion_control";
    private static final String WIREGUARD = "/sys/module/wireguard/version";

    private static final String BACKGROUND = "/dev/cpuset/background/cpus";
    private static final String CAMERA_DAEMON = "/dev/cpuset/camera-daemon/cpus";	
    private static final String FOREGROUND = "/dev/cpuset/foreground/cpus";
    private static final String RESTRICTED = "/dev/cpuset/restricted/cpus";
    private static final String SYSTEM_BACKGROUND = "/dev/cpuset/system-background/cpus";
    private static final String TOP_APP = "/dev/cpuset/top-app/cpus";
    private static final String CHECK_OCTACORE = "/sys/devices/system/cpu/cpu7/online";
	
    private static final String PRINTK_MODE = "/sys/kernel/printk_mode/printk_mode";

    private static final String HOSTNAME_KEY = "net.hostname";

    private final List<String> mLoggers = new ArrayList<>();
    private final List<String> mCrcs = new ArrayList<>();
    private final List<String> mFsyncs = new ArrayList<>();

    {
        mLoggers.add("/sys/kernel/logger_mode/logger_mode");
        mLoggers.add("/sys/module/logger/parameters/enabled");
        mLoggers.add("/sys/module/logger/parameters/log_enabled");

        mCrcs.add("/sys/module/mmc_core/parameters/crc");
        mCrcs.add("/sys/module/mmc_core/parameters/use_spi_crc");

        mFsyncs.add("/sys/devices/virtual/misc/fsynccontrol/fsync_enabled");
        mFsyncs.add("/sys/module/sync/parameters/fsync_enabled");
    }

    private String LOGGER_FILE;
    private String CRC_FILE;
    private String FSYNC_FILE;
    private Boolean FSYNC_USE_INTEGER;

    private Misc() {
        for (String file : mLoggers) {
            if (Utils.existFile(file)) {
                LOGGER_FILE = file;
                break;
            }
        }

        for (String file : mCrcs) {
            if (Utils.existFile(file)) {
                CRC_FILE = file;
                break;
            }
        }

        for (String file : mFsyncs) {
            if (Utils.existFile(file)) {
                FSYNC_FILE = file;
                FSYNC_USE_INTEGER = Character.isDigit(Utils.readFile(FSYNC_FILE).toCharArray()[0]);
                break;
            }
        }
    }

    public void setHostname(String value, Context context) {
        run(Control.setProp(HOSTNAME_KEY, value), HOSTNAME_KEY, context);
    }

    public String getHostname() {
        return RootUtils.getProp(HOSTNAME_KEY);
    }

    public void setTcpCongestion(String tcpCongestion, Context context) {
        run("sysctl -w net.ipv4.tcp_congestion_control=" + tcpCongestion, TCP_AVAILABLE_CONGESTIONS, context);
    }

    public String getTcpCongestion() {
        return getTcpAvailableCongestions().get(0);
    }

    public List<String> getTcpAvailableCongestions() {
        return new ArrayList<>(Arrays.asList(Utils.readFile(TCP_AVAILABLE_CONGESTIONS).split(" ")));
    }

    public void enableArchPower(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", ARCH_POWER), ARCH_POWER, context);
    }

    public boolean isArchPowerEnabled() {
        return Utils.readFile(ARCH_POWER).equals("1");
    }

    public boolean hasArchPower() {
        return Utils.existFile(ARCH_POWER);
    }

	public void enableFPWake(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", FP_WAKE), FP_WAKE, context);
    }

    public boolean isFPWakeEnabled() {
        return Utils.readFile(FP_WAKE).equals("1");
    }

    public boolean hasFPWake() {
        return Utils.existFile(FP_WAKE);
    }
	
	public void enableFPBoost(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", FP_BOOST), FP_BOOST, context);
    }

    public boolean isFPBoostEnabled() {
        return Utils.readFile(FP_BOOST).equals("1");
    }

    public boolean hasFPBoost() {
        return Utils.existFile(FP_BOOST);
    }
	
    public void setBackground(String value, Context context) {
        run(Control.write(String.valueOf(value), BACKGROUND), BACKGROUND, context);
    }

    public static String getBackground() {
        return Utils.readFile(BACKGROUND);
    }

    public static boolean hasBackground() {
        return Utils.existFile(BACKGROUND);
    }	

    public void setCameraDaemon(String value, Context context) {
        run(Control.write(String.valueOf(value), CAMERA_DAEMON), CAMERA_DAEMON, context);
    }

    public static String getCameraDaemon() {
        return Utils.readFile(CAMERA_DAEMON);
    }

    public static boolean hasCameraDaemon() {
        return Utils.existFile(CAMERA_DAEMON);
    }
	
    public void setForeground(String value, Context context) {
        run(Control.write(String.valueOf(value), FOREGROUND), FOREGROUND, context);
    }

    public static String getForeground() {
        return Utils.readFile(FOREGROUND);
    }

    public static boolean hasForeground() {
        return Utils.existFile(FOREGROUND);
    }
	
    public void setRestricted(String value, Context context) {
        run(Control.write(String.valueOf(value), RESTRICTED), RESTRICTED, context);
    }

    public static String getRestricted() {
        return Utils.readFile(RESTRICTED);
    }

    public static boolean hasRestricted() {
        return Utils.existFile(RESTRICTED);
    }	
	
    public void setSystemBackground(String value, Context context) {
        run(Control.write(String.valueOf(value), SYSTEM_BACKGROUND), SYSTEM_BACKGROUND, context);
    }

    public static String getSystemBackground() {
        return Utils.readFile(SYSTEM_BACKGROUND);
    }

    public static boolean hasSystemBackground() {
        return Utils.existFile(SYSTEM_BACKGROUND);
    }	
	
    public void setTopApp(String value, Context context) {
        run(Control.write(String.valueOf(value), TOP_APP), TOP_APP, context);
    }

    public static String getTopApp() {
        return Utils.readFile(TOP_APP);
    }

    public static boolean hasTopApp() {
        return Utils.existFile(TOP_APP);
    }

    public static boolean hasCheckOctacore() {
        return Utils.existFile(CHECK_OCTACORE);
    }

	public void enableUCBalanced(boolean enable, Context context) {
        run(Control.write(enable ? "Y" : "N", UC_BALANCED), UC_BALANCED, context);
    }

    public boolean isUCBalancedEnabled() {
        return Utils.readFile(UC_BALANCED).equals("Y");
    }

    public boolean hasUCBalanced() {
        return Utils.existFile(UC_BALANCED);
    }
	
	public void enableUCBattery(boolean enable, Context context) {
        run(Control.write(enable ? "Y" : "N", UC_BATTERY), UC_BATTERY, context);
    }

    public boolean isUCBatteryEnabled() {
        return Utils.readFile(UC_BATTERY).equals("Y");
    }

    public boolean hasUCBattery() {
        return Utils.existFile(UC_BATTERY);
    }

    public void enableSELinux(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", SELINUX), SELINUX, context);
    }

    public boolean isSELinuxEnabled() {
        return Utils.readFile(SELINUX).equals("1");
    }

    public boolean hasSELinux() {
        return Utils.existFile(SELINUX);
    }

    public void enableGentleFairSleepers(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", GENTLE_FAIR_SLEEPERS), GENTLE_FAIR_SLEEPERS, context);
    }

    public boolean isGentleFairSleepersEnabled() {
        return Utils.readFile(GENTLE_FAIR_SLEEPERS).equals("1");
    }

    public boolean hasGentleFairSleepers() {
        return Utils.existFile(GENTLE_FAIR_SLEEPERS);
    }

    public void enableBlockTuner(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", BLOCK_TUNER), BLOCK_TUNER, context);
    }

    public boolean isBlockTunerEnabled() {
        return Utils.readFile(BLOCK_TUNER).equals("1");
    }

    public boolean hasBlockTuner() {
        return Utils.existFile(BLOCK_TUNER);
    }
	
    public void enableDynamicFsync(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", DYNAMIC_FSYNC), DYNAMIC_FSYNC, context);
    }

    public boolean isDynamicFsyncEnabled() {
        return Utils.readFile(DYNAMIC_FSYNC).equals("1");
    }

    public boolean hasDynamicFsync() {
        return Utils.existFile(DYNAMIC_FSYNC);
    }

    public void enableFsync(boolean enable, Context context) {
        run(Control.write(FSYNC_USE_INTEGER ? enable ? "1" : "0" : enable ? "Y" : "N", FSYNC_FILE),
                FSYNC_FILE, context);
    }

    public boolean isFsyncEnabled() {
        return Utils.readFile(FSYNC_FILE).equals(FSYNC_USE_INTEGER ? "1" : "Y");
    }

    public boolean hasFsync() {
        return FSYNC_FILE != null;
    }

    public void enableCrc(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", CRC_FILE), CRC_FILE, context);
    }

    public boolean isCrcEnabled() {
        return Utils.readFile(CRC_FILE).equals("1") || Utils.readFile(CRC_FILE).equals("Y");
    }

    public boolean hasCrc() {
        return CRC_FILE != null;
    }

    public void enableLogger(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", LOGGER_FILE), LOGGER_FILE, context);
    }

    public boolean isLoggerEnabled() {
        return Utils.readFile(LOGGER_FILE).equals("1");
    }

    public boolean hasLoggerEnable() {
        return LOGGER_FILE != null;
    }

    public void enablePrintKMode(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", PRINTK_MODE), PRINTK_MODE, context);
    }

    public static boolean isPrintKModeEnabled() {
        return Utils.readFile(PRINTK_MODE).contains("1");
    }

    public static boolean hasPrintKMode() {
        return Utils.existFile(PRINTK_MODE);
    }

    public static boolean hasWireguard() {
        return Utils.existFile(WIREGUARD);
    }

    public static String getWireguard() {
        return Utils.readFile(WIREGUARD);
    }

    private void run(String command, String id, Context context) {
        Control.runSetting(command, ApplyOnBootFragment.MISC, id, context);
    }

}
