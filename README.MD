These are the files for creating an image for the raspberrypi2
using Yocto.  The fido branch of poky, meta-raspberrypi, and meta-oe
were used.  
This was started on 07/20/15 with infomation found at 
http://www.cnx-software.com/2015/02/27/yocto-project-raspberry-pi-2-board-minimal-image/
The above provides information to create rpi-basic-image with yocto.
Thanks to Gary Thomas and the yocto mailing list I was able to get the
core-image-sato working,
07/28/15
This image now supports OpenCV using 2 C920 cameras.
 
08/16/15
Goal: To install MyHDL, GTKWave, XSTOOLs Iverilog Matplotlib and VLC on a core-image-sato.

08/17/15 
Added the doc-pkgs to the local.conf which now install several 
RPMs increasing the package count 3753 which 200 additional.
This also increases the image size by 47%.
1409286144 bytes to 2071986176 bytes.

Added hexedit man iproute2 socat packages

08/19/15
New image with gtkwave iverilog xstools and vlc installed
08/23/15
Modified core-image-sato.bb.
The core-image-sato.bb is the recipe that I am using to add other 
software to my build.
These can be found at https://github.com/develone/raspberrypi2_yocto.git
Each of the new recipes are in folders that begin with recipe_xxxxx.

The recipes for gtkwave_3.6.66.bb iverilog XsTools_0.1.29.bb are not working
Until these are working the target will be used to compile and install.
The installed versions are installed using an squashfs see post_install/README.MD

The script Pi_stream can be modified to stream to several systems at the same time.

#!/bin/bash
#this script can be used to stream a video to serveral system
# modify xxxxx.avi with a valid file name 
#modify xxx.xxx.xxx.xxx:zzz with the Pi IP and the desired port

cvlc -vvvvv 'xxxxx.avi' --sout '#standard{access=http,mux=ogg,dst=xxx.xxx.xxx.xxx:zzz}' 
#the system reciving the stream needs vlc an execute 
#vlc -vvv http://xxx.xxx.xxx.xxx:zzz


"cd xstools_test_files"

"xstest -u 0 -b XULA2-LX9"
Success: XuLA2-LX9 passed diagnostic test!

"xsload --usb 0 --fpga blinker_h1.bit"
Now if a led is connected if flash.

"xsload --usb 0 --fpga pc_fast_blinker_sub_h1.bit"
Success: Bitstream in pc_fast_blinker_sub_h1.bit downloaded to FPGA on XuLA2-LX9!

Now if a led is connected if flash at higher rate.
"python pc_subtractor_test.py"
##################################################################
# This program tests the interface between the host PC and the FPGA 
# on the XuLA board that has been programmed to act as a subtractor.
##################################################################

 12 -  74 =  -62 ==> CORRECT!
125 -  56 =   69 ==> CORRECT!
 48 -  44 =    4 ==> CORRECT!
102 -  48 =   54 ==> CORRECT!
  6 - 102 =  -96 ==> CORRECT!
 43 -  53 =  -10 ==> CORRECT!
 74 -  48 =   26 ==> CORRECT!
 50 - 108 =  -58 ==> CORRECT!
	.
	.
	.
 62 -  73 =  -11 ==> CORRECT!
 36 -  40 =   -4 ==> CORRECT!
118 -  20 =   98 ==> CORRECT!
 47 -  13 =   34 ==> CORRECT!
 70 -  80 =  -10 ==> CORRECT!
 61 - 122 =  -61 ==> CORRECT!
 55 -  10 =   45 ==> CORRECT!


The dependencies for XSTOOLs are installed see post_install/README.MD.  
XSTOOLs installs on the target and is working
see the file core-image-sato_xstools.txt  
XSTOOLs 0.1.29 is updated.  In prior versions these commands below
 would provide what appeared to be errors.
xstest -u 0 -b XULA2-LX9
Success: XuLA2-LX9 passed diagnostic test!

xsload --usb 0 --fpga blinker_h1.bit             
Success: Bitstream in blinker_h1.bit downloaded to FPGA on XuLA2-LX9!

xsload --usb 0 --fpga pc_fast_blinker_sub_h1.bit 
Success: Bitstream in pc_fast_blinker_sub_h1.bit downloaded to FPGA on XuLA2-LX9!

08/29/15 Adding iputils to image
Added python3 using source which gtkwave_iverilog_python3_usrlocal082915
This also includes a version of bison to compile vhd2vl2.tgz

Yocto installs bison-3.0.4
bison-3.0.4-r0.cortexa7hf_vfp_vfpv4_neon.rpm
bison-dev-3.0.4-r0.cortexa7hf_vfp_vfpv4_neon.rpm




1.0 HOW TO BUILD vhd2vl:

Just type 'make' in the src directory.

This version of vhd2vl has been tested with bison (GNU Bison) 1.875,
and flex version 2.5.4.


2.0 HOW TO USE vhd2vl:

   vhd2vl VHDL_file.vhd > VHDL_file.v
bison -V            
bison (GNU Bison) 2.5.1
Written by Robert Corbett and Richard Stallman.

Copyright (C) 2012 Free Software Foundation, Inc.
This is free software; see the source for copying conditions.  There is NO
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

Build fails on Raspberry Pi 2 B
 
unsquashfs gtkwave_iverilog_python3_usrlocal082915 
cd squashfs-root/

mkdir /usr/local
cp -R * /usr/local/

pip3 list
myhdl (1.0.dev0)
numpy (1.9.2)
pip (7.1.2)
pyparsing (2.0.3)
python-dateutil (2.4.2)
pytz (2015.4)
setuptools (12.0.5)
six (1.9.0)
tornado (4.2.1)

/usr/local/bin/bison -V
bison (GNU Bison) 2.5.1
Written by Robert Corbett and Richard Stallman.

Copyright (C) 2012 Free Software Foundation, Inc.
This is free software; see the source for copying conditions.  There is NO
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

Tos disable version and to use the one installed with the image using RPMs
chmod 666 /usr/local/bin/bison

bison -V
bison (GNU Bison) 3.0.4
Written by Robert Corbett and Richard Stallman.

Copyright (C) 2015 Free Software Foundation, Inc.
This is free software; see the source for copying conditions.  There is NO
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

+iputils-arping-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-clockdiff-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-dev-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-doc-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-ping-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-ping6-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-tracepath-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-tracepath6-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
+iputils-traceroute6-s20121221-r0.cortexa7hf_vfp_vfpv4_neon
 

9/2/15 Added yosys to yocto build. 
Testing vhd2vl with MyHDL cosimulation 

9/6/15 Added libbcm and testing spi
//If you tie MISO to MOSI, you should read back what was sent
CHAN24 (net bcm9_miso   loc = f1;) & 
CHAN25 (net bcm10_mosi  loc = f2;)PM3 on StickIt-MB
When you run bcm2835-1.45/examples/spi/spi
09/07/15 
image now includes devicetree
devicetree-Image-bcm2708-rpi-b-plus.dtb
devicetree-Image-bcm2708-rpi-b.dtb
devicetree-Image-bcm2709-rpi-2-b.dtb
devicetree-Image-ds1307-rtc-overlay.dtb
devicetree-Image-hifiberry-amp-overlay.dtb
devicetree-Image-hifiberry-dac-overlay.dtb
devicetree-Image-hifiberry-dacplus-overlay.dtb
devicetree-Image-hifiberry-digi-overlay.dtb
devicetree-Image-iqaudio-dac-overlay.dtb
devicetree-Image-iqaudio-dacplus-overlay.dtb
devicetree-Image-lirc-rpi-overlay.dtb
devicetree-Image-pcf8523-rtc-overlay.dtb
devicetree-Image-pps-gpio-overlay.dtb
devicetree-Image-w1-gpio-overlay.dtb
devicetree-Image-w1-gpio-pullup-overlay.dtb
ds1307-rtc-overlay.dtb
hifiberry-amp-overlay.dtb
hifiberry-dac-overlay.dtb
hifiberry-dacplus-overlay.dtb
hifiberry-digi-overlay.dtb
iqaudio-dac-overlay.dtb
iqaudio-dacplus-overlay.dtb
lirc-rpi-overlay.dtb
pcf8523-rtc-overlay.dtb
pps-gpio-overlay.dtb
w1-gpio-overlay.dtb
w1-gpio-pullup-overlay.dtb
09/08/15
Added XSTOOLs python depends
Cleaning up yoctoPi.txt 
device tree are added by defualt 
http://git.yoctoproject.org/cgit/cgit.cgi/meta-raspberrypi/about/
2.L. Device tree support

09/09/15
Added whiptail to image.  The package rpi_config caused errors in do_rootfs.
This version rpi-config does not appear to be useing whiptail.
A copy was added manually at /home/root/RPi-config
diff -u config.txt.orig RPi-config/config.txt 
--- config.txt.orig	2015-09-09 02:11:38.419999827 +0000
+++ RPi-config/config.txt	2015-09-09 03:45:56.189997668 +0000
@@ -496,7 +496,7 @@
 ##
 ##     Default 64
 ##
-gpu_mem=16
+#gpu_mem=128
 
 ## gpu_mem_256
 ##     GPU memory allocation in MB for 256MB board revision.
The value gpu_mem 16 appears to set from the local.conf

09/14/15 
recipe_xstools/xstools_0.1.30.bb is now working
09/15/15
Image now has the HDL tools icestrom, arachne-pnr, and yosys
Ran arachne-pnr test 5:41 hrs 536 additional files in the test folder

10/02/15 added linux-firmware to support wi-fi
 
