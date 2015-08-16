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

Created several recipes and modified core-image-sato.bb.
The core-image-sato.bb is the recipe that I am using to add other 
software to my build.
These can be found at https://github.com/develone/raspberrypi2_yocto.git
Each of the new recipes are in folders that begin with recipe_xxxxx.

The recipes for gtkwave_3.6.66.bb & XsTools_0.1.29.bb still needs work. Until these are
working the target will be used to compile and install.

VLC also need to be compiled on the target see the file vlc_target.txt
An Image vlc-image can be used to install vlc-2.1.4 in less time.

The script Pi_stream can be modified to stream to severals systems at the same time.

#!/bin/bash
#this script can be used to stream a video to serveral system
# modify xxxxx.avi with a valid file name 
#modify xxx.xxx.xxx.xxx:zzz with the Pi IP and the desired port

cvlc -vvvvv 'xxxxx.avi' --sout '#standard{access=http,mux=ogg,dst=xxx.xxx.xxx.xxx:zzz}' 
#the system reciving the stream needs vlc an execute 
#vlc -vvv http://xxx.xxx.xxx.xxx:zzz

Note: Compiling on the target takes 17 mins for GTKWAVE and over 20 mins for Iverilog.

Testing an approach of using a squashfs to install GTKWave, Iverilog, and XSTOOLS.
A squashfs image "gtkwave_iverilog_compiled_xtools" is 
"unsquashfs -d gtkwave_iverilog_compiled_xtools add_gtkwave_iverilog_xstools"
this process takes less than a min.

"cd gtkwave_iverilog_compiled_xtools/" 

"./add_gtkwave_iverilog_xstools.sh"
In addition this process installs some additional rpms
wiringpi-dbg-git-r0.cortexa7hf_vfp_vfpv4_neon.rpm
wiringpi-doc-git-r0.cortexa7hf_vfp_vfpv4_neon.rpm
gtk-demo-2.24.28-r0.cortexa7hf_vfp_vfpv4_neon.rpm
for a detailed decrription see the file add_gtkwave_iverilog_xstools.sh
After the system reboots

"cp -R gtkwave_iverilog_compiled_xtools/xstools_test_files ."

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


The recipes intelhex, PyPubSub, python-bitstring, pyusb argparse were the dependencies
for XSTOOLs.  XSTOOLs installs on the target and is working
see the file core-image-sato_xstools.txt  
XSTOOLs 0.1.29 is updated.  In prior versions these commands below
 would provide what appeared to be errors.
xstest -u 0 -b XULA2-LX9
Success: XuLA2-LX9 passed diagnostic test!

xsload --usb 0 --fpga blinker_h1.bit             
Success: Bitstream in blinker_h1.bit downloaded to FPGA on XuLA2-LX9!

xsload --usb 0 --fpga pc_fast_blinker_sub_h1.bit 
Success: Bitstream in pc_fast_blinker_sub_h1.bit downloaded to FPGA on XuLA2-LX9!

**poky/meta/recipes-devtools/gtkwave/gtkwave_3.6.66.bb
**poky/meta/recipes-devtools/python/xstools_0.1.29.bb

poky/meta/recipes-devtools/python/argparse_1.2.1.bb
poky/meta/recipes-devtools/python/intelhex_1.5.bb
poky/meta/recipes-devtools/python/PyPubSub_3.1.3.bb
poky/meta/recipes-devtools/python/python-bitstring_3.1.3.bb
poky/meta/recipes-devtools/python/python-myhdl_1.0.0.bb
poky/meta/recipes-devtools/python/pyusb-1.0.0a3.bb

poky/meta/recipes-sato/images/core-image-sato.bb

Testing GTKWave_MyHDL_Iverilog.doc provides testing of these software
following the generation of 

files_needed_for_iverilog/cosimulation.tgz

cosimulation/icarus/
cosimulation/icarus/Makefile
cosimulation/icarus/myhdl.c.20030518
cosimulation/icarus/README.txt
cosimulation/icarus/myhdl.c
cosimulation/icarus/myhdl_table.c
cosimulation/icarus/test/
cosimulation/icarus/test/test_all.py
cosimulation/icarus/test/dff_clkout.py
cosimulation/icarus/test/bin2gray.py
cosimulation/icarus/test/dff.py
cosimulation/icarus/test/test.py
cosimulation/icarus/test/tb_test.v
cosimulation/icarus/test/inc.py
cosimulation/icarus/myhdl_20030518.c

The above files are used with iverilog files to generate
 myhdl.vpi. 

matplot is installed but no display pops up.
 


 
