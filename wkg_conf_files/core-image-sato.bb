DESCRIPTION = "Image with Sato, a mobile environment and visual style for \
mobile devices. The image supports X11 with a Sato theme, Pimlico \
applications, and contains terminal, editor, and file manager."

IMAGE_FEATURES += "splash package-management x11-base x11-sato ssh-server-dropbear hwcodecs"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "packagegroup-core-x11-sato-games kernel-dev xterm git \
 jasper gsl liba52  libmad hexedit man iproute2 \
 chkconfig v4l-utils python-imaging socat lame vlc \
 gperf tree libav x264  libav  opencv opencv-samples cmake \
 opencv-apps python-opencv tcl tk rpi-gpio \
 tar pv openjpeg libftdi wiringpi squashfs-tools libmtp libtool \
 rsync yasm evince gparted firefox geany python-pip iputils \
 intelhex python-bitstring pyusb PyPubSub whiptail  \
"
