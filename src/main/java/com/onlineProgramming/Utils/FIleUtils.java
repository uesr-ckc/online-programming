package com.onlineProgramming.Utils;

import com.onlineProgramming.Entity.ProblemUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CKC
 * @DateTime 2021/4/27 11:19
 */
public class FIleUtils {
    private static File file;
    private static String dir;
    private static FileOutputStream out;
    private static DataOutputStream dos;
    
    static {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            dir = "D:" + File.separator + "problem";
        } else {
            dir = File.separator + "root" + File.separator + "problem";
        }
    }
    
    /**
     * @param filename 文件名
     * @param contents 文件内容
     * @param suffix   文件后缀名
     * @param path     用户目录
     * @return
     */
    public static boolean createFile(String filename, String contents, String suffix, String path) {
        try {
            
            file = new File(dir + File.separator + path);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(dir + File.separator + path + File.separator + filename + "." + suffix);
            out = new FileOutputStream(file);
            dos = new DataOutputStream(out);//将文件流包装成数据流
            dos.writeBytes(contents);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    
    /**
     * @return 返回题目
     * TODO 还可以优化,,,,,,ps:频繁访问IO
     */
    public static Map<Integer, ProblemUtils> inquiryFile() {
        FileInputStream in = null;
        file = new File(dir + File.separator + "problem");
        File[] files = file.listFiles();
        Map<Integer, ProblemUtils> map = new HashMap<>();
        
        if (files != null) {
            int i = 0;
            for (File file1 : files) {
                if (file1.isFile()) {
                    file = new File(dir + File.separator + "problem" + File.separator + file1.getName());
                    try {
                        in = new FileInputStream(file);
                        byte[] b2 = new byte[(int) file.length()];//缓冲区
                        int len = in.read(b2);
                        String s = new String(b2, 0, len);
                        map.put(i++, new ProblemUtils(file1.getName().substring(0, file1.getName().indexOf(".")), s));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return map;
    }
}
