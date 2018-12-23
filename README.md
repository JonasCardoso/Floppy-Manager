# Floppy Manager

## Floppy Manager is a modified version of official Kernel Adiutor, which is originally developed by Willi Ye aka Grarak. All the credits goes to the original developer.

## Download
* [All builds](https://github.com/JonasCardoso/Floppy-Manager/releases)
## Added features over official KA

* CPU Input Boost (Sultanxda).
* Simple MSM Thermal (Sultanxda).
* Advanced Control for Fast Charge (yank555.lu) & Boeffla Charge Level Interface (Lord Boeffla).
* Boeffla Sound Control (Lord Boeffla).
* Significantly different Faux Sound implementation.
* In-built Spectrum Support (frap129).
* Adreno Boost (flar2).
* MSM Sleeper (flar2).
* Boeffla Wakelock Blocker (Lord Boeffla).
* Display Backlight Control (Min & Max).
* SELinux Switch.
* WireGuard version information.
* Auto-updates (in *About* page).
* Real-time Charging Status.
* RAM & Swap Status
* LED Blink/Fade support.
* Device & android version specific kernel download & Auto flashing for supported devices.
* Dedicated Frequently Asked Questions (FAQ) section for SmartPack-Kernel (Manager).
* Also compatible with stock & other kernels
* And much more…

## Donations
If you want to appreciate my work, please consider donating to me as it is helpful to continue my projects more active, although it is not at all necessary.

[![PayPal](https://www.paypalobjects.com/webstatic/mktg/Logo/pp-logo-200px.png)](https://www.paypal.me/floppykernel)

## Credits

In addition to official Kernel Adiutor and its related dependencies, I used codes from the following people:

#### Joe Maples

* [Spectrum](https://github.com/frap129/spectrum)

#### Javier Santos

* [AppUpdater](https://github.com/javiersantos/AppUpdater)

***** ***** ***** ***** ***** ***** ***** ***** ***** ***** *****

# About official Kernel Adiutor

[![Build Status](https://travis-ci.org/Grarak/KernelAdiutor.svg?branch=master)](https://travis-ci.org/Grarak/KernelAdiutor)
[![Crowdin](https://d322cqt584bo4o.cloudfront.net/kernel-adiutor/localized.png)](https://crowdin.com/project/kernel-adiutor)

* [Join Google+ Community](https://plus.google.com/communities/108445529270785762340) (Beta Testing)

[![Google Play](http://developer.android.com/images/brand/en_generic_rgb_wo_60.png)](https://play.google.com/store/apps/details?id=com.grarak.kerneladiutor)
[![PayPal](https://www.paypalobjects.com/webstatic/mktg/Logo/pp-logo-200px.png)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=G3643L52LJQ7G)

## Report a bug or request a feature

You can report a bug or request a feature by [opening an issue](https://github.com/Grarak/KernelAdiutor/issues/new).

#### How to report a bug
* A detailed description of the bug
* Logcat
* Make sure there are no similar bug reports already

#### How to request a feature
* A detailed description of the feature
* All kind of information
* Paths to sys interface
* What's the content if the sys file
* How to apply a new value
* Make sure there are no similar feature requests already

## Download & Build

Clone the project and come in:

``` bash
$ git clone git://github.com/Grarak/KernelAdiutor.git
$ cd KernelAdiutor
$ ./gradlew build
```

## Credits

I used following libraries:

* Google: [AndroidX Library](https://developer.android.com/jetpack/androidx/)
* Google: [NavigationView library](https://developer.android.com/reference/com/google/android/material/navigation/NavigationView)
* Ozodrukh: [CircularReveal](https://github.com/ozodrukh/CircularReveal)
* Roman Nurik: [dashclock](https://github.com/romannurik/dashclock)
* Google: [Firebase](https://firebase.google.com)
* Matthew Precious: [swirl](https://github.com/mattprecious/swirl)
* Lopez Mikhael: [CircularImageView](https://github.com/lopspower/CircularImageView)
* Square: [picasso](https://github.com/square/picasso)
* Square: [okhttp](https://github.com/square/okhttp)
* CyanogenMod: [CyanogenMod Platform SDK](https://github.com/CyanogenMod/cm_platform_sdk)
* Akexorcist: [Android-RoundCornerProgressBar](https://github.com/akexorcist/Android-RoundCornerProgressBar)

Also codes from different people:

#### Andrei F.

* [RootUtils](https://github.com/Grarak/KernelAdiutor/blob/master/app/src/main/java/com/grarak/kerneladiutor/utils/root/RootUtils.java)

#### apbaxel

_(Many sys interface paths has been taken from his [UKM-Project](https://github.com/apbaxel/UKM))_

#### Brandon Valosek

* [CpuSpyApp](https://github.com/Grarak/KernelAdiutor/blob/master/app/src/main/java/com/bvalosek/cpuspy/CpuSpyApp.java)
* [CpuStateMonitor](https://github.com/Grarak/KernelAdiutor/blob/master/app/src/main/java/com/bvalosek/cpuspy/CpuStateMonitor.java)
* [OverallFragment](https://github.com/Grarak/KernelAdiutor/blob/master/app/src/main/java/com/grarak/kerneladiutor/fragments/statistics/OverallFragment.java)

## License

    Copyright (C) 2015-2016 Willi Ye <williye97@gmail.com>
    
    Kernel Adiutor is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    
    Kernel Adiutor is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    
    You should have received a copy of the GNU General Public License
    along with Kernel Adiutor.  If not, see <http://www.gnu.org/licenses/>.