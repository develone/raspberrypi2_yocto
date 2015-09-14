# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e5879699e3062f5ffa78ba138b7ff6d"

HOMEPAGE = "https://github.com/xesscorp/xsconnect"
SUMMARY = "Generate pin assignment constraints for a given combination of XESS peripheral + motherboard + daughterboard."

SRC_URI = "https://pypi.python.org/packages/source/x/xsconnect/xsconnect-${PV}.zip"
SRC_URI[md5sum] = "1f539c3d0c0b48459bd3fc494b51b312"
SRC_URI[sha256sum] = "6c63310541e9eafe556ab3c4a4576e8442f3e15195a99dbb4e3e6e519293f5aa"

inherit setuptools

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-argparse python-core python-difflib python-re python-unittest"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    ScrolledText
#    Tkinter
#    tkFileDialog
#    tkMessageBox
#    xsconnect.__init__
