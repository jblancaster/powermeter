DESCRIPTION = "Task to install support packages for the power meter"
LICENSE = "MIT"
PR = "r7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Add openssl-misc to get the openssl.cnf file which is
# needed for "openssl req" and to avoid warnings.
# NOTE: This may change to openssl-conf in the future
CRYPTO_SUPPORT = "\
	openssl \
	openssl-misc \
	openssl-engines \
"

RDEPENDS_${PN} = "\
	${CRYPTO_SUPPORT} \
	fftw \
	curl \
	usbutils \
	libftd2xx \
	libcurl \
	gnutls \
	nettle \
	gmp \
"

IMAGE_INSTALL_append += " ntpdate"
IMAGE_INSTALL_append += " curl"
IMAGE_INSTALL_append += " libdl"
IMAGE_INSTALL_append += " libc"
IMAGE_INSTALL_append += " libz"
IMAGE_INSTALL_append += " pthread"
IMAGE_INSTALL_append += " powermeter"
