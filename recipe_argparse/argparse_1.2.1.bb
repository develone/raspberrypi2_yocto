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
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=09d08bb5b7047e2688ea3faad6408aa8 \
                    file://doc/source/Python-License.txt;md5=2dffb81509b47974467ea23409909b1c \
                    file://doc/source/license.rst;md5=caf23df0ad4e60006a92049c5890d18f"

HOMEPAGE = "http://code.google.com/p/argparse/"
SUMMARY = "Python command-line parsing library"

SRC_URI = "http://argparse.googlecode.com/files/argparse-${PV}.tar.gz"
SRC_URI[md5sum] = "2fbef8cb61e506c706957ab6e135840c"
SRC_URI[sha256sum] = "ddaf4b0a618335a32b6664d4ae038a1de8fbada3b25033f9021510ed2b3941a4"

inherit setuptools

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-codecs python-core python-math python-re python-textutils"
