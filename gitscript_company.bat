@echo off
rem git切换脚本
call:gitcheckout dev
call:gitmerge company
call:gitcheckout master
call:gitmerge dev
call:gitcheckout company
exit

rem 切换分支
:gitcheckout
git checkout %1
goto:eof

rem 合并分支
:gitmerge
git merge %1
goto:eof