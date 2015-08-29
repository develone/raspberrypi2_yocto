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
LICENSE = "GPLv2 Unknown"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://contrib/wix/COPYING.rtf;md5=d5db5117f860aff8f2aff5a6643e48ca"

HOMEPAGE = "http://mercurial.selenic.com/"
SUMMARY = "Fast scalable distributed SCM (revision control, version control) system"

SRC_URI = "https://pypi.python.org/packages/source/M/Mercurial/mercurial-${PV}.tar.gz"
SRC_URI[md5sum] = "3e3010e12759d3783ab7ed93de627da1"
SRC_URI[sha256sum] = "b50f6978e7d39fe0cb298fa3fa3e9ce41d2356721d155e5288f9c57e5f13e9a7"

S = "${WORKDIR}/mercurial-${PV}"

inherit distutils

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python-codecs python-compression python-contextlib python-core python-crypt python-ctypes python-curses python-datetime python-debugger python-difflib python-doctest python-email python-io python-lang python-logging python-math python-mime python-misc python-netclient python-netserver python-numbers python-pickle python-re python-shell python-stringold python-subprocess python-textutils python-threading python-unixadmin python-xml python-xmlrpc"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    MySQLdb
#    OpenSSL
#    _winreg
#    base85
#    bdiff
#    bzrlib
#    bzrlib.revisionspec
#    diffhelpers
#    elementtree.ElementTree
#    elementtree.cElementTree
#    email.Parser
#    email.Utils
#    flamegraph
#    mpatch
#    msvcrt
#    osutil
#    parsers
#    pygments
#    pygments.formatters
#    pygments.lexers
#    pygments.util
#    re2
#    statprof
#    svn
#    svn.client
#    svn.core
#    svn.delta
#    svn.ra
#    wcurses
