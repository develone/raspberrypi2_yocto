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
 
08/04/15
Goal: To install MyHDL, GTKWave, XSTOOLs and Iverilog on a core-image-sato.

Created several recipes and modified core-image-sato.bb.
The core-image-sato.bb is the recipe that I am using to add other 
software to my build.
These can be found at https://github.com/develone/raspberrypi2_yocto.git
Each of the new recipes are in folders that begin with recipe_xxxxx.

The recipe for gtkwave_3.6.66.bb & XsTools_0.1.27.bb still needs work. Until these are
working the target will be used to compile and install.
The recipes intelhex, PyPubSub, python-bitstring, pyusb argparse were the dependencies
for XSTOOLs.  XSTOOLs installs on the target and is working
see the file core-image-sato_xstools.txt  
 
poky/meta/recipes-devtools/gtkwave/
├── gtkwave_3.6.66.bb

poky/meta/recipes-devtools/python/
├── argparse_1.2.1.bb
├── intelhex_1.5.bb
├── PyPubSub_3.1.3.bb
├── python-bitstring_3.1.3.bb
├── python-myhdl_1.0.0.bb
├── pyusb-1.0.0a3.bb

poky/meta/recipes-sato/images/
├── core-image-sato.bb


 
