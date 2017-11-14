package ip_range_to_cidr;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class IPRangetoCIDR {
    /*
        IP range to CIDR
        https://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing
        http://www.ipaddressguide.com/cidr
        Difficulty: Medium
     */
    public class Solution {
        private long ipToLong(String strIP) {
            long[] ip = new long[4];
            String[] ipSec = strIP.split("\\.");
            for (int k = 0; k < 4; k++) {
                ip[k] = Long.valueOf(ipSec[k]);
            }

            return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
        }

        private String longToIP(long longIP) {
            StringBuffer sb = new StringBuffer("");
            sb.append(String.valueOf(longIP >>> 24));
            sb.append(".");
            sb.append(String.valueOf((longIP & 0x00FFFFFF) >>> 16));
            sb.append(".");
            sb.append(String.valueOf((longIP & 0x0000FFFF) >>> 8));
            sb.append(".");
            sb.append(String.valueOf(longIP & 0x000000FF));

            return sb.toString();
        }

        public List<String> ipRange2Cidr(String startIp, int range ) {
            // check parameters
            String a = "";
            long start = ipToLong(startIp);
            long end = start + range - 1;

            List<String> res = new ArrayList<>();
            while (start <= end) {
                // identify the location of first 1's from lower bit to higher bit of start IP
                // e.g. 00000001.00000001.00000001.01101100, return 4 (100)
                long locOfFirstOne = start & (-start);
                int maxMask = 32 - (int) (Math.log(locOfFirstOne) / Math.log(2));

                // calculate how many IP addresses between the start and end
                // e.g. between 1.1.1.111 and 1.1.1.120, there are 10 IP address
                // 3 bits to represent 8 IPs, from 1.1.1.112 to 1.1.1.119 (119 - 112 + 1 = 8)
                double curRange = Math.log(end - start + 1) / Math.log(2);
                int maxDiff = 32 - (int) Math.floor(curRange);

                // why max?
                // if the maxDiff is larger than maxMask
                // which means the numbers of IPs from start to end is smaller than mask range
                // so we can't use as many as bits we want to mask the start IP to avoid exceed the end IP
                // Otherwise, if maxDiff is smaller than maxMask, which means number of IPs is larger than mask range
                // in this case we can use maxMask to mask as many as IPs from start we want.
                maxMask = Math.max(maxDiff, maxMask);

                // Add to results
                String ip = longToIP(start);
                res.add(ip + "/" + maxMask);
                // We have already included 2^(32 - maxMask) numbers of IP into result
                // So the next round start must add that number
                start += Math.pow(2, (32 - maxMask));
            }
            return res;
        }
    }


    /*
        IP range to CIDR
        https://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing
        http://www.ipaddressguide.com/cidr
        Difficulty: Medium
     */
    public class Solution_2 {
        public List<String> ipRange2Cidr(String startIp, int range) {
            long start = ip2Long(startIp);
            long end = start + range - 1;

            List<String> res = new ArrayList<>();
            while (start <= end) {
                long maskCovered = start & (-start);
                int maskBits = (int)(Math.log(maskCovered) / Math.log(2));
                long remain = end - start + 1;
                int remainBits = (int)(Math.log(remain) / Math.log(2));

                StringBuilder sb = new StringBuilder();
                int actualBits = Math.min(maskBits, remainBits);
                res.add(sb.append(long2Ip(start)).append("/").append(32 - actualBits).toString());

                start += (long)Math.pow(2, actualBits);
            }

            return res;
        }

        // 256-based to 10-based
        private long ip2Long(String ip) {
            String[] parts = ip.split("\\.");
            long sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += Long.parseLong(parts[i]);
                if (i < 3) {
                    sum <<= 8;
                }
            }

            return sum;
        }

        // 10-based to 256-based
        private String long2Ip(long num) {
            StringBuilder sb = new StringBuilder();
            sb.append(num >> 24);
            sb.append(".");
            sb.append((num & 0x00FFFFFF) >> 16);
            sb.append(".");
            sb.append((num & 0x0000FFFF) >> 8);
            sb.append(".");
            sb.append((num & 0x000000FF));
            return sb.toString();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new IPRangetoCIDR().new Solution();
            List<String> res = sol.ipRange2Cidr("255.0.0.7", 10);
            assertEquals(3, res.size());
            assertEquals("255.0.0.7/32", res.get(0));
            assertEquals("255.0.0.8/29", res.get(1));
            assertEquals("255.0.0.16/32", res.get(2));

            res = sol.ipRange2Cidr("1.1.1.0", 4);
            assertEquals(1, res.size());
            assertEquals("1.1.1.0/30", res.get(0));


            res = sol.ipRange2Cidr("1.1.1.1", 4);
            assertEquals(3, res.size());
            assertEquals("1.1.1.1/32", res.get(0));
            assertEquals("1.1.1.2/31", res.get(1));
            assertEquals("1.1.1.4/32", res.get(2));
        }

        @Test
        public void test2() {
            Solution_2 sol = new IPRangetoCIDR().new Solution_2();
            List<String> res = sol.ipRange2Cidr("255.0.0.7", 10);
            assertEquals(3, res.size());
            assertEquals("255.0.0.7/32", res.get(0));
            assertEquals("255.0.0.8/29", res.get(1));
            assertEquals("255.0.0.16/32", res.get(2));

            res = sol.ipRange2Cidr("1.1.1.0", 4);
            assertEquals(1, res.size());
            assertEquals("1.1.1.0/30", res.get(0));


            res = sol.ipRange2Cidr("1.1.1.1", 4);
            assertEquals(3, res.size());
            assertEquals("1.1.1.1/32", res.get(0));
            assertEquals("1.1.1.2/31", res.get(1));
            assertEquals("1.1.1.4/32", res.get(2));
        }
    }
}

