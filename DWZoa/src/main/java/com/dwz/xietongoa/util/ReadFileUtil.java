package com.dwz.xietongoa.util;

import com.dwz.xietongoa.dto.ReturnDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dwz
 * @date 2020/4/1813:42
 */
public class ReadFileUtil {
    /**
     * 获取文件夹下的文件名
     *
     * @param filePath 文件夹全路径
     * @return 文件名的集合
     */
    public static ReturnDto getFileName(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    list.add(f.getName());
                }
            }
        } catch (Exception e) {
            ReturnDto.buildFailedReturnDto(e.getMessage());
        }
        return ReturnDto.buildSuccessReturnDto(list);
    }

    /**
     * 传入文件全路径 读取文件内容
     *
     * @param filePath 文件全路径
     * @return 文件内容
     */
    public static ReturnDto readFileByLines(String filePath, String fileName, String charSet) {
        StringBuffer sb = new StringBuffer();
        try {
            File file = new File(filePath + "/" + fileName);
            BufferedReader reader=new BufferedReader(new InputStreamReader
                    (new FileInputStream(file),charSet));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString + "\r\n");
            }
            reader.close();
        } catch (IOException e) {
            ReturnDto.buildFailedReturnDto(e.getMessage());
        }
        return ReturnDto.buildSuccessReturnDto(sb.toString());
    }
}
