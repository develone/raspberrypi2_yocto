# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=a5013fbcba9f5543fcb0a718c35d095f"

SUMMARY = "collection of HDL cores "

SRC_URI = "https://github.com/cfelton/rhea/archive/master.zip"
SRC_URI[md5sum] = "52cba08b9bdde9016ce125f5f732d047"
SRC_URI[sha256sum] = "b7abe9162d4034db9ca11adb4da9b6e307ea4a1afc166547e1af08c475949213"

S = "${WORKDIR}/rhea-master"

inherit setuptools

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-argparse python-core python-imaging python-lang python-logging python-math python-pprint python-shell python-stringold python-subprocess python-threading"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    myhdl
#    myhdl._Signal
