SUMMARY = "Network DBUS object"
DESCRIPTION = "Network DBUS object"
HOMEPAGE = "http://github.com/openbmc/phosphor-networkd"
PR = "r1"

inherit obmc-phosphor-license
inherit obmc-phosphor-systemd
inherit obmc-phosphor-sdbus-service

SYSTEMD_SERVICE_${PN} += "network.service network-update-dns.service"

RDEPENDS_${PN} += "python-dbus python-pygobject python-ipy"

SRC_URI += "git://github.com/openbmc/phosphor-networkd"

SRCREV = "53b692b2365e924025fce0ebc2be4242e77b48ca"

S = "${WORKDIR}/git"

do_install() {
        install -d ${D}/${sbindir}
        install ${S}/netman.py ${D}/${sbindir}
        install ${S}/netman_watch_dns ${D}/${sbindir}
}

