# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# NOTE: multiple licenses have been detected; if that is correct you should separate
# these in the LICENSE value using & if the multiple licenses all apply, or | if there
# is a choice between the multiple licenses. If in doubt, check the accompanying
# documentation to determine which situation is applicable.

LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=6aad4d18bf623a14af299bc60814eb12 \
                    file://COPYING;md5=75859989545e37968a99b631ef42722e \
                    file://src/libbz2/LICENSE;md5=ddeb76cd34e791893c0f539fdab879bb"

SRC_URI = "http://gtkwave.sourceforge.net/gtkwave-3.3.66.tar.gz"
SRC_URI[md5sum] = "0e0dfeb3304947a4dfc8edc727e60538"
SRC_URI[sha256sum] = "04ce0851ebcf7ce07506c6e34af878ebf0c5a09495035a71e881fe6ff2abb99e"

S = "${WORKDIR}/gtkwave-3.3.66"

# NOTE: the following prog dependencies are unknown, ignoring: gedit fsdbdebug fsdb2vcd vpd2vcd wlf2vcd gperf
# NOTE: the following library dependencies are unknown, ignoring: dl m pthread z bz2 lzma Judy
#       (this is based on recipes that have previously been built and packaged)
# NOTE: unable to map the following pkg-config dependencies: gtk+-2.0 gconf-2.0
#       (this is based on recipes that have previously been built and packaged)
# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
#inherit pkgconfig autotools gettext texinfo 
DEPENDS = "tcl tk gpref" 
# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--with-tcl=../../../../../sysroots/raspberrypi2/usr/lib --with-tk=../../../../../sysroots/raspberrypi2/usr/lib "

