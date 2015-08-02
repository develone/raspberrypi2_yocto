# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://src/pubsub/LICENSE_BSD_Simple.txt;md5=2fedfd31700f60e5c8d6499d70311882"

HOMEPAGE = "http://pubsub.sourceforge.net"
SUMMARY = "Python Publish-Subscribe Package"

SRC_URI = "http://downloads.sourceforge.net/project/pubsub/pubsub/3.3.0/PyPubSub-3.3.0.zip"
SRC_URI[md5sum] = "1c8d88cc2506532df85bc95dde719816"
SRC_URI[sha256sum] = "05e301917a8489f4fdf71bf5a717526a44c4f908e93809df366accec2886a84b"

S = "${WORKDIR}/PyPubSub-3.3.0"

inherit setuptools

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-core python-crypt python-distribute python-distutils python-lang python-netclient python-re python-shell"
