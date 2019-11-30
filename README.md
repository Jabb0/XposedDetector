# XposedDetector
Proof of concept app for detection of the XPOSED framework on android

How does this app work? 
The xposed framework puts itself in front of the android zygote process in terms of android virtual machine execution. 
Therefore the android-system includes the package into the stacktrace of any running application. 
This fact can be used to determine if the XPOSED framework is installed by searching for the package name of it.

If any masking technique known solves this issue is not tested.

This code is usefull for example if you don't want your app to run on xposed android systems.
