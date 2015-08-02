# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a53a9c39efcfb812e2464af14afab013"

HOMEPAGE = "http://pyusb.sourceforge.net"
SUMMARY = "Python USB access module"

SRC_URI = "https://pypi.python.org/packages/source/p/pyusb/pyusb-${PV}.tar.gz"
SRC_URI[md5sum] = "28f72453a7c0562cb8bd572758f6f7e1"
SRC_URI[sha256sum] = "09ede69752e3d57793627b9408275701df3b8109b46b09509e4d4c9049ebe3ab"

inherit distutils

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-core python-ctypes python-lang python-logging python-math"
