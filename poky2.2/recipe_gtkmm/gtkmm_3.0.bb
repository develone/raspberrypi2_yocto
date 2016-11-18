# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# NOTE: multiple licenses have been detected; if that is correct you should separate
# these in the LICENSE value using & if the multiple licenses all apply, or | if there
# is a choice between the multiple licenses. If in doubt, check the accompanying
# documentation to determine which situation is applicable.
LICENSE = "LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d8045f3b8f929c1cb29a1e3fd737b499 \
                    file://COPYING.tools;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/gtkmm/${PV}/gtkmm-${PV}.0.tar.bz2"
SRC_URI[md5sum] = "90bb087152a3214c2cc348aa04f917c3"
SRC_URI[sha256sum] = "567582948d4c47c29aa751162adc714644f50958d3d3e427c7a8c3818cd643f9"

S = "${WORKDIR}/${BPN}-${PV}.0"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
DEPENDS = "atkmm pangomm glibmm gtk+ cairomm"

EXTRA_OECONF = " --disable-documentaion --disable-silent-rules \
--disable-dependency-tracking --with-libtool-sysroot --disable-static "

