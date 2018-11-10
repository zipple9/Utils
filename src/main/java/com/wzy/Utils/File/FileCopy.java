package com.wzy.Utils.File;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wzy on 2018/11/6 17:46
 **/
public final class FileCopy {


    private FileCopy() {
    } // 工具类 其方法都是静态方法，故应将构造方法私有化

    /**
     * 复制文件的几种方法
     * @param sourcePath
     * @throws IOException
     */
    public static void copyFileUsingFileStreams(String sourcePath)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;

        File source=new File(sourcePath);
        File dest=new File(source.getAbsolutePath().replace(".","(copy)."));

        for (int i = 2; i <100 ; i++) {
            if(!new File(dest.getAbsolutePath().replace("(copy).","(copy"+i+").")).exists()){
                dest=new File(dest.getAbsolutePath().replace("(copy).","(copy"+i+")."));
                break;
            }
        // 针对副本已存在情况的处理

        }

        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[4096];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }
    public static void copyFileUsingFileStreams(File source)
            throws IOException {
        copyFileUsingFileStreams(source.getAbsoluteFile());
    }


    public static void fileCopyNIO(String source) throws IOException {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(source.replace(".","(copy).")))  //这种try的方式会自动释放资源
            {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
}


