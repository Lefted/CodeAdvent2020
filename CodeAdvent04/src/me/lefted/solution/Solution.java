package me.lefted.solution;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
	String input = "iyr:2015\r\n" + "hgt:59cm byr:2029 cid:219 pid:9381688753 eyr:1992 hcl:#b6652a\r\n" + "ecl:#7a0fa6\r\n" + "\r\n"
	    + "ecl:blu iyr:2018 pid:943614755 cid:335\r\n" + "byr:1968\r\n" + "eyr:2026\r\n" + "\r\n" + "pid:067285985 hcl:#ceb3a1 cid:281\r\n"
	    + "ecl:#07219a eyr:1944\r\n" + "iyr:2025\r\n" + "byr:2029 hgt:64cm\r\n" + "\r\n" + "hgt:185cm\r\n" + "ecl:gry cid:222\r\n" + "iyr:2016\r\n"
	    + "hcl:#866857 byr:1970 pid:269105457 eyr:2026\r\n" + "\r\n" + "pid:260043570 hcl:#b6652a cid:275 byr:1990 ecl:brn\r\n" + "hgt:163cm iyr:2012\r\n"
	    + "\r\n" + "hgt:181cm pid:604983466\r\n" + "iyr:1930 eyr:2039 byr:1950 ecl:#906548 hcl:#b6652a\r\n" + "\r\n"
	    + "iyr:2025 eyr:1956 hcl:z pid:#1c42cc byr:2006\r\n" + "cid:327 hgt:141 ecl:#f2affc\r\n" + "\r\n" + "hgt:178cm byr:1939 pid:595705064 ecl:oth\r\n"
	    + "iyr:2020 eyr:2026\r\n" + "hcl:#888785\r\n" + "\r\n" + "hgt:159cm iyr:2016\r\n" + "hcl:#efcc98 pid:139063139 byr:1980 ecl:brn\r\n"
	    + "eyr:2020\r\n" + "\r\n" + "pid:646870519 hgt:179cm eyr:2022 iyr:2011 hcl:#602927\r\n" + "ecl:brn\r\n" + "byr:1997\r\n" + "\r\n"
	    + "hgt:170cm hcl:#ceb3a1 iyr:2014 eyr:2023 ecl:oth pid:243067344 byr:1962\r\n" + "\r\n" + "hcl:#866857\r\n" + "ecl:oth pid:704529614\r\n"
	    + "byr:1941 cid:94\r\n" + "eyr:2026 hgt:180cm\r\n" + "iyr:2010\r\n" + "\r\n" + "iyr:1924\r\n" + "pid:36196401\r\n" + "hgt:74cm eyr:1921\r\n"
	    + "ecl:#3acf57 hcl:a4e4c0 byr:2024\r\n" + "cid:153\r\n" + "\r\n" + "pid:770262094 hcl:#866857\r\n" + "eyr:2020 hgt:151cm\r\n" + "ecl:blu\r\n"
	    + "iyr:2012\r\n" + "byr:2002\r\n" + "cid:242\r\n" + "\r\n" + "pid:984364862 ecl:dne\r\n" + "iyr:2020\r\n"
	    + "hgt:151 eyr:2023 cid:314 hcl:z byr:2012\r\n" + "\r\n" + "hgt:178cm iyr:2020 hcl:#6b5442 ecl:grn cid:323 eyr:2030 byr:1925 pid:285882039\r\n"
	    + "\r\n" + "iyr:2019 pid:986123633\r\n" + "eyr:2024 byr:1990 hcl:#7d3b0c ecl:hzl hgt:192cm\r\n" + "\r\n" + "hgt:90\r\n" + "byr:2025 iyr:1933\r\n"
	    + "ecl:dne eyr:2040 pid:8194347544\r\n" + "\r\n" + "hgt:163cm byr:1934 eyr:2026 ecl:amb hcl:#eec6fb cid:303 pid:721792159 iyr:2013\r\n" + "\r\n"
	    + "iyr:2019\r\n" + "byr:1920 hcl:#a97842\r\n" + "cid:186 eyr:2020\r\n" + "ecl:oth\r\n" + "hgt:167cm pid:217112082\r\n" + "\r\n"
	    + "pid:#55ce6b hcl:d30f6b eyr:2040 hgt:60cm ecl:dne iyr:1920\r\n" + "cid:107 byr:2029\r\n" + "\r\n"
	    + "ecl:amb eyr:2024 pid:644304174 hcl:#6b5442 iyr:2018\r\n" + "byr:1935\r\n" + "hgt:182cm\r\n" + "\r\n" + "ecl:hzl pid:559383552\r\n"
	    + "hcl:#ceb3a1 eyr:2024 hgt:161cm byr:1968 iyr:2010\r\n" + "\r\n" + "iyr:2018\r\n" + "hcl:43fafb\r\n" + "hgt:65cm eyr:2027\r\n"
	    + "byr:1937 pid:#4bff3e ecl:grt\r\n" + "\r\n" + "eyr:2024\r\n" + "iyr:2014 cid:163 byr:1924 hcl:#18171d\r\n" + "hgt:166cm\r\n" + "\r\n"
	    + "eyr:2026 pid:955203781\r\n" + "iyr:2016 cid:52 hgt:167cm\r\n" + "ecl:grn byr:1963\r\n" + "\r\n" + "pid:479898570 hgt:165cm eyr:2024 byr:1932\r\n"
	    + "iyr:2010 ecl:grn\r\n" + "cid:88\r\n" + "hcl:#c0a76e\r\n" + "\r\n"
	    + "cid:241 hgt:178cm ecl:blu pid:069760797 hcl:#623a2f byr:1925 eyr:2029 iyr:2019\r\n" + "\r\n" + "hgt:172cm eyr:2036\r\n"
	    + "iyr:2016 pid:#98caec\r\n" + "ecl:dne hcl:z\r\n" + "\r\n" + "ecl:#510672 iyr:1938 byr:2018 hgt:172in hcl:z cid:339 eyr:2039\r\n"
	    + "pid:#6c1216\r\n" + "\r\n" + "hcl:#efcc98\r\n" + "byr:1972 ecl:brn iyr:2011 pid:190911803 eyr:2025 hgt:171cm\r\n" + "\r\n"
	    + "pid:0636917222 byr:2009 hgt:96\r\n" + "hcl:z\r\n" + "iyr:1997 ecl:hzl eyr:2026\r\n" + "\r\n"
	    + "byr:1989 iyr:2011 pid:071588682 cid:155 ecl:grn\r\n" + "hcl:#ceb3a1 eyr:1955 hgt:170cm\r\n" + "\r\n"
	    + "cid:266 hcl:#a97842 byr:1964 hgt:175cm\r\n" + "iyr:2017 ecl:brn\r\n" + "\r\n" + "pid:930133867 ecl:grn hcl:#733820 hgt:63in byr:1995\r\n"
	    + "eyr:2021 iyr:2014\r\n" + "\r\n" + "eyr:2025 pid:284329794\r\n" + "ecl:blu hcl:#ceb3a1 iyr:2012\r\n" + "hgt:65in byr:1961\r\n" + "\r\n"
	    + "iyr:2010 byr:1998\r\n" + "hgt:160cm\r\n" + "eyr:2029 hcl:#cfa07d\r\n" + "pid:253052921\r\n" + "ecl:amb cid:324\r\n" + "\r\n"
	    + "pid:026835791 byr:1999 eyr:2022 hgt:162cm\r\n" + "hcl:#7d3b0c ecl:brn iyr:2014\r\n" + "\r\n"
	    + "pid:672752198 eyr:2030 byr:1952 hgt:65in iyr:2016 ecl:amb\r\n" + "hcl:#cfa07d\r\n" + "\r\n" + "hgt:193in\r\n"
	    + "byr:2019 hcl:z pid:#cbc08c iyr:1951 ecl:#3e9f2f eyr:2002\r\n" + "\r\n" + "ecl:utc pid:571477176\r\n" + "byr:2012 eyr:1929 cid:240\r\n"
	    + "hgt:175in hcl:f4ef32\r\n" + "\r\n" + "cid:93 hcl:#a5db2a\r\n" + "pid:274721479 byr:1940 eyr:2022 ecl:gry\r\n" + "hgt:157cm iyr:2012\r\n" + "\r\n"
	    + "pid:540858450 iyr:2014 cid:95 byr:1964\r\n" + "hgt:156cm hcl:#866857 ecl:brn eyr:2026\r\n" + "\r\n" + "pid:532626994 byr:1939 iyr:2017\r\n"
	    + "ecl:blu eyr:2026\r\n" + "hcl:#fffffd hgt:184cm\r\n" + "\r\n" + "hgt:70 pid:404622083\r\n" + "iyr:2026\r\n"
	    + "byr:2022 hcl:c1ba7f eyr:1979 ecl:lzr\r\n" + "\r\n" + "pid:931910908\r\n" + "cid:177 hcl:#6b5442\r\n" + "ecl:gry hgt:184cm\r\n"
	    + "byr:1963 eyr:2020\r\n" + "iyr:2014\r\n" + "\r\n" + "iyr:2019 eyr:2022 hcl:#ceb3a1 hgt:191cm ecl:gry pid:954124659 cid:123 byr:1939\r\n" + "\r\n"
	    + "pid:411032659 byr:1950\r\n" + "hgt:153cm eyr:2020 iyr:2014 ecl:hzl\r\n" + "\r\n"
	    + "hgt:156cm eyr:2023 pid:29836124 byr:2017 hcl:56de83 ecl:zzz cid:179\r\n" + "iyr:2018\r\n" + "\r\n"
	    + "hcl:#866857 iyr:2014 hgt:190cm byr:1998 pid:565524574 eyr:2020\r\n" + "\r\n" + "byr:1973 hcl:#888785 iyr:2016 eyr:2028 hgt:173cm ecl:blu\r\n"
	    + "\r\n" + "byr:1987\r\n" + "pid:028825120 hcl:#7d3b0c\r\n" + "eyr:2023 hgt:190cm ecl:oth iyr:2014\r\n" + "\r\n" + "eyr:2036 pid:172661617\r\n"
	    + "ecl:#ae607d byr:2017 hcl:z\r\n" + "hgt:82 cid:153\r\n" + "\r\n" + "pid:202888577 eyr:2028 iyr:2013\r\n" + "byr:1933\r\n"
	    + "hgt:68in cid:151 hcl:#b6652a ecl:brn\r\n" + "\r\n" + "iyr:2020\r\n" + "ecl:amb eyr:2025 hcl:#a355be hgt:63in pid:146650894\r\n" + "\r\n"
	    + "iyr:2016 hgt:192cm pid:531372965 hcl:#fffffd\r\n" + "ecl:blu eyr:2025\r\n" + "\r\n"
	    + "eyr:2025 ecl:blu byr:1961 cid:224 iyr:2016 hcl:#6b5442 pid:368694418\r\n" + "hgt:169cm\r\n" + "\r\n" + "pid:43707504 iyr:1945\r\n"
	    + "ecl:grt byr:2010\r\n" + "eyr:2026 cid:273\r\n" + "hgt:165in hcl:z\r\n" + "\r\n" + "hgt:159cm ecl:gry\r\n" + "hcl:#6b5442\r\n"
	    + "eyr:2030 pid:915819272 iyr:2015\r\n" + "\r\n" + "pid:808392314 ecl:gry cid:285 hcl:#efcc98 byr:1923 hgt:161cm iyr:1941 eyr:2020\r\n" + "\r\n"
	    + "iyr:2017\r\n" + "hgt:161cm\r\n" + "eyr:2025 hcl:#602927 ecl:oth pid:081917611 byr:1983\r\n" + "\r\n"
	    + "eyr:2028 pid:831032131 ecl:brn iyr:2013 hcl:#341e13 cid:198 byr:1991 hgt:67in\r\n" + "\r\n"
	    + "hgt:181cm cid:320 pid:032769757 ecl:grn hcl:#733820\r\n" + "eyr:2022 byr:1992\r\n" + "\r\n"
	    + "iyr:2010 cid:128 hgt:171cm byr:1932 pid:923377839 ecl:brn\r\n" + "hcl:#18171d eyr:2020\r\n" + "\r\n"
	    + "ecl:hzl iyr:2021 byr:2008 pid:569583509 hcl:f74823\r\n" + "hgt:188in\r\n" + "\r\n"
	    + "iyr:2016 hcl:z eyr:2021 ecl:#24ceee pid:349492243 hgt:67cm\r\n" + "cid:144 byr:2010\r\n" + "\r\n" + "ecl:gry\r\n"
	    + "byr:2029 hcl:3a0c30 hgt:163in eyr:1962\r\n" + "\r\n" + "byr:1927 hgt:180\r\n" + "cid:87\r\n" + "ecl:#7ea777\r\n"
	    + "hcl:#623a2f iyr:2024 pid:597098940 eyr:2027\r\n" + "\r\n" + "cid:89 hgt:193cm hcl:#623a2f\r\n" + "iyr:2010 eyr:2026\r\n"
	    + "pid:374988952 ecl:hzl byr:1973\r\n" + "\r\n" + "eyr:2023 iyr:2013 byr:1977\r\n" + "cid:329 pid:711256829 ecl:grn hgt:154cm\r\n"
	    + "hcl:#866857\r\n" + "\r\n" + "pid:212535692 ecl:brn\r\n" + "hcl:#b6652a hgt:169cm eyr:2025 byr:1920 iyr:2019\r\n" + "\r\n" + "ecl:blu\r\n"
	    + "byr:1962\r\n" + "hgt:157cm iyr:2020 eyr:2027 pid:451039029\r\n" + "hcl:#6b5442\r\n" + "\r\n" + "hgt:187cm pid:187808959 eyr:2026 iyr:2020\r\n"
	    + "ecl:oth\r\n" + "byr:1956 hcl:#733820\r\n" + "\r\n" + "byr:1959 hgt:160cm ecl:blu hcl:#6b5442\r\n" + "cid:193 eyr:2026\r\n" + "iyr:2014\r\n"
	    + "pid:812555315\r\n" + "\r\n" + "hgt:153cm iyr:2011\r\n" + "ecl:grn hcl:#ceb3a1\r\n" + "eyr:2026 byr:1966 pid:503356330\r\n" + "\r\n"
	    + "ecl:#95d8a9\r\n" + "eyr:2024 pid:382174744\r\n" + "iyr:2025\r\n" + "hgt:152 hcl:#888785 byr:2012\r\n" + "\r\n" + "eyr:2028\r\n"
	    + "iyr:2017 byr:1938\r\n" + "cid:279 hcl:#733820 ecl:amb pid:497365268 hgt:191cm\r\n" + "\r\n" + "cid:335 byr:1982 hgt:171cm iyr:2013\r\n"
	    + "ecl:hzl eyr:2030\r\n" + "hcl:#efcc98 pid:018900639\r\n" + "\r\n" + "eyr:2029 hgt:175cm pid:530128340\r\n" + "hcl:#888785\r\n" + "ecl:gry\r\n"
	    + "byr:1947 iyr:2019\r\n" + "\r\n" + "hgt:183cm\r\n" + "hcl:#6b5442 eyr:2023 ecl:grn\r\n" + "byr:1934\r\n" + "\r\n"
	    + "hcl:f8ed45 cid:54 iyr:1997\r\n" + "hgt:69cm eyr:2037 ecl:gry\r\n" + "pid:184cm byr:2012\r\n" + "\r\n"
	    + "ecl:grn hcl:#733820 byr:1928 pid:002528194\r\n" + "iyr:2014 eyr:2021 hgt:157cm\r\n" + "\r\n" + "hgt:163in\r\n"
	    + "hcl:#c0946f byr:2018 eyr:2021\r\n" + "iyr:1955 ecl:#216920 pid:87155266\r\n" + "cid:298\r\n" + "\r\n"
	    + "eyr:2026 byr:1945 cid:161 iyr:2017 hgt:170cm hcl:#fffffd ecl:hzl pid:649441221\r\n" + "\r\n" + "byr:1930\r\n"
	    + "iyr:2014 pid:151910079 hcl:#18171d ecl:oth eyr:2029\r\n" + "hgt:169cm\r\n" + "\r\n" + "ecl:blu byr:1950 iyr:2010 cid:260 hcl:#cfa07d\r\n"
	    + "hgt:167cm\r\n" + "pid:910685738 eyr:2021\r\n" + "\r\n" + "hgt:182cm byr:1993\r\n" + "eyr:2030 pid:073035999 hcl:#341e13\r\n" + "cid:117\r\n"
	    + "\r\n" + "byr:1981\r\n" + "hcl:#866857\r\n" + "eyr:2028 iyr:2012 ecl:blu pid:620133246 hgt:157cm\r\n" + "\r\n" + "hgt:191cm\r\n"
	    + "iyr:2010 pid:089995590 eyr:2023 ecl:amb byr:1986 hcl:#733820\r\n" + "\r\n" + "iyr:2019 ecl:gry\r\n"
	    + "hgt:165cm pid:910093364 hcl:#efcc98 byr:1997\r\n" + "eyr:2028\r\n" + "cid:153\r\n" + "\r\n" + "hgt:83 hcl:174774 eyr:2032\r\n"
	    + "ecl:xry iyr:2017 byr:1940\r\n" + "\r\n" + "byr:1943\r\n" + "pid:980352645\r\n" + "iyr:2015 hgt:66 eyr:2023 hcl:#b6652a ecl:oth\r\n" + "\r\n"
	    + "ecl:amb byr:1980 hgt:164cm pid:775303596 hcl:#671bed iyr:2013 eyr:2030\r\n" + "\r\n"
	    + "hgt:173cm byr:1947 eyr:1947 iyr:1940 ecl:gmt hcl:7e515c\r\n" + "\r\n" + "hcl:#b6652a\r\n" + "iyr:2012\r\n" + "eyr:2030 hgt:185cm ecl:grn\r\n"
	    + "\r\n" + "ecl:amb byr:1940 hcl:#2943a5 iyr:2015\r\n" + "hgt:185cm pid:931660417\r\n" + "eyr:2021\r\n" + "\r\n" + "eyr:1957 hcl:#623a2f\r\n"
	    + "ecl:grt hgt:62cm pid:#af106a iyr:2012\r\n" + "cid:59 byr:1985\r\n" + "\r\n" + "ecl:amb eyr:2025\r\n"
	    + "pid:351412754 iyr:2014 byr:1941 hcl:#6b5442 hgt:174cm\r\n" + "\r\n" + "pid:5621200134 hcl:6ef9ba ecl:#ef68f5 eyr:1924\r\n"
	    + "hgt:63cm cid:188 byr:2004\r\n" + "\r\n" + "hcl:#a97842 byr:1976 eyr:2020 hgt:171cm pid:041926354 iyr:2019\r\n" + "\r\n" + "cid:234\r\n"
	    + "byr:2025 hcl:98619a pid:181cm eyr:1941\r\n" + "iyr:2021\r\n" + "hgt:167in ecl:#f5e651\r\n" + "\r\n"
	    + "hgt:73cm eyr:2028 byr:1985 iyr:1949 hcl:z ecl:utc cid:207 pid:#ee9f95\r\n" + "\r\n" + "pid:179cm eyr:2030 hcl:b8e142\r\n" + "hgt:69cm\r\n"
	    + "iyr:1933\r\n" + "byr:1934\r\n" + "ecl:grn\r\n" + "\r\n" + "iyr:2028 eyr:1954 hgt:111 cid:180 pid:183391861\r\n"
	    + "byr:2030 hcl:1fb30f ecl:#0d0160\r\n" + "\r\n" + "ecl:#0b3b2d hgt:191cm byr:2023 pid:727024676 eyr:2025 hcl:#b6652a\r\n" + "\r\n" + "hgt:66in\r\n"
	    + "byr:1923 eyr:2023 ecl:gry\r\n" + "pid:454789451 iyr:2013 hcl:#cfa07d\r\n" + "\r\n" + "eyr:2020\r\n" + "pid:339972685\r\n" + "ecl:amb\r\n"
	    + "iyr:2017 byr:1926 hgt:154cm\r\n" + "hcl:#18171d\r\n" + "\r\n" + "ecl:oth cid:302\r\n" + "byr:1946\r\n" + "hcl:#ceb3a1\r\n"
	    + "pid:622779476 eyr:2024 iyr:2012 hgt:158cm\r\n" + "\r\n" + "byr:2012\r\n" + "pid:748786877 hgt:135 iyr:2016 hcl:b6e962 ecl:gry eyr:2011\r\n"
	    + "\r\n" + "byr:1997\r\n" + "hcl:#a97842\r\n" + "eyr:2022 pid:325672898 ecl:amb hgt:190cm iyr:2010\r\n" + "\r\n"
	    + "cid:210 hcl:#c0946f byr:1957 eyr:2022\r\n" + "iyr:2020 pid:374646087 ecl:blu hgt:184cm\r\n" + "\r\n" + "eyr:2029 ecl:#353e0f\r\n"
	    + "pid:#66ec82\r\n" + "byr:2023 hcl:10d9d8 cid:271\r\n" + "\r\n" + "pid:816485054\r\n" + "eyr:2019 ecl:grn\r\n"
	    + "hcl:#efcc98 hgt:185cm iyr:2013\r\n" + "byr:2014\r\n" + "\r\n" + "hcl:#866857 iyr:2014 byr:1953 eyr:2022 ecl:blu hgt:166cm\r\n" + "\r\n"
	    + "pid:162cm hgt:59cm iyr:1981\r\n" + "eyr:2025 byr:2009\r\n" + "ecl:gmt hcl:116742\r\n" + "\r\n"
	    + "eyr:2028 hgt:67cm hcl:3d1f34 byr:1963 pid:62859332\r\n" + "ecl:dne\r\n" + "iyr:2023\r\n" + "\r\n" + "iyr:2013\r\n"
	    + "pid:271450754 eyr:2016 hcl:e20882 cid:186 hgt:157in ecl:utc byr:2023\r\n" + "\r\n"
	    + "pid:702200026 eyr:1968 ecl:gmt hcl:#888785 iyr:2018 hgt:193in byr:1943\r\n" + "\r\n" + "eyr:2025 byr:1989 ecl:amb hcl:#866857 cid:119\r\n"
	    + "hgt:191cm\r\n" + "pid:556011434\r\n" + "\r\n" + "hgt:178cm iyr:2013\r\n" + "pid:928476807\r\n" + "ecl:amb hcl:#623a2f byr:1996 eyr:2026\r\n"
	    + "\r\n" + "cid:222\r\n" + "pid:325218825 eyr:2021 byr:1983 hgt:155cm ecl:brn iyr:2011\r\n" + "hcl:#fffffd\r\n" + "\r\n"
	    + "pid:949344785 ecl:grn eyr:2025 cid:182 byr:1974 hcl:#ceb3a1\r\n" + "iyr:2011\r\n" + "\r\n"
	    + "cid:269 pid:669599426 hgt:176cm ecl:blu byr:1957\r\n" + "iyr:2015 hcl:#623a2f eyr:2025\r\n" + "\r\n" + "eyr:2023 hcl:#888785\r\n"
	    + "pid:178525132 iyr:2018 hgt:186cm\r\n" + "\r\n" + "ecl:hzl\r\n" + "byr:1940 iyr:2013\r\n" + "hgt:185cm eyr:2028\r\n" + "hcl:#7c73a3\r\n" + "\r\n"
	    + "hcl:z\r\n" + "byr:2001 cid:292 ecl:#d56bbd pid:93473192\r\n" + "iyr:2003 hgt:150\r\n" + "eyr:1922\r\n" + "\r\n" + "eyr:2021 pid:786485899\r\n"
	    + "hgt:170cm hcl:#efcc98 byr:1955\r\n" + "iyr:2010 ecl:brn\r\n" + "\r\n"
	    + "hcl:#733820 ecl:hzl hgt:157cm byr:1944 eyr:2027 pid:906803629 iyr:2015\r\n" + "\r\n" + "hgt:151cm ecl:blu iyr:2016\r\n"
	    + "hcl:#02ffd7 byr:1995\r\n" + "pid:369315941 eyr:2026\r\n" + "\r\n" + "cid:330 ecl:#18e883 eyr:2038\r\n" + "hcl:z iyr:1929\r\n"
	    + "hgt:193 pid:33765426\r\n" + "\r\n" + "pid:743094345 eyr:2027\r\n" + "iyr:1949 byr:1955\r\n" + "ecl:gry\r\n" + "hgt:160cm hcl:8dae67\r\n" + "\r\n"
	    + "cid:167 hcl:#18171d\r\n" + "iyr:2016 pid:214065645 byr:1942 eyr:2030 hgt:183cm ecl:hzl\r\n" + "\r\n" + "ecl:brn hcl:#623a2f cid:171 byr:1971\r\n"
	    + "iyr:2011 eyr:2028\r\n" + "pid:607344613\r\n" + "hgt:153cm\r\n" + "\r\n"
	    + "byr:1921 pid:677007802 hcl:#341e13 ecl:brn iyr:2012 hgt:188cm eyr:2028\r\n" + "\r\n" + "hgt:162cm cid:319 hcl:z iyr:2025\r\n"
	    + "byr:1989 eyr:1939 pid:67311222\r\n" + "ecl:utc\r\n" + "\r\n" + "iyr:2014 eyr:2025 hgt:171cm\r\n" + "cid:302 byr:1997\r\n" + "hcl:z\r\n"
	    + "ecl:amb pid:101363367\r\n" + "\r\n" + "ecl:oth iyr:2010\r\n" + "cid:96 hgt:164cm hcl:4bc20a byr:1947\r\n" + "pid:166115442 eyr:2030\r\n" + "\r\n"
	    + "byr:1964\r\n" + "hcl:#6b5442 hgt:156cm eyr:2022 pid:426807062 ecl:brn cid:321 iyr:2012\r\n" + "\r\n"
	    + "byr:2012 hcl:#888785 cid:298 eyr:1920 ecl:zzz hgt:169cm pid:0660316558 iyr:2019\r\n" + "\r\n"
	    + "hcl:579266 byr:1931 pid:#aa5fd0 ecl:gry eyr:2017 hgt:60 iyr:1965\r\n" + "\r\n" + "iyr:2011\r\n" + "pid:610896691 hcl:#733820\r\n"
	    + "byr:1936\r\n" + "ecl:gry eyr:2021 hgt:161cm\r\n" + "\r\n" + "pid:443246791 iyr:2015 hgt:158cm hcl:#18171d\r\n" + "byr:1928 ecl:brn cid:207\r\n"
	    + "\r\n" + "byr:1950 pid:644579904 hcl:#b6652a\r\n" + "eyr:2027 iyr:2017\r\n" + "ecl:brn hgt:171cm\r\n" + "\r\n" + "iyr:2011 byr:1960\r\n"
	    + "eyr:2023\r\n" + "hgt:171cm ecl:hzl\r\n" + "pid:331465564 cid:205 hcl:#18171d\r\n" + "\r\n"
	    + "hgt:61cm eyr:1987 ecl:#9f458c byr:2023 pid:162cm hcl:z iyr:1997\r\n" + "\r\n" + "hcl:59e376 pid:065607649\r\n" + "iyr:2020\r\n"
	    + "byr:2010 ecl:blu\r\n" + "\r\n" + "pid:167cm byr:2022 hgt:150cm ecl:#06650a hcl:caa145 eyr:2032\r\n" + "iyr:2015\r\n" + "\r\n" + "byr:1932\r\n"
	    + "hcl:#419d73\r\n" + "cid:203 iyr:2017\r\n" + "pid:105921085\r\n" + "ecl:gry\r\n" + "\r\n" + "pid:501585534 hcl:#418895\r\n" + "iyr:2018\r\n"
	    + "hgt:157cm byr:1940 ecl:hzl eyr:2027\r\n" + "\r\n" + "cid:220 hgt:171cm hcl:#623a2f\r\n" + "ecl:gry\r\n" + "iyr:2017\r\n"
	    + "pid:085309709 eyr:2024 byr:1932\r\n" + "\r\n" + "hcl:#733820 eyr:2028 cid:93\r\n" + "iyr:2017\r\n"
	    + "byr:1974 hgt:163cm ecl:grn pid:630322998\r\n" + "\r\n" + "hcl:#602927 cid:97 hgt:166cm eyr:2025\r\n"
	    + "ecl:hzl iyr:2016 byr:1964 pid:355325363\r\n" + "\r\n" + "iyr:2016 pid:402228657 hgt:174cm byr:1993\r\n" + "eyr:2020 hcl:#733820 ecl:grn\r\n"
	    + "\r\n" + "iyr:2020 hgt:171cm ecl:amb\r\n" + "hcl:#c0946f\r\n" + "byr:1939\r\n" + "cid:316 pid:782384470 eyr:2030\r\n" + "\r\n"
	    + "byr:1983 pid:839608616\r\n" + "eyr:2026\r\n" + "hcl:#ceb3a1 cid:242\r\n" + "hgt:192cm ecl:hzl\r\n" + "\r\n"
	    + "pid:701022732 byr:1931 ecl:amb\r\n" + "hgt:70in hcl:#341e13 eyr:2030 iyr:2013\r\n" + "\r\n" + "eyr:2027\r\n" + "pid:740692321 byr:1940\r\n"
	    + "hgt:179cm ecl:blu cid:153 iyr:2010\r\n" + "\r\n" + "iyr:2024 hcl:z ecl:zzz hgt:181in pid:#c38620 eyr:1976 cid:97\r\n" + "byr:2029\r\n" + "\r\n"
	    + "byr:1999 ecl:lzr hcl:6f29a6 eyr:2023\r\n" + "iyr:2018 cid:209 pid:401606571 hgt:163cm\r\n" + "\r\n" + "ecl:amb\r\n"
	    + "byr:1996 hgt:181cm iyr:2018 hcl:#6b5442 pid:022285219 eyr:2021\r\n" + "\r\n" + "cid:93 pid:807990476\r\n"
	    + "hgt:61in eyr:2027 hcl:#cfa07d ecl:oth iyr:2017\r\n" + "\r\n" + "hcl:#7d3b0c pid:225151503 iyr:2013 cid:68\r\n" + "eyr:2029\r\n"
	    + "ecl:brn hgt:64in byr:1959\r\n" + "\r\n" + "eyr:2028 hgt:172in\r\n" + "iyr:2014 byr:1950 pid:187cm hcl:z ecl:brn\r\n" + "\r\n" + "byr:1982\r\n"
	    + "pid:978263388 eyr:2021 hgt:175cm iyr:2014 ecl:brn hcl:#a97842\r\n" + "\r\n" + "hgt:162cm\r\n" + "eyr:2025\r\n"
	    + "pid:6533951177 byr:1993 iyr:2011 hcl:#c0946f ecl:hzl\r\n" + "\r\n" + "pid:182cm\r\n" + "iyr:2025 eyr:2035 hgt:59in\r\n" + "ecl:#799f29 hcl:z\r\n"
	    + "byr:1920 cid:202\r\n" + "\r\n" + "hcl:#733820\r\n" + "eyr:2022 hgt:185cm byr:1989 pid:195276207\r\n" + "ecl:blu iyr:2017\r\n" + "\r\n"
	    + "hcl:#7d3b0c\r\n" + "cid:257 ecl:gry\r\n" + "pid:123065639 byr:1951 iyr:2013\r\n" + "\r\n"
	    + "eyr:2039 ecl:#a82e90 byr:1927 pid:719738468 hgt:73cm\r\n" + "\r\n" + "hcl:605223\r\n" + "hgt:162cm pid:50424035\r\n"
	    + "ecl:oth cid:343 byr:2025 iyr:2023 eyr:2024\r\n" + "\r\n" + "hcl:699116 iyr:2001\r\n" + "eyr:2022\r\n" + "byr:2013\r\n"
	    + "hgt:171cm pid:8900968325\r\n" + "\r\n" + "hcl:#efcc98 eyr:2029 ecl:grn pid:568953221\r\n" + "byr:1986\r\n" + "hgt:178cm\r\n" + "iyr:2020\r\n"
	    + "\r\n" + "pid:452235579 byr:1932\r\n" + "ecl:grn\r\n" + "iyr:2010 hgt:189cm eyr:2028\r\n" + "hcl:#602927 cid:258\r\n" + "\r\n"
	    + "ecl:xry iyr:2009 cid:334 pid:189cm\r\n" + "eyr:2032 byr:2005 hgt:172in hcl:z\r\n" + "\r\n" + "hgt:159cm hcl:z pid:166cm\r\n"
	    + "ecl:oth eyr:2026 iyr:2020\r\n" + "\r\n" + "eyr:2023 ecl:blu byr:1935 iyr:2015\r\n" + "hcl:#866857 pid:542611829\r\n" + "hgt:168cm\r\n" + "\r\n"
	    + "pid:#ec3d53\r\n" + "hcl:#ceb3a1\r\n" + "byr:1999 eyr:2024\r\n" + "hgt:188cm ecl:oth iyr:2018\r\n" + "\r\n" + "byr:2003 hgt:167\r\n"
	    + "hcl:486800\r\n" + "ecl:#29bdd6 eyr:2037 cid:169 iyr:2010\r\n" + "\r\n" + "byr:1983\r\n" + "eyr:2026 ecl:gry\r\n" + "pid:203934984\r\n"
	    + "hgt:181cm iyr:2020 hcl:#a97842 cid:184\r\n" + "\r\n" + "hgt:180cm\r\n" + "iyr:1934 eyr:2038 hcl:#a97842 ecl:brn byr:1942 pid:427001597\r\n"
	    + "\r\n" + "hcl:#18171d byr:1988\r\n" + "cid:267 hgt:188cm\r\n" + "ecl:amb\r\n" + "eyr:2028 pid:696617232\r\n" + "\r\n" + "eyr:2024 hcl:#cfa07d\r\n"
	    + "iyr:2013 pid:176cm hgt:189cm byr:1990\r\n" + "ecl:gry\r\n" + "\r\n"
	    + "eyr:2025 iyr:2015 hgt:153cm hcl:#ceb3a1 ecl:grn pid:686467422 byr:1961 cid:282\r\n" + "\r\n" + "byr:1931 hgt:185cm ecl:oth\r\n" + "eyr:2022\r\n"
	    + "pid:561083684 hcl:#efcc98\r\n" + "iyr:2012\r\n" + "\r\n" + "byr:1948 cid:327 hgt:151cm\r\n" + "iyr:2016 hcl:#733820 ecl:oth pid:341978822\r\n"
	    + "\r\n" + "hcl:#ceb3a1\r\n" + "byr:1978 iyr:2020 hgt:172cm\r\n" + "eyr:2022 ecl:oth pid:093317990\r\n" + "\r\n" + "eyr:2029\r\n"
	    + "pid:096891409 iyr:2018\r\n" + "hcl:#d82822 hgt:174cm ecl:hzl\r\n" + "byr:1988\r\n" + "\r\n"
	    + "hgt:170cm iyr:2018 pid:588142771 eyr:2022 hcl:#733820\r\n" + "cid:273 byr:1940 ecl:#a608fe\r\n" + "\r\n"
	    + "iyr:2029 eyr:1980 hcl:#341e13 byr:2027 ecl:grt\r\n" + "pid:443809337 hgt:180cm\r\n" + "cid:205\r\n" + "\r\n"
	    + "ecl:#f89df0 hgt:144 hcl:2f26ab iyr:1982 pid:#3b43c1 eyr:2032 byr:2012\r\n" + "\r\n" + "ecl:hzl byr:1971\r\n" + "pid:030850749\r\n"
	    + "hgt:170in\r\n" + "hcl:#ceb3a1 eyr:2023 iyr:2018\r\n" + "\r\n" + "byr:1940 iyr:2020\r\n" + "eyr:2026 pid:437820254\r\n" + "hgt:179cm ecl:gry\r\n"
	    + "\r\n" + "byr:2028\r\n" + "eyr:1986 hcl:z\r\n" + "hgt:185in pid:773739744 ecl:dne iyr:2020\r\n" + "\r\n" + "hcl:#a97842\r\n"
	    + "hgt:186cm cid:64 iyr:2016\r\n" + "byr:1947 eyr:2021\r\n" + "\r\n" + "byr:1988 hgt:160cm eyr:2023 hcl:#866857 pid:788805179 iyr:2022 ecl:amb\r\n"
	    + "\r\n" + "hgt:164cm byr:1996 cid:338 hcl:#efcc98\r\n" + "eyr:2029 pid:208596014 ecl:blu\r\n" + "\r\n"
	    + "pid:357680064 byr:1960 eyr:2029 ecl:gry hgt:192cm hcl:#c0946f\r\n" + "\r\n" + "ecl:#d32320\r\n" + "hgt:167in pid:19531341\r\n" + "hcl:z\r\n"
	    + "cid:346 iyr:2024 byr:2006 eyr:2035\r\n" + "\r\n" + "pid:843729120 byr:1987 hgt:185cm eyr:2022\r\n" + "ecl:amb\r\n" + "iyr:2012 hcl:#c0946f\r\n"
	    + "\r\n" + "eyr:2020 byr:1961 iyr:2011\r\n" + "hgt:162cm cid:54 pid:891397982 ecl:brn\r\n" + "\r\n"
	    + "ecl:zzz byr:2019 iyr:2015 eyr:2028 hcl:43d56d\r\n" + "hgt:152cm\r\n" + "pid:182cm\r\n" + "\r\n" + "hcl:#18171d byr:1979 hgt:174cm\r\n"
	    + "iyr:2013 cid:228 eyr:2022 ecl:amb pid:82422450\r\n" + "\r\n" + "cid:156 iyr:2017\r\n" + "byr:1924\r\n"
	    + "hcl:#b6652a ecl:gry hgt:184cm eyr:2027 pid:451347151\r\n" + "\r\n" + "pid:850192502 hgt:65in\r\n" + "iyr:2011 hcl:#7d3b0c\r\n"
	    + "eyr:2023 ecl:gry\r\n" + "\r\n" + "ecl:amb hgt:181cm iyr:2017 pid:233345009 byr:1934\r\n" + "hcl:#341e13\r\n" + "eyr:2024 cid:199\r\n" + "\r\n"
	    + "eyr:2026 pid:#4cb480\r\n" + "iyr:1958 hgt:176cm ecl:dne hcl:z\r\n" + "\r\n" + "ecl:grn eyr:2027 hgt:178cm byr:1994 hcl:#341e13\r\n"
	    + "iyr:2016 pid:790075315\r\n" + "\r\n" + "pid:140922484\r\n" + "byr:1958\r\n" + "eyr:2025\r\n" + "iyr:2019 ecl:brn hgt:157cm hcl:#623a2f\r\n"
	    + "\r\n" + "pid:466785488 hgt:160cm hcl:#cfa07d\r\n" + "byr:1947\r\n" + "iyr:2010\r\n" + "cid:198 eyr:2020 ecl:hzl\r\n" + "\r\n" + "ecl:oth\r\n"
	    + "eyr:2022 byr:1963\r\n" + "hcl:#fffffd iyr:2017\r\n" + "hgt:171cm pid:463249115\r\n" + "\r\n" + "hgt:73cm byr:1968\r\n"
	    + "pid:470317690 ecl:blu\r\n" + "iyr:2015 hcl:#c0946f cid:54 eyr:2029\r\n" + "\r\n" + "hgt:162cm iyr:2014\r\n"
	    + "byr:1951 hcl:#b6652a eyr:2029 ecl:blu\r\n" + "\r\n" + "ecl:oth\r\n" + "hgt:176cm hcl:#888785 byr:1963\r\n"
	    + "iyr:2017 pid:453133253 eyr:2025\r\n" + "\r\n" + "hcl:#efcc98\r\n" + "eyr:2024 iyr:2020 cid:330 byr:1950 pid:937122408 ecl:gry hgt:162cm\r\n"
	    + "\r\n" + "hgt:168cm\r\n" + "pid:745867335\r\n" + "cid:165 hcl:#c0946f iyr:2018 ecl:grt eyr:2030\r\n" + "byr:1932\r\n" + "\r\n"
	    + "byr:1949 pid:116003343\r\n" + "hcl:#c0946f hgt:178cm eyr:2028 iyr:2020 cid:220\r\n" + "ecl:hzl\r\n" + "\r\n" + "iyr:2013\r\n"
	    + "cid:314 pid:186cm hgt:74cm eyr:1973 ecl:hzl byr:2007\r\n" + "hcl:180e0c\r\n" + "\r\n" + "pid:486330019\r\n"
	    + "byr:1999 ecl:oth hgt:154cm iyr:2019 eyr:2026\r\n" + "hcl:#efcc98\r\n" + "\r\n" + "eyr:2030 iyr:2018 hcl:#18171d byr:1950\r\n"
	    + "pid:648616604 hgt:160cm ecl:gry\r\n" + "\r\n" + "hgt:173cm\r\n" + "ecl:oth byr:1993 eyr:2029 hcl:#fffffd iyr:2010 pid:317451887\r\n" + "\r\n"
	    + "ecl:brn hgt:157cm\r\n" + "byr:1963 eyr:2023 pid:005387570 hcl:#866857 iyr:2012\r\n" + "\r\n"
	    + "pid:419695212 eyr:2020 byr:1957 cid:198 iyr:2015 hcl:#888785 hgt:168cm ecl:amb\r\n" + "\r\n" + "ecl:amb\r\n"
	    + "iyr:2017 eyr:2024 pid:039995171 hcl:#a97842\r\n" + "hgt:153cm byr:1983\r\n" + "\r\n"
	    + "byr:1979 eyr:2021 iyr:2011 hgt:157cm ecl:blu pid:110855542 hcl:#c0946f\r\n" + "\r\n" + "ecl:blu pid:948753945 eyr:2029 iyr:2012 hcl:#ceb3a1\r\n"
	    + "hgt:164cm byr:1988\r\n" + "\r\n" + "iyr:2010\r\n" + "eyr:2032 hcl:#fffffd pid:#175129 hgt:184cm\r\n" + "ecl:hzl byr:1985\r\n" + "\r\n"
	    + "hgt:189cm ecl:blu byr:1936 eyr:2027 hcl:#733820\r\n" + "pid:728752361 iyr:2011\r\n" + "\r\n"
	    + "hcl:#733820 ecl:blu eyr:2023 hgt:172cm iyr:2017\r\n" + "pid:013415387 byr:1947\r\n" + "\r\n" + "byr:2012 iyr:2017 pid:#424ae4\r\n"
	    + "cid:172 hgt:166cm eyr:2022\r\n" + "hcl:b1319b ecl:#6635d8\r\n" + "\r\n" + "eyr:2030\r\n"
	    + "iyr:1928 hgt:185cm ecl:brn pid:#ac5a90 byr:1984 hcl:ac8f43\r\n" + "\r\n" + "eyr:2027\r\n" + "ecl:amb iyr:2014 hcl:#fffffd\r\n"
	    + "pid:838758900\r\n" + "hgt:177cm byr:1942\r\n" + "\r\n" + "cid:166 iyr:2020 ecl:lzr hgt:70cm eyr:2040 byr:2004 hcl:#733820\r\n" + "\r\n"
	    + "eyr:2028 ecl:grn byr:2016 cid:61 iyr:2010\r\n" + "hcl:#cfa07d\r\n" + "hgt:155in\r\n" + "pid:9594283803\r\n" + "\r\n"
	    + "ecl:gmt pid:984675198\r\n" + "byr:1997 hgt:128 eyr:2037 hcl:#b6652a cid:299\r\n" + "\r\n" + "iyr:2015 pid:733864914 eyr:2021 ecl:amb\r\n"
	    + "byr:1971 cid:280\r\n" + "hgt:181cm hcl:#054593\r\n" + "\r\n" + "ecl:hzl hcl:#cfa07d eyr:2022 pid:832736421\r\n" + "byr:1958\r\n" + "iyr:2010\r\n"
	    + "cid:274 hgt:152cm\r\n" + "\r\n" + "eyr:2020 hcl:#6b5442 cid:223 hgt:155cm byr:1989 ecl:oth\r\n" + "iyr:2011 pid:549182194\r\n" + "\r\n"
	    + "iyr:2020 hcl:#cfa07d\r\n" + "eyr:2027 pid:093361240 byr:1941 cid:271 hgt:178cm ecl:brn\r\n" + "\r\n" + "ecl:blu cid:290 eyr:2027\r\n"
	    + "hgt:192cm byr:1945 hcl:#7d3b0c iyr:2020 pid:910713369\r\n" + "\r\n" + "byr:1991 hcl:#ceb3a1 ecl:xry hgt:159cm pid:9496171384\r\n"
	    + "eyr:2030 iyr:2016\r\n" + "\r\n" + "eyr:2020 pid:812617809 hcl:#7d3b0c\r\n" + "byr:1970 ecl:gmt\r\n" + "iyr:1971 hgt:157in\r\n" + "\r\n"
	    + "pid:596027311 hcl:#866857 hgt:169cm byr:1945 eyr:2030 ecl:oth\r\n" + "iyr:2010\r\n" + "\r\n" + "hgt:176cm\r\n"
	    + "pid:213213359 byr:2012 hcl:be7b13 eyr:1971 ecl:gmt iyr:2011\r\n" + "cid:64\r\n" + "\r\n" + "pid:27107946 ecl:utc hgt:66cm byr:1928 eyr:2040\r\n"
	    + "cid:87\r\n" + "\r\n" + "byr:1959 ecl:blu hcl:4e023b pid:9017609497 eyr:2023 hgt:68 iyr:2029\r\n" + "\r\n"
	    + "hgt:164cm eyr:2023 byr:2008 ecl:grn pid:420168481 hcl:#b6652a iyr:2012\r\n" + "\r\n" + "eyr:1977 byr:1934\r\n" + "ecl:brn cid:163\r\n"
	    + "iyr:2018 pid:2863284754\r\n" + "hgt:150in hcl:#623a2f\r\n" + "\r\n" + "ecl:hzl eyr:2031 cid:145 hgt:186cm hcl:#cfa07d\r\n"
	    + "byr:1941 iyr:2010 pid:722056139\r\n" + "\r\n" + "ecl:blu eyr:2027\r\n" + "hcl:#888785 iyr:2018 byr:1977 cid:278 hgt:156cm\r\n" + "\r\n"
	    + "eyr:2039 hgt:82 byr:2007\r\n" + "hcl:z iyr:2021 ecl:dne cid:191\r\n" + "pid:#1cf69f\r\n" + "\r\n" + "pid:183cm cid:111\r\n" + "hgt:66cm\r\n"
	    + "iyr:1950\r\n" + "eyr:1947 ecl:#016f6a\r\n" + "\r\n" + "ecl:hzl byr:1957 iyr:2015 hgt:186cm eyr:2029 hcl:#701e04 cid:149 pid:827898914\r\n"
	    + "\r\n" + "cid:214 pid:785688542 hgt:189cm byr:1974 ecl:brn\r\n" + "hcl:#18171d\r\n" + "eyr:2030\r\n" + "\r\n" + "hcl:#866857\r\n"
	    + "cid:241 ecl:grn pid:389488422 byr:1959 iyr:2015 hgt:67in\r\n" + "eyr:2027\r\n" + "\r\n" + "hcl:#6b5442 iyr:2011 hgt:193cm\r\n"
	    + "eyr:2026 byr:1952\r\n" + "pid:033382338\r\n" + "ecl:grn\r\n" + "\r\n" + "iyr:2020 hgt:166cm byr:1927\r\n" + "eyr:2029 ecl:hzl\r\n"
	    + "pid:927006613 hcl:#623a2f\r\n" + "\r\n" + "ecl:gry pid:640783974\r\n" + "hgt:71in byr:1945 iyr:2019 cid:268 hcl:#b6652a\r\n" + "eyr:2025\r\n"
	    + "\r\n" + "hcl:#733820 hgt:163cm\r\n" + "pid:1285584293 byr:1967 ecl:oth\r\n" + "cid:309 iyr:2020 eyr:2031\r\n" + "\r\n"
	    + "pid:910349085 iyr:2011 hcl:#623a2f byr:1956\r\n" + "eyr:2025 ecl:gry\r\n" + "hgt:182cm\r\n" + "\r\n"
	    + "pid:018283044 hcl:#602927 hgt:153cm ecl:gry iyr:2020\r\n" + "eyr:2024\r\n" + "byr:1990\r\n" + "\r\n" + "hgt:184cm hcl:#866857 ecl:oth\r\n"
	    + "eyr:2023 pid:405733635 cid:205\r\n" + "byr:1987 iyr:2012\r\n" + "\r\n" + "hgt:167cm\r\n" + "iyr:2015 ecl:brn\r\n" + "eyr:2025\r\n"
	    + "hcl:#18171d cid:313 byr:1960\r\n" + "\r\n" + "hgt:165cm byr:1933\r\n" + "iyr:2014\r\n" + "cid:203\r\n" + "hcl:#1cdbb3\r\n"
	    + "ecl:hzl eyr:2027 pid:747009469\r\n" + "\r\n" + "hgt:169cm ecl:gry iyr:2014\r\n" + "byr:1966 pid:621876532 hcl:#efcc98\r\n" + "\r\n"
	    + "cid:342 eyr:2029 hcl:#a97842 byr:1970\r\n" + "ecl:oth\r\n" + "pid:137287449 hgt:180cm\r\n" + "iyr:2011\r\n" + "\r\n"
	    + "hcl:#cfa07d byr:1985 hgt:183cm ecl:grn\r\n" + "iyr:2013 eyr:2022\r\n" + "\r\n" + "iyr:2023\r\n" + "pid:164cm hcl:z byr:1966\r\n"
	    + "eyr:2021 ecl:utc\r\n" + "\r\n" + "hcl:#fffffd cid:60\r\n" + "byr:1973\r\n" + "pid:324648387\r\n" + "hgt:177cm eyr:2022 iyr:2010\r\n"
	    + "ecl:oth\r\n" + "\r\n" + "pid:632056596 hcl:#efcc98\r\n" + "hgt:73in ecl:brn byr:1928 iyr:2017\r\n" + "eyr:2023\r\n" + "\r\n"
	    + "cid:144 ecl:amb eyr:2035 byr:1943 hgt:180cm\r\n" + "iyr:2012\r\n" + "pid:155cm\r\n" + "\r\n" + "hcl:#6b5442\r\n" + "pid:927492391\r\n"
	    + "eyr:2023 hgt:172cm byr:1958 cid:92 ecl:gry iyr:2019\r\n" + "\r\n" + "iyr:2020 cid:82\r\n" + "hgt:193in hcl:#b6652a\r\n"
	    + "ecl:grn eyr:2034 byr:2026\r\n" + "\r\n" + "iyr:1922 hcl:245cb3 byr:2015\r\n" + "pid:151cm\r\n" + "eyr:2040\r\n" + "ecl:lzr cid:136 hgt:101\r\n"
	    + "\r\n" + "byr:2025\r\n" + "eyr:2029\r\n" + "hgt:193in\r\n" + "cid:308\r\n" + "ecl:gry iyr:2028 pid:9335153289\r\n" + "hcl:z\r\n" + "\r\n"
	    + "eyr:2030 hgt:163cm iyr:2014\r\n" + "pid:147768826 ecl:blu byr:1922 hcl:#ceb3a1 cid:169\r\n" + "\r\n"
	    + "ecl:blu byr:2002 eyr:2028 pid:998185490 cid:165 iyr:2020\r\n" + "hgt:188cm hcl:#c0946f\r\n";
	List<String> inputStrings = Arrays.asList(input.split("\r\n\r\n"));
	int validCount = 0;

	for (String string : inputStrings) {
	    if (isValid(string)) {
		++validCount;
	    }
	}

	System.out.println(String.format("Found %s", validCount));
    }

    public static boolean isValid(String str) {
	if (str.contains("byr") && str.contains("iyr") && str.contains("eyr") && str.contains("hgt") && str.contains("hcl") && str.contains("ecl") && str
	    .contains("pid")) {
	    boolean valid = true;
	    String[] credentials = str.split("\r\n| ");

	    for (String cred : credentials) {
		final String[] split = cred.split(":");
		String selector = split[0];
		String value = split[1];

		System.out.println(selector + ":" + value);

		switch (selector) {
		case "byr":
		    valid = valid && validateByr(value);
		    break;
		case "iyr":
		    valid = valid && validateIyr(value);
		    break;
		case "eyr":
		    valid = valid && validateEyr(value);
		    break;
		case "hgt":
		    valid = valid && validateHgt(value);
		    break;
		case "hcl":
		    valid = valid && validateHcl(value);
		    break;
		case "ecl":
		    valid = valid && validateEcl(value);
		    break;
		case "pid":
		    valid = valid && validatePid(value);
		    break;
		}
	    }
	    return valid;
	}

	return false;
    }

    public static boolean validateByr(String value) {
	int numberValue = Integer.parseInt(value);
	return 1920 <= numberValue && numberValue <= 2002;
    }

    public static boolean validateIyr(String value) {
	int numberValue = Integer.parseInt(value);
	return 2010 <= numberValue && numberValue <= 2020;
    }

    public static boolean validateEyr(String value) {
	int numberValue = Integer.parseInt(value);
	return 2020 <= numberValue && numberValue <= 2030;
    }

    public static boolean validateHgt(String value) {
	if (!value.contains("in") && !value.contains("cm")) {
	    return false;
	}

	String unit = value.substring(value.length() - 2, value.length());
	int number = Integer.valueOf(value.substring(0, value.length() - 2));
	if (unit.equals("cm")) {
	    return 150 <= number && number <= 193;
	} else if (unit.equals("in")) {
	    return 59 <= number && number <= 76;
	}
	return false;
    }

    public static boolean validateHcl(String value) {
	if (value.startsWith("#")) {
	    String hexValue = value.substring(1);

	    try {
		Integer.parseInt(hexValue, 16);
	    } catch (Exception e) {
		return false;
	    }
	    return true;
	}
	return false;
    }

    public static boolean validateEcl(String value) {
	return value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry") || value.equals("grn") || value.equals("hzl")
	    || value.equals("oth");
    }

    public static boolean validatePid(String value) {
	if (value.length() == 9) {
	    try {
		Integer.parseInt(value);
	    } catch (Exception e) {
		return false;
	    }
	    return true;
	}
	return false;
    }

    // PART 1
    // public static boolean isValid(String str) {
    // return str.contains("byr") && str.contains("iyr") && str.contains("eyr") && str.contains("hgt") && str.contains("hcl") && str.contains("ecl") && str
    // .contains("pid");
    // }
}
