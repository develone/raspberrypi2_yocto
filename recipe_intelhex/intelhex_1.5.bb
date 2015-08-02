# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d49896f9dda94a042878ce417e7e595d"

HOMEPAGE = "http://www.bialix.com/intelhex/"
SUMMARY = "Intel HEX file format reader and convertor"

SRC_URI = "https://pypi.python.org/packages/source/I/IntelHex/intelhex-${PV}.tar.gz"
SRC_URI[md5sum] = "3bb13d25f2f7868765d2fa3ab687caa5"
SRC_URI[sha256sum] = "bb3eda3ef142a2e9bcb7a7656e32a7322cba88f548aeed5ae0c94fb7370dd0c2"

inherit distutils

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-core python-difflib python-io python-lang python-unittest"
