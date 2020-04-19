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
public class StringMatchTwo {

    int max = 0;

    @Test
    public void test() {
        String str = "大便习惯改变,大便不规律,排便习惯改变,排便不规律,排便规律改变,排便习惯改便";
        List<String> list = new ArrayList<>();
        List<String> testList = (Arrays.asList("头痛", "头晕", "恶心", "冠心病", "很头痛", "非常头痛", "我头痛"));
//        list.addAll(new ArrayList<>(Arrays.asList("大便习惯改变", "大便不规律", "大便", "排便习惯改变", "排便不规律", "排便规律改变", "排便习惯改便")));
        list.addAll(readTxtFile());
//        list.addAll(testList);
        log.info("字典的大小是[{}]", list.size());
        Map<Character, Map<Integer, Map<Character, String>>> words = init(list);
        log.debug("初始化字典是 words = {}", words);
        log.debug("hash 后的字典是 words = {}", words.size());
        String userStr = "我很头痛，非常头痛，我我我我头痛";
        userStr = "我头疼，有点恶心，我头痛";
        userStr = readTxtFile("D:\\wechat\\WeChat Files\\zymhao\\FileStorage\\File\\2020-04\\testText.txt");
        log.info("用户输入长度 {} ", userStr.length());
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
    public Map<Character, Map<Integer, Map<Character, String>>> init(List<String> list) {
        Map<Character, Map<Integer, Map<Character, String>>> words = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.length() > max) {
                max = str.length();
            }
            Character a = str.charAt(0);
            char[] chars = str.toCharArray();
            Map<Integer, Map<Character, String>> integerMap = words.get(a);
            if (Objects.isNull(integerMap)) {
                integerMap = new HashMap<>();
            }
            for (int j = 1; j < chars.length; j++) {
                Map<Character, String> characterMapMap = integerMap.get(j);
                if (Objects.isNull(characterMapMap)) {
                    characterMapMap = new HashMap<>();
                }
                String value = "";
                if (j == chars.length - 1) {
                    value = str;
                }
                characterMapMap.put(chars[j], value);
                integerMap.put(j, characterMapMap);
            }
            words.put(a, integerMap);
        }
        log.debug("最大字符串长度是[{}]", max);
        return words;
    }


    public Set<String> getStrs(String key, Map<Character, Map<Integer, Map<Character, String>>> words) {
        char[] keys = key.toCharArray();
        //遍历字符
        Set<String> set = new HashSet<>();
        for (int i = 0; i < keys.length; i++) {
            //步进为1
            char startChar = keys[i];
            log.debug("--------------key={}-startchar={}-------------------------", key, startChar);
            Map<Integer, Map<Character, String>> map = words.get(startChar);
            //没匹配到
            if (map == null || map.isEmpty()) {
                continue;
            } else {
                for (int j = 1; j < keys.length - 1; j++) {
                    Map<Character, String> characterStringMap = map.get(j);
                    log.debug("keys[] {} map {}", keys[j], characterStringMap);
                    //最后一个字符不匹配
                    if (!(i + j < keys.length - 1)) {
                        break;
                    }
                    //首字母未hash到，直接退出
                    if (Objects.isNull(characterStringMap) || characterStringMap.isEmpty() || characterStringMap.values().isEmpty()) {
                        break;
                    }
                    log.debug("========set {} ,key {}", characterStringMap.keySet(), keys[i + j]);
                    //开始按层匹配
                    if (characterStringMap.keySet().contains(keys[i + j])) {
                        //字典值
                        String word = characterStringMap.get(keys[i + j]);
                        // 是否到尾部
                        if (Objects.nonNull(word) && !"".equals(word)) {
                            String splitStr = getStr(keys, i, i + j);
                            log.debug("word {},i {},i+j {} ,splitStr  {}", word, i, i + j, splitStr);
                            if (word.equals(splitStr)) {
                                set.add(word);
                            }
                        } else {
                            log.debug("匹配到 {} 未到末尾，继续匹配", keys[i + j]);
                            continue;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return set;
    }


    public String getStr(char[] chars, int start, int end) {
        StringBuilder str = new StringBuilder();
        if (start > end || chars.length == 0) {
            return "";
        } else {
            for (int i = start; i <= end; i++) {
                str.append(chars[i]);
            }
        }
        return str.toString();
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
