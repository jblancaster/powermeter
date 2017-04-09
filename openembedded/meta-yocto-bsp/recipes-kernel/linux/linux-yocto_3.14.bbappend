KBRANCH_genericx86  = "standard/common-pc/base"
KBRANCH_genericx86-64  = "standard/common-pc-64/base"
KBRANCH_edgerouter = "standard/edgerouter"
KBRANCH_beaglebone = "standard/beaglebone"
KBRANCH_mpc8315e-rdb = "standard/fsl-mpc8315e-rdb"

KMACHINE_genericx86 ?= "common-pc"
KMACHINE_genericx86-64 ?= "common-pc-64"

SRCREV_machine_genericx86 ?= "a39fd81fa54776b2ac8c288251846890c3124dee"
SRCREV_machine_genericx86-64 ?= "dbe5b52e93ff114b2c0f5da6f6af91f52c18f2b8"
SRCREV_machine_edgerouter ?= "dbe5b52e93ff114b2c0f5da6f6af91f52c18f2b8"
SRCREV_machine_beaglebone ?= "dbe5b52e93ff114b2c0f5da6f6af91f52c18f2b8"
SRCREV_machine_mpc8315e-rdb ?= "4b2929392ec56ca8ef90cc98042609795c44aa3c"

COMPATIBLE_MACHINE_genericx86 = "genericx86"
COMPATIBLE_MACHINE_genericx86-64 = "genericx86-64"
COMPATIBLE_MACHINE_edgerouter = "edgerouter"
COMPATIBLE_MACHINE_beaglebone = "beaglebone"
COMPATIBLE_MACHINE_mpc8315e-rdb = "mpc8315e-rdb"

KBUILD_DEFCONFIG_KMACHINE ?= "file://defconfig"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "  \
	file://defconfig \
	file://0001-musb-dsps.patch \
	"
