package net.hypnozcore.hypnozcore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OsUtilsTest {
    /**
     * Method under test: {@link OsUtils#getOsType()}
     */
    @Test
    void testGetOsType() {
        assertEquals(1, OsUtils.getOsType());
    }

    /**
     * Method under test: {@link OsUtils#getOsPath(String)}
     */
    @Test
    void testGetOsPath() {
        assertEquals("foo/", OsUtils.getOsPath("foo"));
        assertEquals("/", OsUtils.getOsPath("\\"));
        assertEquals("//", OsUtils.getOsPath("\\\\"));
        assertEquals("///", OsUtils.getOsPath("\\\\\\"));
        assertEquals("//", OsUtils.getOsPath("\\/"));
        assertEquals("/os.name/", OsUtils.getOsPath("\\os.name"));
        assertEquals("/linux/", OsUtils.getOsPath("\\linux"));
        assertEquals("/foo/", OsUtils.getOsPath("\\foo"));
        assertEquals("/42/", OsUtils.getOsPath("\\42"));
        assertEquals("/darwin/", OsUtils.getOsPath("\\darwin"));
        assertEquals("/macos/", OsUtils.getOsPath("\\macos"));
        assertEquals("/solaris/", OsUtils.getOsPath("\\solaris"));
        assertEquals("/sunos/", OsUtils.getOsPath("\\sunos"));
        assertEquals("/windows/", OsUtils.getOsPath("\\windows"));
        assertEquals("////", OsUtils.getOsPath("\\\\\\\\"));
        assertEquals("///", OsUtils.getOsPath("\\\\/"));
        assertEquals("//os.name/", OsUtils.getOsPath("\\\\os.name"));
        assertEquals("//linux/", OsUtils.getOsPath("\\\\linux"));
        assertEquals("//foo/", OsUtils.getOsPath("\\\\foo"));
        assertEquals("//42/", OsUtils.getOsPath("\\\\42"));
        assertEquals("//darwin/", OsUtils.getOsPath("\\\\darwin"));
        assertEquals("//macos/", OsUtils.getOsPath("\\\\macos"));
        assertEquals("//solaris/", OsUtils.getOsPath("\\\\solaris"));
        assertEquals("//sunos/", OsUtils.getOsPath("\\\\sunos"));
        assertEquals("//windows/", OsUtils.getOsPath("\\\\windows"));
        assertEquals("//", OsUtils.getOsPath("/\\"));
        assertEquals("///", OsUtils.getOsPath("/\\\\"));
        assertEquals("os.name/", OsUtils.getOsPath("os.name\\"));
        assertEquals("os.name//", OsUtils.getOsPath("os.name\\\\"));
        assertEquals("linux/", OsUtils.getOsPath("linux\\"));
        assertEquals("linux//", OsUtils.getOsPath("linux\\\\"));
        assertEquals("foo/", OsUtils.getOsPath("foo\\"));
        assertEquals("foo//", OsUtils.getOsPath("foo\\\\"));
        assertEquals("42/", OsUtils.getOsPath("42\\"));
        assertEquals("42//", OsUtils.getOsPath("42\\\\"));
        assertEquals("darwin/", OsUtils.getOsPath("darwin\\"));
        assertEquals("darwin//", OsUtils.getOsPath("darwin\\\\"));
        assertEquals("macos/", OsUtils.getOsPath("macos\\"));
        assertEquals("macos//", OsUtils.getOsPath("macos\\\\"));
        assertEquals("solaris/", OsUtils.getOsPath("solaris\\"));
        assertEquals("solaris//", OsUtils.getOsPath("solaris\\\\"));
        assertEquals("sunos/", OsUtils.getOsPath("sunos\\"));
        assertEquals("sunos//", OsUtils.getOsPath("sunos\\\\"));
        assertEquals("windows/", OsUtils.getOsPath("windows\\"));
        assertEquals("windows//", OsUtils.getOsPath("windows\\\\"));
        assertEquals("/////", OsUtils.getOsPath("\\\\\\\\\\"));
        assertEquals("////", OsUtils.getOsPath("\\\\\\/"));
        assertEquals("///os.name/", OsUtils.getOsPath("\\\\\\os.name"));
        assertEquals("///linux/", OsUtils.getOsPath("\\\\\\linux"));
        assertEquals("///foo/", OsUtils.getOsPath("\\\\\\foo"));
        assertEquals("///42/", OsUtils.getOsPath("\\\\\\42"));
        assertEquals("///darwin/", OsUtils.getOsPath("\\\\\\darwin"));
        assertEquals("///macos/", OsUtils.getOsPath("\\\\\\macos"));
        assertEquals("///solaris/", OsUtils.getOsPath("\\\\\\solaris"));
        assertEquals("///sunos/", OsUtils.getOsPath("\\\\\\sunos"));
        assertEquals("///windows/", OsUtils.getOsPath("\\\\\\windows"));
        assertEquals("///", OsUtils.getOsPath("\\/\\"));
        assertEquals("////", OsUtils.getOsPath("\\/\\\\"));
        assertEquals("///", OsUtils.getOsPath("\\//"));
        assertEquals("//os.name/", OsUtils.getOsPath("\\/os.name"));
        assertEquals("//linux/", OsUtils.getOsPath("\\/linux"));
        assertEquals("//foo/", OsUtils.getOsPath("\\/foo"));
        assertEquals("//42/", OsUtils.getOsPath("\\/42"));
        assertEquals("//darwin/", OsUtils.getOsPath("\\/darwin"));
        assertEquals("//macos/", OsUtils.getOsPath("\\/macos"));
        assertEquals("//solaris/", OsUtils.getOsPath("\\/solaris"));
        assertEquals("//sunos/", OsUtils.getOsPath("\\/sunos"));
        assertEquals("//windows/", OsUtils.getOsPath("\\/windows"));
        assertEquals("/os.name/", OsUtils.getOsPath("\\os.name\\"));
        assertEquals("/os.name//", OsUtils.getOsPath("\\os.name\\\\"));
        assertEquals("/os.name/", OsUtils.getOsPath("\\os.name/"));
        assertEquals("/os.nameos.name/", OsUtils.getOsPath("\\os.nameos.name"));
        assertEquals("/os.namelinux/", OsUtils.getOsPath("\\os.namelinux"));
        assertEquals("/os.namefoo/", OsUtils.getOsPath("\\os.namefoo"));
        assertEquals("/os.name42/", OsUtils.getOsPath("\\os.name42"));
        assertEquals("/os.namedarwin/", OsUtils.getOsPath("\\os.namedarwin"));
        assertEquals("/os.namemacos/", OsUtils.getOsPath("\\os.namemacos"));
        assertEquals("/os.namesolaris/", OsUtils.getOsPath("\\os.namesolaris"));
        assertEquals("/os.namesunos/", OsUtils.getOsPath("\\os.namesunos"));
        assertEquals("/os.namewindows/", OsUtils.getOsPath("\\os.namewindows"));
        assertEquals("/linux/", OsUtils.getOsPath("\\linux\\"));
        assertEquals("/linux//", OsUtils.getOsPath("\\linux\\\\"));
        assertEquals("/linux/", OsUtils.getOsPath("\\linux/"));
        assertEquals("/linuxos.name/", OsUtils.getOsPath("\\linuxos.name"));
        assertEquals("/linuxlinux/", OsUtils.getOsPath("\\linuxlinux"));
        assertEquals("/linuxfoo/", OsUtils.getOsPath("\\linuxfoo"));
        assertEquals("/linux42/", OsUtils.getOsPath("\\linux42"));
        assertEquals("/linuxdarwin/", OsUtils.getOsPath("\\linuxdarwin"));
        assertEquals("/linuxmacos/", OsUtils.getOsPath("\\linuxmacos"));
        assertEquals("/linuxsolaris/", OsUtils.getOsPath("\\linuxsolaris"));
        assertEquals("/linuxsunos/", OsUtils.getOsPath("\\linuxsunos"));
        assertEquals("/linuxwindows/", OsUtils.getOsPath("\\linuxwindows"));
        assertEquals("/foo/", OsUtils.getOsPath("\\foo\\"));
        assertEquals("/foo//", OsUtils.getOsPath("\\foo\\\\"));
        assertEquals("/foo/", OsUtils.getOsPath("\\foo/"));
        assertEquals("/fooos.name/", OsUtils.getOsPath("\\fooos.name"));
        assertEquals("/foolinux/", OsUtils.getOsPath("\\foolinux"));
        assertEquals("/foofoo/", OsUtils.getOsPath("\\foofoo"));
        assertEquals("/foo42/", OsUtils.getOsPath("\\foo42"));
        assertEquals("/foodarwin/", OsUtils.getOsPath("\\foodarwin"));
        assertEquals("/foomacos/", OsUtils.getOsPath("\\foomacos"));
        assertEquals("/foosolaris/", OsUtils.getOsPath("\\foosolaris"));
        assertEquals("/foosunos/", OsUtils.getOsPath("\\foosunos"));
        assertEquals("/foowindows/", OsUtils.getOsPath("\\foowindows"));
        assertEquals("/42/", OsUtils.getOsPath("\\42\\"));
        assertEquals("/42//", OsUtils.getOsPath("\\42\\\\"));
        assertEquals("/42/", OsUtils.getOsPath("\\42/"));
        assertEquals("/42os.name/", OsUtils.getOsPath("\\42os.name"));
        assertEquals("/42linux/", OsUtils.getOsPath("\\42linux"));
        assertEquals("/42foo/", OsUtils.getOsPath("\\42foo"));
        assertEquals("/4242/", OsUtils.getOsPath("\\4242"));
        assertEquals("/42darwin/", OsUtils.getOsPath("\\42darwin"));
        assertEquals("/42macos/", OsUtils.getOsPath("\\42macos"));
        assertEquals("/42solaris/", OsUtils.getOsPath("\\42solaris"));
        assertEquals("/42sunos/", OsUtils.getOsPath("\\42sunos"));
        assertEquals("/42windows/", OsUtils.getOsPath("\\42windows"));
        assertEquals("/darwin/", OsUtils.getOsPath("\\darwin\\"));
        assertEquals("/darwin//", OsUtils.getOsPath("\\darwin\\\\"));
        assertEquals("/darwin/", OsUtils.getOsPath("\\darwin/"));
        assertEquals("/darwinos.name/", OsUtils.getOsPath("\\darwinos.name"));
        assertEquals("/darwinlinux/", OsUtils.getOsPath("\\darwinlinux"));
        assertEquals("/darwinfoo/", OsUtils.getOsPath("\\darwinfoo"));
        assertEquals("/darwin42/", OsUtils.getOsPath("\\darwin42"));
        assertEquals("/darwindarwin/", OsUtils.getOsPath("\\darwindarwin"));
        assertEquals("/darwinmacos/", OsUtils.getOsPath("\\darwinmacos"));
        assertEquals("/darwinsolaris/", OsUtils.getOsPath("\\darwinsolaris"));
        assertEquals("/darwinsunos/", OsUtils.getOsPath("\\darwinsunos"));
        assertEquals("/darwinwindows/", OsUtils.getOsPath("\\darwinwindows"));
        assertEquals("/macos/", OsUtils.getOsPath("\\macos\\"));
        assertEquals("/macos//", OsUtils.getOsPath("\\macos\\\\"));
        assertEquals("/macos/", OsUtils.getOsPath("\\macos/"));
        assertEquals("/macosos.name/", OsUtils.getOsPath("\\macosos.name"));
        assertEquals("/macoslinux/", OsUtils.getOsPath("\\macoslinux"));
        assertEquals("/macosfoo/", OsUtils.getOsPath("\\macosfoo"));
        assertEquals("/macos42/", OsUtils.getOsPath("\\macos42"));
        assertEquals("/macosdarwin/", OsUtils.getOsPath("\\macosdarwin"));
        assertEquals("/macosmacos/", OsUtils.getOsPath("\\macosmacos"));
        assertEquals("/macossolaris/", OsUtils.getOsPath("\\macossolaris"));
        assertEquals("/macossunos/", OsUtils.getOsPath("\\macossunos"));
        assertEquals("/macoswindows/", OsUtils.getOsPath("\\macoswindows"));
        assertEquals("/solaris/", OsUtils.getOsPath("\\solaris\\"));
        assertEquals("/solaris//", OsUtils.getOsPath("\\solaris\\\\"));
        assertEquals("/solaris/", OsUtils.getOsPath("\\solaris/"));
        assertEquals("/solarisos.name/", OsUtils.getOsPath("\\solarisos.name"));
        assertEquals("/solarislinux/", OsUtils.getOsPath("\\solarislinux"));
        assertEquals("/solarisfoo/", OsUtils.getOsPath("\\solarisfoo"));
        assertEquals("/solaris42/", OsUtils.getOsPath("\\solaris42"));
        assertEquals("/solarisdarwin/", OsUtils.getOsPath("\\solarisdarwin"));
        assertEquals("/solarismacos/", OsUtils.getOsPath("\\solarismacos"));
        assertEquals("/solarissolaris/", OsUtils.getOsPath("\\solarissolaris"));
        assertEquals("/solarissunos/", OsUtils.getOsPath("\\solarissunos"));
        assertEquals("/solariswindows/", OsUtils.getOsPath("\\solariswindows"));
        assertEquals("/sunos/", OsUtils.getOsPath("\\sunos\\"));
        assertEquals("/sunos//", OsUtils.getOsPath("\\sunos\\\\"));
        assertEquals("/sunos/", OsUtils.getOsPath("\\sunos/"));
        assertEquals("/sunosos.name/", OsUtils.getOsPath("\\sunosos.name"));
        assertEquals("/sunoslinux/", OsUtils.getOsPath("\\sunoslinux"));
        assertEquals("/sunosfoo/", OsUtils.getOsPath("\\sunosfoo"));
        assertEquals("/sunos42/", OsUtils.getOsPath("\\sunos42"));
        assertEquals("/sunosdarwin/", OsUtils.getOsPath("\\sunosdarwin"));
        assertEquals("/sunosmacos/", OsUtils.getOsPath("\\sunosmacos"));
        assertEquals("/sunossolaris/", OsUtils.getOsPath("\\sunossolaris"));
        assertEquals("/sunossunos/", OsUtils.getOsPath("\\sunossunos"));
        assertEquals("/sunoswindows/", OsUtils.getOsPath("\\sunoswindows"));
        assertEquals("/windows/", OsUtils.getOsPath("\\windows\\"));
        assertEquals("/windows//", OsUtils.getOsPath("\\windows\\\\"));
        assertEquals("/windows/", OsUtils.getOsPath("\\windows/"));
        assertEquals("/windowsos.name/", OsUtils.getOsPath("\\windowsos.name"));
        assertEquals("/windowslinux/", OsUtils.getOsPath("\\windowslinux"));
        assertEquals("/windowsfoo/", OsUtils.getOsPath("\\windowsfoo"));
        assertEquals("/windows42/", OsUtils.getOsPath("\\windows42"));
        assertEquals("/windowsdarwin/", OsUtils.getOsPath("\\windowsdarwin"));
        assertEquals("/windowsmacos/", OsUtils.getOsPath("\\windowsmacos"));
        assertEquals("/windowssolaris/", OsUtils.getOsPath("\\windowssolaris"));
        assertEquals("/windowssunos/", OsUtils.getOsPath("\\windowssunos"));
        assertEquals("/windowswindows/", OsUtils.getOsPath("\\windowswindows"));
    }

    /**
     * Method under test: {@link OsUtils#getOsHomeDir()}
     */
    @Test
    void testGetOsHomeDir() {
        assertEquals("/opt/hypnozcore/", OsUtils.getOsHomeDir());
    }

    /**
     * Method under test: {@link OsUtils#getTempDir()}
     */
    @Test
    void testGetTempDir() {
        assertEquals("/opt/hypnozcore//temps", OsUtils.getTempDir());
    }
}

