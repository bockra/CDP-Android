It is android cdp parser using usb to ethernet module

Fully tested on Samsung Galaxy Nexus, Android 4.1.2 (should work on any 4.0+ androids and devices with OTG support)

Also its a great example of running bash scripts from your device.

Each file has a lot of description inside
I searched a lot for this information.
So check MainActivity.java



Requipments:
1. Phone MUST-have OTG support (http://en.wikipedia.org/wiki/USB_On-The-Go)
2. Android phone should be rooted, because of accesing system files via bash scripts
3. You have to install TCPdump for android. Good instruction (http://gadgetcat.wordpress.com/2011/09/11/tcpdump-on-android/)
4. You should have Ethernet to USB connector to connect to wired network (I've used Apple Ethernet to sb connector + female usb to microusb)

Instruction:
1. Create new android project (I used eclipse (in my own its name is com.example.test)
2. MainActivity.java should be placed in Test\src\com\example\test\
3. activity_main.xml is from Test\res\layout
 running scripts is on "android:onClick=" property in Textview
4. android:targetSdkVersion="15" android:minSdkVersion="9"

5. place cdp.sh and eth.sh to /sdcard/
6. compile - run - tap 2nd Textview to get info about ethernet - tap 4th Textview to get and parse CDP info