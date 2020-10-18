package cn.danao.code.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * date 2020/4/17 16:04 <br/>
 * descriptionclass <br/>
 * 字符匹配测试代码
 * <p>
 * 有一个字典 ["头痛", "头晕", "恶心", "冠心病", "很头痛", "非常头痛", "我头痛"]
 * <p>
 * 则当用户输入[我头疼，有点恶心，我头痛]时，匹配到[头疼,恶心，我头痛]
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class StringMatch {

    int max = 0;

    @Test
    public void test() {
        String str = "大便习惯改变,大便不规律,排便习惯改变,排便不规律,排便规律改变,排便习惯改便";
        List<String> list = new ArrayList<>();
        List<String> testList = (Arrays.asList("头痛", "头晕", "恶心", "冠心病", "很头痛", "非常头痛", "我头痛"));
        //list.addAll(new ArrayList<>(Arrays.asList("大便习惯改变", "大便不规律", "大便", "排便习惯改变", "排便不规律", "排便规律改变", "排便习惯改便")));
        list.addAll(readTxtFile());
//        list.addAll(testList);
        log.info("字典的大小是[{}]", list.size());
        Map<Character, Map<Integer, Set<char[]>>> words = init(list);
        log.debug("初始化字典是 words = {}", words);
        log.info("hash 后的字典是 words = {}", words.size());
        String userStr = "我很头痛，非常头痛，我我我我头痛";
        userStr = "我头疼，有点恶心，我头痛";
        userStr = readTxtFile("D:\\wechat\\WeChat Files\\zymhao\\FileStorage\\File\\2020-04\\testText.txt");
        log.info("用户输入长度 {} ",userStr.length());
        log.info("start");
        Set<String> word = getStrs(userStr, words);
        log.info("end");
        log.info("匹配的词的数量{}", word.size());
        log.debug("用户输入 [{}] 匹配到的词是[{}]", userStr, word);
    }


    /**
     * 初始化字典
     * <p>
     * 字典按照首字母 hash之后 存入 长度和字符列表
     *
     * @param list
     * @return
     */
    public Map<Character, Map<Integer, Set<char[]>>> init(List<String> list) {
        Map<Character, Map<Integer, Set<char[]>>> words = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.length() > max) {
                max = str.length();
            }
            Character a = str.charAt(0);
            Map<Integer, Set<char[]>> map = words.get(a);
            if (Objects.isNull(map)) {
                map = new HashMap<>();
                Set<char[]> set = new HashSet<>();
                set.add(str.toCharArray());
                map.put(str.length(), set);
            } else {
                //存放结构
                Set<char[]> set = map.get(str.length());
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(str.toCharArray());
                map.put(str.length(), set);
            }
            words.put(a, map);
        }
        log.info("最大字符串长度是[{}]", max);
        return words;
    }


    public Set<String> getStrs(String key, Map<Character, Map<Integer, Set<char[]>>> words) {
        char[] keys = key.toCharArray();
        //遍历字符
        Set<String> set = new HashSet<>();
        for (int i = 0; i < keys.length; i++) {
            //步进为1
            char startChar = keys[i];

            Map<Integer, Set<char[]>> map = words.get(startChar);
            //没匹配到
            if (map == null || map.isEmpty()) {
                continue;
            } else {
                //匹配上首字母
                Integer[] integers = sortSet(map.keySet());
                Integer max = integers[integers.length - 1];
                Integer min = integers[0];
                log.debug("最大深度是[{}],最小深度[{}]", max, min);
                //剩余长度
                if ((key.length() - i) < min) {
                    log.debug("没有匹配长度的字典");
                    return set;
                } else {
                    //匹配上首字母 则将字典里面的key进行匹配
                    for (int j = 0; j < integers.length; j++) {
                        Set<char[]> chars = map.get(integers[j]);
                        final int integer = integers[j];
                        final int start = i;
                        chars.forEach(k -> {
                            log.debug("start = {}, integer = {},key.length={}", start, integer, key.length());
                            if ((start + integer - 1) < key.length()) {
                                char[] word = key.substring(start, start + integer).toCharArray();
                                log.debug("k = {} word = {}", k, word);
                                if (new String(k).equals(new String(word))) {
                                    set.add(new String(word));
                                }
                                ;
                            }
                        });
                    }
                }
            }
        }
        return set;
    }


    public Integer[] sortSet(Set<Integer> set) {
        Integer[] arrays = set.toArray(new Integer[]{});
        Arrays.sort(arrays);
        return arrays;
    }

    public Set<String> getKeys(Map<Integer, List<String>> listMap, String key) {
        return null;
    }


    public static List<String> readTxtFile() {
        String str = readTxtFile("D:\\wechat\\WeChat Files\\zymhao\\FileStorage\\File\\2020-04\\symptoms.txt");
        String[] strings = str.split(System.lineSeparator());
        List<String> strs = new ArrayList<>(Arrays.asList(strings));
        log.debug("{}", strs);
        return strs;
    }

    public static void main(String[] args) {
        readTxtFile();
    }

    public static String readTxtFile(String filePath) { //优化读取txt工具，防止io阻塞 
        String content = null;
        try (Reader reader = new InputStreamReader(new FileInputStream(filePath), "UTF-8")) {
            StringBuffer sb = new StringBuffer();
            char[] tempchars = new char[1024];
            while (reader.read(tempchars) != -1) {
                sb.append(tempchars);
            }
            content = sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public boolean isTrue(char s, char[] chars) {
        return chars[0] == s;
    }
}
