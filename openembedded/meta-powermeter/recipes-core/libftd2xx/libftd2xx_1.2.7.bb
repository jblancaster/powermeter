SUMMARY = "fdt2xx driver shared library"
DESCRIPTION = "fdt2xx library to manage ftd USB hardware"
SECTION = "libraries"
LICENSE = "ftd"
LIC_FILES_CHKSUM = "file://COPYING;md5=2db26cef49692cb7f0121f9202107dbf"

PV = "1.2.7"
PR = "r1"

PACKAGES = "${PN}"

SRC_URI = " \
	file://libftd2xx.so.1.2.7 \
	file://ftd2xx.h \
	file://WinTypes.h \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
S = "${WORKDIR}"

do_install() {
	install -d ${D}/usr/lib
	install -m 0755 ${S}/libftd2xx.so.1.2.7 ${D}/usr/lib
	cd ${D}/usr/lib
	ln -sf libftd2xx.so.1.2.7 libftd2xx.so
	install -d ${D}/usr/include
	install -m 0755 ${S}/ftd2xx.h ${D}/usr/include
	install -d ${D}/usr/include
	install -m 0755 ${S}/WinTypes.h ${D}/usr/include
}

do_qa_configure() {
}

do_package_qa() {
}

FILES_${PN} += "/usr/lib/*"
INSANE_SKIP_${PN} = "installed-vs-shipped"
