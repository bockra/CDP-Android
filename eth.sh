#!/bin/bash
#get info about connected ethernet
#clear cache
rm /sdcard/eth.jah
rm /sdcard/link.jah


eth=`grep -c 'eth0' /proc/net/dev`
link=`cat /sys/class/net/eth0/carrier`

#check: is ethernet to usb connected to device
if [ "$eth" -eq '1' ] 
then
#check: is link up
	if [ "$link" -eq '1' ]
	then
		echo "eth:OK link:OK" > /sdcard/eth.jah
	else
		echo "eth:OK link:NO" > /sdcard/eth.jah
	fi
else
	echo "eth:NO link:NO" > /sdcard/eth.jah
fi
