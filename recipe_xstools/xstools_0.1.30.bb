# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "GPL-2.0+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"

HOMEPAGE = "https://github.com/xesscorp/XSTOOLs"
SUMMARY = "Tools and classes for interfacing with XESS FPGA boards via USB."

SRC_URI = "https://github.com/xesscorp/XSTOOLs/archive/python.zip"
SRC_URI[md5sum] = "4490bb7ac130207528fe14d869ae0b28"
SRC_URI[sha256sum] = "e25e0977bba3eee585a1c75398ff69f2f5db3fc8db093d3a287c60a24309c7b0"

S = "${WORKDIR}/XSTOOLs-python"

inherit setuptools

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "PyPubSub intelhex python-argparse python-bitstring python-core python-logging python-math python-stringold python-threading python-unittest pyusb"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    bitarray
#    pylab
#    scipy
#    serial
#    winsound
#    wx
#    wx.html
#    wx.lib
#    wx.lib.filebrowsebutton
#    wx.lib.flatnotebook
#    wx.lib.intctrl
#    wx.lib.platebtn
#    xstools.__init__
