# 关于Android drawable和drawable-v24文件夹有什么区别

## 1.创建一个项目时自动生成res目录

drawable
drawable-v24
layout
mipmap-anydpi-v26
mipmap-hdpi
mipmap-mdpi
mipmap-xhdpi
mipmap-xxhdpi
mipmap-xxxhdpi

## 图片资源放到drawable-v24里面，导致7.0以下不能找到图片 不同的drawable文件夹用于为设备兼容性和不同的Android版本提供不同的屏幕密度。同理mipmap-anydpi-v26  API 26（安卓8.0）也是一样的道理，注意不同的文件对应的不同的版本。