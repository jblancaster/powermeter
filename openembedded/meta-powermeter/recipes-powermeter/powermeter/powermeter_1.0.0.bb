DESCRIPTION = "Powermeter is a power monitoring device"
HOMEPAGE = ""
LICENSE = "closed"
LIC_FILES_CHKSUM = "file://COPYING;md5=d8e20eece214df8ef953ed5857862150"
DEPENDS = "packagegroup-arago-tisdk-power-meter curl libftd2xx fftw"
DEPENDS += "virtual/kernel"
SRCREV = ""
SRC_URI = " \
    file:///home/jeff/hg/power_meter \
"

inherit update-alternatives
DEPENDS_append = " update-rc.d-native"

#SRC_URI = " \
#    hg://127.0.0.1/hg;rev=${SRCREV};module=power_meter \
#"

S = "${WORKDIR}/power_meter"

do_compile_prepend() {
    cp -rf ../home/jeff/power_meter/src/* .
}

do_compile() {
    #oe_runmake CC="${CC}" CPPFLAGS="${CPPFLAGS}" LDFLAGS=" -ldl -lm ${LDFLAGS}"
    oe_runmake CC="${CC}" CPPFLAGS="${CPPFLAGS}" LDFLAGS=" ${LDFLAGS}"
}

do_install() {
    install -d ${D}/usr/bin
    install -m 755 ${WORKDIR}/power_meter/powermeter ${D}/usr/bin
    install -d ${D}/opt/powermeter
    install -m 644 ${WORKDIR}/home/jeff/power_meter/setup.txt ${D}/opt/powermeter
    install -d ${D}/etc/init.d
    install -m 755 ${WORKDIR}/home/jeff/power_meter/powerd ${D}/etc/init.d
}

do_install_append() {
    install -m 0755    ${WORKDIR}/home/jeff/power_meter/powerd ${D}${sysconfdir}/init.d
#     update-rc.d -r ${D} mountnfs.sh start 22 3 4 5 .
}

do_qa_configure () {
}

SRC_URI[md5sum] = "37b8264ee15dd6d50024f061db33d659"
SRC_URI[sha256sum] = "896d4ceb06fd21f578de63d16cbb38bfd1bc6b7e85f645d8cc9566fae1be0038"

FILES_${PN} = "/opt/powermeter/setup.txt ${bindir}/powermeter /etc/init.d/powerd"
INSANE_SKIP_${PN} = "installed-vs-shipped"
