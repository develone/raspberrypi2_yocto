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

 

 

 

 





 
