# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# WARNING: the following LICENSE value is a best guess - it is your
# responsibility to verify that the value is complete and correct.
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

HOMEPAGE = "http://python-bitstring.googlecode.com"
SUMMARY = "Simple construction, analysis and modification of binary data."

SRC_URI = "https://pypi.python.org/packages/source/b/bitstring/bitstring-${PV}.zip"
SRC_URI[md5sum] = "1db5d54ee269f6b54d50c3eb257eea4b"
SRC_URI[sha256sum] = "2d00f66655567cc241af5f6f5c155727daccdb03ddfe58f3814cedaad179f5fa"

S = "${WORKDIR}/bitstring-${PV}"

inherit distutils

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-core python-io python-lang python-numbers python-re"
