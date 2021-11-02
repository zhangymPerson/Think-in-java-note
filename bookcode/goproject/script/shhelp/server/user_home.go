package server

import (
    "bytes"
    "errors"
    "fmt"
    "os"
    "os/exec"
    "os/user"
    "runtime"
    "strings"
)

// Home 获取不同操作系统的当前home目录
func Home() string {
    user, err := user.Current()
    if nil == err {
        return user.HomeDir
    }

    // cross compile support
    if "windows" == runtime.GOOS {
        home, err := homeWindows()
        if err != nil {
            fmt.Println("获取Home失败")
            err.Error()
        }
        return home
    }

    home, err := homeUnix()
    if err != nil {
        fmt.Println("获取Home失败")
        err.Error()
    }
    return home

}

func homeUnix() (string, error) {
    // First prefer the HOME environmental variable
    if home := os.Getenv("HOME"); home != "" {
        return home, nil
    }

    // If that fails, try the shell
    var stdout bytes.Buffer
    cmd := exec.Command("sh", "-c", "eval echo ~$USER")
    cmd.Stdout = &stdout
    if err := cmd.Run(); err != nil {
        return "", err
    }

    result := strings.TrimSpace(stdout.String())
    if result == "" {
        return "", errors.New("blank output when reading home directory")
    }

    return result, nil
}

func homeWindows() (string, error) {
    drive := os.Getenv("HOMEDRIVE")
    path := os.Getenv("HOMEPATH")
    home := drive + path
    if drive == "" || path == "" {
        home = os.Getenv("USERPROFILE")
    }
    if home == "" {
        return "", errors.New("HOMEDRIVE, HOMEPATH, and USERPROFILE are blank")
    }

    return home, nil
}
