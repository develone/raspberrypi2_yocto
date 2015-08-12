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
 
08/12/15
Goal: To install MyHDL, GTKWave, XSTOOLs and Iverilog on a core-image-sato.

Created several recipes and modified core-image-sato.bb.
The core-image-sato.bb is the recipe that I am using to add other 
software to my build.
These can be found at https://github.com/develone/raspberrypi2_yocto.git
Each of the new recipes are in folders that begin with recipe_xxxxx.

The recipes for gtkwave_3.6.66.bb & XsTools_0.1.29.bb still needs work. Until these are
working the target will be used to compile and install.
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


 
