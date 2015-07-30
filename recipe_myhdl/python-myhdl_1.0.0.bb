# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=7fbc338309ac38fefcd64b04bb903e34"

HOMEPAGE = "http://www.myhdl.org"
SUMMARY = "Python as a Hardware Description Language"

SRC_URI = "git://github.com/jandecaluwe/myhdl.git"

# Modify these as desired
PV = "1.0.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit setuptools

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-core"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    __future__
#    ast
#    collections
#    copy
#    ctypes.windll.kernel32
#    datetime
#    difflib
#    inspect
#    io
#    linecache
#    msvcrt
#    os
#    py
#    pytest
#    re
#    shlex
#    shutil
#    string
#    subprocess
#    tempfile
#    tokenize
#    types
#    warnings
