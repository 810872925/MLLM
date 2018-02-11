package com.utilslibrary.file;

import android.os.Environment;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author: 马龙
 * E-mail: 178917169@qq.com
 * CreatedTime: 2018/2/11 16:16
 * <p>
 * 文件工具类
 */
public class FileUtils {

    private FileUtils() {
        throw new UnsupportedOperationException("FileUtil 工具类不能被实例化");
    }

    /**
     * 外部存储状态
     *
     * @return
     */
    public static boolean isStorageExists() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 文件是否存在
     *
     * @param path
     * @return
     */
    public static boolean isFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * 创建文件目录
     *
     * @param path
     * @return
     */
    public static String createFolder(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return path;
    }

    /**
     * 创建文件目录
     *
     * @param path
     * @return
     */
    public static File createFile(String path) {
        return new File(path);
    }

    /**
     * 创建文件目录
     *
     * @param path
     * @return
     */
    public static File createNomediaFile(String path) {
        return new File(path, ".nomedia");
    }

    /**
     * 保存文件
     *
     * @param path
     * @param inputStream
     * @throws IOException
     */
    public static boolean saveFile(String path, InputStream inputStream) {
        String dir = path.substring(0, path.lastIndexOf("\\"));
        FileOutputStream fileOutputStream = null;
        try {
            createFolder(dir);
            fileOutputStream = new FileOutputStream(path);
            int temp = 0;
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((temp = (inputStream.read(bytes))) != -1) {
                length += temp;
                fileOutputStream.write(bytes, 0, length);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 保存文件
     *
     * @param path
     * @param bytes
     */
    public static boolean saveFile(String path, byte[] bytes) {
        return saveFile(path, new ByteArrayInputStream(bytes));
    }

    /**
     * 保存文件
     *
     * @param path
     * @param text
     * @throws IOException
     */
    public static void saveFile(String path, String text) throws IOException {
        saveFile(path, new ByteArrayInputStream(text.getBytes()));
    }

    /**
     * 移动文件
     *
     * @param srcFile
     * @param destPath
     * @return
     */
    public static boolean moveFile(File srcFile, String destPath) {
        File dir = new File(destPath);
        return srcFile.renameTo(new File(dir, srcFile.getName()));
    }

    /**
     * 移动文件
     *
     * @param srcPath
     * @param destPath
     * @return
     */
    public static boolean moveFile(String srcPath, String destPath) {
        File file = new File(srcPath);
        File dir = new File(destPath);
        return file.renameTo(new File(dir, file.getName()));
    }

    /**
     * 复制文件
     *
     * @param oldPath
     * @param newPath
     */
    public static boolean copyFile(String oldPath, String newPath) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File oldFile = new File(oldPath);
            if (!oldFile.exists()) {
                return false;
            }
            inputStream = new FileInputStream(oldPath);
            fileOutputStream = new FileOutputStream(newPath);
            int length = 0;
            int temp = 0;
            byte[] bytes = new byte[1024];
            while ((temp = inputStream.read(bytes)) != -1) {
                length += temp;
                fileOutputStream.write(bytes, 0, length);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 复制文件
     *
     * @param oldFile
     * @param newPath
     */
    public static void copyFile(File oldFile, String newPath) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            if (!oldFile.exists()) {
                return;
            }
            inputStream = new FileInputStream(oldFile);
            fileOutputStream = new FileOutputStream(newPath);
            int length = 0;
            int temp = 0;
            byte[] bytes = new byte[1024];
            while ((temp = inputStream.read(bytes)) != -1) {
                length += temp;
                fileOutputStream.write(bytes, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取文件名称
     *
     * @param path
     * @return
     */
    public static String getFileName(String path) {
        return path.substring(path.lastIndexOf("\\") + 1);
    }

    /**********************************************************************************************/

    /**
     * 获取文件后缀名
     *
     * @param file
     * @return
     */
    public static String getFileExtensionName(File file) {
        String fileName = file.getName();
        return getFileExtensionName(fileName);
    }

    /**
     * 获取文件后缀名
     *
     * @param path
     * @return
     */
    public static String getFileExtensionName(String path) {
        return path.substring(path.lastIndexOf("."));
    }

    /**
     * 文件追加内容
     *
     * @param srcFile
     * @param inputStream
     */
    public boolean appendFile(File srcFile, InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(srcFile, true);
            int temp = 0;
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((temp = (inputStream.read(bytes))) != -1) {
                length += temp;
                fileOutputStream.write(bytes, 0, length);
            }
            srcFile = new File(srcFile.getPath());
            return srcFile.isFile();
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

}
