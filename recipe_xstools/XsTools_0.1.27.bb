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
#LICENSE = "GPLv3 Unknown"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://src/XstoolsLib/libusb-win32/COPYING_GPL.txt;md5=d32239bcb673463ab874e80d47fae504 \
                    file://src/XstoolsLib/libusb-win32/COPYING_LGPL.txt;md5=e6a600fd5e1d9cbde2d983680233ad02 \
                    file://src/XstoolsLib/libusb-win32/installer_license.txt;md5=fa212535996be4035ac876f3cce2c73d"

SRC_URI = "git://github.com/xesscorp/XSTOOLs.git"

# Modify these as desired
PV = "0.1.27+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

# NOTE: no Makefile found, unable to determine what needs to be done
#inherit setuptools
#inherit distutils
#inherit autotools-brokensep
inherit autotools
# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-codecs python-core python-math python-re python-textutils \
python-bitstring PyPubSub intelhex pyusb argparse"

 
