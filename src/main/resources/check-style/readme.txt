安装注意：
1. 在Windows的Eclipse上面安装Checkstyle时候需要单独下载插件，因为Eclipse(Windows版本)得应用市场没有Checkstyle插件
2. CheckStyle在git commit前自动检查，只需要将当前目录下的pre-commit文件复制到./.git/hooks/文件夹中，在提交时候就会自动检查代码格式
