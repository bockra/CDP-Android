#!/bin/bash
#get and parse CDP info
#clear old files
#cdp.jah and port.jah are files that used for holding output strings
rm /sdcard/cdp.jah
rm /sdcard/port.jah

#get only one cdp packet from USB2ETHERnet connector and write it to file
tcpdump -c 1 -nn -v -i eth0 -s 1500 -c 1 'ether[20:2] == 0x2000' > /sdcard/cdp.jah

#Find the string with switch name (switch01.somehost.net) and get its name "switch01"
grep somehost.net /sdcard/cdp.jah | awk '{print $6}' > /sdcard/port.jah

#Find the string with switch name (switch01.somename.net) and get its port number 0/1
grep Ether /sdcard/cdp.jah | awk '{print $6}' >> /sdcard/port.jah