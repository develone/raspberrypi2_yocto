DESCRIPTION = "Image with Sato, a mobile environment and visual style for \
mobile devices. The image supports X11 with a Sato theme, Pimlico \
applications, and contains terminal, editor, and file manager."

IMAGE_FEATURES += "splash package-management x11-base x11-sato ssh-server-dropbear hwcodecs"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "packagegroup-core-x11-sato-games kernel-dev xterm git \
 jasper gsl gsl-dev python-netserver python-pygtk python-pygtk-dev \
 python-numpy liba52 liba52-dev libmad libmad-dev libmad-staticdev \
 chkconfig v4l-utils python-imaging parted python-distribute \
 python-pyrex python-pexpect gperf tree libav libav-dev \
 x264 x264-dev libav libav-dev opencv opencv-samples cmake \
 opencv-apps python-opencv tcl tk rpi-gpio python-myhdl python-bitstring \
 PyPubSub tar intelhex pyusb argparse pv openjpeg libftdi \
 python-matplotlib wiringpi"
