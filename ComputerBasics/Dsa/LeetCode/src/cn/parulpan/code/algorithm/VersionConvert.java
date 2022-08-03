package cn.parulpan.code.algorithm;

/**
 * @author parzulpan
 * @since 2022/07/21
 */
public class VersionConvert {
    public static void main(String[] args) {
        VersionConvert versionConvert = new VersionConvert();
        System.out.println(versionConvert.covertVersionNumber("1.9.1"));
        System.out.println(versionConvert.covertVersionNumber("1.9.11"));
        System.out.println(versionConvert.covertVersionNumber("1.10.1"));
        System.out.println(versionConvert.covertVersionNumber("1.10.11"));
    }

     /**
     * 1.9.1 -> 1009001  1.10.3 -> 1010003
     */
    private Long covertVersionNumber(String version) {
        String[] versionArr = version.split("\\.");
        String a = versionArr[0];
        String b = versionArr[1];
        String c = versionArr[2];

        StringBuilder bV = new StringBuilder(b);
        StringBuilder cV = new StringBuilder(c);

        int bLength = b.length();
        while (bLength < 3) {
            bV.insert(0, "0");
            bLength++;
        }

        int cLength = c.length();
        while (cLength < 3) {
            cV.insert(0, "0");
            cLength++;
        }

        return Long.parseLong(a + bV + cV);
    }
}